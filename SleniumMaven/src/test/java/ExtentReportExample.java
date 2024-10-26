import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class ExtentReportExample {
    public static void main(String[] args) {
        {
        //    String path = System.getProperty("user.dir")+"\\TestReport.html";
            // Create an instance of ExtentSparkReporter
            ExtentSparkReporter reporter = new ExtentSparkReporter("D:\\");
            reporter.config().setDocumentTitle("Test Report");
            reporter.config().setReportName("Web Automation Report");

            // Create an instance of ExtentReports and attach the reporter
            ExtentReports extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Browser", "Chrome");

            // variable to Log test name, etc.
            ExtentTest test = extent.createTest("Test Case 1");

            //Create chrome driver object
            WebDriver driver = null;
            WebDriverManager.chromedriver().setup();

            //Create chrome driver option object
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.get("https://www.saucedemo.com/");

            //Verify if site title is correct using hard assert
            String ActualTitle = driver.getTitle();
            String ExpectedTitle = "Swag Labs1";
            if(ActualTitle.equals(ExpectedTitle)){
                test.pass("Page Title matches with expected");
            }
            else {
                test.fail("Page Title does not match with expected");
            }
            extent.flush();
            driver.quit();

        }
    }
}
