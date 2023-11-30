package hu.unideb.inf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class HomePage {

    private static final String PAGE_URL = "https://www.saucedemo.com/";

   // private static final String Inventory_Page_URL = "https://www.saucedemo.com/inventory.html";

    private final WebDriver driver;

    @FindBy(css = "#login_button_container > div > form > div.error-message-container.error > h3")
    private WebElement errorMessage;
    @FindBy(css = "#checkout_summary_container > div > div.summary_info > div.summary_info_label.summary_total_label")
    private WebElement priceLabel;
    /**
     * The web element that is linked to the filter menu.
     * Used to open the filter menu to sort the page.
     */
    @FindBy(xpath = "//select")
    private WebElement productSortContainer;

    /**
     * The web element linked to the filter from A to Z button within the filter menu.
     * Used to filter the inventory items from A to Z.
     */
    @FindBy(xpath = "//option[@value=\"az\"]")
    private WebElement filterAToZ;

    /**
     * The web element linked to the filter from Z to A button within the filter menu.
     * Used to filter the inventory items from Z to A.
     */
    @FindBy(xpath = "//option[@value=\"za\"]")
    private WebElement filterZToA;

    /**
     * The web element linked to the price low to high button within the filter menu.
     *  Used to filter the inventory items from price low to high.
     */
    @FindBy(xpath = "//option[@value=\"lohi\"]")
    private WebElement priceLowHigh;

    /**
     * The web element linked to the price high to low button within the filter menu.
     *  Used to filter the inventory items from price high to low.
     */
    @FindBy(xpath = "//option[@value=\"hilo\"]")
    private WebElement priceHighLow;

    private static final Map<String, By> textFields = Map.of(
       "Username", By.id("user-name"),
       "Password", By.id("password"),
       "First Name", By.id("first-name"),
       "Last Name", By.id("last-name"),
       "Zip Code", By.id("postal-code")
    );

    private static final Map<String, By> itemButtons = Map.of(
       "Sauce Labs Backpack", By.id("add-to-cart-sauce-labs-backpack"),
       "Sauce Labs Bike Light", By.id("add-to-cart-sauce-labs-bike-light"),
       "Sauce Labs Bolt T-Shirt", By.id("add-to-cart-sauce-labs-bolt-t-shirt"),
       "Sauce Labs Fleece Jacket", By.id("add-to-cart-sauce-labs-fleece-jacket"),
       "Sauce Labs Onesie", By.id("add-to-cart-sauce-labs-onesie"),
       "Test.allTheThings() T-Shirt (Red)", By.id("add-to-cart-test.allthethings()-t-shirt-(red)")
    );

    private static final Map<String, By> navigationButtons = Map.of(
        "Login", By.id("login-button"),
        "Cart", By.className("shopping_cart_link"),
        "Checkout", By.id("checkout"),
        "Continue", By.id("continue"),
            "Hamburger Menu",By.id("react-burger-menu-btn"),
            "inventorySidebarLinkAllItems",By.id("inventory_sidebar_link"),
            "aboutSidebarLinkItemMenu",By.id("about_sidebar_link"),
            "logoutSidebarLinkItemMenu",By.id("logout_sidebar_link"),
            "resetSidebarLinkAppState",By.id("reset_sidebar_link")
    );

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    /**
     * The method used to check if the shopping cart web element contains a web element called badge that shows how many items are in the cart.
     */
    public boolean checkIfBadgeExists(){
        List<WebElement> elements = driver.findElements(By.cssSelector("div.page_wrapper div.header_container:nth-child(1) div.primary_header div.shopping_cart_container:nth-child(3) a.shopping_cart_link > span.shopping_cart_badge"));
        if(elements.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    /**
     * The method used to check if the items on the inventory page are in ascending order.
     * @return a boolean value indicating whether or not the items are in ascending order.
     */
    public boolean checkIfItemsFilteredAToZ(){
        List<WebElement> elements = driver.findElements(By.cssSelector("div.page_wrapper div:nth-child(1) div:nth-child(2) div:nth-child(1) div.inventory_container > div.inventory_list"));
        ArrayList<String> sortedByNameAscending = new ArrayList<>();
        ArrayList<String> retrievedNames = new ArrayList<>();
        for(WebElement element : elements){
            retrievedNames.add(element.findElement(By.className("inventory_item_name")).getText());
            sortedByNameAscending.add(element.findElement(By.className("inventory_item_name")).getText());
        }
        Collections.sort(sortedByNameAscending);
        for(int i = 0; i < retrievedNames.size();i++){
            if(!retrievedNames.get(i).equals(sortedByNameAscending.get(i))){
                return false;
            }
        }

        return true;
    }

    /**
     * The method used to check if the items on the inventory page are sorted in descending order.
     * @return a boolean value indicating whether or not the items are in descending order.
     */
    public boolean checkIfItemsFilteredZToA(){
        List<WebElement> elements = driver.findElements(By.cssSelector("div.page_wrapper div:nth-child(1) div:nth-child(2) div:nth-child(1) div.inventory_container > div.inventory_list"));
        ArrayList<String> sortedByNameDescending = new ArrayList<>();
        ArrayList<String> retrievedNames = new ArrayList<>();
        for(WebElement element : elements){
            retrievedNames.add(element.findElement(By.className("inventory_item_name")).getText());
            sortedByNameDescending.add(element.findElement(By.className("inventory_item_name")).getText());
        }
        Collections.sort(sortedByNameDescending,Collections.reverseOrder());
        for(int i = 0; i < retrievedNames.size();i++){
            if(!retrievedNames.get(i).equals(sortedByNameDescending.get(i))){
                return false;
            }
        }

        return true;
    }

    /**
     * The method used to check if items on the inventory page are sorted by price in ascending order.
     * @return a boolean value indicating whether or not the items are in ascending order.
     */
    public boolean checkIfItemsFilteredLowToHigh(){
        List<WebElement> elements = driver.findElements(By.cssSelector("div.page_wrapper div:nth-child(1) div:nth-child(2) div:nth-child(1) div.inventory_container > div.inventory_list"));
        ArrayList<Float> sortedByPriceAscending = new ArrayList<>();
        ArrayList<Float> retrievedPrice = new ArrayList<>();
        for(WebElement element : elements){
            retrievedPrice.add(Float.parseFloat(element.findElement(By.className("inventory_item_price")).getText().replace("$","")));
            sortedByPriceAscending.add(Float.parseFloat(element.findElement(By.className("inventory_item_price")).getText().replace("$","")));
        }
        Collections.sort(sortedByPriceAscending);
        for(int i = 0; i < retrievedPrice.size();i++){
            if(!retrievedPrice.get(i).equals(sortedByPriceAscending.get(i))){
                return false;
            }
        }

        return true;
    }

    /**
     * The method used to check if the items on the inventory page are sorted by price in descending order.
     * @return a boolean value indicating whether or not the items are in descending order.
     */
    public boolean checkIfItemsFilteredHighToLow(){
        List<WebElement> elements = driver.findElements(By.cssSelector("div.page_wrapper div:nth-child(1) div:nth-child(2) div:nth-child(1) div.inventory_container > div.inventory_list"));
        ArrayList<Float> sortedByPriceDescending = new ArrayList<>();
        ArrayList<Float> retrievedPrice = new ArrayList<>();
        for(WebElement element : elements){
            retrievedPrice.add(Float.parseFloat(element.findElement(By.className("inventory_item_price")).getText().replace("$","")));
            sortedByPriceDescending.add(Float.parseFloat(element.findElement(By.className("inventory_item_price")).getText().replace("$","")));
        }
        Collections.sort(sortedByPriceDescending,Collections.reverseOrder());
        for(int i = 0; i < retrievedPrice.size();i++){
            if(!retrievedPrice.get(i).equals(sortedByPriceDescending.get(i))){
                return false;
            }
        }

        return true;
    }

    /**
     * The method used to click on the filterAToZ web element.
     */
    public void clickOnfilterAToZ(){
        filterAToZ.click();
    }

    /**
     * The method used to click on the filterZToA web element.
     */
    public void clickOnfilterZToA(){
        filterZToA.click();
    }

    /**
     * The method used to click on the priceLowHigh web element.
     */
    public void clickOnPriceLowToHigh(){
        priceLowHigh.click();
    }

    /**
     * The method used to click on the priceHighLow web element.
     */
    public void clickOnPriceHighToLow(){
        priceHighLow.click();
    }

    /**
     * The method used to click on the productSortContainer web element.
     */
    public void clickOnProductSort(){
        productSortContainer.click();
    }

    public void closePage() {
        driver.quit();
    }

    public void fillOutField(String field, String text) {
        driver.findElement(textFields.get(field)).sendKeys(text);
    }

    public void clickButton(String button) {
        driver.findElement(navigationButtons.get(button)).click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void addItemToCart(String item) {
        driver.findElement(itemButtons.get(item)).click();
    }

    public String getTotal() {
        return priceLabel.getText();
    }

}
