package behavioral.visitor;

public interface VisitableShape {
    void accept(ShapeVisitor visitor);
    String name();
}
