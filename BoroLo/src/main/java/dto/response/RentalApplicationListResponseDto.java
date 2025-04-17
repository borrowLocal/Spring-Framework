package dto.response;

import java.util.List;

public class RentalApplicationListResponseDto {
    private List<RentalStatusResponseDto> applicants;

	public List<RentalStatusResponseDto> getApplicants() {
		return applicants;
	}

	public void setApplicants(List<RentalStatusResponseDto> applicants) {
		this.applicants = applicants;
	}
}