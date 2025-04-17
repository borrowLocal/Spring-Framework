package domain;

public class Deposit {
    private Integer deposit_id;
    private Integer amount;
    private String deposit_status;
    private Integer rental_id;

    public Integer getDeposit_id() { return deposit_id; }
    public void setDeposit_id(Integer deposit_id) { this.deposit_id = deposit_id; }

    public Integer getAmount() { return amount; }
    public void setAmount(Integer amount) { this.amount = amount; }

    public String getDeposit_status() { return deposit_status; }
    public void setDeposit_status(String deposit_status) { this.deposit_status = deposit_status; }

    public Integer getRental_id() { return rental_id; }
    public void setRental_id(Integer rental_id) { this.rental_id = rental_id; }
}