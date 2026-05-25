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
public final class DatabaseConfig_Factory implements Factory<DatabaseConfig> {
  @Override
  public DatabaseConfig get() {
    return newInstance();
  }

  public static DatabaseConfig_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static DatabaseConfig newInstance() {
    return new DatabaseConfig();
  }

  private static final class InstanceHolder {
    private static final DatabaseConfig_Factory INSTANCE = new DatabaseConfig_Factory();
  }
}
