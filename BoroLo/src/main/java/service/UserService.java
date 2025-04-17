package service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

import domain.User;
import dto.request.EmailVerificationRequestDto;
import dto.request.JoinRequestDto;
import dto.request.LoginRequestDto;
import dto.request.PasswordResetRequestDto;
import dto.request.UpdateUserProfileRequestDto;
import dto.request.VerifyPasswordRequestDto;
import dto.response.UserProfileResponseDto;
import repository.FavoriteDao;
import repository.ItemDao;
import repository.RentalDao;
import repository.UserDao;

@Service
public class UserService {

    private final UserDao userDao;
    private final ItemDao itemDao;
    private final RentalDao rentalDao;
    private final FavoriteDao favoriteDao;

    // 인증 코드 저장용
    private final Map<String, String> verificationMap = new HashMap<>();

    public UserService(UserDao userDao, ItemDao itemDao, RentalDao rentalDao, FavoriteDao favoriteDao) {
        this.userDao = userDao;
        this.itemDao = itemDao;
        this.rentalDao = rentalDao;
        this.favoriteDao = favoriteDao;
    }

    // 1. 회원가입
    public void registerUser(JoinRequestDto dto) {
        if (userDao.findByEmail(dto.getEmail()) != null) {
            throw new IllegalArgumentException("이미 가입된 이메일입니다.");
        }

        if (userDao.findByNickName(dto.getNick_name()) != null) {
            throw new IllegalArgumentException("이미 사용 중인 닉네임입니다.");
        }

        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setReal_name(dto.getReal_name());
        user.setNick_name(dto.getNick_name());
        user.setBirth_date(dto.getBirth_date());
        user.setCreate_time(LocalDateTime.now());
        user.setIs_deleted(false);
        user.setRating(0.0f);

        userDao.insert(user);
    }

    // 2. 로그인
    public User login(LoginRequestDto dto) {
        User user = userDao.findByEmail(dto.getEmail());

        if (user == null || user.getIs_deleted()) {
            throw new IllegalArgumentException("존재하지 않는 계정입니다.");
        }

        if (!user.getPassword().equals(dto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return user;
    }
    
    // 3. 비밀번호 재설정
    public void resetPassword(PasswordResetRequestDto dto) {
        String code = verificationMap.get(dto.getEmail());

        if (code == null || !code.equals(dto.getCode())) {
            throw new IllegalArgumentException("인증코드가 일치하지 않습니다.");
        }

        userDao.updatePassword(dto.getEmail(), dto.getNew_password());
        verificationMap.remove(dto.getEmail());
    }

    // 4. 이메일 인증코드 발송
    public void verifyEmailCode(EmailVerificationRequestDto dto) {
        User user = userDao.findByEmail(dto.getEmail());
        if (user == null || user.getIs_deleted()) {
            throw new IllegalArgumentException("가입되지 않은 이메일입니다.");
        }

        String code = String.valueOf(new Random().nextInt(900000) + 100000);
        verificationMap.put(dto.getEmail(), code);

        System.out.println("인증코드: " + code);
    }

    // 5-1. 마이페이지 정보 조회
    public UserProfileResponseDto getUserProfile(int user_id) {
        User user = userDao.findById(user_id);
        if (user == null || user.getIs_deleted()) {
            throw new IllegalArgumentException("사용자를 찾을 수 없습니다.");
        }

        int itemCount = itemDao.countByUserId(user_id);
        int rentalCount = rentalDao.countByUserId(user_id);
        int favoriteCount = favoriteDao.countByUserId(user_id);

        UserProfileResponseDto dto = new UserProfileResponseDto();
        dto.setReal_name(user.getReal_name());
        dto.setNick_name(user.getNick_name());
        dto.setRating(user.getRating());
        dto.setItem_count(itemCount);
        dto.setRental_count(rentalCount);
        dto.setFavorite_count(favoriteCount);

        return dto;
    }

    // 5-2. 개인정보 수정
    public void updateUserProfile(UpdateUserProfileRequestDto dto) {
        User existing = userDao.findById(dto.getUser_id());
        if (existing == null || existing.getIs_deleted()) {
            throw new IllegalArgumentException("사용자를 찾을 수 없습니다.");
        }

        if (!existing.getNick_name().equals(dto.getNick_name())) {
            if (userDao.findByNickName(dto.getNick_name()) != null) {
                throw new IllegalArgumentException("이미 사용 중인 닉네임입니다.");
            }
        }

        existing.setReal_name(dto.getReal_name());
        existing.setNick_name(dto.getNick_name());
        existing.setBirth_date(dto.getBirth_date());

        userDao.update(existing);
    }

    // 6. 비밀번호 확인
    public boolean verifyPassword(VerifyPasswordRequestDto dto) {
        User user = userDao.findById(dto.getUser_id());

        if (user == null || user.getIs_deleted()) {
            throw new IllegalArgumentException("사용자를 찾을 수 없습니다.");
        }

        return user.getPassword().equals(dto.getPassword());
    }

    // 7. 회원 탈퇴
    public void deleteUser(int user_id) {
        User user = userDao.findById(user_id);
        if (user == null || user.getIs_deleted()) {
            throw new IllegalArgumentException("이미 삭제된 계정이거나 존재하지 않습니다.");
        }

        user.setIs_deleted(true);
        userDao.update(user);
    }
}