package teamkim.barrier_free_kiosk_spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import teamkim.barrier_free_kiosk_spring.dto.MoveInReportReqDto;
import teamkim.barrier_free_kiosk_spring.entity.Address;
import teamkim.barrier_free_kiosk_spring.entity.MoveInReportLog;
import teamkim.barrier_free_kiosk_spring.entity.User;
import teamkim.barrier_free_kiosk_spring.exception.CustomException;
import teamkim.barrier_free_kiosk_spring.exception.ExceptionCode;
import teamkim.barrier_free_kiosk_spring.repository.LogRepository;
import teamkim.barrier_free_kiosk_spring.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class KioskService {
    private final UserRepository userRepository;
    private final LogRepository logRepository;

    @Transactional
    public Long registerMoveInReport(MoveInReportReqDto moveInReportReqDto) {
        User user = userRepository.findByPhoneNumberAndName(moveInReportReqDto.phoneNumber(), moveInReportReqDto.name())
                .orElseThrow(() -> new CustomException(ExceptionCode.USER_NOT_FOUND));

        user.updateAddress(Address.from(moveInReportReqDto.newAddress()));

        MoveInReportLog moveInReportLog = logRepository.save(MoveInReportLog.from(moveInReportReqDto, user));

        return moveInReportLog.getId();
    }
}
