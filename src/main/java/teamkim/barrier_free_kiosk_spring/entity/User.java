package teamkim.barrier_free_kiosk_spring.entity;

import jakarta.persistence.*;
import teamkim.barrier_free_kiosk_spring.enums.Gender;

@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String registrationNumber;

    private String name;

    @Column(unique = true)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Embedded
    private Address address;

    public void updateAddress(Address address) {
        this.address = address;
    }
}
