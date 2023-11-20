package com.greatminds.ayni.authentication.domain.model.commands;

public record SignInCommand(
        String username,
        String password
) {
}
