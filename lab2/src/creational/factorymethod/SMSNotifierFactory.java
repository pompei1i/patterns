package creational.factorymethod;

public class SMSNotifierFactory extends NotifierFactory {
    @Override
    public Notifier createNotifier(String destination) {
        return new SMSNotifier(destination);
    }
}
