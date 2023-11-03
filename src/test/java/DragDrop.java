import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selenide.*;

public class DragDrop {
    @BeforeAll
    static void beforeAll() {
        browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com/drag_and_drop";

    }
    @Test
    void dragAndDrop() {
        open(Configuration.baseUrl);
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
