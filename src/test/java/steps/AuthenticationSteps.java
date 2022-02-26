package steps;

import com.codeborne.selenide.Condition;
import constants.LoginPageConstants;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class AuthenticationSteps extends AbstractSteps {

    static {
        System.setProperty("email", "rsche13feb@mailinator.com");
        System.setProperty("password", "78wgXcnBvuVNa57");
    }

    public static final String EMAIL_CSS = ".control input[type=text]";
    public static final String PASSWORD_CSS = ".control input[type=password]";
    public static final String LOGIN_BUTTON_CSS = ".section button";

    @Step("Login {email}/*********")
    public void login(String email, String password) {
        $(EMAIL_CSS).sendKeys(email);
        $(PASSWORD_CSS).sendKeys(password);
        $(LOGIN_BUTTON_CSS).click();
    }

    public AuthenticationSteps open()  {
        openPage(
                LoginPageConstants.LOGIN_PAGE_URN,
                LOGIN_BUTTON_CSS,
                Condition.text(LoginPageConstants.LOGIN_BUTTON_TEXT)
        );
        return this;
    }

    @Step("Valid credentials login")
    public HomePageSteps validLogin() {
        login(System.getProperty("email"), System.getProperty("password"));
        return new HomePageSteps();
    }
}