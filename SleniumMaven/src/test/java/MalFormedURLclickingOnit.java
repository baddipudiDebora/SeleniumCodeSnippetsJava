import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MalFormedURLclickingOnit {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       // Wait for up to 10 seconds
        // Navigate to the webpage
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        // Find all links on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        // Check each link
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url != null && !url.isEmpty()) {
                try {
                    System.out.println(url);
                    driver.get(url);
                    if (driver.getCurrentUrl().equals(url)) {
                        System.out.println("Valid URL: " + url);
                    } else {
                        System.out.println("Malformed URL: " + url);
                    }
                } catch (Exception e) {
                    System.out.println("Malformed URL: " + url);
                }
            }
        }
    }
}