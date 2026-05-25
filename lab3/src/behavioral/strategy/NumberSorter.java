package behavioral.strategy;

import java.util.Arrays;

public class NumberSorter {
    private SortStrategy strategy;

    public NumberSorter(SortStrategy strategy) { this.strategy = strategy; }
    public void setStrategy(SortStrategy strategy) { this.strategy = strategy; }

    public int[] sort(int[] data) {
        int[] copy = Arrays.copyOf(data, data.length);
        strategy.sort(copy);
        return copy;
    }

    public String getStrategyName() { return strategy.name(); }
}
