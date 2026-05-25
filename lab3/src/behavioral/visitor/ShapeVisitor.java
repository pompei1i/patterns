package behavioral.visitor;

public interface ShapeVisitor {
    void visit(CircleShape circle);
    void visit(RectangleShape rectangle);
    void visit(TriangleShape triangle);
}
