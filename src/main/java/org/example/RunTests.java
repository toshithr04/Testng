package org.example;

import org.testng.TestNG;
import java.util.Collections;

public class RunTests {
    public static void main(String[] args) {
        // Create TestNG instance
        TestNG testng = new TestNG();

        // Point to your suite file
        testng.setTestSuites(Collections.singletonList("testng.xml"));

        // Set custom output directory
        testng.setOutputDirectory("reports/custom-output");

        // Run the suite
        testng.run();
    }
}
