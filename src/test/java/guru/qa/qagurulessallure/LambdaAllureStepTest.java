package guru.qa.qagurulessallure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaAllureStepTest {
    private static String REPOSITORY = "eroshenkoam/allure-example";
    private static int ISSUE = 80;

    @Test
    @Feature("Issue в репозитории")
    @Story("Добавление issue")
    @DisplayName("Добавление issue не авторизированным пользователем")
    @Owner("Sasha")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("BlockerTag")
    @Link(value = "Testing Stage", url = "test.github.ru")
    public void testLambdaIssuesSearch(){
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Перейти на главную", () ->{
            open("https://github.com/");
            attachment("Source", webdriver().driver().source());
        });
        step("Найти репозиторий " + REPOSITORY, () ->{
            $(".header-search-input").setValue("eroshenkoam/allure-example").pressEnter();
        });
        step("Перейти в репозиторий "+ REPOSITORY, () -> {
            $(linkText("eroshenkoam/allure-example")).click();
        });
        step("Перейти в раздел issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверить наличие issue по тексту" + ISSUE, () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        } );

    }
}
