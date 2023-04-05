package guru.qa.qagurulessallure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.qagurulessallure.steps.Steps;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class StepsAllureTest extends BaseTest {

    @Test
    @Feature("Issue в репозитории")
    @Story("Добавление issue")
    @DisplayName("Добавление issue не авторизированным пользователем")
    @Owner("Sasha")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("BlockerTag")
    @Link(value = "Testing Stage", url = "https://test.github.ru")
    public void stepsTest() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
        Steps steps = new Steps();
        steps.goMainPage();
        steps.searchRepo(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.goToIssues();
        steps.checkIssueText(ISSUE);
        steps.takeScreenshot();
    }
}
