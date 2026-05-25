package behavioral.mediator;

public abstract class ChatUser {
    protected final ChatMediator mediator;
    protected final String name;

    public ChatUser(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public String getName() { return name; }

    public void send(String message) {
        System.out.println("  [" + name + "] sends: " + message);
        mediator.sendMessage(message, this);
    }

    public abstract void receive(String message, ChatUser from);
}
