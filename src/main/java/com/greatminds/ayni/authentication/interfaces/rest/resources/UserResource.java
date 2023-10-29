package com.greatminds.ayni.authentication.interfaces.rest.resources;

import com.greatminds.ayni.authentication.domain.model.aggregates.Role;

import java.util.Set;

public record UserResource(
        Long id,
        String username,
        String email,
        Set<Role> roles
) {
}
