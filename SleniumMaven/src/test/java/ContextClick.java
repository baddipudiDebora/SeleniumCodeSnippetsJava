import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextClick   {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");


        // Find the element to right-click on
        WebElement elementToRightClick =  driver.findElement(By.xpath("//a[@href='https://www.google.ca/intl/en/about/products']"));

        // Create an instance of Actions class
        Actions actions = new Actions(driver);

        // Perform the context-click (right-click) action
        actions.contextClick(elementToRightClick).perform();

    }
}
