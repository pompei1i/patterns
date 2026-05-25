package structural.decorator;

public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) { super(coffee); }

    @Override public String getDescription() { return decorated.getDescription() + ", sugar"; }
    @Override public double getCost() { return decorated.getCost() + 0.10; }
}
