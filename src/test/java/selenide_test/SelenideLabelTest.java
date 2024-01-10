package selenide_test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class SelenideLabelTest {

    //eroshenkoam/allure-example/
    @Feature("Поиск issue в репрзитории")
    @Story("Создание issue")
    @Owner("samigullaeva")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка номера issue")
    @Test
    public void annotationTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        WebStepsTest wb = new WebStepsTest();
        wb.openPage();
        wb.searchRepository();
        wb.clickOnRepositoryLink();
        wb.searchIssueNumber(85);
    }


}
