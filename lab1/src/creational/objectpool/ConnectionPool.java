package creational.objectpool;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private final List<PooledConnection> pool = new ArrayList<>();
    private final int maxSize;

    public ConnectionPool(int maxSize) {
        this.maxSize = maxSize;
        System.out.println("  [Pool] Created pool with max size " + maxSize);
    }

    public PooledConnection acquire() {
        for (PooledConnection conn : pool) {
            if (!conn.isInUse()) {
                conn.setInUse(true);
                System.out.println("  [Pool] Reusing connection #" + conn.getId());
                return conn;
            }
        }
        if (pool.size() < maxSize) {
            PooledConnection conn = new PooledConnection(pool.size() + 1);
            conn.setInUse(true);
            pool.add(conn);
            return conn;
        }
        throw new RuntimeException("Connection pool exhausted (max=" + maxSize + ")");
    }

    public void release(PooledConnection conn) {
        conn.setInUse(false);
        System.out.println("  [Pool] Released connection #" + conn.getId() + " back to pool");
    }

    public int getActiveCount() {
        return (int) pool.stream().filter(PooledConnection::isInUse).count();
    }

    public int getPoolSize() { return pool.size(); }
}
