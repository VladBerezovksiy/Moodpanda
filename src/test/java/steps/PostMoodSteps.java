package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import constants.PostPageConstants;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class PostMoodSteps extends AbstractSteps {

    public static final String TITLE_CSS = ".hero .title";
    public static final String MOOD_BUTTON_XPATH_PATTERN = "//button[contains(.,'%s')]";
    public static final String POST_MOOD_BUTTON_XPATH = "//a[contains(.,'Update to')]";
    public static final String TEXT_AREA_CSS = "textarea.textarea";


    @Step("Check Post page is loaded")
    public PostMoodSteps isPostPageOpened() {
        $(TITLE_CSS).shouldHave(Condition.text(PostPageConstants.TITLE_TEXT));
        return this;
    }

    @Step("Select any mood")
    public PostMoodSteps selectMood(int mood) {
        assert (0 <= mood) && (mood <= 10);
        String xpath = String.format(MOOD_BUTTON_XPATH_PATTERN, mood);
        ElementsCollection elements = $$x(xpath);
        for (SelenideElement button: elements) {
            if (button.isDisplayed()) {
                button.click();
                break;
            }
        }
        return this;
    }

    @Step("Describe any text for mood")
    public PostMoodSteps describeMood(String text) {
        $(TEXT_AREA_CSS).sendKeys(text);
        return this;
    }

    @Step("Click 'Post' button that sent mood")
    public HomePageSteps postMood() {
        $x(POST_MOOD_BUTTON_XPATH).click();
        return new HomePageSteps();
    }

    @Step
    public HomePageSteps fillNewMood(int mood, String text) {
        selectMood(mood);
        describeMood(text);
        return postMood();
    }
}
