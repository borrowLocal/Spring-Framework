package dto.response;

public class DepositResponseDto {
    private Integer deposit_id;
    private Integer amount;
    private String deposit_status;
    private Integer rental_id;
    private String item_title;
    private String counterparty_nick_name;
	public Integer getDeposit_id() {
		return deposit_id;
	}
	public void setDeposit_id(Integer deposit_id) {
		this.deposit_id = deposit_id;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getDeposit_status() {
		return deposit_status;
	}
	public void setDeposit_status(String deposit_status) {
		this.deposit_status = deposit_status;
	}
	public Integer getRental_id() {
		return rental_id;
	}
	public void setRental_id(Integer rental_id) {
		this.rental_id = rental_id;
	}
	public String getItem_title() {
		return item_title;
	}
	public void setItem_title(String item_title) {
		this.item_title = item_title;
	}
	public String getCounterparty_nick_name() {
		return counterparty_nick_name;
	}
	public void setCounterparty_nick_name(String counterparty_nick_name) {
		this.counterparty_nick_name = counterparty_nick_name;
	}
    
    
}