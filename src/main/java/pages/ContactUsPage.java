package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ContactUsPage {

    private static String pageURL = "http://automationpractice.com/index.php";
    private static WebDriver driver;
//    Contact us page locator
    public By contactUsPageUrlLocator = By.xpath("//*[@id='contact-link']/a");

    public static ContactUsPage navigateHere(WebDriver driverIn) {
        driver = driverIn;
        driver.navigate().to(pageURL);
        return new ContactUsPage();
    }

    public void doClickOnContactUsLink() {
        WebElement contactUsPageLink = driver.findElement(contactUsPageUrlLocator);
        contactUsPageLink.click();
    }

}
