package creational.prototype;

public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(int x, int y, String color, int width, int height) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.width = width;
        this.height = height;
    }

    public Rectangle(Rectangle other) {
        super(other);
        this.width = other.width;
        this.height = other.height;
    }

    public void setWidth(int width) { this.width = width; }
    public void setHeight(int height) { this.height = height; }

    @Override
    public Rectangle clone() {
        return new Rectangle(this);
    }

    @Override
    public String describe() {
        return "Rectangle[x=" + x + ", y=" + y + ", color=" + color + ", width=" + width + ", height=" + height + "]";
    }
}
