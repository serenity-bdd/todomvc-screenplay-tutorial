package todomvc.screenplay.todos;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.ui.PageElement;

public class TodoList {
    public static Target TODO_ITEM = PageElement.locatedBy(".todo-list label");
}
