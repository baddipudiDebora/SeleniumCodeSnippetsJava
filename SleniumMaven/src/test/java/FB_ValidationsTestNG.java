import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FB_Validations {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        // Log In button Color Validation
        String LogInBtnColor =
                driver.findElement(By.xpath("//button[contains(text(),'Log In')]")).getCssValue("background-color");
        if (LogInBtnColor.equals("rgba(8, 102, 255, 1)")) {
            System.out.println("Log In button color verified");
        } else {
            System.out.println("Log In button color not verified");
        }
        driver.findElement(By.partialLinkText("password?")).click();
        Thread.sleep(3000);
//Email Label Color Verification
        String emailTxtBoxLabelColor =
                driver.findElement(By.xpath("//input[@id='identify_email']")).getCssValue("color");
        if (emailTxtBoxLabelColor.equals("rgba(28, 30, 33, 1)")) {
            System.out.println("Email Label Color Verified");
        } else {
            System.out.println("Email Label Color not Verified");
        }
//Log In button is enabled validation
        boolean btnEnabled = driver.findElement(By.xpath("//span[contains(text(),'Log In')]")).isEnabled();
        if (btnEnabled) {
            System.out.println("Log In button is enabled");
        } else {
            System.out.println("Log In button is not enabled");
        }
// URL contains 'facebook'
        boolean facebookInUrl = driver.getCurrentUrl().contains("facebook");
        if (facebookInUrl) {
            System.out.println("Facebook is present in the URL");
        } else {
            System.out.println("Facebook is not present in the URL");
        }
// Forgotten password
        driver.findElement(By.linkText("Forgot Account?")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#identify_email")).sendKeys("999999")
        ;
        Thread.sleep(3000);
        driver.findElement(By.id("did_submit")).click();
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div [@class='pam uiBoxRed']")));
        String expectedErrorMessage = "No search results Your search did not return any results. Please try again with other information.";
        String actualErrorMessage =
                driver.findElement(By.xpath("//div[@class='pam uiBoxRed']")).getText();
        if (actualErrorMessage.equals(expectedErrorMessage)) {
            System.out.println("Error Message Verified");
        } else {
            System.out.println("Error Message Not Verified");
        }
// Verify Title
        String expectedTitle = "Forgot password | Can't log in | Facebook";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Title Matched");
        } else {
            System.out.println("Title Not Matched");
        }
// Verify text 'Find Your Account'
        boolean textPresent =
                driver.findElement(By.className("uiHeaderTitle")).isDisplayed();
        if (textPresent) {
            System.out.println("Find Your Account text is present");
        } else {
            System.out.println("Find Your Account text is not present");
        }
        driver.quit();
    }
}