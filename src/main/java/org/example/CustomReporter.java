package org.example;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

import java.util.List;
import java.util.Map;

public class CustomReporter implements IReporter {
        @Override
        public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
            for (ISuite suite : suites) {
                Map<String, ISuiteResult> results = suite.getResults();
                for (ISuiteResult result : results.values()) {
                    ITestContext context = result.getTestContext();
                    System.out.println("Passed tests: " + context.getPassedTests().size());
                    System.out.println("Failed tests: " + context.getFailedTests().size());
                }
            }
        }
    }

