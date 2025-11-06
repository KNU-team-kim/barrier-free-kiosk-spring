package teamkim.barrier_free_kiosk_spring.dto.response;

import teamkim.barrier_free_kiosk_spring.entity.Address;

public record AddressGetResDto(
        String sido,
        String sigungu,
        String roadName,
        Integer mainBuildingNumber,
        Integer subBuildingNumber,
        String detail
) {

    public static AddressGetResDto from(Address address) {
        return new AddressGetResDto(
                address.getSido(),
                address.getSigungu(),
                address.getRoadName(),
                address.getMainBuildingNumber(),
                address.getSubBuildingNumber(),
                address.getDetailAddress()
        );
    }
}
