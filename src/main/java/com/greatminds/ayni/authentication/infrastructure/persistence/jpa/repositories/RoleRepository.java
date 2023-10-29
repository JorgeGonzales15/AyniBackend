package com.greatminds.ayni.authentication.infrastructure.persistence.jpa.repositories;

import com.greatminds.ayni.authentication.domain.model.aggregates.Role;
import com.greatminds.ayni.authentication.domain.model.valueobjects.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
