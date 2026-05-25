package com.lab6.notification;

import com.lab6.config.AppConfig;
import javax.inject.Inject;

public class LogService {

    private final AppConfig appConfig;

    @Inject
    public LogService(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    public void log(String message) {
        System.out.println("[" + appConfig.getAppName() + "] LOG: " + message);

    }
}
