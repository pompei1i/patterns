package structural.decorator;

public class SimpleCoffee implements Coffee {
    @Override public String getDescription() { return "Simple coffee"; }
    @Override public double getCost() { return 1.00; }
}
