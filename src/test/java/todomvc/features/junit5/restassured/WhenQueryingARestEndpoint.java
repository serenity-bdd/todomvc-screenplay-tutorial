package todomvc.features.junit5.restassured;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
class WhenQueryingARestEndpoint {
    @Steps
    DogImageSteps dogImageSteps;

    @Test
    void shouldFetchADogImage() {
        String dogImage = dogImageSteps.fetchADogImage();
        assertThat(dogImage).endsWith(".jpg");
    }
}
