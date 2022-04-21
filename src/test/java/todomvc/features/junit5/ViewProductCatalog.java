package todomvc.features.junit5;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.questions.Text;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Keys;
import todomvc.features.junit5.pageobjects.TodoMvcPage;
import todomvc.features.junit5.tasks.Login;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
class ViewProductCatalog {

    @CastMember(name = "Toby")
    Actor toby;

    @Test
    @DisplayName("View the product catalog")
    void viewProductCatalog() {
        toby.attemptsTo(
                Open.url("https://www.saucedemo.com/"),
                Enter.theValue("standard_user").into("#user-name"),
                Enter.theValue("secret_sauce").into("#password"),
                Click.on("#login-button")
        );
        String pageTitle = toby.asksFor(Text.of(".title"));
        assertThat(pageTitle).isEqualToIgnoringCase("Products");
    }

    @Test
    @DisplayName("View the product catalog using a Task")
    void viewProductCatalogUsingATask() {
        toby.attemptsTo(Login.asAStandardUser());
        String pageTitle = toby.asksFor(Text.of(".title"));
        assertThat(pageTitle).isEqualToIgnoringCase("Products");
    }

    @Test
    @DisplayName("View the product catalog using a parameterized task")
    void viewProductCatalogUsingAParameterizedTask() {
        toby.attemptsTo(Login.as("standard_user","secret_sauce"));
    }

}
