package com.lab6.service;

import com.lab6.notification.EmailSender;
import com.lab6.notification.LogService;
import javax.inject.Inject;

public class NotificationService {

    private final EmailSender emailSender;
    private final LogService logService;

    @Inject
    public NotificationService(EmailSender emailSender, LogService logService) {
        this.emailSender = emailSender;
        this.logService = logService;
    }

    public void notify(String userEmail, String message) {
        System.out.println("NotificationService: sending notification...");
        emailSender.sendEmail(userEmail, message);
        logService.log("Notified " + userEmail);
    }
}
