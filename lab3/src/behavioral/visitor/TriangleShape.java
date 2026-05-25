package behavioral.visitor;

public class TriangleShape implements VisitableShape {
    private final double a, b, c;

    public TriangleShape(double a, double b, double c) {
        this.a = a; this.b = b; this.c = c;
    }

    public double getA() { return a; }
    public double getB() { return b; }
    public double getC() { return c; }

    @Override public void accept(ShapeVisitor v) { v.visit(this); }
    @Override public String name() { return "Triangle(" + a + "," + b + "," + c + ")"; }
}
