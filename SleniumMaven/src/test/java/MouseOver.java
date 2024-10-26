import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MouseOver {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
 //       driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.get("https://www.amazon.in");

        WebElement elementToHover = driver.findElement(By.xpath("//a[@id=\"nav-link-accountList\"]"));

        // Create an instance of Actions class
        Actions actions = new Actions(driver);

        // Perform the hover action
        actions.moveToElement(elementToHover).build().perform();

    }
}
