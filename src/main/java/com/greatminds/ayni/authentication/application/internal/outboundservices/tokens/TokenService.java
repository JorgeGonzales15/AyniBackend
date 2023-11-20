package com.greatminds.ayni.authentication.application.internal.outboundservices.tokens;

public interface TokenService {

    String generateToken(String username);
    String getUsernameFromToken(String token);
    boolean validateToken(String token);
}
