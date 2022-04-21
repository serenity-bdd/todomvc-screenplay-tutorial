package todomvc.screenplay.todos;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

public class AddItem implements Performable {
    private String name;

    public AddItem() {}

    public AddItem(String name) {
        this.name = name;
    }

    @Override
    @Step("{0} adds an item to the list")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(name)
                        .into(".new-todo")
                        .thenHit(Keys.RETURN)
        );
    }

    public static AddItem called(String name) {
        return new AddItem(name);
    }
}
