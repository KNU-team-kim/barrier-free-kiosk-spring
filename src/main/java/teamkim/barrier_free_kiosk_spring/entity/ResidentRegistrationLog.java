package teamkim.barrier_free_kiosk_spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import teamkim.barrier_free_kiosk_spring.dto.ResidentRegistrationReqDto;
import teamkim.barrier_free_kiosk_spring.enums.RegistrationCopyType;

@Entity
@Getter
@NoArgsConstructor
public class ResidentRegistrationLog extends Log {

    @Enumerated(EnumType.STRING)
    private RegistrationCopyType type;

    private Integer copyNumber;

    public ResidentRegistrationLog(User user, RegistrationCopyType type, Integer copyNumber) {
        super(user);
        this.type = type;
        this.copyNumber = copyNumber;
    }

    public static ResidentRegistrationLog from(ResidentRegistrationReqDto dto, User user) {
        return new ResidentRegistrationLog(
                user,
                dto.type(),
                dto.copyNumber()
        );
    }
}