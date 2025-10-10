package teamkim.barrier_free_kiosk_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import teamkim.barrier_free_kiosk_spring.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByPhoneNumberAndName(String phoneNumber, String name);

    Optional<User> findByRegistrationNumber(String registrationNumber);
}
