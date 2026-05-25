package creational.factorymethod;

public abstract class NotifierFactory {
    public abstract Notifier createNotifier(String destination);

    public void notify(String destination, String message) {
        Notifier notifier = createNotifier(destination);
        notifier.send(message);
    }
}
