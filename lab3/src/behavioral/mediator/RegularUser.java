package behavioral.mediator;

public class RegularUser extends ChatUser {
    public RegularUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void receive(String message, ChatUser from) {
        System.out.println("  [" + name + "] received from " + from.getName() + ": " + message);
    }
}
