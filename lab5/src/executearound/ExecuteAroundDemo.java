package executearound;

import java.io.*;
import java.nio.file.*;

public class ExecuteAroundDemo {

    @FunctionalInterface
    public interface ThrowingConsumer<T> {
        void accept(T t) throws Exception;
    }

    @FunctionalInterface
    public interface ThrowingFunction<T, R> {
        R apply(T t) throws Exception;
    }

    static <T extends AutoCloseable> void withResource(
            String label, T resource, ThrowingConsumer<T> action) throws Exception {
        System.out.println("  [+] Acquired: " + label);
        try (resource) {
            action.accept(resource);
        } finally {
            System.out.println("  [-] Released: " + label);
        }
    }

    static <T extends AutoCloseable, R> R withResourceResult(
            String label, T resource, ThrowingFunction<T, R> action) throws Exception {
        System.out.println("  [+] Acquired: " + label);
        try (resource) {
            return action.apply(resource);
        } finally {
            System.out.println("  [-] Released: " + label);
        }
    }

    static <R> R withTiming(String label, ThrowingFunction<Void, R> action) throws Exception {
        System.out.println("  [>] Starting: " + label);
        long start = System.nanoTime();
        try {
            return action.apply(null);
        } finally {
            long ms = (System.nanoTime() - start) / 1_000_000;
            System.out.println("  [<] Finished: " + label + " (" + ms + " ms)");
        }
    }

    static class FakeTransaction implements AutoCloseable {
        private boolean committed = false;

        void execute(String sql) {
            System.out.println("  [SQL] " + sql);
        }

        void commit() {
            committed = true;
            System.out.println("  [TX ] Committed");
        }

        public void close() {
            if (!committed) System.out.println("  [TX ] Rolled back");
        }
    }

    static void withTransaction(ThrowingConsumer<FakeTransaction> action) throws Exception {
        System.out.println("  [+] Transaction started");
        try (FakeTransaction tx = new FakeTransaction()) {
            action.accept(tx);
            tx.commit();
        } finally {
            System.out.println("  [-] Transaction ended");
        }
    }

    public static void demo() {
        System.out.println("=== Execute Around Pattern ===\n");

        Path tempFile = Path.of(System.getProperty("java.io.tmpdir"), "lab5_output.txt");

        System.out.println("-- File Writing --");
        try {
            withResource("File: " + tempFile.getFileName(),
                new PrintWriter(new FileWriter(tempFile.toFile())),
                writer -> {
                    writer.println("Line 1: Execute Around pattern");
                    writer.println("Line 2: resource management in one place");
                    System.out.println("  Written 2 lines");
                });
        } catch (Exception e) {
            System.out.println("  Error: " + e.getMessage());
        }

        System.out.println();

        System.out.println("-- File Reading with Result --");
        try {
            long lineCount = withResourceResult("BufferedReader",
                new BufferedReader(new FileReader(tempFile.toFile())),
                reader -> reader.lines().count());
            System.out.println("  Line count: " + lineCount);
        } catch (Exception e) {
            System.out.println("  Error: " + e.getMessage());
        }

        System.out.println();

        System.out.println("-- Timing --");
        try {
            int result = withTiming("computation", _v -> {
                Thread.sleep(30);
                return 42;
            });
            System.out.println("  Result: " + result);
        } catch (Exception e) {
            System.out.println("  Error: " + e.getMessage());
        }

        System.out.println();

        System.out.println("-- Transaction (success) --");
        try {
            withTransaction(tx -> {
                tx.execute("INSERT INTO orders (product, qty) VALUES ('Apple', 10)");
                tx.execute("UPDATE inventory SET stock = stock - 10 WHERE product = 'Apple'");
            });
        } catch (Exception e) {
            System.out.println("  Error: " + e.getMessage());
        }

        System.out.println();

        System.out.println("-- Transaction (failure -> rollback) --");
        try {
            withTransaction(tx -> {
                tx.execute("INSERT INTO orders (product, qty) VALUES ('Cherry', 5)");
                if (true) throw new RuntimeException("Inventory constraint violated");
                tx.execute("UPDATE inventory SET stock = stock - 5 WHERE product = 'Cherry'");
            });
        } catch (Exception e) {
            System.out.println("  Caught: " + e.getMessage());
        }

        System.out.println();
    }
}
