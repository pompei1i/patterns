package behavioral.observer;

public class Investor implements StockObserver {
    private final String name;

    public Investor(String name) { this.name = name; }

    @Override
    public void update(String ticker, double price) {
        System.out.printf("  [%s] %s price updated: $%.2f%n", name, ticker, price);
    }
}
