package service;

import java.util.List;

import org.springframework.stereotype.Service;

import domain.Item;
import domain.Rental;
import dto.request.RentalRequestDto;
import repository.ItemDao;
import repository.RentalDao;

@Service
public class RentalService {
    private final RentalDao rentalDao;
    private final ItemDao itemDao;

    public RentalService(RentalDao rentalDao, ItemDao itemDao) {
        this.rentalDao = rentalDao;
        this.itemDao = itemDao;
    }

    // 1. 대여 신청
    public void applyRental(RentalRequestDto dto, int user_id) {
        Item item = itemDao.findById(dto.getItem_id());
        if (item == null) {
            throw new IllegalArgumentException("해당 물품이 존재하지 않습니다.");
        }

        Rental rental = new Rental();
        rental.setItem_id(dto.getItem_id());
        rental.setUser_id(user_id);
        rental.setStart_date(dto.getStart_date());
        rental.setEnd_date(dto.getEnd_date());
        rental.setMeeting_location(dto.getMeeting_location());
        rental.setMeeting_time(dto.getMeeting_time());
        rental.setRental_status("대기 중");
        rental.setIs_approved(false);
        rental.setIs_completed(false);

        rentalDao.insert(rental);
    }

    // 2. 대여 상태 확인
    public List<Rental> getRentalStatus(int user_id) {
        return rentalDao.findByUserId(user_id);
    }

    // 3. 대여 수락
	  public void approveRental(int rental_id) {
	      Rental rental = rentalDao.findById(rental_id);
	          if (rental == null) {
	             throw new IllegalArgumentException("대여 신청이 존재하지 않습니다.");
	          }
	
	          rentalDao.approveRental(rental_id);
	      }
	
    // 4. 대여 완료
    public void completeRental(int rental_id) {
        Rental rental = rentalDao.findById(rental_id);
        if (rental == null) {
            throw new IllegalArgumentException("대여 정보가 없습니다.");
        }
        rentalDao.completeRental(rental_id);
        rentalDao.updateStatus(rental_id, "완료됨");
    }

    // 5. 5. 물품의 신청자 목록 조회
    public List<Rental> getApplicants(int item_id) {
        return rentalDao.findByItemId(item_id);
    }
}