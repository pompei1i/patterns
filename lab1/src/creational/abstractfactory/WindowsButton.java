package creational.abstractfactory;

public class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("[Windows] Rendering a flat square button");
    }

    @Override
    public void onClick() {
        System.out.println("[Windows] Button clicked with Windows style");
    }
}
