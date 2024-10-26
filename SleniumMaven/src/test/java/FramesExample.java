import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/iframe");
        Thread.sleep(2000);
        driver.switchTo().frame("mce_0_ifr");
        System.out.println(driver.findElement(By.xpath("//body[@id=\"tinymce\"]")).getText());
    }
}
