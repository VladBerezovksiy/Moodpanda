package moodpanda;

import org.testng.annotations.Test;

public class PostUpdateTest extends BaseTest {

    @Test(description = "Add post")
    public void postUpdateTest() {
        loginSteps.open()
                .validLogin()
                .isHomeOpened()
                .postMood()
                .isPostPageOpened()
                .fillNewMood(10, "VLADOS");
    }
}
