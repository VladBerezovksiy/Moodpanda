package moodpanda;

import org.testng.annotations.Test;

public class HugTest extends BaseTest {

    @Test(description = "Hug someone")
    public void hugSomeoneTest() {
        loginSteps.open()
                .validLogin()
                .isHomeOpened()
                .hug("Stars");
    }
}
