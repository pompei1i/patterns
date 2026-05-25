package behavioral.command;

public class TextEditor {
    private StringBuilder text = new StringBuilder();

    public void write(String words) {
        text.append(words);
    }

    public void delete(int count) {
        int len = text.length();
        if (count > len) count = len;
        text.delete(len - count, len);
    }

    public String getText() { return text.toString(); }
}
