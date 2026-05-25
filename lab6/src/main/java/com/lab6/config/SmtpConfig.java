package com.lab6.config;

import javax.inject.Inject;

public class SmtpConfig {

    @Inject
    public SmtpConfig() {}

    public String getHost() {
        return "smtp.example.com";
    }
}
