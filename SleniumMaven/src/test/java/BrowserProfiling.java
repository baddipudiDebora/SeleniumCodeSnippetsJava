import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BrowserProfiling {
    public static void main(String[] args) {
        WebDriver driver=null;
        String browserDriverForTest = "Firefox";

        if (browserDriverForTest.equalsIgnoreCase("Firefox")) {

            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("browser.download.folderList", 2);
            profile.setPreference("browser.download.manager.showWhenStarting", false);
            profile.setPreference("browser.download.dir", "D:\\");
            profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");

            // Create Firefox options and set the profile
            FirefoxOptions options = new FirefoxOptions();
            options.setProfile(profile);
            driver = new FirefoxDriver(options);

        }

        else if (browserDriverForTest.equalsIgnoreCase("Chrome"))

            {
                // Create a new ChromeOptions instance
                ChromeOptions options = new ChromeOptions();

                // Set custom preferences
                options.addArguments("--disable-notifications");
                options.addArguments("--start-maximized");
                options.addArguments("--user-data-dir=/path/to/your/custom/profile");


                // Create a map to set the preferences
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("download.default_directory", "D:\\");

                // Set the preferences
                options.setExperimentalOption("prefs", prefs);
                // Initialize the WebDriver with the Chrome options
                 driver = new ChromeDriver(options);

            }

            driver.manage().window().maximize();
            driver.get("https://www.tutorialspoint.com/selenium/practice/upload-download.php");
        System.out.println("Hi");
            driver.findElement(By.id("downloadButton")).click();
            driver.get("https://stackoverflow.com/questions/10340373/how-to-send-cookies-with-selenium-webdriver");
            // Get all cookies
            Set <Cookie> cookies = driver.manage().getCookies();

            // Iterate through the cookies and print their details
            for (Cookie cookie : cookies) {
                System.out.println("Name: " + cookie.getName());
                System.out.println("Value: " + cookie.getValue());
                System.out.println("Domain: " + cookie.getDomain());
                System.out.println("Path: " + cookie.getPath());
                System.out.println("Expiry: " + cookie.getExpiry());
                System.out.println("Is Secure: " + cookie.isSecure());
                System.out.println("Is HTTPOnly: " + cookie.isHttpOnly());
                System.out.println("--------------------------------------------------");
            }
            driver.quit();
        }
    }
