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
public final class SecurityConfig_Factory implements Factory<SecurityConfig> {
  @Override
  public SecurityConfig get() {
    return newInstance();
  }

  public static SecurityConfig_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static SecurityConfig newInstance() {
    return new SecurityConfig();
  }

  private static final class InstanceHolder {
    private static final SecurityConfig_Factory INSTANCE = new SecurityConfig_Factory();
  }
}
