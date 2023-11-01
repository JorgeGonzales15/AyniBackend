package com.greatminds.ayni.authentication.domain.model.aggregates;

import com.greatminds.ayni.authentication.domain.model.valueobjects.ERole;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    @Getter
    private ERole name;

    public Role() {}
}
