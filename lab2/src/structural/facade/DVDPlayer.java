package structural.facade;

public class DVDPlayer {
    public void on()  { System.out.println("  DVD Player: ON"); }
    public void off() { System.out.println("  DVD Player: OFF"); }
    public void play(String movie) { System.out.println("  DVD Player: playing \"" + movie + "\""); }
    public void stop() { System.out.println("  DVD Player: stopped"); }
}
