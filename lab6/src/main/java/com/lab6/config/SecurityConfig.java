package com.lab6.config;

import javax.inject.Inject;

public class SecurityConfig {

    @Inject
    public SecurityConfig() {}

    public String getSecretKey() {
        return "my-secret-key";
    }
}
