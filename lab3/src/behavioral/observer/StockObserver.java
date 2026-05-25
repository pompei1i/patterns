package behavioral.observer;

public interface StockObserver {
    void update(String ticker, double price);
}
