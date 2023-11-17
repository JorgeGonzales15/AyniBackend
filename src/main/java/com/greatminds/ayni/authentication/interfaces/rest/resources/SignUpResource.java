package com.greatminds.ayni.authentication.interfaces.rest.resources;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SignUpResource(
        String username,
        String email,
        String role,
        String password
) {
}
