package com.greatminds.ayni.authentication.domain.model.commands;

public record SignUpCommand(
        String username,
        String email,
        String password,
        String role
) {
}
