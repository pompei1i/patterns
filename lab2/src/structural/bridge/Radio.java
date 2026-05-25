package structural.bridge;

public class Radio implements Device {
    private boolean on = false;
    private int volume = 50;
    private int channel = 1;

    @Override public boolean isEnabled() { return on; }
    @Override public void enable()  { on = true;  System.out.println("  Radio: powered ON"); }
    @Override public void disable() { on = false; System.out.println("  Radio: powered OFF"); }
    @Override public int getVolume() { return volume; }
    @Override public void setVolume(int v) { volume = Math.max(0, Math.min(100, v)); System.out.println("  Radio: volume = " + volume); }
    @Override public int getChannel() { return channel; }
    @Override public void setChannel(int c) { channel = c; System.out.println("  Radio: channel = " + channel); }
    @Override public String getName() { return "Radio"; }
}
