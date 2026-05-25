package com.lab6.config;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class SmtpConfig_Factory implements Factory<SmtpConfig> {
  @Override
  public SmtpConfig get() {
    return newInstance();
  }

  public static SmtpConfig_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static SmtpConfig newInstance() {
    return new SmtpConfig();
  }

  private static final class InstanceHolder {
    private static final SmtpConfig_Factory INSTANCE = new SmtpConfig_Factory();
  }
}
