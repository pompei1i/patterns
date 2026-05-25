package com.lab6.notification;

import com.lab6.config.AppConfig;
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
public final class LogService_Factory implements Factory<LogService> {
  private final Provider<AppConfig> appConfigProvider;

  public LogService_Factory(Provider<AppConfig> appConfigProvider) {
    this.appConfigProvider = appConfigProvider;
  }

  @Override
  public LogService get() {
    return newInstance(appConfigProvider.get());
  }

  public static LogService_Factory create(Provider<AppConfig> appConfigProvider) {
    return new LogService_Factory(appConfigProvider);
  }

  public static LogService newInstance(AppConfig appConfig) {
    return new LogService(appConfig);
  }
}
