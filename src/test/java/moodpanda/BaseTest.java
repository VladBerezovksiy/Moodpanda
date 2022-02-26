package moodpanda;

import com.codeborne.selenide.Configuration;
import constants.DomainConstants;
import constants.WindowSizeConstants;
import models.WindowsSize;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.AuthenticationSteps;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    AuthenticationSteps loginSteps;

    @BeforeMethod
    public void setup()  {
        Configuration.headless = true;
        Configuration.browser = "chrome";
        Configuration.baseUrl = DomainConstants.BASE_URL;
        configureWindowSizeDependencies(WindowSizeConstants.SMALL_SIZE);

        loginSteps = new AuthenticationSteps();

        /*ChromeOptions chromeOptions = new ChromeOptions();
        chroOptions.addArguments("--disable-popup");
        WebDriver driver = new ChromeDriver(chromeOptions);
        setWebDriver(driver);*/
    }

    public void configureWindowSizeDependencies(WindowsSize windowSize) {
        Configuration.browserSize = windowSize.getScreenSize();
        System.setProperty("HOME_PAGE_TITLE_CSS", windowSize.getElementClass());
        System.setProperty("HOME_POST_BUTTON_CSS", windowSize.getPostButton());
        System.setProperty("DASHBOARD_PAGE_TITLE_CSS", windowSize.getElementClass());
    }

    @AfterMethod
    public void teardown(){
        getWebDriver().quit();
    }
}
