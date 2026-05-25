package com.lab6.app;

import com.lab6.service.NotificationService;
import com.lab6.service.OrderService;
import com.lab6.service.UserService;
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
public final class Application_Factory implements Factory<Application> {
  private final Provider<OrderService> orderServiceProvider;

  private final Provider<UserService> userServiceProvider;

  private final Provider<NotificationService> notificationServiceProvider;

  public Application_Factory(Provider<OrderService> orderServiceProvider,
      Provider<UserService> userServiceProvider,
      Provider<NotificationService> notificationServiceProvider) {
    this.orderServiceProvider = orderServiceProvider;
    this.userServiceProvider = userServiceProvider;
    this.notificationServiceProvider = notificationServiceProvider;
  }

  @Override
  public Application get() {
    return newInstance(orderServiceProvider.get(), userServiceProvider.get(), notificationServiceProvider.get());
  }

  public static Application_Factory create(Provider<OrderService> orderServiceProvider,
      Provider<UserService> userServiceProvider,
      Provider<NotificationService> notificationServiceProvider) {
    return new Application_Factory(orderServiceProvider, userServiceProvider, notificationServiceProvider);
  }

  public static Application newInstance(OrderService orderService, UserService userService,
      NotificationService notificationService) {
    return new Application(orderService, userService, notificationService);
  }
}
