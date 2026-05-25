package creational.abstractfactory;

public class MacCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("[Mac] Rendering a circular checkbox");
    }

    @Override
    public void toggle() {
        System.out.println("[Mac] Checkbox toggled with Mac style");
    }
}
