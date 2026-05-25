package behavioral.chainofresponsibility;

public abstract class SupportHandler {
    protected SupportHandler next;

    public SupportHandler setNext(SupportHandler next) {
        this.next = next;
        return next;
    }

    public abstract void handle(SupportTicket ticket);

    protected void passToNext(SupportTicket ticket) {
        if (next != null) next.handle(ticket);
        else System.out.println("  [Support] No handler available for: " + ticket.getDescription());
    }
}
