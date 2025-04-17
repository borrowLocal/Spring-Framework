package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.request.FavoriteRequestDto;
import dto.response.FavoriteListResponseDto;
import service.FavoriteService;

@RestController
@RequestMapping("/favorites")
public class FavoriteController {
    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    // 즐겨찾기 추가
    @PostMapping
    public ResponseEntity<Void> addFavorite(@RequestParam int user_id, @RequestBody FavoriteRequestDto dto) {
        try {
            favoriteService.addFavorite(dto, user_id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // 즐겨찾기 삭제
    @DeleteMapping("/{item_id}")
    public ResponseEntity<Void> removeFavorite(@PathVariable int item_id, @RequestParam int user_id) {
        try {
            favoriteService.removeFavorite(item_id, user_id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // 즐겨찾기 목록 조회
    @GetMapping("/{user_id}")
    public ResponseEntity<FavoriteListResponseDto> getFavorites(@PathVariable int user_id) {
        return ResponseEntity.ok(favoriteService.getFavorites(user_id));
    }
}