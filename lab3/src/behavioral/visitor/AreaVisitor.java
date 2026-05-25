package behavioral.visitor;

public class AreaVisitor implements ShapeVisitor {
    @Override
    public void visit(CircleShape c) {
        double area = Math.PI * c.getRadius() * c.getRadius();
        System.out.printf("  Area of %s = %.2f%n", c.name(), area);
    }

    @Override
    public void visit(RectangleShape r) {
        double area = r.getWidth() * r.getHeight();
        System.out.printf("  Area of %s = %.2f%n", r.name(), area);
    }

    @Override
    public void visit(TriangleShape t) {
        double s = (t.getA() + t.getB() + t.getC()) / 2;
        double area = Math.sqrt(s * (s - t.getA()) * (s - t.getB()) * (s - t.getC()));
        System.out.printf("  Area of %s = %.2f%n", t.name(), area);
    }
}
