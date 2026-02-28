package org.example;

import org.testng.*;
import org.testng.xml.XmlSuite;
import java.io.*;
import java.util.*;

public class HtmlReporter implements IReporter {
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        try {
            FileWriter fw = new FileWriter(  "./custom-report.html");
            PrintWriter pw = new PrintWriter(fw);

            pw.println("<html><head><title>Custom TestNG Report</title></head><body>");
            pw.println("<h1>Execution Summary</h1>");

            for (ISuite suite : suites) {
                pw.println("<h2>Suite: " + suite.getName() + "</h2>");
                Map<String, ISuiteResult> results = suite.getResults();

                for (ISuiteResult result : results.values()) {
                    ITestContext context = result.getTestContext();
                    pw.println("<p>Passed: " + context.getPassedTests().size() + "</p>");
                    pw.println("<p>Failed: " + context.getFailedTests().size() + "</p>");
                    pw.println("<p>Skipped: " + context.getSkippedTests().size() + "</p>");
                }
            }

            pw.println("</body></html>");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
