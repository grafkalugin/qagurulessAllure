package guru.qa.qagurulessallure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static org.openqa.selenium.By.linkText;

public class SelenideAllureTest {

    @Test
    @Feature("Issue в репозитории")
    @Story("Добавление issue")
    @DisplayName("Добавление issue не авторизированным пользователем")
    @Owner("Sasha")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("BlockerTag")
    @Link(value = "Testing Stage", url = "test.github.ru")
    public void testIssuesSearch(){
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/");
        attachment("Source", webdriver().driver().source());
        $(".header-search-input").setValue("eroshenkoam/allure-example").pressEnter();
        $(linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $(withText("#80")).should(Condition.exist);
    }
}
