package structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileComponent {
    private final String name;
    private final List<FileComponent> children = new ArrayList<>();

    public Directory(String name) { this.name = name; }

    public void add(FileComponent component) { children.add(component); }
    public void remove(FileComponent component) { children.remove(component); }

    @Override public String getName() { return name; }

    @Override
    public long getSize() {
        return children.stream().mapToLong(FileComponent::getSize).sum();
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "📁 " + name + "/ (" + getSize() + " KB total)");
        for (FileComponent child : children) {
            child.print(indent + "  ");
        }
    }
}
