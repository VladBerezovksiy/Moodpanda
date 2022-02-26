package steps;

import com.codeborne.selenide.Condition;
import constants.DashboardPostsPageConstants;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class YourPostsSteps extends AbstractSteps {

    public static final String TITLE_CSS = "#dashboardBreadcrumb";
    public static final String POST_CARD_PATTERN_XPATH =
            "//div[contains(text(), '%s')]/ancestor::div[contains(@class,'card')]//div[contains(@class,'dropdown-trigger')]";
    public static final String DELETE_BUTTON =
            "//footer[@class='card-footer']//a[@class='dropdown-item' and contains(text(),'Delete')]";

    public YourPostsSteps isYourPostOpened() {
        $(TITLE_CSS).shouldHave(Condition.text(DashboardPostsPageConstants.TITLE_TEXT));
        return this;
    }

    @Step
    public HomePageSteps deletePost(String text) {
        $x(String.format(POST_CARD_PATTERN_XPATH, text)).shouldBe(Condition.visible).click();
        $x(DELETE_BUTTON).shouldBe(Condition.visible).click();
        return new HomePageSteps();
    }
}
