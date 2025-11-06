package teamkim.barrier_free_kiosk_spring.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import teamkim.barrier_free_kiosk_spring.dto.request.MoveInReportReqDto;

@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String sido;

    private String sigungu;

    private String roadName;

    private Integer mainBuildingNumber;

    private Integer subBuildingNumber;

    private String detailAddress;

    public static Address from(MoveInReportReqDto.Address address) {
        return new Address(
                address.sido(),
                address.sigungu(),
                address.roadName(),
                address.mainBuildingNumber(),
                address.subBuildingNumber(),
                address.detail()
        );
    }
}
