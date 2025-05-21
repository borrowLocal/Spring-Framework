package controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.response.DepositResponseDto;
import service.DepositService;

@RestController
@RequestMapping("/deposits")
public class DepositController {

    private final DepositService depositService;

    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }

    // 내가 거래한 보증금 내역 조회
    @GetMapping("/renter/{user_id}")
    public ResponseEntity<List<DepositResponseDto>> getDepositsAsRenter(@PathVariable int user_id) {
        return ResponseEntity.ok(depositService.getDepositsAsRenter(user_id));
    }

    // 내가 등록한 물품의 보증금 내역 조회
    @GetMapping("/owner/{user_id}")
    public ResponseEntity<List<DepositResponseDto>> getDepositsAsItemOwner(@PathVariable int user_id) {
        return ResponseEntity.ok(depositService.getDepositsAsItemOwner(user_id));
    }
}