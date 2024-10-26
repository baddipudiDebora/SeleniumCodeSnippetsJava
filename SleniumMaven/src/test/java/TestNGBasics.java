import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNGBasics {
    @Test public void basicTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        // implicit wait is defined only once at global level , till the driver object instance
        // telling driver object , you need to wait for this amount of time before throwing any error
        // this will slow down the entire test suite execution time as for every real error ,
        // it will wait for 10 sec before failing the test , but every  500 milliseconds it will be checking the DOM
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Now in explicit wait you can target a specific element, okay?
        // but within explicit wait,you can target a specific scenario,


    }
}
