package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import domain.Review;
import domain.User;
import dto.request.ReviewRequestDto;
import dto.response.ReviewResponseDto;
import repository.ReviewDao;
import repository.UserDao;

@Service
public class ReviewService {
    private final ReviewDao reviewDao;
    private final UserDao userDao;

    public ReviewService(ReviewDao reviewDao, UserDao userDao) {
        this.reviewDao = reviewDao;
        this.userDao = userDao;
    }

    // 1. 리뷰 작성
    public void writeReview(ReviewRequestDto dto, int writer_id) {
        if (reviewDao.findByRentalId(dto.getRental_id()) != null) {
            throw new IllegalArgumentException("이미 작성된 리뷰입니다.");
        }

        Review review = new Review();
        review.setContent(dto.getContent());
        review.setRating(dto.getRating());
        review.setRental_id(dto.getRental_id());
        review.setUser_write_id(writer_id);
        review.setUser_target_id(dto.getUser_target_id());

        reviewDao.insert(review);
    }

    // 2. 받은 리뷰 목록
    public List<ReviewResponseDto> getReviewsReceived(int user_id) {
        List<Review> reviews = reviewDao.findByUserTargetId(user_id);
        return toResponseDtoList(reviews);
    }

    // 3. 작성한 리뷰 목록
    public List<ReviewResponseDto> getReviewsWritten(int user_id) {
        List<Review> reviews = reviewDao.findByUserWriteId(user_id);
        return toResponseDtoList(reviews);
    }

    private List<ReviewResponseDto> toResponseDtoList(List<Review> reviews) {
        return reviews.stream().map(r -> {
            ReviewResponseDto dto = new ReviewResponseDto();
            User writer = userDao.findById(r.getUser_write_id());
            dto.setWriter_nick_name(writer != null ? writer.getNick_name() : "알 수 없음");
            dto.setContent(r.getContent());
            dto.setRating(r.getRating());
            dto.setCreated_at(r.getCreated_at());
            return dto;
        }).collect(Collectors.toList());
    }
}