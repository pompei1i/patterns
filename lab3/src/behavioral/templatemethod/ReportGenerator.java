package behavioral.templatemethod;

import java.util.List;

public abstract class ReportGenerator {

    public final void generate(String title, List<String> rows) {
        writeHeader(title);
        for (String row : rows) writeRow(row);
        writeFooter();
    }

    protected abstract void writeHeader(String title);
    protected abstract void writeRow(String row);
    protected abstract void writeFooter();
}
