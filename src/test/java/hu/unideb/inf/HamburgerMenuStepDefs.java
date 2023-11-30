package hu.unideb.inf;


import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;


/**
 * The class used to test the hamburgermenu.feature file.
 */
public class HamburgerMenuStepDefs extends AbstractStepDefs {

    @Given("the {string} is opened")
    public void theCartIsOpened(String button) {
        homePage.clickButton(button);
    }

    @And("the {string} is Clicked")
    public void theHamburgerMenuIsClicked(String button) {
        homePage.clickButton(button);
    }

    @When("the {string} option is chosen")
    public void theAllItemsOptionIsChosen(String button) {
        homePage.clickButton(button);
    }

    @Then("the inventory page is opened")
    public void theInventoryPageIsOpened() {
        Assert.assertEquals(driver.getCurrentUrl(), homePage.openPage());
    }

    @Then("Check if About Webpage is opened")
    public void checkIfAboutWebpageIsOpened() {
        Assert.assertEquals(driver.getCurrentUrl(),"https://saucelabs.com/");
    }

    @Then("The Login Screen is open")
    public void theLoginScreenIsOpen() {
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/");
    }

    @Given("the {string} is added to the cart")
    public void theSauceLabsBackpackIsAddedToTheCart(String item) {
        homePage.addItemToCart(item);
    }

    @And("the cart badge exists")
    public void theCartBadgeExists() {
        Assert.assertTrue(homePage.checkIfBadgeExists());
    }

    @Then("the cart badge does not exist")
    public void theCartBadgeDoesNotExist() {
        Assert.assertFalse(homePage.checkIfBadgeExists());
    }

    @When("the {string} is Clicked")
    public void logoutOptionIsClicked(String button) {
        homePage.clickButton(button);
    }
    @Given("the home page is opened")
    public void theHomePageIsOpened() {
        homePage.openPage();
    }

    @Given("the {string} field is filled with {string}")
    public void theFieldIsFilledWithText(String field, String text) {
        homePage.fillOutField(field, text);
    }

    @When("the {string} button is clicked")
    public void theButtonIsClicked(String button) {
        homePage.clickButton(button);
    }

    @AfterAll
    public static void cleanUp() {
        homePage.closePage();
    }
}
