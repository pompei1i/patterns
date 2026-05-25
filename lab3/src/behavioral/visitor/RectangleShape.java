package behavioral.visitor;

public class RectangleShape implements VisitableShape {
    private final double width, height;

    public RectangleShape(double width, double height) {
        this.width = width; this.height = height;
    }

    public double getWidth()  { return width; }
    public double getHeight() { return height; }

    @Override public void accept(ShapeVisitor v) { v.visit(this); }
    @Override public String name() { return "Rectangle(" + width + "x" + height + ")"; }
}
