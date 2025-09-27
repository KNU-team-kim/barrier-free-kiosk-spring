package teamkim.barrier_free_kiosk_spring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import teamkim.barrier_free_kiosk_spring.enums.MoveInReason;

public record MoveInReportReqDto(
        @NotBlank String name,
        @NotBlank String phoneNumber,
        @NotNull MoveInReason reason,
        @NotNull Address oldAddress,
        @NotNull Address newAddress
) {
    public record Address(
            @NotBlank String sido,
            @NotBlank String sigungu,
            @NotBlank String roadName,
            @NotNull Integer buildingNumber,
            @NotNull String detailAddress
    ) {}
}
