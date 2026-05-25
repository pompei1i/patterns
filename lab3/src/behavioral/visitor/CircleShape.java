package behavioral.visitor;

public class CircleShape implements VisitableShape {
    private final double radius;

    public CircleShape(double radius) { this.radius = radius; }
    public double getRadius() { return radius; }

    @Override public void accept(ShapeVisitor v) { v.visit(this); }
    @Override public String name() { return "Circle(r=" + radius + ")"; }
}
