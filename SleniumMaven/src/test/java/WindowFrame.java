import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowFrame   {
    public static void main(String[] args) throws InterruptedException {
        ExtentSparkReporter reporter = new ExtentSparkReporter("D:\\");
        reporter.config().setDocumentTitle("Window SwitchTest");
        reporter.config().setReportName("Window SwitchTest");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("BrowserVersion", "8");
        extent.setSystemInfo("OS", "Windows");

        ExtentTest test = extent.createTest("Window SwitchTest");


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com");
        Assert.assertEquals(driver.getTitle(), "The Internet");
        test.info("Succesfully navigated to https://the-internet.herokuapp.com");
        //scroll down
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement buttonToClick = driver.findElement(By.linkText("Multiple Windows"));
        je.executeScript("arguments[0].scrollIntoView(true);",buttonToClick);

        test.info("Scrolled down succesfully");

        buttonToClick.click();

        driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
        //new tab or new window is always treated as new window only in selenium
   /*      Set<String> windows = driver.getWindowHandles();
         driver.switchTo().window(windows.iterator().next());*/

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String parentID = iterator.next();
        String childID = iterator.next();
        driver.switchTo().window(childID);
        Assert.assertEquals(  driver.getTitle(), "New Window");


        if(driver.getTitle().equals("New Window")){
            test.pass("Window Switched successfully and the title of new window is  -  "+driver.getTitle());
        }
        else {
            test.fail("Window not Switched successfully");
        }

        driver.switchTo().window(parentID);
        Assert.assertEquals(  driver.getTitle(), "The Internet");
        test.pass("Window Switched back to parent successfully -  "+driver.getTitle());
        extent.flush();




    }
}
