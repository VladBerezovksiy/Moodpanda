package steps;

import com.codeborne.selenide.Condition;
import constants.DashboardPageConstants;
import constants.DashboardPostsPageConstants;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPageSteps extends AbstractSteps {

    public static final String TITLE_CSS_PATTERN = ".%s .title";
    public static final String TITLE_CSS =
            String.format(TITLE_CSS_PATTERN, System.getProperty("DASHBOARD_PAGE_TITLE_CSS"));
    public static final String BREAD_CRUMB_BUTTON_CSS = "#dashboardBreadcrumb";
    public static final String YOUR_POST_BUTTON_CSS_PATTERN = "#dashboardBreadcrumb a[href='/dashboard%s']";
    public static final String YOUR_POST_BUTTON_CSS = String.format(
      YOUR_POST_BUTTON_CSS_PATTERN, DashboardPostsPageConstants.URN
    );

    public DashboardPageSteps isDashboardOpened() {
        $(TITLE_CSS).shouldHave(Condition.text(DashboardPageConstants.TITLE_TEXT));
        $(TITLE_CSS).shouldBe(Condition.visible);
        return this;
    }

    public YourPostsSteps chooseYourPost() {
        $(BREAD_CRUMB_BUTTON_CSS).shouldBe(Condition.visible).click();
        $(YOUR_POST_BUTTON_CSS).click();
        return new YourPostsSteps();
    }
}
