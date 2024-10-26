import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class SendOnlyCaps {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.costco.ca");
       Thread.sleep(2000);
        Actions action = new Actions(driver);
      //  WebElement webelementToSendText = ;

        // simualate writing in CAPS , we press shift button and then type
     //   action.moveToElement(driver.findElement(By.id(":rc:"))).click().keyDown(Keys.SHIFT).sendKeys("hellotypingincaps").build().perform();
        action.moveToElement(driver.findElement(By.id(":rc:"))).click().keyDown(Keys.SHIFT).sendKeys("hellotypingincaps").doubleClick().build().perform();
    }
}
