package hu.unideb.inf;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

/**
 * The class used to test the filters.feature file.
 */
public class FilterStepDefs extends AbstractStepDefs {
    @Given("the Product Sort button is clicked")
    public void theProductSortButtonIsClicked() {
        homePage.clickOnProductSort();
    }

    @When("the Filter From A to Z button is clicked")
    public void theFilterFromAToZButtonIsClicked() {
        homePage.clickOnfilterAToZ();
    }

    @Then("the Page Items is sorted from A to Z")
    public void thePageItemsIsSortedFromAToZ() {
        Assert.assertTrue(homePage.checkIfItemsFilteredAToZ());
    }

    @Then("the Page Items is sorted from Z to A")
    public void thePageItemsIsSortedFromZToA() {
        Assert.assertTrue(homePage.checkIfItemsFilteredZToA());
    }

    @When("the Filter From Z to A button is clicked")
    public void theFilterFromZToAButtonIsClicked() {
        homePage.clickOnfilterZToA();
    }

    @When("the Filter from price Low to High is clicked")
    public void theFilterFromPriceLowToHighIsClicked() {
        homePage.clickOnPriceLowToHigh();
    }

    @Then("the Page Items is sorted from Price Low to High")
    public void thePageItemsIsSortedFromPriceLowToHigh() {
        homePage.checkIfItemsFilteredLowToHigh();
    }

    @When("the Filter from price High to Low is clicked")
    public void theFilterFromPriceHighToLowIsClicked() {
        homePage.clickOnPriceHighToLow();
    }

    @Then("the Page Items is sorted from Price High to Low")
    public void thePageItemsIsSortedFromPriceHighToLow() {
        homePage.checkIfItemsFilteredHighToLow();
    }
}