package com.greatminds.ayni.authentication.domain.services;

import com.greatminds.ayni.authentication.domain.model.aggregates.User;
import com.greatminds.ayni.authentication.domain.model.commands.SignInCommand;
import com.greatminds.ayni.authentication.domain.model.commands.SignUpCommand;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Optional;

public interface UserCommandService {
    Long handle(SignUpCommand command);
    Optional<ImmutablePair<User, String>> handle(SignInCommand command);
}
