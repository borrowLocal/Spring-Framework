package dto.request;

public class PasswordResetRequestDto {
    private String email;
    private String code;
    private String new_password;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getNew_password() { return new_password; }
    public void setNew_password(String new_password) { this.new_password = new_password; }
}