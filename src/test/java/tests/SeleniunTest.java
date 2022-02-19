package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.ContactUsPage;
import utils.PropertyReader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SeleniumTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        String browser = PropertyReader.browser;
        switch (browser) {
            case ("chrome"): {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            }
            case ("firefox"): {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
            default:
                throw new InvalidArgumentException("cant initialize driver, available options is: chrome, firefox");
        }
    }

    @Test
    public void UseDriverManager() throws InterruptedException {
        driver.get("http://automationpractice.com/");
        WebElement contactUsPageLink = driver.findElement(By.xpath("//*[@id='contact-link']/a"));
        if (contactUsPageLink.isEnabled())
            contactUsPageLink.click();
        Thread.sleep(1000);
        assertTrue(driver.getCurrentUrl().contains("contact"));
    }

    @Test
    public void clickContactUsPageTest() {
        ContactUsPage contactUsPage = ContactUsPage.navigateHere(driver);
        contactUsPage.doClickOnContactUsLink();
        WebElement navigationSpan = driver.findElement(By.xpath("//span[@class='navigation_page']"));
        assertEquals(navigationSpan.getText(),"Contact");
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}