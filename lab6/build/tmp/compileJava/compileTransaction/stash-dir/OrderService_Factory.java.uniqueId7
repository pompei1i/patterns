package com.lab6.service;

import com.lab6.repository.OrderRepository;
import com.lab6.repository.ProductRepository;
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
public final class OrderService_Factory implements Factory<OrderService> {
  private final Provider<ProductRepository> productRepositoryProvider;

  private final Provider<OrderRepository> orderRepositoryProvider;

  public OrderService_Factory(Provider<ProductRepository> productRepositoryProvider,
      Provider<OrderRepository> orderRepositoryProvider) {
    this.productRepositoryProvider = productRepositoryProvider;
    this.orderRepositoryProvider = orderRepositoryProvider;
  }

  @Override
  public OrderService get() {
    return newInstance(productRepositoryProvider.get(), orderRepositoryProvider.get());
  }

  public static OrderService_Factory create(Provider<ProductRepository> productRepositoryProvider,
      Provider<OrderRepository> orderRepositoryProvider) {
    return new OrderService_Factory(productRepositoryProvider, orderRepositoryProvider);
  }

  public static OrderService newInstance(ProductRepository productRepository,
      OrderRepository orderRepository) {
    return new OrderService(productRepository, orderRepository);
  }
}
