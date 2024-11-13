import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class ChromeOptionsDemo {
    public static void main(String[] args) throws InterruptedException {
       WebDriver driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();

        // Set custom preferences
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--user-data-dir=/path/to/your/custom/profile");
        options = new ChromeOptions(); options.addArguments("--headless");

       // Create a map to set the preferences
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", "E:\\");

        // Set the preferences
        options.setExperimentalOption("prefs", prefs);
        // Initialize the WebDriver with the Chrome options
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/download");
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//a[contains(text(),'passport bernd.jpg')]")).click();
    //    driver.findElement(By.xpath("//input[@value='Google Search']")).click();

        System.out.println("Download done, check E drive ");

    }
}
