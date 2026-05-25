package structural.adapter;

public class AudioPlayer implements MediaPlayer {
    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("  [AudioPlayer] Playing MP3 file: " + fileName);
        } else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            new MediaAdapter(audioType).play(audioType, fileName);
        } else {
            System.out.println("  [AudioPlayer] Format not supported: " + audioType);
        }
    }
}
