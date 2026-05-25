package structural.facade;

public class HomeTheaterFacade {
    private final DVDPlayer dvd;
    private final Projector projector;
    private final SoundSystem sound;
    private final Lights lights;

    public HomeTheaterFacade(DVDPlayer dvd, Projector projector, SoundSystem sound, Lights lights) {
        this.dvd = dvd;
        this.projector = projector;
        this.sound = sound;
        this.lights = lights;
    }

    public void watchMovie(String movie) {
        System.out.println("  --- Get ready to watch a movie! ---");
        lights.dim(10);
        projector.on();
        projector.setInput("DVD");
        sound.on();
        sound.setSurroundSound();
        sound.setVolume(40);
        dvd.on();
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("  --- Shutting down movie theater ---");
        dvd.stop();
        dvd.off();
        sound.off();
        projector.off();
        lights.on();
    }
}
