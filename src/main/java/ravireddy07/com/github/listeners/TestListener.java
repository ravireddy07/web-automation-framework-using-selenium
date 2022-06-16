package ravireddy07.com.github.listeners;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.binary.Base64;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import ravireddy07.com.github.DriverManager;
import ravireddy07.com.github.utils.ExtentReport;
import ravireddy07.com.github.utils.TestUtils;

public class TestListener implements ITestListener, IAnnotationTransformer {
    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.startTest(result.getName(), result.getMethod().getDescription()).assignCategory("Mac M1_Chrome").assignAuthor("Ravi Kanth Gojur");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReport.getTest().log(Status.PASS, MarkupHelper.createLabel("Test Case '" + result.getName() + "' Passed", ExtentColor.GREEN));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReport.getTest().log(Status.SKIP, MarkupHelper.createLabel("Test Case '" + result.getName() + "' Skipped", ExtentColor.GREY));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onFinish(ITestContext result) {
        ExtentReport.getReporter().flush();
    }

    public void onTestFailure(ITestResult result) {
        TestUtils utils = new TestUtils();
        if(result.getThrowable() != null) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            result.getThrowable().printStackTrace(pw);
            utils.log().info(sw.toString());
        }

        File file = DriverManager.getDriver().getScreenshotAs(OutputType.FILE);

        byte[] encoded = null;
        try {
            encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
        } catch(IOException e1) {
            e1.printStackTrace();
        }

        // Get Values from current XML files(This will helpful if we have given Parameters in xml)
        Map<String, String> params = new HashMap<String, String>();
        params = result.getTestContext().getCurrentXmlTest().getAllParameters();
        String imagePath = "Screenshots" + File.separator + params.get("browserName") + File.separator + utils.dateTime() + File.separator + result.getTestClass().getRealClass().getSimpleName() + File.separator + result.getName() + ".png";
        String completeImagePath = System.getProperty("user.dir") + File.separator + imagePath;

        try {
            FileUtils.copyFile(file, new File(imagePath));
            Reporter.log("This is a sample screenshot");
            Reporter.log("<a href='" + completeImagePath + "'> <img src='" + completeImagePath + "' height='400' width='400'/> </a>");
        } catch(IOException e) {
            e.printStackTrace();
        }
        ExtentReport.getTest().log(Status.FAIL, MarkupHelper.createLabel("Test Case '" + result.getName() + "' Failed", ExtentColor.RED));
        ExtentReport.getTest().fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromBase64String(new String(encoded, StandardCharsets.US_ASCII)).build());
        ExtentReport.getTest().fail(result.getThrowable());
    }

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        iTestAnnotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}
