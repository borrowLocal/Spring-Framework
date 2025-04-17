package service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import domain.Item;
import domain.ItemCategory;
import domain.User;
import dto.request.RegisterItemRequestDto;
import dto.response.ItemDetailResponseDto;
import dto.response.ItemSummaryDto;
import repository.ItemCategoryDao;
import repository.ItemDao;
import repository.UserDao;

@Service
public class ItemService {

    private final ItemDao itemDao;
    private final ItemCategoryDao itemCategoryDao;
    private final UserDao userDao;

    public ItemService(ItemDao itemDao, ItemCategoryDao itemCategoryDao, UserDao userDao) {
        this.itemDao = itemDao;
        this.itemCategoryDao = itemCategoryDao;
        this.userDao = userDao;
    }
    
		// 1. 물품 등록
    public void registerItem(RegisterItemRequestDto dto) {
        ItemCategory category = itemCategoryDao.findById(dto.getCategory_id());
        if (category == null) {
            throw new IllegalArgumentException("유효하지 않은 카테고리입니다.");
        }

        if (dto.getDeposit_amount() < dto.getPrice_per_day() * 0.1) {
            throw new IllegalArgumentException("보증금은 대여가의 10% 이상이어야 합니다.");
        }

        Item item = new Item();
        item.setTitle(dto.getTitle());
        item.setDescription(dto.getDescription());
        item.setPrice_per_day(dto.getPrice_per_day());
        item.setDeposit_amount(dto.getDeposit_amount());
        item.setImage_url(dto.getImage_url());
        item.setLocation(dto.getLocation());
        item.setItem_status("대여 전");
        item.setCreate_time(LocalDateTime.now());
        item.setUpdate_time(LocalDateTime.now());
        item.setUser_id(dto.getUser_id());
        item.setCategory_id(dto.getCategory_id());

        itemDao.insert(item);
    }

		// 2. 물품 조회 
    public ItemDetailResponseDto getItemDetail(int item_id) {
        Item item = itemDao.findById(item_id);
        if (item == null) {
            throw new IllegalArgumentException("해당 물품을 찾을 수 없습니다.");
        }

        ItemCategory category = itemCategoryDao.findById(item.getCategory_id());
        User owner = userDao.findById(item.getUser_id());

        ItemDetailResponseDto dto = new ItemDetailResponseDto();
        dto.setItem_id(item.getItem_id());
        dto.setTitle(item.getTitle());
        dto.setDescription(item.getDescription());
        dto.setPrice_per_day(item.getPrice_per_day());
        dto.setDeposit_amount(item.getDeposit_amount());
        dto.setImage_url(item.getImage_url());
        dto.setLocation(item.getLocation());
        dto.setItem_status(item.getItem_status());
        dto.setCategory_name(category != null ? category.getCategory_name() : null);
        dto.setOwner_nick_name(owner != null ? owner.getNick_name() : null);
        dto.setOwner_rating(owner != null ? owner.getRating() : null);

        return dto;
    }
		// 3. 유저 등록 물품 조회
    public List<ItemSummaryDto> getItemListByUser(int user_id) {
        List<Item> items = itemDao.findByUserId(user_id);
        return items.stream().map(item -> {
            ItemSummaryDto dto = new ItemSummaryDto();
            dto.setItem_id(item.getItem_id());
            dto.setTitle(item.getTitle());
            dto.setPrice_per_day(item.getPrice_per_day());
            dto.setImage_url(item.getImage_url());
            dto.setLocation(item.getLocation());
            dto.setItem_status(item.getItem_status());
            return dto;
        }).collect(Collectors.toList());
    }
		// 4. 등록 물품 수정
    public void updateItem(int item_id, UpdateItemRequestDto dto) {
        Item item = itemDao.findById(item_id);
        if (item == null) {
            throw new IllegalArgumentException("물품이 존재하지 않습니다.");
        }

        item.setTitle(dto.getTitle());
        item.setDescription(dto.getDescription());
        item.setPrice_per_day(dto.getPrice_per_day());
        item.setDeposit_amount(dto.getDeposit_amount());
        item.setImage_url(dto.getImage_url());
        item.setLocation(dto.getLocation());
        item.setUpdate_time(LocalDateTime.now());

        itemDao.update(item);
    }
		// 5. 물품 삭제
    public void deleteItem(int item_id) {
        Item item = itemDao.findById(item_id);
        if (item == null) {
            throw new IllegalArgumentException("삭제할 물품이 존재하지 않습니다.");
        }

        itemDao.delete(item_id);
    }
}