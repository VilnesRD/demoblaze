package demoblaze.ui;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class Login {
@Test
    void successfulLogin () {
    open("https://www.demoblaze.com/");
    $("#login2").click();
    $("#loginusername").setValue("test_qa_16");
    $("#loginpassword").setValue("xswqaz123");
    $("button[onclick='logIn()']").click();
    $("#nameofuser").shouldHave(text("Welcome test_qa_16"));
    Configuration.holdBrowserOpen = true;

}

    @Test
    void unSuccessfulLogin () {
        open("https://www.demoblaze.com/");
        $("#login2").click();
        $("#loginusername").setValue("12333");
        $("#loginpassword").setValue("1233333");
        $("button[onclick='logIn()']").click();
        switchTo().alert().accept();
        $("#logInModal").shouldBe(visible);
        $("#nameofuser").shouldNotBe(visible);

        Configuration.holdBrowserOpen = true;


    }
}
