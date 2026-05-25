package com.lab6.config;

import javax.inject.Inject;

public class AppConfig {

    @Inject
    public AppConfig() {}

    public String getAppName() {
        return "Lab6 App";
    }
}
