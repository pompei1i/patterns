package structural.decorator;

public abstract class CoffeeDecorator implements Coffee {
    protected final Coffee decorated;

    public CoffeeDecorator(Coffee coffee) { this.decorated = coffee; }

    @Override public String getDescription() { return decorated.getDescription(); }
    @Override public double getCost() { return decorated.getCost(); }
}
