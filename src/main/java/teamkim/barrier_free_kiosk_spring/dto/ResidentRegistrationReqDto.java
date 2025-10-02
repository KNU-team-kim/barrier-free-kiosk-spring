package teamkim.barrier_free_kiosk_spring.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import teamkim.barrier_free_kiosk_spring.enums.RegistrationCopyType;

public record ResidentRegistrationReqDto(
        @NotBlank String name,
        @NotBlank String phoneNumber,
        @NotNull RegistrationCopyType type,
        @NotNull @Min(1) Integer copyNumber
) {
}