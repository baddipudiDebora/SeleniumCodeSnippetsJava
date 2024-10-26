import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ScrollDownDemo {
    public static void main(String[] args) {
        WebDriver driver = null;
        WebDriverManager.chromedriver().setup();

        //Create chrome driver option object
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        //Maximize the browser window
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com");

        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement buttonToClick = driver.findElement(By.linkText("Multiple Windows"));
        je.executeScript("arguments[0].scrollIntoView(true);",buttonToClick);
        buttonToClick.click();

    }
}
