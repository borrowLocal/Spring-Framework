package controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.User;
import dto.request.EmailVerificationRequestDto;
import dto.request.JoinRequestDto;
import dto.request.LoginRequestDto;
import dto.request.PasswordResetRequestDto;
import dto.request.UpdateUserProfileRequestDto;
import dto.request.VerifyPasswordRequestDto;
import dto.response.UserProfileResponseDto;
import service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 1. 회원가입
    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody JoinRequestDto dto) {
        try {
            userService.registerUser(dto);
            return ResponseEntity.ok("회원가입이 완료되었습니다.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // 2. 로그인
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequestDto dto) {
        try {
            User user = userService.login(dto);
            return ResponseEntity.ok(user); // 나중에 LoginResponseDto로 분리 가능
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
    
    // 3. 비밀번호 재설정
    @PostMapping("/password/reset")
    public ResponseEntity<Void> resetPassword(@RequestBody PasswordResetRequestDto dto) {
        try {
            userService.resetPassword(dto);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // 4. 이메일 인증코드 발송
    @PostMapping("/email/verify")
    public ResponseEntity<Void> sendResetCode(@RequestBody EmailVerificationRequestDto dto) {
        try {
            userService.verifyEmailCode(dto);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // 5-1. 마이페이지 조회
    @GetMapping("/{user_id}")
    public ResponseEntity<UserProfileResponseDto> getUserProfile(@PathVariable int user_id) {
        try {
            UserProfileResponseDto dto = userService.getUserProfile(user_id);
            return ResponseEntity.ok(dto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // 5-2. 개인정보 수정
    @PutMapping("/{user_id}")
    public ResponseEntity<Void> updateProfile(@RequestBody UpdateUserProfileRequestDto dto) {
        try {
            userService.updateUserProfile(dto);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // 6. 비밀번호 확인
    @PostMapping("/verify-password")
    public ResponseEntity<Boolean> verifyPassword(@RequestBody VerifyPasswordRequestDto dto) {
        try {
            boolean result = userService.verifyPassword(dto);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    //. 회원 탈퇴
    @DeleteMapping("/{user_id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int user_id) {
        try {
            userService.deleteUser(user_id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}