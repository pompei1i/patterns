package creational.abstractfactory;

public class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("[Windows] Rendering a square checkbox");
    }

    @Override
    public void toggle() {
        System.out.println("[Windows] Checkbox toggled with Windows style");
    }
}
