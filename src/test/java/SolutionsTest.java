import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SolutionsTest {
    @BeforeAll
    static void beforeAll() {
        browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";

    }

    @Test
    void solutionsTest() {
        String url = (Configuration.baseUrl)+"/enterprise";

        open(Configuration.baseUrl);
        $(byText("Solutions")).hover();
        $("[href='/enterprise']").click();
        $("#hero-section-brand-heading").shouldHave(Condition.text("The AI-powered developer platform."));
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(url, currentUrl);

    }

}