package com.lab6.auth;

import com.lab6.config.SecurityConfig;
import javax.inject.Inject;

public class AuthService {

    private final SecurityConfig securityConfig;

    @Inject
    public AuthService(SecurityConfig securityConfig) {
        this.securityConfig = securityConfig;
    }

    public boolean authenticate(String token) {
        boolean result = token.equals(securityConfig.getSecretKey());
        System.out.println("AuthService: token check - " + (result ? "success" : "failed"));
        return result;
    }
}
