package repository;

import java.util.List;

import domain.Item;

public interface ItemDao {
    Item findById(int item_id);
    List<Item> findByUserId(int user_id);
    List<Item> findByCategoryId(int category_id);
    List<Item> findAvailableItems(); // 대여 가능 목록
    int countByUserId(int user_id);

    void insert(Item item);
    void update(Item item);
    void delete(int item_id);
}