import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Selenide.*;

public class TodoMvcTest {
    @Test
    void completesTask() {
        open("http://todomvc.com/examples/emberjs/");

        element("#new-todo").setValue("a").pressEnter();
        element("#new-todo").setValue("b").pressEnter();
        element("#new-todo").setValue("c").pressEnter();
        elements("#todo-list>li").shouldHave(exactTexts("a", "b", "c"));

        element("#todo-list>li:nth-child(2) .toggle").click();
        element("#todo-list>li:nth-child(1)").shouldHave(not(cssClass("completed")));
        element("#todo-list>li:nth-child(2)").shouldHave(cssClass("completed"));
        element("#todo-list>li:nth-child(3)").shouldHave(not(cssClass("completed")));
    }
}
