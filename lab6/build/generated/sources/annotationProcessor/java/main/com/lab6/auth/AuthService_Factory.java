package com.lab6.auth;

import com.lab6.config.SecurityConfig;
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
public final class AuthService_Factory implements Factory<AuthService> {
  private final Provider<SecurityConfig> securityConfigProvider;

  public AuthService_Factory(Provider<SecurityConfig> securityConfigProvider) {
    this.securityConfigProvider = securityConfigProvider;
  }

  @Override
  public AuthService get() {
    return newInstance(securityConfigProvider.get());
  }

  public static AuthService_Factory create(Provider<SecurityConfig> securityConfigProvider) {
    return new AuthService_Factory(securityConfigProvider);
  }

  public static AuthService newInstance(SecurityConfig securityConfig) {
    return new AuthService(securityConfig);
  }
}
