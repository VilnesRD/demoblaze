package demoblaze.ui;

import demoblaze.ui.pageObject.LoginObject;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class Login extends TestBase {
@Test
    void successfulLogin () {
    open("https://www.demoblaze.com/");
    new LoginObject()
            .openLoginWindow()
            .setUsername("test_qa_16")
            .setPassword("xswqaz123")
            .clickToLogin()
            .checkResultSuccessfulLogin();

}

    @Test
    void unSuccessfulLogin () {
        open("https://www.demoblaze.com/");
        new LoginObject()
                .openLoginWindow()
                .setUsername("12333")
                .setPassword("1233333")
                .clickToLogin()
                .checkResultUnsuccessfulLogin();

    }
}
