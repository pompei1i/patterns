package structural.facade;

public class Projector {
    public void on()  { System.out.println("  Projector: ON"); }
    public void off() { System.out.println("  Projector: OFF"); }
    public void setInput(String input) { System.out.println("  Projector: input set to " + input); }
}
