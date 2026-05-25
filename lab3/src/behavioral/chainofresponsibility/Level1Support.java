package behavioral.chainofresponsibility;

public class Level1Support extends SupportHandler {
    @Override
    public void handle(SupportTicket ticket) {
        if (ticket.getPriority() == SupportTicket.Priority.LOW) {
            System.out.println("  [Level1] Resolved: " + ticket.getDescription());
        } else {
            System.out.println("  [Level1] Escalating: " + ticket.getDescription());
            passToNext(ticket);
        }
    }
}
