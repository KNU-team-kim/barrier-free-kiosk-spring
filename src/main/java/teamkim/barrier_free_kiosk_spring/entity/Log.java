package teamkim.barrier_free_kiosk_spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@NoArgsConstructor
public class Log {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    protected User user;

    protected LocalDateTime createdAt;

    protected Log(User user) {
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }
}
