package com.lab6.service;

import com.lab6.notification.EmailSender;
import com.lab6.notification.LogService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class NotificationService_Factory implements Factory<NotificationService> {
  private final Provider<EmailSender> emailSenderProvider;

  private final Provider<LogService> logServiceProvider;

  public NotificationService_Factory(Provider<EmailSender> emailSenderProvider,
      Provider<LogService> logServiceProvider) {
    this.emailSenderProvider = emailSenderProvider;
    this.logServiceProvider = logServiceProvider;
  }

  @Override
  public NotificationService get() {
    return newInstance(emailSenderProvider.get(), logServiceProvider.get());
  }

  public static NotificationService_Factory create(Provider<EmailSender> emailSenderProvider,
      Provider<LogService> logServiceProvider) {
    return new NotificationService_Factory(emailSenderProvider, logServiceProvider);
  }

  public static NotificationService newInstance(EmailSender emailSender, LogService logService) {
    return new NotificationService(emailSender, logService);
  }
}
