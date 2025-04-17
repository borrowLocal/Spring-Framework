package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import domain.Item;
import dto.request.FavoriteRequestDto;
import dto.response.FavoriteListResponseDto;
import dto.response.ItemSummaryDto;
import repository.FavoriteDao;
import repository.ItemDao;

@Service
public class FavoriteService {

    private final FavoriteDao favoriteDao;
    private final ItemDao itemDao;

    public FavoriteService(FavoriteDao favoriteDao, ItemDao itemDao) {
        this.favoriteDao = favoriteDao;
        this.itemDao = itemDao;
    }

    // 즐겨찾기 등록
    public void addFavorite(FavoriteRequestDto dto, int user_id) {
        boolean exists = favoriteDao.exists(user_id, dto.getItem_id());
        if (exists) {
            throw new IllegalArgumentException("이미 즐겨찾기에 추가된 항목입니다.");
        }
        favoriteDao.insertFavorite(user_id, dto.getItem_id());
    }

    // 즐겨찾기 삭제
    public void removeFavorite(int item_id, int user_id) {
        if (!favoriteDao.exists(user_id, item_id)) {
            throw new IllegalArgumentException("즐겨찾기에 등록되어 있지 않은 항목입니다.");
        }
        favoriteDao.deleteFavorite(user_id, item_id);
    }

    // 즐겨찾기 목록 조회
    public FavoriteListResponseDto getFavorites(int user_id) {
        List<Item> items = favoriteDao.findFavoritesByUserId(user_id);

        List<ItemSummaryDto> summaries = items.stream().map(item -> {
            ItemSummaryDto dto = new ItemSummaryDto();
            dto.setItem_id(item.getItem_id());
            dto.setTitle(item.getTitle());
            dto.setPrice_per_day(item.getPrice_per_day());
            dto.setImage_url(item.getImage_url());
            dto.setLocation(item.getLocation());
            dto.setItem_status(item.getItem_status());
            return dto;
        }).collect(Collectors.toList());

        FavoriteListResponseDto result = new FavoriteListResponseDto();
        result.setFavorites(summaries);
        return result;
    }
}