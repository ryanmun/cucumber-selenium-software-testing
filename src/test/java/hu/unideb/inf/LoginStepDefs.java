package hu.unideb.inf;

import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginStepDefs extends AbstractStepDefs {

    @Then("the {string} message is shown")
    public void theErrorMessageMessageIsShown(String errorMessage) {
        assertEquals(errorMessage, homePage.getErrorMessage());
    }

    @Then("the user is directed to {string}")
    public void theLoginScreenIsOpen(String expectedURL) {
        // Retrieve the actual URL from the WebDriver instance
        String actualURL = driver.getCurrentUrl();

        // Compare the actual URL with the expected URL using assertions

        Assert.assertEquals(expectedURL, actualURL);
    }
}
