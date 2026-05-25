package creational.abstractfactory;

public class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("[Mac] Rendering a rounded button");
    }

    @Override
    public void onClick() {
        System.out.println("[Mac] Button clicked with Mac style");
    }
}
