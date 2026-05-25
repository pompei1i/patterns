package creational.factorymethod;

public class EmailNotifierFactory extends NotifierFactory {
    @Override
    public Notifier createNotifier(String destination) {
        return new EmailNotifier(destination);
    }
}
