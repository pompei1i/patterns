package behavioral.command;

public class WriteCommand implements Command {
    private final TextEditor editor;
    private final String words;

    public WriteCommand(TextEditor editor, String words) {
        this.editor = editor;
        this.words = words;
    }

    @Override public void execute() { editor.write(words); }
    @Override public void undo()    { editor.delete(words.length()); }
}
