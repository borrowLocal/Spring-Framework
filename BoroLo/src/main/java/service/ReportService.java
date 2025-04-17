package service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import domain.Report;
import dto.request.ReportRequestDto;
import dto.response.ReportResponseDto;
import repository.ReportDao;

@Service
public class ReportService {
    private final ReportDao reportDao;

    public ReportService(ReportDao reportDao) {
        this.reportDao = reportDao;
    }

    // 1. 신고 등록
    public void submitReport(ReportRequestDto dto, int reporter_id) {
        Report report = new Report();
        report.setReporter_id(reporter_id);
        report.setTarget_user_id(dto.getTarget_user_id());
        report.setRental_id(dto.getRental_id());
        report.setReason(dto.getReason());
        report.setCreated_at(LocalDateTime.now());

        reportDao.insert(report);
    }

    // 2. 받은 신고 조회
    public List<ReportResponseDto> getReportsAboutUser(int user_id) {
        List<Report> reports = reportDao.findByTargetUserId(user_id);

        return reports.stream().map(report -> {
            ReportResponseDto dto = new ReportResponseDto();
            dto.setReason(report.getReason());
            dto.setCreated_at(report.getCreated_at());
            return dto;
        }).collect(Collectors.toList());
    }
}