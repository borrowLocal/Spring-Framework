package dto.response;

import java.time.LocalDateTime;

public class ReviewResponseDto {
    private String writer_nick_name;
    private String content;
    private Integer rating;
    private LocalDateTime created_at;

    public String getWriter_nick_name() { return writer_nick_name; }
    public void setWriter_nick_name(String writer_nick_name) { this.writer_nick_name = writer_nick_name; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public LocalDateTime getCreated_at() { return created_at; }
    public void setCreated_at(LocalDateTime created_at) { this.created_at = created_at; }
}