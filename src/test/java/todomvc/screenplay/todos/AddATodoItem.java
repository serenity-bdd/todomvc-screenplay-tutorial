package todomvc.screenplay.todos;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ui.InputField;
import org.openqa.selenium.Keys;

public class AddATodoItem {
    public static Performable called(String thingToDo) {
        return Task.where("{0} adds a todo item called " + thingToDo,
                Enter.theValue(thingToDo)
                        .into(InputField.withPlaceholder("What needs to be done?"))
                        .thenHit(Keys.RETURN)
        );
    }
}
