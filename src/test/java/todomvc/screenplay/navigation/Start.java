package todomvc.screenplay.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.ui.PageElement;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import todomvc.screenplay.todos.AddATodoItem;

import java.util.Arrays;

public class Start {
    public static Performable withAnEmptyTodoList() {
        return Task.where("{0} starts with an empty todo list",
                Open.url("https://todomvc.com/examples/angularjs/#/")
        );
    }

    public static Performable withAListContainingTheItems(String... items) {
        return Task.where("{0} starts with a list containing " + Arrays.asList(items),
                actor -> {
                    actor.attemptsTo(Start.withAnEmptyTodoList());
                    for (String item : items) {
                        actor.attemptsTo(AddATodoItem.called(item));
                    }
                }
        );
    }
}
