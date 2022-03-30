package moodpanda;

import org.testng.annotations.Test;

public class DeletePostTest extends BaseTest{

    @Test(description = "Delete post")
    public void postDeleteTest() {
        loginSteps.open()
                .validLogin()
                .isHomeOpened()
                .openDashboard()
                .isDashboardOpened()
                .chooseYourPost()
                .isYourPostOpened()
                .deletePost("VLADOS");
    }
}
