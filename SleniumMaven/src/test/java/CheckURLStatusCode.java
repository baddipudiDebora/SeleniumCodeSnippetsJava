import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class CheckURLStatusCode {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // Navigate to the webpage
        driver.get("https://the-internet.herokuapp.com/status_codes");

        // Find all links on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // Check each link
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url != null && !url.isEmpty()) {
                try {
                    // Validate URL by status code
                    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                    connection.setRequestMethod("HEAD"); // Use HEAD to get headers only
                    int responseCode = connection.getResponseCode();
                    System.out.println(responseCode+" "+url);

                   if (responseCode >= 200 && responseCode < 400) {
                        System.out.println("Valid URL: " + url + " - Status Code: " + responseCode);
                    }
                    else {
                        System.out.println("Malformed URL: " + url + " - Status Code: " + responseCode);
                    }

                } catch (Exception e) {
                    System.out.println("Malformed URL: " + url + " - Exception: " + e.getMessage());
                }
            } else {
                System.out.println("Empty or Null URL found");
            }
        }

        driver.quit();
    }
}
