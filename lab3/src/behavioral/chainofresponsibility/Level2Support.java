package behavioral.chainofresponsibility;

public class Level2Support extends SupportHandler {
    @Override
    public void handle(SupportTicket ticket) {
        if (ticket.getPriority() == SupportTicket.Priority.MEDIUM) {
            System.out.println("  [Level2] Resolved: " + ticket.getDescription());
        } else {
            System.out.println("  [Level2] Escalating: " + ticket.getDescription());
            passToNext(ticket);
        }
    }
}
