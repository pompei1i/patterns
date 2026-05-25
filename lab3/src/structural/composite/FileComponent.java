package structural.composite;

public interface FileComponent {
    String getName();
    long getSize();
    void print(String indent);
}
