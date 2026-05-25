package behavioral.templatemethod;

public class HtmlReportGenerator extends ReportGenerator {
    @Override protected void writeHeader(String title) { System.out.println("  <html><body><h1>" + title + "</h1><ul>"); }
    @Override protected void writeRow(String row)      { System.out.println("    <li>" + row + "</li>"); }
    @Override protected void writeFooter()             { System.out.println("  </ul></body></html>"); }
}
