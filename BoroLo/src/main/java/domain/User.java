package domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
    private Integer user_id;
    private String password;
    private String real_name;
    private String nick_name;
    private String email;
    private LocalDate birth_date;
    private Float rating;
    private LocalDateTime create_time;
    private Boolean is_deleted;

    public Integer getUser_id() { return user_id; }
    public void setUser_id(Integer user_id) { this.user_id = user_id; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getReal_name() { return real_name; }
    public void setReal_name(String real_name) { this.real_name = real_name; }

    public String getNick_name() { return nick_name; }
    public void setNick_name(String nick_name) { this.nick_name = nick_name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getBirth_date() { return birth_date; }
    public void setBirth_date(LocalDate birth_date) { this.birth_date = birth_date; }

    public Float getRating() { return rating; }
    public void setRating(Float rating) { this.rating = rating; }

    public LocalDateTime getCreate_time() { return create_time; }
    public void setCreate_time(LocalDateTime create_time) { this.create_time = create_time; }

    public Boolean getIs_deleted() { return is_deleted; }
    public void setIs_deleted(Boolean is_deleted) { this.is_deleted = is_deleted; }
}