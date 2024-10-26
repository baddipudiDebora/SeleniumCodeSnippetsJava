import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class AssertionDemo {
    public static void main(String[] args) {
        //Create chrome driver object
        WebDriver driver = null;
        WebDriverManager.chromedriver().setup();

        //Create chrome driver option object
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        //Maximize the browser window
        driver.manage().window().maximize();

        //Navigate to the site
        driver.get("https://www.saucedemo.com/");

        //Verify if site title is correct using hard assert
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Swag1 Labs";
//        // soft assert
//        SoftAssert sassert = new SoftAssert();
//        sassert.assertEquals(ActualTitle, ExpectedTitle);
//        System.out.println("Assertion 1 Passed; Title is "+ActualTitle);
//     // remember to add the below line, else it catch all failures but wont report
//        sassert.assertAll();
        // Hard Assert - will stop immediatly on that line
        Assert.assertEquals(ActualTitle, ExpectedTitle);
        System.out.println("Assert passed only if you see this message");
    }
}
