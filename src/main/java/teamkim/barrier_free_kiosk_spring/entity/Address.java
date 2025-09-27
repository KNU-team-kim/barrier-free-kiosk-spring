package teamkim.barrier_free_kiosk_spring.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import teamkim.barrier_free_kiosk_spring.dto.MoveInReportReqDto;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String sido;

    private String sigungu;

    private String roadName;

    private Integer buildingNumber;

    private String detailAddress;

    public static Address from(MoveInReportReqDto.Address address) {
        return new Address(
                address.sido(),
                address.sigungu(),
                address.roadName(),
                address.buildingNumber(),
                address.detailAddress()
        );
    }
}
