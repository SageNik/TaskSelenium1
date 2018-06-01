import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Ник on 01.06.2018.
 */
public class Test1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver webDriver = initChromeDriver();
        webDriver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        WebElement emailField = webDriver.findElement(By.id("email"));
        emailField.sendKeys("webinar.test@gmail.com");
        WebElement passwordField = webDriver.findElement(By.id("passwd"));
        passwordField.sendKeys("Xcg7299bnSmMuRLp9ITw");
        WebElement submitButton = webDriver.findElement(By.name("submitLogin"));
        submitButton.click();
        Thread.sleep(3000);

        WebElement profileIcon = webDriver.findElement(By.className("employee_avatar_small"));
        profileIcon.click();
        Thread.sleep(2000);
        WebElement logOut = webDriver.findElement(By.id("header_logout"));
        logOut.click();
        webDriver.quit();
    }

    public static WebDriver initChromeDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        return new ChromeDriver();
    }
}
