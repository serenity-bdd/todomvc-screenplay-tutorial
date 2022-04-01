package todomvc.features;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import todomvc.screenplay.navigation.Start;
import todomvc.screenplay.todos.AddATodoItem;
import todomvc.screenplay.todos.TodoList;

@ExtendWith(SerenityJUnit5Extension.class)
class AddNewTodos {

    @CastMember(name = "Toby")
    Actor toby;

    @Test
    @DisplayName("Add a todo item to an empty list")
    void addToEmptyList() {
        toby.attemptsTo(
                Start.withAnEmptyTodoList(),
                AddATodoItem.called("Buy some milk"),
                Ensure.that(Text.ofEach(TodoList.TODO_ITEM))
                      .containsExactly("Buy some milk")
        );
    }

    @Test
    @DisplayName("Add a todo item to a populated list")
    void addToAPopulatedList() {
        toby.attemptsTo(
                Start.withAListContaingTheItems("Feed the cat","Buy some bread"),
                AddATodoItem.called("Walk the dog"),
                Ensure.that(Text.ofEach(TodoList.TODO_ITEM))
                      .containsExactly("Feed the cat","Buy some bread","Walk the dog")
        );
    }
}
