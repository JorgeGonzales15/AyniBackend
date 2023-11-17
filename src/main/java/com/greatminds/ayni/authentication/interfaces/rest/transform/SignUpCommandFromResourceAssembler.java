package com.greatminds.ayni.authentication.interfaces.rest.transform;

import com.greatminds.ayni.authentication.domain.model.commands.SignUpCommand;
import com.greatminds.ayni.authentication.interfaces.rest.resources.SignUpResource;

public class SignUpCommandFromResourceAssembler {

    public static SignUpCommand toCommandFromResource(SignUpResource resource){
        return new SignUpCommand(
                resource.username(),
                resource.email(),
                resource.password(),
                resource.role()
        );
    }
}
