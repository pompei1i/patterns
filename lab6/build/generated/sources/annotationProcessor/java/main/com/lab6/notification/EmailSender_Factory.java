package com.lab6.notification;

import com.lab6.config.SmtpConfig;
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
public final class EmailSender_Factory implements Factory<EmailSender> {
  private final Provider<SmtpConfig> smtpConfigProvider;

  public EmailSender_Factory(Provider<SmtpConfig> smtpConfigProvider) {
    this.smtpConfigProvider = smtpConfigProvider;
  }

  @Override
  public EmailSender get() {
    return newInstance(smtpConfigProvider.get());
  }

  public static EmailSender_Factory create(Provider<SmtpConfig> smtpConfigProvider) {
    return new EmailSender_Factory(smtpConfigProvider);
  }

  public static EmailSender newInstance(SmtpConfig smtpConfig) {
    return new EmailSender(smtpConfig);
  }
}
