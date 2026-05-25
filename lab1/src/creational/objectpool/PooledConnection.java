package creational.objectpool;

public class PooledConnection {
    private final int id;
    private boolean inUse;

    public PooledConnection(int id) {
        this.id = id;
        System.out.println("  [Pool] Creating new connection #" + id);
    }

    public void executeQuery(String sql) {
        if (!inUse) throw new IllegalStateException("Connection #" + id + " is not acquired");
        System.out.println("  [Pool] Connection #" + id + " executing: " + sql);
    }

    public boolean isInUse() { return inUse; }
    public void setInUse(boolean inUse) { this.inUse = inUse; }
    public int getId() { return id; }
}
