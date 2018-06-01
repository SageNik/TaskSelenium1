import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Ник on 01.06.2018.
 */
public class Test2 {

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

        checkElementById("tab-AdminDashboard", webDriver);
        checkElementById("subtab-AdminParentOrders", webDriver);
        checkElementById("subtab-AdminCatalog", webDriver);
        webDriver.navigate().back();
        checkElementById("subtab-AdminParentCustomer", webDriver);
        checkElementById("subtab-AdminParentCustomerThreads", webDriver);
        checkElementById("subtab-AdminStats", webDriver);
        checkElementById("subtab-AdminParentModulesSf", webDriver);
        webDriver.navigate().back();
        checkElementById("subtab-AdminParentThemes", webDriver);
        checkElementById("subtab-AdminParentShipping", webDriver);
        checkElementById("subtab-AdminParentPayment", webDriver);
        checkElementById("subtab-AdminInternational", webDriver);
        checkElementById("subtab-ShopParameters", webDriver);
        checkElementById("subtab-AdminAdvancedParameters", webDriver);

        webDriver.quit();
    }

    public static void checkElementById(String id, WebDriver webDriver){
        WebElement currentWebElement = webDriver.findElement(By.id(id)) ;
        currentWebElement.click();
        System.out.println("The title: " + webDriver.getTitle());

        webDriver.navigate().refresh();
        System.out.println("The title after refresh page: " + webDriver.getTitle());
        System.out.println("----------------------------------------------------------------------------------");
    }

    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        return new ChromeDriver();
    }

}
