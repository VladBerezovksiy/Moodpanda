package steps;

import com.codeborne.selenide.Condition;
import constants.DashboardPageConstants;
import constants.HomePageConstants;
import constants.PostPageConstants;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePageSteps extends AbstractSteps {

    public static final String TITLE_CSS_PATTERN = ".%s .title";
    public static final String TITLE_CSS = String.format(TITLE_CSS_PATTERN, System.getProperty("HOME_PAGE_TITLE_CSS"));
    public static final String POST_BUTTON_CSS_PATTERN = ".notification a[href='/post'].%s";
    public static final String POST_BUTTON_CSS = String.format(
            POST_BUTTON_CSS_PATTERN, System.getProperty("HOME_POST_BUTTON_CSS")
    );
    public static final String MENU_BURGER_CSS = ".navbar-burger";
    public static final String MENU_LIST_CSS_PATTERN = "a[href='%s']";
    public static final String MENU_LIST_DASHBOARD_CSS = String.format(
            MENU_LIST_CSS_PATTERN, DashboardPageConstants.YOUR_POST_LINK
    );
    public static final String MENU_LIST_POST_AN_UPDATE_CSS = String.format(
            MENU_LIST_CSS_PATTERN, PostPageConstants.URN
    );
    public static final String CARD_BUTTON_XPATH_PATTERN =
            "//p[contains(text(),'%s')]/ancestor::div[contains(@class,'card')]" +
                    "//a[@class='card-footer-item' and contains(.,'%s')]";
    public static final String TEXTAREA_XPATH_PATTERN =
            "//label[contains(.,'Reply to %s')]/ancestor::div[@class='field']//textarea";
    public static final String REPLY_BUTTON_XPATH_PATTERN =
            "//label[contains(.,'Reply to %s')]/ancestor::section//button[contains(.,'%s')]";
    public static final String TEXT_REPLY_XPATH_PATTERN =
            "//p[contains(text(),'%s')]/ancestor::div[contains(@class,'card')]/parent::div" +
                    "//section[contains(@class,'notification')]//div[contains(@class,'is-light')]" +
                    "//div[@class='wrap' and contains(.,'%s')]";

    @Step("Check Home page is loaded")
    public HomePageSteps isHomeOpened() {
        $(TITLE_CSS).shouldHave(Condition.text(HomePageConstants.TITLE_TEXT), Duration.ofSeconds(8));
        $(TITLE_CSS).shouldBe(Condition.visible);
        return this;
    }

    @Step("Click 'Hug' button by username")
    public void clickHug(String username) {
        $x(String.format(CARD_BUTTON_XPATH_PATTERN, username, "Hug")).click();
    }

    @Step("Check 'Hug' button is sent")
    public void checkHugText(String username) {
        $x(String.format(CARD_BUTTON_XPATH_PATTERN, username, "Hug sent"))
                .should(Condition.visible).shouldHave(Condition.text("Hug sent"));
    }

    public void hug(String username) {
        clickHug(username);
        checkHugText(username);
    }

    @Step("Click 'Reply' button by username")
    public void sentReply(String username, String text) {
        $x(String.format(CARD_BUTTON_XPATH_PATTERN, username, "Reply")).shouldBe(Condition.visible).click();
        $x(String.format(TEXTAREA_XPATH_PATTERN, username)).shouldBe(Condition.visible).sendKeys(text);
        $x(String.format(REPLY_BUTTON_XPATH_PATTERN, username, "Send")).shouldBe(Condition.visible).click();
    }

    @Step("Check 'Reply' button is sent and contain valid text")
    public void checkReply(String username, String text) {
        $x(String.format(TEXT_REPLY_XPATH_PATTERN, username, text)).shouldHave(Condition.text(text));
    }

    public void reply(String username, String text) {
        sentReply(username, text);
        checkReply(username, text);
    }

    @Step("Open 'dashboard' in Menu")
    public DashboardPageSteps openDashboard() {
        $(MENU_BURGER_CSS).shouldBe(Condition.visible).click();
        $(MENU_LIST_DASHBOARD_CSS).shouldHave(Condition.visible).click();
        return new DashboardPageSteps();
    }

    @Step("Click 'Post Update' button in Header")
    public PostMoodSteps postMoodInHeader() {
        $(MENU_BURGER_CSS).shouldBe(Condition.visible).click();
        $(MENU_LIST_POST_AN_UPDATE_CSS).shouldHave(Condition.visible).click();
        return new PostMoodSteps();
    }

    @Step("Click 'Post Update' button")
    public PostMoodSteps postMood() {
        $(POST_BUTTON_CSS).click();
        return new PostMoodSteps();
    }
}
