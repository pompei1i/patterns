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
public final class ProductRepository_Factory implements Factory<ProductRepository> {
  private final Provider<DatabaseConfig> dbConfigProvider;

  public ProductRepository_Factory(Provider<DatabaseConfig> dbConfigProvider) {
    this.dbConfigProvider = dbConfigProvider;
  }

  @Override
  public ProductRepository get() {
    return newInstance(dbConfigProvider.get());
  }

  public static ProductRepository_Factory create(Provider<DatabaseConfig> dbConfigProvider) {
    return new ProductRepository_Factory(dbConfigProvider);
  }

  public static ProductRepository newInstance(DatabaseConfig dbConfig) {
    return new ProductRepository(dbConfig);
  }
}
