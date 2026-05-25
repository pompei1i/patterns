package creational.builder;

public class ComputerDirector {
    public Computer buildGamingPC() {
        return new Computer.Builder()
                .cpu("Intel Core i9-13900K")
                .ram(32)
                .storage(2000)
                .gpu("NVIDIA RTX 4090")
                .bluetooth(true)
                .wifi(true)
                .build();
    }

    public Computer buildOfficePC() {
        return new Computer.Builder()
                .cpu("Intel Core i5-12400")
                .ram(16)
                .storage(512)
                .wifi(true)
                .build();
    }

    public Computer buildServerPC() {
        return new Computer.Builder()
                .cpu("AMD EPYC 9654")
                .ram(256)
                .storage(8000)
                .build();
    }
}
