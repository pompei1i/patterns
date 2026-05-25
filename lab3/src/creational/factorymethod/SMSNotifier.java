package creational.factorymethod;

public class SMSNotifier implements Notifier {
    private final String phone;

    public SMSNotifier(String phone) {
        this.phone = phone;
    }

    @Override
    public void send(String message) {
        System.out.println("[SMS] To: " + phone + " | Message: " + message);
    }
}
