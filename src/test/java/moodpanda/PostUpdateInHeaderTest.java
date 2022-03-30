package moodpanda;

import org.testng.annotations.Test;

public class PostUpdateInHeaderTest extends BaseTest {

    @Test(description = "Add post in header")
    public void postUpdateInHeaderTest()  {
        loginSteps.open()
                .validLogin()
                .isHomeOpened()
                .postMoodInHeader()
                .isPostPageOpened()
                .fillNewMood(8, "VLADOS");
    }
}
