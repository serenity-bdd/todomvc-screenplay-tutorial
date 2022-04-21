package todomvc.features.junit5.restassured;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class DogImageSteps {
    @Step
    public String fetchADogImage() {
        SerenityRest.get("https://dog.ceo/api/breeds/image/random")
                .then()
                .statusCode(200);

        return SerenityRest.lastResponse().jsonPath().get("message");
    }
}
