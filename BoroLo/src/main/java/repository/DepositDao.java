package repository;

import domain.Deposit;

public interface DepositDao {
    Deposit findByRentalId(int rental_id);

    void insert(Deposit deposit);
    void updateStatus(int deposit_id, String status);
}