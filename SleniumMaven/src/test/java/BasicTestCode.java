import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public  class BasicTestCode {

    public static void main(String[] args) {
        System.out.println("Hello World");
    }

    public static void openBrowser(String DriverToPass)
    {
        WebDriver driver = null;
       if(DriverToPass.equalsIgnoreCase("FirefoxDriver")){
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        else if(DriverToPass.equalsIgnoreCase("SafariDriver")){
            driver = new SafariDriver();
        }
        else if(DriverToPass.equalsIgnoreCase("EdgeDriver")){
            driver = new EdgeDriver();
        }
        else if(DriverToPass.equalsIgnoreCase("IEDriver")){
            driver = new InternetExplorerDriver();
        }
        else {
           driver = new ChromeDriver();
         }
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }
}
