package domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class UserLocation {
    private Integer user_id;
    private BigDecimal lat;
    private BigDecimal lng;
    private Boolean is_manual;
    private LocalDateTime update_time;

    public Integer getUser_id() { return user_id; }
    public void setUser_id(Integer user_id) { this.user_id = user_id; }

    public BigDecimal getLat() { return lat; }
    public void setLat(BigDecimal lat) { this.lat = lat; }

    public BigDecimal getLng() { return lng; }
    public void setLng(BigDecimal lng) { this.lng = lng; }

    public Boolean getIs_manual() { return is_manual; }
    public void setIs_manual(Boolean is_manual) { this.is_manual = is_manual; }

    public LocalDateTime getUpdate_time() { return update_time; }
    public void setUpdate_time(LocalDateTime update_time) { this.update_time = update_time; }
}