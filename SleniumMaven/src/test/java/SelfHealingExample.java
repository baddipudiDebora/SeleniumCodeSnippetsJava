import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.epam.healenium.SelfHealingDriver;

public class SelfHealingExample {
    public static void main(String[] args) {
        // Initialize WebDriver and SelfHealingDriver
        WebDriver driver = new ChromeDriver();
        SelfHealingDriver healingDriver = SelfHealingDriver.create(driver);

        // Navigate to the desired URL
        healingDriver.get("https://www.example.com");

        // Find and interact with the element
        WebElement element = healingDriver.findElement(By.id("elementId"));
        element.click();

        // Close the browser
        healingDriver.quit();
    }
    }



