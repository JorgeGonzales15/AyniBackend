package com.greatminds.ayni.authentication.interfaces.rest.transform;

import com.greatminds.ayni.authentication.domain.model.commands.SignInCommand;
import com.greatminds.ayni.authentication.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource resource){
        return new SignInCommand(
                resource.username(),
                resource.password()
        );
    }
}
