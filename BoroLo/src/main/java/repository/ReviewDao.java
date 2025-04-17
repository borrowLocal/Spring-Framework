package repository;

import org.apache.ibatis.annotations.Param;
import java.util.List;

import domain.Review;

public interface ReviewDao {
    List<Review> findByUserTargetId(@Param("user_id") int user_id);
    List<Review> findByUserWriteId(@Param("user_id") int user_id);
    Review findByRentalId(@Param("rental_id") int rental_id);

    void insert(Review review);
}