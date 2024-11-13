import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MalFormedURLusingURLclass {
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
        driver.get("https://www.amazon.com/");

        // Find all links on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        // Check each link
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url != null && !url.isEmpty()) {
                try {
                    // Validate URL the new URL(url) constructor in Java validates the passed URL.
                    // When you create a new URL object, it parses the string representation of the URL and throws a MalformedURLException if the URL is not valid.
                    new URL(url);
                    System.out.println("Valid URL: " + url);
                } catch (MalformedURLException e) {
                    System.out.println("Malformed URL: " + url);
                }
            } else {
                System.out.println("Empty or Null URL found");
            }
        }
    }
}