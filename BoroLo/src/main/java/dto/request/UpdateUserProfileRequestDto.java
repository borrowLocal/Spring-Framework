package dto.request;

import java.time.LocalDate;

public class UpdateUserProfileRequestDto {
    private Integer user_id;
    private String real_name;
    private String nick_name;
    private LocalDate birth_date;

    public Integer getUser_id() { return user_id; }
    public void setUser_id(Integer user_id) { this.user_id = user_id; }

    public String getReal_name() { return real_name; }
    public void setReal_name(String real_name) { this.real_name = real_name; }

    public String getNick_name() { return nick_name; }
    public void setNick_name(String nick_name) { this.nick_name = nick_name; }

    public LocalDate getBirth_date() { return birth_date; }
    public void setBirth_date(LocalDate birth_date) { this.birth_date = birth_date; }
}