package io.github.ryansilva.veticore.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter @Setter
@EqualsAndHashCode(of = "id")@ToString(of = "id")
@Entity
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String phone;
    private String email;
    private boolean active;
    private LocalDateTime createdAt;

    @PrePersist
    private void prePersist() {
        this.active = true;
        this.createdAt = LocalDateTime.now();
    }
}
