package com.ensayo.mapstrcut.domain.entites;

import java.util.List;

import com.ensayo.mapstrcut.utils.enums.RoleUser;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 50, nullable = false)
    private String username;
    @Column(length = 100, nullable = false)
    private String password;
    @Column(length = 100, nullable = false)
    private String email;
    @Column(length = 100, nullable = false)
    private String full_name;
    @Enumerated(EnumType.STRING)
    private RoleUser role;

    @OneToMany(mappedBy = "userEntity",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<LoanEntity> loanEntities;

    @OneToMany(mappedBy = "userEntity",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<ReservationEntity> reservationEntities;

}

