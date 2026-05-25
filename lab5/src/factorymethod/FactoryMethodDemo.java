package factorymethod;

import java.util.Map;
import java.util.function.Function;

public class FactoryMethodDemo {

    interface Notification {
        void send(String message);
    }

    static class EmailNotification implements Notification {
        private final String address;
        EmailNotification(String address) { this.address = address; }
        public void send(String msg) {
            System.out.println("  [Email -> " + address + "] " + msg);
        }
    }

    static class SmsNotification implements Notification {
        private final String phone;
        SmsNotification(String phone) { this.phone = phone; }
        public void send(String msg) {
            System.out.println("  [SMS   -> " + phone + "] " + msg);
        }
    }

    static class PushNotification implements Notification {
        private final String deviceId;
        PushNotification(String deviceId) { this.deviceId = deviceId; }
        public void send(String msg) {
            System.out.println("  [Push  -> " + deviceId + "] " + msg);
        }
    }

    static abstract class NotificationFactory {
        abstract Notification createNotification(String target);

        void notify(String target, String message) {
            createNotification(target).send(message);
        }
    }

    static class EmailNotificationFactory extends NotificationFactory {
        public Notification createNotification(String target) {
            return new EmailNotification(target);
        }
    }

    static class SmsNotificationFactory extends NotificationFactory {
        public Notification createNotification(String target) {
            return new SmsNotification(target);
        }
    }

    static class PushNotificationFactory extends NotificationFactory {
        public Notification createNotification(String target) {
            return new PushNotification(target);
        }
    }

    static final Function<String, Notification> emailFactory = EmailNotification::new;
    static final Function<String, Notification> smsFactory = SmsNotification::new;
    static final Function<String, Notification> pushFactory = PushNotification::new;

    static final Map<String, Function<String, Notification>> REGISTRY = Map.of(
        "email", EmailNotification::new,
        "sms", SmsNotification::new,
        "push", PushNotification::new
    );

    static void notify(Function<String, Notification> factory, String target, String message) {
        factory.apply(target).send(message);
    }

    public static void demo() {
        System.out.println("=== Factory Method Pattern ===\n");

        System.out.println("-- OOP --");
        NotificationFactory emailFact = new EmailNotificationFactory();
        NotificationFactory smsFact = new SmsNotificationFactory();
        NotificationFactory pushFact = new PushNotificationFactory();

        emailFact.notify("user@example.com", "Welcome!");
        smsFact.notify("+1-555-0100", "Your code: 4242");
        pushFact.notify("device-abc-xyz", "New message");

        System.out.println();

        System.out.println("-- Functional --");
        notify(emailFactory, "user@example.com", "Welcome!");
        notify(smsFactory, "+1-555-0100", "Your code: 4242");
        notify(pushFactory, "device-abc-xyz", "New message");

        System.out.println();

        System.out.println("-- Functional (registry) --");
        REGISTRY.get("email").apply("admin@example.com").send("System alert");
        REGISTRY.get("sms").apply("+1-555-0199").send("System alert");
        REGISTRY.get("push").apply("device-999-zzz").send("System alert");

        System.out.println();
    }
}
