package dto.request;

public class EmailVerificationRequestDto {
    private String email;
    private String code; // 인증코드
    
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
} 