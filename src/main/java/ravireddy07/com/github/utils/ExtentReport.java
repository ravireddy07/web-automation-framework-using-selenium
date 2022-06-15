package ravireddy07.com.github.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.HashMap;
import java.util.Map;

public class ExtentReport {
    final static String filePath = "reports/ExtentReport.html";
    static ExtentReports extent;
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();

    public synchronized static ExtentTest getTest() {
        return extentTestMap.get((int) (Thread.currentThread().getId()));
    }

    public synchronized static ExtentTest startTest(String testCaseName, String description) {
        ExtentTest test = getReporter().createTest(testCaseName, description);
        extentTestMap.put((int) (Thread.currentThread().getId()), test);
        return test;
    }

    public synchronized static ExtentReports getReporter() {
        if(extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter(filePath);
            spark.config().setEncoding("UTF-8");
            spark.config().setReportName("Report Title");
            spark.config().setDocumentTitle("Sprint Testing Report");
            spark.config().setTheme(Theme.DARK);
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}
