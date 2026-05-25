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
public final class OrderRepository_Factory implements Factory<OrderRepository> {
  private final Provider<DatabaseConfig> dbConfigProvider;

  public OrderRepository_Factory(Provider<DatabaseConfig> dbConfigProvider) {
    this.dbConfigProvider = dbConfigProvider;
  }

  @Override
  public OrderRepository get() {
    return newInstance(dbConfigProvider.get());
  }

  public static OrderRepository_Factory create(Provider<DatabaseConfig> dbConfigProvider) {
    return new OrderRepository_Factory(dbConfigProvider);
  }

  public static OrderRepository newInstance(DatabaseConfig dbConfig) {
    return new OrderRepository(dbConfig);
  }
}
