package com.lab6.notification;

import com.lab6.config.SmtpConfig;
import javax.inject.Inject;

public class EmailSender {

    private final SmtpConfig smtpConfig;

    @Inject
    public EmailSender(SmtpConfig smtpConfig) {
        this.smtpConfig = smtpConfig;
    }

    public void sendEmail(String to, String message) {
        System.out.println("EmailSender: sending email to " + to + " via " + smtpConfig.getHost());
        System.out.println("  Message: " + message);
    }
}
