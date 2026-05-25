package behavioral.chainofresponsibility;

public class SupportTicket {
    public enum Priority { LOW, MEDIUM, HIGH, CRITICAL }

    private final String description;
    private final Priority priority;

    public SupportTicket(String description, Priority priority) {
        this.description = description;
        this.priority = priority;
    }

    public Priority getPriority() { return priority; }
    public String getDescription() { return description; }
}
