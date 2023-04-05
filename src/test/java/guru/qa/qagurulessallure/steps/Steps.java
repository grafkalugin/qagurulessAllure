package guru.qa.qagurulessallure.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class Steps {

        @Step("Перейти на главную")
        public void goMainPage(){
            open("https://github.com/");
            attachment("Source", webdriver().driver().source());
        };

        @Step("Найти репозиторий {repo}")
        public void searchRepo(String repo){
            $(".header-search-input").setValue(repo).pressEnter();
        };

        @Step("Перейти в репозиторий {repo}")
        public void goToRepository(String repo){
            $(linkText(repo)).click();
        };

        @Step("Перейти в раздел issues")
        public void goToIssues(){
            $("#issues-tab").click();
        };

        @Step("Проверить наличие issue по тексту {issue}")
        public void checkIssueText(String issue){
            $(withText("#" + issue)).should(Condition.exist);
        };

        @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
        public byte[] takeScreenshot (){
            return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        };

    }

