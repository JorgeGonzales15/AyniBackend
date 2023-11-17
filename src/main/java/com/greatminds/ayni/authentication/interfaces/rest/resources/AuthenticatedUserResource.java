package com.greatminds.ayni.authentication.interfaces.rest.resources;

import com.greatminds.ayni.authentication.domain.model.valueobjects.Role;

import java.util.Set;

public record AuthenticatedUserResource (Long id,
                                         String username,
                                         String email,
                                         Set<Role> roles,
                                         String token) {
}
