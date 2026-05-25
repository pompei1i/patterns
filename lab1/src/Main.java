import creational.singleton.AppConfig;
import creational.factorymethod.*;
import creational.abstractfactory.*;
import creational.builder.Computer;
import creational.builder.ComputerDirector;
import creational.prototype.*;
import creational.objectpool.ConnectionPool;
import creational.objectpool.PooledConnection;

public class Main {
    public static void main(String[] args) {
        demoSingleton();
        demoFactoryMethod();
        demoAbstractFactory();
        demoBuilder();
        demoPrototype();
        demoObjectPool();
    }

    // ------------------------------------------------------------------ //
    //  1. SINGLETON
    // ------------------------------------------------------------------ //
    static void demoSingleton() {
        System.out.println("=== 1. SINGLETON ===");

        AppConfig config1 = AppConfig.getInstance();
        AppConfig config2 = AppConfig.getInstance();

        System.out.println("config1: " + config1);
        System.out.println("config2: " + config2);
        System.out.println("Same instance? " + (config1 == config2));
        System.out.println();
    }

    // ------------------------------------------------------------------ //
    //  2. FACTORY METHOD
    // ------------------------------------------------------------------ //
    static void demoFactoryMethod() {
        System.out.println("=== 2. FACTORY METHOD ===");

        NotifierFactory[] factories = {
            new EmailNotifierFactory(),
            new SMSNotifierFactory(),
            new PushNotifierFactory()
        };
        String[] destinations = {
            "user@example.com",
            "+380501234567",
            "device-token-abc123"
        };

        for (int i = 0; i < factories.length; i++) {
            factories[i].notify(destinations[i], "Your order has been shipped!");
        }
        System.out.println();
    }

    // ------------------------------------------------------------------ //
    //  3. ABSTRACT FACTORY
    // ------------------------------------------------------------------ //
    static void demoAbstractFactory() {
        System.out.println("=== 3. ABSTRACT FACTORY ===");

        GUIFactory[] factories = { new WindowsFactory(), new MacFactory() };

        for (GUIFactory factory : factories) {
            Button button = factory.createButton();
            Checkbox checkbox = factory.createCheckbox();
            button.render();
            button.onClick();
            checkbox.render();
            checkbox.toggle();
        }
        System.out.println();
    }

    // ------------------------------------------------------------------ //
    //  4. BUILDER
    // ------------------------------------------------------------------ //
    static void demoBuilder() {
        System.out.println("=== 4. BUILDER ===");

        ComputerDirector director = new ComputerDirector();

        Computer gamingPC = director.buildGamingPC();
        Computer officePC = director.buildOfficePC();

        // Manual build (no director)
        Computer customPC = new Computer.Builder()
                .cpu("AMD Ryzen 7 7700X")
                .ram(32)
                .storage(1000)
                .gpu("AMD RX 7800 XT")
                .bluetooth(true)
                .wifi(true)
                .build();

        System.out.println("Gaming PC : " + gamingPC);
        System.out.println("Office PC : " + officePC);
        System.out.println("Custom PC : " + customPC);
        System.out.println();
    }

    // ------------------------------------------------------------------ //
    //  5. PROTOTYPE
    // ------------------------------------------------------------------ //
    static void demoPrototype() {
        System.out.println("=== 5. PROTOTYPE ===");

        ShapeRegistry registry = new ShapeRegistry();
        registry.register("bigCircle",    new Circle(0, 0, "red", 50));
        registry.register("smallRect",    new Rectangle(10, 10, "blue", 100, 50));

        Circle c1 = (Circle) registry.get("bigCircle");
        Circle c2 = (Circle) registry.get("bigCircle");
        c2.setColor("green");
        c2.setRadius(75);

        Rectangle r1 = (Rectangle) registry.get("smallRect");

        System.out.println("c1: " + c1.describe());
        System.out.println("c2: " + c2.describe() + "  (independent clone)");
        System.out.println("r1: " + r1.describe());
        System.out.println("c1 == c2? " + (c1 == c2));
        System.out.println();
    }

    // ------------------------------------------------------------------ //
    //  6. OBJECT POOL
    // ------------------------------------------------------------------ //
    static void demoObjectPool() {
        System.out.println("=== 6. OBJECT POOL ===");

        ConnectionPool pool = new ConnectionPool(3);

        PooledConnection conn1 = pool.acquire();
        PooledConnection conn2 = pool.acquire();
        conn1.executeQuery("SELECT * FROM users");
        conn2.executeQuery("INSERT INTO orders VALUES (...)");

        pool.release(conn1);

        // conn3 reuses conn1's slot
        PooledConnection conn3 = pool.acquire();
        conn3.executeQuery("UPDATE products SET stock = 0");

        System.out.println("  Pool size: " + pool.getPoolSize() + ", active: " + pool.getActiveCount());

        pool.release(conn2);
        pool.release(conn3);
        System.out.println("  After release — active: " + pool.getActiveCount());
        System.out.println();
    }
}
