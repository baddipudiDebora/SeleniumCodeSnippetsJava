import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class scratchpad {
    public static void main(String[] args) {
        // WebDriver setup and configuration
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.example.com");

       // Test script execution
        WebElement element = driver.findElement(By.id("sample-id"));
        element.click();
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Expected Title");

       // Tear down
        driver.quit();

    }
}
