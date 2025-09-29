package teamkim.barrier_free_kiosk_spring.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import teamkim.barrier_free_kiosk_spring.enums.MoveInReason;

public record MoveInReportReqDto(
        @NotBlank String name,
        @NotBlank String phoneNumber,
        @NotNull MoveInReason reason,
        @NotNull @Valid Address oldAddress,
        @NotNull @Valid Address newAddress
) {
    public record Address(
            @NotBlank String sido,
            @NotBlank String sigungu,
            @NotBlank String roadName,
            @NotNull Integer buildingNumber,
            @NotNull String detailAddress
    ) {}
}
