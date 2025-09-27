package teamkim.barrier_free_kiosk_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import teamkim.barrier_free_kiosk_spring.entity.Log;

public interface LogRepository extends JpaRepository<Log, Long> {
}
