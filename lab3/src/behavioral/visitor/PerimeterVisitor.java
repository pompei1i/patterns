package behavioral.visitor;

public class PerimeterVisitor implements ShapeVisitor {
    @Override
    public void visit(CircleShape c) {
        System.out.printf("  Perimeter of %s = %.2f%n", c.name(), 2 * Math.PI * c.getRadius());
    }

    @Override
    public void visit(RectangleShape r) {
        System.out.printf("  Perimeter of %s = %.2f%n", r.name(), 2 * (r.getWidth() + r.getHeight()));
    }

    @Override
    public void visit(TriangleShape t) {
        System.out.printf("  Perimeter of %s = %.2f%n", t.name(), t.getA() + t.getB() + t.getC());
    }
}
