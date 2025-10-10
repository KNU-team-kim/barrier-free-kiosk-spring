package teamkim.barrier_free_kiosk_spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import teamkim.barrier_free_kiosk_spring.dto.request.MoveInReportReqDto;
import teamkim.barrier_free_kiosk_spring.dto.response.AddressGetResDto;
import teamkim.barrier_free_kiosk_spring.service.KioskService;
import teamkim.barrier_free_kiosk_spring.dto.request.ResidentRegistrationReqDto;

@Validated
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class KioskController {
    private final KioskService kioskService;

    @PostMapping("/move-in")
    @Operation(summary = "전입 신고 API")
    public ResponseEntity<Long> postMoveInReport(@Valid @RequestBody MoveInReportReqDto moveInReportReqDto) {
        return ResponseEntity.ok(kioskService.registerMoveInReport(moveInReportReqDto));
    }

    @PostMapping("/resident-registration")
    @Operation(summary = "주민등록초본 발급 API")
    public ResponseEntity<Long> postResidentRegistration(@Valid @RequestBody ResidentRegistrationReqDto residentRegistrationReqDto) {
        return ResponseEntity.ok(kioskService.issueResidentRegistration(residentRegistrationReqDto));
    }

    @GetMapping("/move-in/check")
    @Operation(summary = "전화번호 유효성 체크 API")
    public ResponseEntity<Boolean> getPhoneNumberValidity(@RequestParam @NotBlank String phoneNumber, @RequestParam @NotBlank String name) {
        return ResponseEntity.ok(kioskService.checkPhoneNumberAndName(phoneNumber, name));
    }

    @GetMapping("/move-in/address")
    @Operation(summary = "주소 검색 API")
    public ResponseEntity<AddressGetResDto> getAddress(@RequestParam @NotBlank String name, @RequestParam @NotBlank String phoneNumber) {
        return ResponseEntity.ok(kioskService.retrieveAddress(name, phoneNumber));
    }
}
