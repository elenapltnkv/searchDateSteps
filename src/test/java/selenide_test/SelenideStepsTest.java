package selenide_test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class SelenideStepsTest {

    //eroshenkoam/allure-example/
    @Test
    public void searchIssueLambdaTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть главную страницу", () -> {
            open("https://github.com");
        });
        step("Найти строку поиска", () -> {
            $(".search-input").click();
        });
        step("Ввести текст в строке поиска", () -> {
            $(".QueryBuilder-Input").sendKeys("eroshenkoam/allure-example");
        });
        step("Нажать на кнопку поиск", () -> {
            $(".QueryBuilder-Input").submit();
        });
        step("Нажать на ссылку в результатах поиска: 'eroshenkoam/allure-example'", () -> {
            $(linkText("eroshenkoam/allure-example")).click();
        });
        step("Перейти на вкладку: 'issues'", () -> {
            $("#issues-tab").click();
        });
        step("Проверить, что на странице отображается #85", () -> {
            $(withText("#85")).shouldHave(Condition.exist);
        });


    }
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
