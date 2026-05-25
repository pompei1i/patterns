package com.lab6.app;

import com.lab6.service.NotificationService;
import com.lab6.service.OrderService;
import com.lab6.service.UserService;
import javax.inject.Inject;

public class Application {

    private final OrderService orderService;
    private final UserService userService;
    private final NotificationService notificationService;

    @Inject
    public Application(OrderService orderService,
                       UserService userService,
                       NotificationService notificationService) {
        this.orderService = orderService;
        this.userService = userService;
        this.notificationService = notificationService;
    }

    public void run() {
        System.out.println("=== Application started ===");
        System.out.println();

        userService.loginUser(1, "my-secret-key");
        System.out.println();

        orderService.processOrder(101, 5);
        System.out.println();

        notificationService.notify("user@example.com", "Your order has been processed!");
        System.out.println();

        System.out.println("=== Application finished ===");
    }
}
