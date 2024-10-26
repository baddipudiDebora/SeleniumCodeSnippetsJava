//Import all required packages
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class FirstWebDriverDemo {

    public static void main(String[] args) throws InterruptedException {
        //Create chrome driver object
        WebDriver driver = null;
        WebDriverManager.chromedriver().setup();

        //Create chrome driver option object
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        //Maximize the browser window
        driver.manage().window().maximize();

        //Navigate to the site
        driver.get("https://www.saucedemo.com/");

        //Verify if site title is correct using hard assert
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Swag Labs";
        Assert.assertEquals(ActualTitle, ExpectedTitle);
        System.out.println("Assertion 1 Passed; Title is "+ActualTitle);

        //Verify if site logo is displayed using soft assert
        SoftAssert softassert = new SoftAssert();
        WebElement siteLogo = driver.findElement(By.className("login_logo"));
        softassert.assertEquals(true,siteLogo.isDisplayed());
        System.out.println("Assertion 2 Passed; Site Logo is displayed");

        //Locate username text field using ID
        WebElement username = driver.findElement(By.id("user-name"));
        //Enter username
        username.sendKeys("standard_user");

        //Locate password text field using relative xpath
        WebElement password = driver.findElement(By.xpath(".//*[@name='password']"));
        //Enter password
        password.sendKeys("secret_sauce");

        //Locate login button using name
        WebElement loginBtn = driver.findElement(By.name("login-button"));
        //Click on login button
        loginBtn.click();

        //Verify if Inventory page URL is loaded
        String ActualURL = driver.getCurrentUrl();
        String ExpectedURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(ActualURL, ExpectedURL);
        System.out.println("Assertion 3 Passed; Inventory URl loaded correctly. Loaded URL is "+ ActualURL);

        //Verify if Filter object is displayed
        //Locate filter object using ClassName
        WebElement filter = driver.findElement(By.className("product_sort_container"));
        Assert.assertEquals(true,filter.isDisplayed());
        System.out.println("Assertion 4 Passed; Filter is displayed");

        //Sort product by highest price
        Select sortProduct = new Select(filter);
        sortProduct.selectByValue("hilo");

        //Add the first product to cart
        //Open the first product
        // *[1], which will select the node value of the first child
        driver.findElement(By.xpath("//div[@class='inventory_container']//div/*[1]//div//a//img")).click();
        //      driver.findElement(By.xpath("//*[@id=\"item_5_img_link\"]/img")).click();
        driver.findElement(By.xpath("//button[text()='Add to cart']")).click();

        //Complete the purchase
        //Locate Shopping cart icon using cssSelector and click on icon
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();

        //Verify if the correct product is added to cart
        WebElement productAdded = driver.findElement(By.xpath(".//*[text()='Sauce Labs Fleece Jacket']"));
        Assert.assertEquals(true,productAdded.isDisplayed());
        System.out.println("Assertion 5 Passed; Correct product added");

        //Click on Checkout button
        driver.findElement(By.id("checkout")).click();

        //Fill in the checkout information form
        driver.findElement(By.name("firstName")).sendKeys("TestUser");
        driver.findElement(By.id("last-name")).sendKeys("Selenium");
        driver.findElement(By.name("postalCode")).sendKeys("123456");
        //Click on Continue button
        driver.findElement(By.name("continue")).click();

        //Verify checkout overview; verify the price
        WebElement productPrice = driver.findElement(By.xpath(".//*[text()='53.99']"));
        Assert.assertEquals(true,productPrice.isDisplayed());
        System.out.println("Assertion 6 Passed; Correct price displayed");


        //Click on Finish button
        driver.findElement(By.xpath(".//*[@id='finish']")).click();

        //Verify the checkout complete page
        WebElement orderComplete = driver.findElement(By.xpath(".//*[text()='Thank you for your order!']"));
        Assert.assertEquals(true,orderComplete.isDisplayed());
        System.out.println("Assertion 7 Passed; Order complete");

        //Logout
        driver.findElement(By.id("back-to-products")).click();
        driver.findElement(By.id("react-burger-menu-btn")).click();
        (new WebDriverWait(driver, Duration.ofSeconds(5))).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[text()='Logout']"))));
        driver.findElement(By.xpath(".//*[text()='Logout']")).click();


        //Verify if user is successfully logout
        WebElement btn = driver.findElement(By.id("login-button"));
        Assert.assertEquals(true,btn.isDisplayed());
        System.out.println("Assertion 8 Passed; Logout Successful");

        //Tearing down browser
        driver.quit();
    }
}

