package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    private final List<StockObserver> observers = new ArrayList<>();
    private final String ticker;
    private double price;

    public StockMarket(String ticker, double initialPrice) {
        this.ticker = ticker;
        this.price = initialPrice;
    }

    public void subscribe(StockObserver o)   { observers.add(o); }
    public void unsubscribe(StockObserver o) { observers.remove(o); }

    public void setPrice(double newPrice) {
        this.price = newPrice;
        notifyObservers();
    }

    private void notifyObservers() {
        for (StockObserver o : observers) o.update(ticker, price);
    }
}
