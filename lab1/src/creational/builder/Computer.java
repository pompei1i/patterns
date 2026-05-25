package creational.builder;

public class Computer {
    private final String cpu;
    private final int ramGb;
    private final int storageGb;
    private final String gpu;
    private final boolean hasBluetooth;
    private final boolean hasWifi;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ramGb = builder.ramGb;
        this.storageGb = builder.storageGb;
        this.gpu = builder.gpu;
        this.hasBluetooth = builder.hasBluetooth;
        this.hasWifi = builder.hasWifi;
    }

    public String getCpu() { return cpu; }
    public int getRamGb() { return ramGb; }
    public int getStorageGb() { return storageGb; }
    public String getGpu() { return gpu; }
    public boolean hasBluetooth() { return hasBluetooth; }
    public boolean hasWifi() { return hasWifi; }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram=" + ramGb + "GB" +
                ", storage=" + storageGb + "GB" +
                ", gpu='" + (gpu != null ? gpu : "integrated") + '\'' +
                ", bluetooth=" + hasBluetooth +
                ", wifi=" + hasWifi +
                '}';
    }

    public static class Builder {
        private String cpu;
        private int ramGb;
        private int storageGb;
        private String gpu;
        private boolean hasBluetooth = false;
        private boolean hasWifi = false;

        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder ram(int gb) {
            this.ramGb = gb;
            return this;
        }

        public Builder storage(int gb) {
            this.storageGb = gb;
            return this;
        }

        public Builder gpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Builder bluetooth(boolean enabled) {
            this.hasBluetooth = enabled;
            return this;
        }

        public Builder wifi(boolean enabled) {
            this.hasWifi = enabled;
            return this;
        }

        public Computer build() {
            if (cpu == null || cpu.isEmpty()) throw new IllegalStateException("CPU is required");
            if (ramGb <= 0) throw new IllegalStateException("RAM must be positive");
            if (storageGb <= 0) throw new IllegalStateException("Storage must be positive");
            return new Computer(this);
        }
    }
}
