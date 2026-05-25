package structural.adapter;

public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("  [VlcPlayer] Playing VLC file: " + fileName);
    }

    @Override
    public void playMp4(String fileName) { /* not supported */ }
}
