import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeywordActions {
    private WebDriver driver;

    public void performAction(Keyword keyword, String... params) {
        switch (keyword) {
            case OPEN_BROWSER:
                driver = new ChromeDriver();
                break;

            case NAVIGATE_TO_URL:
                driver.manage().window().maximize();
                driver.get(params[0]);
                break;

            case CLICK:
                WebElement clickElement = driver.findElement(By.xpath(params[0]));
                clickElement.click();
                break;

            case ENTER_TEXT:
                WebElement textElement = driver.findElement(By.xpath(params[0]));
                textElement.sendKeys(params[1]);
                break;

            case VERIFY_TEXT:
                WebElement verifyElement = driver.findElement(By.xpath(params[0]));
                String actualText = verifyElement.getText();
                if (!actualText.equals(params[1])) {
                    throw new AssertionError("Text does not match!");
                }
                break;

            case CLOSE_BROWSER:
                driver.quit();
                break;

            default:
                throw new IllegalArgumentException("Invalid keyword");
        }
    }
}
