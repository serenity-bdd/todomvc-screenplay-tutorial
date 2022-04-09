package todomvc.features.junit5.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;

public class Login {

    public static Task asAStandardUser() {
        return Task.where(
                Open.url("https://www.saucedemo.com/"),
                Enter.theValue("standard_user").into("#user-name"),
                Enter.theValue("secret_sauce").into("#password"),
                Click.on("#login-button")
        );
    }

    public static Task as(String username, String password) {
        return Task.where("{0} logs in as " + username,
                Open.url("https://www.saucedemo.com/"),
                Enter.theValue(username).into("#user-name"),
                Enter.theValue(password).into("#password"),
                Click.on("#login-button")
        );
    }
}
