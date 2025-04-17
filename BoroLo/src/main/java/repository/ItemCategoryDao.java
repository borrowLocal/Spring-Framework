package repository;

import java.util.List;

import domain.ItemCategory;

public interface ItemCategoryDao {
    List<ItemCategory> findAll();
    ItemCategory findById(int category_id);
    List<ItemCategory> findByGroup(String group);

    void insert(ItemCategory category);
    void update(ItemCategory category);
    void delete(int category_id);
}