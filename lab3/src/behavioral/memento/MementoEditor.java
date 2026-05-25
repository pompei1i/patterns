package behavioral.memento;

public class MementoEditor {
    private String content = "";

    public void type(String text) { content += text; }
    public String getContent()    { return content; }

    public EditorMemento save()              { return new EditorMemento(content); }
    public void restore(EditorMemento m)     { content = m.getContent(); }
}
