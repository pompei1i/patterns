package com.lab6.repository;

import com.lab6.config.DatabaseConfig;
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
public final class UserRepository_Factory implements Factory<UserRepository> {
  private final Provider<DatabaseConfig> dbConfigProvider;

  public UserRepository_Factory(Provider<DatabaseConfig> dbConfigProvider) {
    this.dbConfigProvider = dbConfigProvider;
  }

  @Override
  public UserRepository get() {
    return newInstance(dbConfigProvider.get());
  }

  public static UserRepository_Factory create(Provider<DatabaseConfig> dbConfigProvider) {
    return new UserRepository_Factory(dbConfigProvider);
  }

  public static UserRepository newInstance(DatabaseConfig dbConfig) {
    return new UserRepository(dbConfig);
  }
}
