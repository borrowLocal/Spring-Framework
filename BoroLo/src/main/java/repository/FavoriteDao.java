package repository;

import domain.Item;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface FavoriteDao {
    List<Item> findFavoritesByUserId(@Param("user_id") int user_id);
    int countByUserId(int user_id);

    void insertFavorite(@Param("user_id") int user_id, @Param("item_id") int item_id);
    void deleteFavorite(@Param("user_id") int user_id, @Param("item_id") int item_id);
    boolean exists(@Param("user_id") int user_id, @Param("item_id") int item_id);
}