package creational.prototype;

public class Circle extends Shape {
    private int radius;

    public Circle(int x, int y, String color, int radius) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.radius = radius;
    }

    public Circle(Circle other) {
        super(other);
        this.radius = other.radius;
    }

    public void setRadius(int radius) { this.radius = radius; }
    public int getRadius() { return radius; }

    @Override
    public Circle clone() {
        return new Circle(this);
    }

    @Override
    public String describe() {
        return "Circle[x=" + x + ", y=" + y + ", color=" + color + ", radius=" + radius + "]";
    }
}
