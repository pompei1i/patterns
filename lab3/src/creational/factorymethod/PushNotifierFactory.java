package creational.factorymethod;

public class PushNotifierFactory extends NotifierFactory {
    @Override
    public Notifier createNotifier(String destination) {
        return new PushNotifier(destination);
    }
}
