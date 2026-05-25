package strategy;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class StrategyDemo {

    record Product(String name, double price, int stock) {}

    interface SortStrategy {
        List<Product> sort(List<Product> products);
    }

    static class ByNameStrategy implements SortStrategy {
        public List<Product> sort(List<Product> products) {
            List<Product> copy = new ArrayList<>(products);
            copy.sort(Comparator.comparing(Product::name));
            return copy;
        }
    }

    static class ByPriceStrategy implements SortStrategy {
        public List<Product> sort(List<Product> products) {
            List<Product> copy = new ArrayList<>(products);
            copy.sort(Comparator.comparingDouble(Product::price));
            return copy;
        }
    }

    static class ByStockStrategy implements SortStrategy {
        public List<Product> sort(List<Product> products) {
            List<Product> copy = new ArrayList<>(products);
            copy.sort(Comparator.comparingInt(Product::stock));
            return copy;
        }
    }

    static class ProductSorter {
        private SortStrategy strategy;

        ProductSorter(SortStrategy strategy) { this.strategy = strategy; }

        void setStrategy(SortStrategy strategy) { this.strategy = strategy; }

        List<Product> sort(List<Product> products) { return strategy.sort(products); }
    }

    static List<Product> sortWith(List<Product> products, Comparator<Product> strategy) {
        return products.stream().sorted(strategy).collect(Collectors.toList());
    }

    public static void demo() {
        List<Product> products = List.of(
            new Product("Banana", 1.20, 50),
            new Product("Apple", 0.80, 120),
            new Product("Cherry", 3.50, 30),
            new Product("Date", 5.00, 10),
            new Product("Elderberry", 2.30, 10)
        );

        System.out.println("=== Strategy Pattern ===\n");

        System.out.println("-- OOP --");
        ProductSorter sorter = new ProductSorter(new ByNameStrategy());
        System.out.println("By name:  " + fmt(sorter.sort(products)));

        sorter.setStrategy(new ByPriceStrategy());
        System.out.println("By price: " + fmt(sorter.sort(products)));

        sorter.setStrategy(new ByStockStrategy());
        System.out.println("By stock: " + fmt(sorter.sort(products)));

        System.out.println();

        System.out.println("-- Functional --");
        Comparator<Product> byName = Comparator.comparing(Product::name);
        Comparator<Product> byPrice = Comparator.comparingDouble(Product::price);
        Comparator<Product> byStock = Comparator.comparingInt(Product::stock);
        Comparator<Product> byStockThenName = byStock.thenComparing(byName);

        System.out.println("By name:       " + fmt(sortWith(products, byName)));
        System.out.println("By price:      " + fmt(sortWith(products, byPrice)));
        System.out.println("By stock:      " + fmt(sortWith(products, byStock)));
        System.out.println("By stock+name: " + fmt(sortWith(products, byStockThenName)));
        System.out.println("By price desc: " + fmt(sortWith(products, byPrice.reversed())));
        System.out.println();
    }

    private static String fmt(List<Product> list) {
        return list.stream()
            .map(p -> p.name() + "($" + p.price() + ", stock=" + p.stock() + ")")
            .collect(Collectors.joining(", "));
    }
}
