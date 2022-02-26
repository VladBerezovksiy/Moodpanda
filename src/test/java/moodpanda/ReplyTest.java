package moodpanda;

import org.testng.annotations.Test;

public class ReplyTest extends BaseTest{

    @Test(description = "Reply someone")
    public void replySomeoneTest() {
        loginSteps.open()
                .validLogin()
                .isHomeOpened()
                .reply("Lacey", "AQA-10");
    }
}
