package controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.request.RegisterItemRequestDto;
import dto.response.ItemDetailResponseDto;
import dto.response.ItemSummaryDto;
import service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // 1. 물품 등록
    @PostMapping
    public ResponseEntity<Void> registerItem(@RequestBody RegisterItemRequestDto dto) {
        try {
            itemService.registerItem(dto);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // 2. 물품 상세 조회
    @GetMapping("/{item_id}")
    public ResponseEntity<ItemDetailResponseDto> getItemDetail(@PathVariable int item_id) {
        try {
            ItemDetailResponseDto dto = itemService.getItemDetail(item_id);
            return ResponseEntity.ok(dto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // 3. 특정 사용자의 등록 물품 목록
    @GetMapping("/user/{user_id}")
    public ResponseEntity<List<ItemSummaryDto>> getItemListByUser(@PathVariable int user_id) {
        List<ItemSummaryDto> items = itemService.getItemListByUser(user_id);
        return ResponseEntity.ok(items);
    }

    // 4. 물품 수정
    @PutMapping("/{item_id}")
    public ResponseEntity<Void> updateItem(@PathVariable int item_id, @RequestBody UpdateItemRequestDto dto) {
        try {
            itemService.updateItem(item_id, dto);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // 5. 물품 삭제
    @DeleteMapping("/{item_id}")
    public ResponseEntity<Void> deleteItem(@PathVariable int item_id) {
        try {
            itemService.deleteItem(item_id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}