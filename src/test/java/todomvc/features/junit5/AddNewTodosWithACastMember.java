package todomvc.features.junit5;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.questions.Text;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import todomvc.features.junit5.pageobjects.TodoMvcPage;
import todomvc.screenplay.todos.AddItem;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
class AddNewTodosWithACastMember {

    @CastMember(name = "Toby")
    Actor toby;

    @Test
    @DisplayName("Add a todo item to an empty list")
    void addToEmptyList() {

        toby.attemptsTo(
                Open.browserOn().the(TodoMvcPage.class),
                Enter.theValue("Buy some milk").into(".new-todo").thenHit(Keys.RETURN)
        );
        Collection<String> items = toby.asksFor(Text.ofEach(".todo-list label"));
        assertThat(items).containsExactly("Buy some milk");

        String title = toby.asksFor(Text.of(By.tagName("h1")));
        assertThat(title).isEqualTo("todos");
    }

    @Test
    @DisplayName("Add a todo item to an empty list with a page object")
    void addToEmptyListUsingAPageObject() {
        toby.attemptsTo(
                Open.browserOn().the(TodoMvcPage.class),
                Enter.theValue("Buy some milk").into(".new-todo").thenHit(Keys.RETURN)
        );
    }

    @Test
    @DisplayName("Add a todo item to an empty list using a named page")
    void addToEmptyListUsingANamedPage() {
        toby.attemptsTo(
                Open.browserOn().thePageNamed("pages.react"),
                Enter.theValue("Buy some milk").into(".new-todo").thenHit(Keys.RETURN)
        );
    }

    @Test
    @DisplayName("Add a todo item to an empty list using a named page")
    void addToEmptyListUsingACustomTask() {
        toby.attemptsTo(
                Open.browserOn().thePageNamed("pages.react"),
                new AddItem("Buy some milk")
        );
    }

//
//    @Test
//    @DisplayName("Add a todo item to a populated list")
//    void addToAPopulatedList() {
//        toby.attemptsTo(
//                Start.withAListContaingTheItems("Feed the cat","Buy some bread"),
//                AddATodoItem.called("Walk the dog"),
//                Ensure.that(Text.ofEach(TodoList.TODO_ITEM))
//                      .containsExactly("Feed the cat","Buy some bread","Walk the dog")
//        );
//    }
}
