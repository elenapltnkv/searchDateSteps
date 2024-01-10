package selenide_test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebStepsTest {
    @Step("Открыть главную страницу")
    public void openPage() {
        open("https://github.com");
    }

    @Step("Найти строку поиска")
    public void searchRepository() {
        $(".search-input").click();
        $(".QueryBuilder-Input").sendKeys("eroshenkoam/allure-example");
        $(".QueryBuilder-Input").submit();
    }

    @Step("Нажать на ссылку в результатах поиска: 'eroshenkoam/allure-example'")
    public void clickOnRepositoryLink() {
        $(linkText("eroshenkoam/allure-example")).click();
    }

    @Step("Перейти на вкладку: 'issues'")
    public void openTab() {
        $("#issues-tab").click();
    }

    @Step("Проверить, что на странице отображается #85")
    public void searchIssueNumber(int issue) {
        $(withText("issue")).shouldHave(Condition.exist);
    }

@Attachment(value="screenshot", type="image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
       return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);

    }
}
