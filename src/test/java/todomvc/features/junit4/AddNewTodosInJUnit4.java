package todomvc.features.junit4;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.questions.Text;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class AddNewTodosInJUnit4 {

    @CastMember(name = "Toby")
    Actor toby;

    @Test
    public void addToEmptyList() {
        toby.attemptsTo(
                Open.url("https://todomvc.com/examples/angularjs/#/"),
                Enter.theValue("Buy some milk").into(".new-todo").thenHit(Keys.RETURN)
        );
        var todos = toby.asksFor(Text.ofEach(".todo-list li"));
        assertThat(todos).containsExactly("Buy some milk");
    }
}
