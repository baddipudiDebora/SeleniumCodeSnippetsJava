import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitsExample1 {


    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
       // Implicit Wait - defined globally
        // Explicit wait / Webdriver wait - based on certian conditions , we specify time and condition , default polling to check DOM is  500 milliseconds.
        // Fluent wait - same a explicti wait but we have control to customize default polling period and give our own polling period
        // Credit card processing example -  please wait your card is accepted(3sec) , then processed succesfully (7th sec)  both same xpath
        // so kept polling period in fluent wait as 5 sec, so that it will not check in DOM when 1st message comes and goes off , then it polls for DOM


        driver.get("https://www.costco.ca/");
        //      Thread.sleep(5000);
        //        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        //      driver.findElement(By.id("onetrust-pc-btn-handler")).click();

        WebDriverWait d=new WebDriverWait(driver, Duration.ofSeconds(5));
        d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alertdialog']")));
        driver.findElement(By.id("onetrust-pc-btn-handler")).click();
        //  Fluent wait comes under category of Explicit wait, we have control to define the polling interval
//  sample application for practise
    }

}



