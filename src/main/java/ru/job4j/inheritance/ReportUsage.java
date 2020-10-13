package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        TextReport report = new TextReport();
        HtmlReport htmlReport = new HtmlReport();
        JSONReport jsonReport = new JSONReport();
        String text1 = report.generate("Report's name", "Report's body");
        System.out.println(text1);
        String text2 = htmlReport.generate("Report's name", "Report's body");
        System.out.println(text2);
        String text3 = jsonReport.generate("name", "body");
        System.out.println(text3);
    }
}
