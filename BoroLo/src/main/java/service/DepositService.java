package service;

import java.util.List;

import org.springframework.stereotype.Service;

import dto.response.DepositResponseDto;
import repository.DepositDao;

@Service
public class DepositService {

    private final DepositDao depositDao;

    public DepositService(DepositDao depositDao) {
        this.depositDao = depositDao;
    }

    public List<DepositResponseDto> getDepositsAsRenter(int user_id) {
        return depositDao.findByRenterUserId(user_id);
    }

    public List<DepositResponseDto> getDepositsAsItemOwner(int user_id) {
        return depositDao.findByItemOwnerId(user_id);
    }
}