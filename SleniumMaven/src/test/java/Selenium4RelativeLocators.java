import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Selenium4RelativeLocators {
    public static void main(String[] args) throws InterruptedException {
        //Create chrome driver object
        WebDriver driver = null;
        WebDriverManager.chromedriver().setup();

        //Create chrome driver option object
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        //Maximize the browser window
        driver.manage().window().maximize();

        //Navigate to the site
        driver.get("https://the-internet.herokuapp.com/challenging_dom");
       Thread.sleep(2000);
//
//
//      // Find the script tag
//        WebElement scriptTag = driver.findElement(RelativeLocator.with(By.tagName("script")).above(driver.findElement(By.id("page-footer"))));
//
//
//        // Get the content of the script tag
//        String scriptContent = scriptTag.getDomAttribute()
//        // Print the content
//        System.out.println("Script Content: " + scriptContent);
        // Close the browser
       // driver.quit();

        System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/script/text()")).getCssValue("background-color"));
        driver.quit();

    }
}