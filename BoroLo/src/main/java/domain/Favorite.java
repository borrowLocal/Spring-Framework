package domain;

import java.time.LocalDateTime;

public class Favorite {
    private Integer user_id;
    private Integer item_id;
    private LocalDateTime created_at;

    public Integer getUser_id() { return user_id; }
    public void setUser_id(Integer user_id) { this.user_id = user_id; }

    public Integer getItem_id() { return item_id; }
    public void setItem_id(Integer item_id) { this.item_id = item_id; }

    public LocalDateTime getCreated_at() { return created_at; }
    public void setCreated_at(LocalDateTime created_at) { this.created_at = created_at; }
}