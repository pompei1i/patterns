package com.lab6.service;

import com.lab6.repository.OrderRepository;
import com.lab6.repository.ProductRepository;
import javax.inject.Inject;

public class OrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Inject
    public OrderService(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public void processOrder(int orderId, int productId) {
        System.out.println("OrderService: processing order...");
        String order = orderRepository.findOrder(orderId);
        String product = productRepository.findProduct(productId);
        System.out.println("  Result: " + order + " contains " + product);
    }
}
