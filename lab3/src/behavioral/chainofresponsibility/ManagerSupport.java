package behavioral.chainofresponsibility;

public class ManagerSupport extends SupportHandler {
    @Override
    public void handle(SupportTicket ticket) {
        System.out.println("  [Manager] Handling " + ticket.getPriority() + " issue: " + ticket.getDescription());
    }
}
