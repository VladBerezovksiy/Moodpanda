package moodpanda;

import com.codeborne.selenide.Configuration;
import constants.DomainConstants;
import constants.WindowSizeConstants;
import models.WindowsSize;
import org.testng.annotations.BeforeMethod;
import steps.AuthenticationSteps;


public class BaseTest {

    AuthenticationSteps loginSteps;

    @BeforeMethod
    public void setup()  {
        Configuration.headless = false;
        Configuration.browser = "chrome";
        Configuration.baseUrl = DomainConstants.BASE_URL;
        configureWindowSizeDependencies(WindowSizeConstants.SMALL_SIZE);

        loginSteps = new AuthenticationSteps();

        /*ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-popup");
        WebDriver driver = new ChromeDriver(chromeOptions);
        setWebDriver(driver);*/
    }

    public void configureWindowSizeDependencies(WindowsSize windowSize) {
        Configuration.browserSize = windowSize.getScreenSize();
        System.setProperty("HOME_PAGE_TITLE_CSS", windowSize.getElementClass());
        System.setProperty("HOME_POST_BUTTON_CSS", windowSize.getPostButton());
        System.setProperty("DASHBOARD_PAGE_TITLE_CSS", windowSize.getElementClass());
    }
}
