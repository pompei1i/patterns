package structural.bridge;

public class TV implements Device {
    private boolean on = false;
    private int volume = 30;
    private int channel = 1;

    @Override public boolean isEnabled() { return on; }
    @Override public void enable()  { on = true;  System.out.println("  TV: powered ON"); }
    @Override public void disable() { on = false; System.out.println("  TV: powered OFF"); }
    @Override public int getVolume() { return volume; }
    @Override public void setVolume(int v) { volume = Math.max(0, Math.min(100, v)); System.out.println("  TV: volume = " + volume); }
    @Override public int getChannel() { return channel; }
    @Override public void setChannel(int c) { channel = c; System.out.println("  TV: channel = " + channel); }
    @Override public String getName() { return "TV"; }
}
