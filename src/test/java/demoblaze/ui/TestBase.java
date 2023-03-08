package demoblaze.ui;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;

public class TestBase {
    @AfterEach
    void afterTest () {
        Configuration.holdBrowserOpen = true;
    }
}
