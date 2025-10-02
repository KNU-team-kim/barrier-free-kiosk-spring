package teamkim.barrier_free_kiosk_spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import teamkim.barrier_free_kiosk_spring.dto.MoveInReportReqDto;
import teamkim.barrier_free_kiosk_spring.service.KioskService;
import teamkim.barrier_free_kiosk_spring.dto.ResidentRegistrationReqDto;

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
}
