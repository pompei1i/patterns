package structural.facade;

public class SoundSystem {
    public void on()  { System.out.println("  Sound System: ON"); }
    public void off() { System.out.println("  Sound System: OFF"); }
    public void setVolume(int v) { System.out.println("  Sound System: volume = " + v); }
    public void setSurroundSound() { System.out.println("  Sound System: surround sound enabled"); }
}
