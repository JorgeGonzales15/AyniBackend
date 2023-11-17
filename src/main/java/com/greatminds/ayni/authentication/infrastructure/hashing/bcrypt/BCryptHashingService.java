package com.greatminds.ayni.authentication.infrastructure.hashing.bcrypt;

import com.greatminds.ayni.authentication.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface BCryptHashingService extends HashingService, PasswordEncoder {
}
