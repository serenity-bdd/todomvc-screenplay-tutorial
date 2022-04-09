package todomvc.features.junit5;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import todomvc.screenplay.navigation.Start;
import todomvc.screenplay.todos.AddATodoItem;
import todomvc.screenplay.todos.TodoList;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
class AddNewTodosWithAManagedDriver {

    @Managed
    WebDriver driver;

    @Test
    @DisplayName("Add a todo item to an empty list")
    void addToEmptyList() {
        Actor toby = Actor.named("Toby")
                          .whoCan(BrowseTheWeb.with(driver));

        toby.attemptsTo(
                Open.url("https://todomvc.com/examples/angularjs/#/"),
                Enter.theValue("Buy some milk").into(".new-todo").thenHit(Keys.RETURN)
        );
        var todos = toby.asksFor(Text.ofEach(".todo-list li"));
        assertThat(todos).containsExactly("Buy some milk");
    }
}
