package com.lab6.di;

import com.lab6.app.Application;
import com.lab6.auth.AuthService;
import com.lab6.config.AppConfig;
import com.lab6.config.DatabaseConfig;
import com.lab6.config.SecurityConfig;
import com.lab6.config.SmtpConfig;
import com.lab6.notification.EmailSender;
import com.lab6.notification.LogService;
import com.lab6.repository.OrderRepository;
import com.lab6.repository.ProductRepository;
import com.lab6.repository.UserRepository;
import com.lab6.service.NotificationService;
import com.lab6.service.OrderService;
import com.lab6.service.UserService;
import dagger.internal.DaggerGenerated;
import javax.annotation.processing.Generated;

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
public final class DaggerAppComponent {
  private DaggerAppComponent() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static AppComponent create() {
    return new Builder().build();
  }

  public static final class Builder {
    private Builder() {
    }

    public AppComponent build() {
      return new AppComponentImpl();
    }
  }

  private static final class AppComponentImpl implements AppComponent {
    private final AppComponentImpl appComponentImpl = this;

    private AppComponentImpl() {


    }

    private ProductRepository productRepository() {
      return new ProductRepository(new DatabaseConfig());
    }

    private OrderRepository orderRepository() {
      return new OrderRepository(new DatabaseConfig());
    }

    private OrderService orderService() {
      return new OrderService(productRepository(), orderRepository());
    }

    private UserRepository userRepository() {
      return new UserRepository(new DatabaseConfig());
    }

    private AuthService authService() {
      return new AuthService(new SecurityConfig());
    }

    private UserService userService() {
      return new UserService(userRepository(), authService());
    }

    private EmailSender emailSender() {
      return new EmailSender(new SmtpConfig());
    }

    private LogService logService() {
      return new LogService(new AppConfig());
    }

    private NotificationService notificationService() {
      return new NotificationService(emailSender(), logService());
    }

    @Override
    public Application application() {
      return new Application(orderService(), userService(), notificationService());
    }
  }
}
