package com.lab6.service;

import com.lab6.auth.AuthService;
import com.lab6.repository.UserRepository;
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
public final class UserService_Factory implements Factory<UserService> {
  private final Provider<UserRepository> userRepositoryProvider;

  private final Provider<AuthService> authServiceProvider;

  public UserService_Factory(Provider<UserRepository> userRepositoryProvider,
      Provider<AuthService> authServiceProvider) {
    this.userRepositoryProvider = userRepositoryProvider;
    this.authServiceProvider = authServiceProvider;
  }

  @Override
  public UserService get() {
    return newInstance(userRepositoryProvider.get(), authServiceProvider.get());
  }

  public static UserService_Factory create(Provider<UserRepository> userRepositoryProvider,
      Provider<AuthService> authServiceProvider) {
    return new UserService_Factory(userRepositoryProvider, authServiceProvider);
  }

  public static UserService newInstance(UserRepository userRepository, AuthService authService) {
    return new UserService(userRepository, authService);
  }
}
