package behavioral.templatemethod;

public class CsvReportGenerator extends ReportGenerator {
    @Override protected void writeHeader(String title) { System.out.println("  # " + title); System.out.println("  value"); }
    @Override protected void writeRow(String row)      { System.out.println("  " + row); }
    @Override protected void writeFooter()             { System.out.println("  # end of report"); }
}
