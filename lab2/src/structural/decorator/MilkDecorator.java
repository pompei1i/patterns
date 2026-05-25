package structural.decorator;

public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) { super(coffee); }

    @Override public String getDescription() { return decorated.getDescription() + ", milk"; }
    @Override public double getCost() { return decorated.getCost() + 0.25; }
}
