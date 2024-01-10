package selenide_test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class AttachmentTest {
    @Test
    public void openPageAttach() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebStepsTest steps = new WebStepsTest();

        open("https://github.com");
        steps.takeScreenshot();
    }


}
