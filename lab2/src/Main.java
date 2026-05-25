import creational.singleton.AppConfig;
import creational.factorymethod.*;
import creational.abstractfactory.*;
import creational.builder.Computer;
import creational.builder.ComputerDirector;
import creational.prototype.*;
import creational.objectpool.ConnectionPool;
import creational.objectpool.PooledConnection;

import structural.adapter.AudioPlayer;
import structural.bridge.*;
import structural.composite.*;
import structural.decorator.*;
import structural.facade.*;
import structural.flyweight.Forest;
import structural.proxy.*;

public class Main {
    public static void main(String[] args) {
        // --- Creational ---
        demoSingleton();
        demoFactoryMethod();
        demoAbstractFactory();
        demoBuilder();
        demoPrototype();
        demoObjectPool();

        // --- Structural ---
        demoAdapter();
        demoBridge();
        demoComposite();
        demoDecorator();
        demoFacade();
        demoFlyweight();
        demoProxy();
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
        registry.register("bigCircle", new Circle(0, 0, "red", 50));
        registry.register("smallRect", new Rectangle(10, 10, "blue", 100, 50));

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

        PooledConnection conn3 = pool.acquire();
        conn3.executeQuery("UPDATE products SET stock = 0");

        System.out.println("  Pool size: " + pool.getPoolSize() + ", active: " + pool.getActiveCount());

        pool.release(conn2);
        pool.release(conn3);
        System.out.println("  After release — active: " + pool.getActiveCount());
        System.out.println();
    }

    // ------------------------------------------------------------------ //
    //  7. ADAPTER
    // ------------------------------------------------------------------ //
    static void demoAdapter() {
        System.out.println("=== 7. ADAPTER ===");

        AudioPlayer player = new AudioPlayer();
        player.play("mp3", "song.mp3");
        player.play("vlc", "movie.vlc");
        player.play("mp4", "clip.mp4");
        player.play("avi", "video.avi");
        System.out.println();
    }

    // ------------------------------------------------------------------ //
    //  8. BRIDGE
    // ------------------------------------------------------------------ //
    static void demoBridge() {
        System.out.println("=== 8. BRIDGE ===");

        TV tv = new TV();
        RemoteControl basicRemote = new RemoteControl(tv);
        basicRemote.togglePower();
        basicRemote.volumeUp();
        basicRemote.channelUp();

        Radio radio = new Radio();
        AdvancedRemoteControl advRemote = new AdvancedRemoteControl(radio);
        advRemote.togglePower();
        advRemote.volumeUp();
        advRemote.mute();
        advRemote.setChannel(5);
        System.out.println();
    }

    // ------------------------------------------------------------------ //
    //  9. COMPOSITE
    // ------------------------------------------------------------------ //
    static void demoComposite() {
        System.out.println("=== 9. COMPOSITE ===");

        Directory root = new Directory("root");

        Directory src = new Directory("src");
        src.add(new File("Main.java", 12));
        src.add(new File("Utils.java", 8));

        Directory resources = new Directory("resources");
        resources.add(new File("config.xml", 3));
        resources.add(new File("logo.png", 240));

        root.add(src);
        root.add(resources);
        root.add(new File("README.md", 5));

        root.print("");
        System.out.println("  Total project size: " + root.getSize() + " KB");
        System.out.println();
    }

    // ------------------------------------------------------------------ //
    //  10. DECORATOR
    // ------------------------------------------------------------------ //
    static void demoDecorator() {
        System.out.println("=== 10. DECORATOR ===");

        Coffee coffee = new SimpleCoffee();
        System.out.printf("  %-35s $%.2f%n", coffee.getDescription(), coffee.getCost());

        coffee = new MilkDecorator(coffee);
        System.out.printf("  %-35s $%.2f%n", coffee.getDescription(), coffee.getCost());

        coffee = new SugarDecorator(coffee);
        System.out.printf("  %-35s $%.2f%n", coffee.getDescription(), coffee.getCost());

        coffee = new WhipDecorator(coffee);
        System.out.printf("  %-35s $%.2f%n", coffee.getDescription(), coffee.getCost());
        System.out.println();
    }

    // ------------------------------------------------------------------ //
    //  11. FACADE
    // ------------------------------------------------------------------ //
    static void demoFacade() {
        System.out.println("=== 11. FACADE ===");

        HomeTheaterFacade theater = new HomeTheaterFacade(
            new DVDPlayer(), new Projector(), new SoundSystem(), new Lights()
        );
        theater.watchMovie("Inception");
        System.out.println("  ... enjoying the movie ...");
        theater.endMovie();
        System.out.println();
    }

    // ------------------------------------------------------------------ //
    //  12. FLYWEIGHT
    // ------------------------------------------------------------------ //
    static void demoFlyweight() {
        System.out.println("=== 12. FLYWEIGHT ===");

        Forest forest = new Forest();
        forest.plantTree(1, 2, "Oak",   "green", "rough");
        forest.plantTree(3, 4, "Pine",  "dark",  "smooth");
        forest.plantTree(5, 1, "Oak",   "green", "rough");   // reuses existing flyweight
        forest.plantTree(7, 8, "Birch", "white", "papery");
        forest.plantTree(2, 6, "Pine",  "dark",  "smooth");  // reuses existing flyweight

        forest.draw();
        System.out.println("  Trees planted: " + forest.getTreeCount()
            + ", unique TreeType objects: " + structural.flyweight.TreeTypeFactory.getCacheSize());
        System.out.println();
    }

    // ------------------------------------------------------------------ //
    //  13. PROXY
    // ------------------------------------------------------------------ //
    static void demoProxy() {
        System.out.println("=== 13. PROXY ===");

        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        System.out.println("  Images created (not yet loaded)");
        image1.display(); // loads + displays
        image1.display(); // only displays (cached)
        image2.display(); // loads + displays
        System.out.println();
    }
}
