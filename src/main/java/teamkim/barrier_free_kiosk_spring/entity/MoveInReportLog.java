package teamkim.barrier_free_kiosk_spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import teamkim.barrier_free_kiosk_spring.dto.MoveInReportReqDto;
import teamkim.barrier_free_kiosk_spring.enums.MoveInReason;

@Entity
@Getter
@NoArgsConstructor
public class MoveInReportLog extends Log {
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "sido", column = @Column(name = "old_sido")),
            @AttributeOverride(name = "sigungu", column = @Column(name = "old_sigungu")),
            @AttributeOverride(name = "roadName", column = @Column(name = "old_road_name")),
            @AttributeOverride(name = "buildingNumber", column = @Column(name = "old_building_number")),
            @AttributeOverride(name = "detailAddress", column = @Column(name = "old_detail_address"))
    })
    private Address oldAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "sido", column = @Column(name = "new_sido")),
            @AttributeOverride(name = "sigungu", column = @Column(name = "new_sigungu")),
            @AttributeOverride(name = "roadName", column = @Column(name = "new_road_name")),
            @AttributeOverride(name = "buildingNumber", column = @Column(name = "new_building_number")),
            @AttributeOverride(name = "detailAddress", column = @Column(name = "new_detail_address"))
    })
    private Address newAddress;

    @Enumerated(EnumType.STRING)
    private MoveInReason reason;

    public MoveInReportLog(User user, Address oldAddress, Address newAddress, MoveInReason reason) {
        super(user);
        this.oldAddress = oldAddress;
        this.newAddress = newAddress;
        this.reason = reason;
    }

    public static MoveInReportLog from(MoveInReportReqDto moveInReportReqDto, User user) {
        return new MoveInReportLog(
                user,
                Address.from(moveInReportReqDto.oldAddress()),
                Address.from(moveInReportReqDto.newAddress()),
                moveInReportReqDto.reason()
        );
    }
}
