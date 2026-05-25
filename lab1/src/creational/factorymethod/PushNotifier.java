package creational.factorymethod;

public class PushNotifier implements Notifier {
    private final String deviceToken;

    public PushNotifier(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    @Override
    public void send(String message) {
        System.out.println("[PUSH] Device: " + deviceToken + " | Message: " + message);
    }
}
