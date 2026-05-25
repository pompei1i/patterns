package behavioral.memento;

import java.util.ArrayDeque;
import java.util.Deque;

public class EditorHistory {
    private final Deque<EditorMemento> stack = new ArrayDeque<>();

    public void push(EditorMemento m) { stack.push(m); }

    public EditorMemento pop() {
        return stack.isEmpty() ? null : stack.pop();
    }
}
