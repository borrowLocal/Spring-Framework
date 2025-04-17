package dto.response;

import java.util.List;

public class ReviewListResponseDto {
    private List<ReviewResponseDto> reviews;

	public List<ReviewResponseDto> getReviews() {
		return reviews;
	}
	public void setReviews(List<ReviewResponseDto> reviews) {
		this.reviews = reviews;
	}
}