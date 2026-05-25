package structural.decorator;

public class WhipDecorator extends CoffeeDecorator {
    public WhipDecorator(Coffee coffee) { super(coffee); }

    @Override public String getDescription() { return decorated.getDescription() + ", whip"; }
    @Override public double getCost() { return decorated.getCost() + 0.50; }
}
