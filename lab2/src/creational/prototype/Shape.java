package creational.prototype;

public abstract class Shape {
    protected int x;
    protected int y;
    protected String color;

    protected Shape() {}

    protected Shape(Shape other) {
        this.x = other.x;
        this.y = other.y;
        this.color = other.color;
    }

    public abstract Shape clone();
    public abstract String describe();

    public void setColor(String color) { this.color = color; }
    public String getColor() { return color; }
}
