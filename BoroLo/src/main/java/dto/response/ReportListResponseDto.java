package dto.response;

import java.util.List;

public class ReportListResponseDto {
    private List<ReportResponseDto> reports;

	public List<ReportResponseDto> getReports() {
		return reports;
	}
	public void setReports(List<ReportResponseDto> reports) {
		this.reports = reports;
	}
}