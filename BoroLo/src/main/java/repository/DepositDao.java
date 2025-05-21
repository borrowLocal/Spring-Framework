package repository;

import java.util.List;

import dto.response.DepositResponseDto;

public interface DepositDao {
    List<DepositResponseDto> findByRenterUserId(int user_id);
    List<DepositResponseDto> findByItemOwnerId(int user_id);
}