package com.greatminds.ayni.authentication.interfaces.rest;

import com.greatminds.ayni.authentication.domain.model.queries.GetUserByIdQuery;
import com.greatminds.ayni.authentication.domain.services.UserCommandService;
import com.greatminds.ayni.authentication.domain.services.UserQueryService;
import com.greatminds.ayni.authentication.interfaces.rest.resources.SignInResource;
import com.greatminds.ayni.authentication.interfaces.rest.resources.SignUpResource;
import com.greatminds.ayni.authentication.interfaces.rest.transform.SignInCommandFromResourceAssembler;
import com.greatminds.ayni.authentication.interfaces.rest.transform.AuthenticatedUserResourceFromEntityAssembler;
import com.greatminds.ayni.authentication.interfaces.rest.transform.SignUpCommandFromResourceAssembler;
import com.greatminds.ayni.authentication.interfaces.rest.transform.UserResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Authentication", description = "Authentication endpoints")
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final UserQueryService userQueryService;
    private final UserCommandService userCommandService;

    public AuthController(UserQueryService userQueryService, UserCommandService userCommandService) {
        this.userQueryService = userQueryService;
        this.userCommandService = userCommandService;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody SignInResource resource){
        var signInCommand = SignInCommandFromResourceAssembler.toCommandFromResource(resource);
        var authenticatedUser = userCommandService.handle(signInCommand);
        if (authenticatedUser.isEmpty()) return ResponseEntity.notFound().build();

        var authenticatedResource = AuthenticatedUserResourceFromEntityAssembler.toResourceFromEntity(authenticatedUser.get().getLeft(), authenticatedUser.get().getRight());
        return new ResponseEntity<>(authenticatedResource, HttpStatus.ACCEPTED);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpResource resource){
        var signInCommand = SignUpCommandFromResourceAssembler.toCommandFromResource(resource);
        var userId = userCommandService.handle(signInCommand);
        if (userId == 0L){
            return ResponseEntity.badRequest().build();
        }

        var getUserByIdQuery = new GetUserByIdQuery(userId);
        var user = userQueryService.handle(getUserByIdQuery);

        if (user.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return new ResponseEntity<>(userResource, HttpStatus.CREATED);
    }
}
