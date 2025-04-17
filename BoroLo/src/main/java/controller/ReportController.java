package controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.request.ReportRequestDto;
import dto.response.ReportResponseDto;
import service.ReportService;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    // 1. 신고 등록
    @PostMapping
    public ResponseEntity<Void> submitReport(@RequestParam int reporter_id, @RequestBody ReportRequestDto dto) {
        try {
            reportService.submitReport(dto, reporter_id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // 2. 특정 유저가 받은 신고 목록 조회
    @GetMapping("/target/{user_id}")
    public ResponseEntity<List<ReportResponseDto>> getReportsAboutUser(@PathVariable int user_id) {
        try {
            List<ReportResponseDto> reports = reportService.getReportsAboutUser(user_id);
            return ResponseEntity.ok(reports);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}