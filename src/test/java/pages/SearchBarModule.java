package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SearchBarModule extends PageObject {

    public SearchBarModule(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchTextbox;

    @FindBy(id = "nav-search-submit-button")
    public WebElement searchSubmitButton;

    @FindBy(id = "nav-cart")
    public WebElement navCart;

    @FindBy(id = "nav-link-accountList")
    public WebElement signInLink;

    @FindBy(xpath = "//div[@id ='nav-flyout-ya-newCust']//a[text()='Start here.']")
    public WebElement startHereLink;


    public void enterSearchedItem(String searchedItem) {
        searchTextbox.sendKeys(searchedItem);
    }

    public void clickSearchSubmitButton() {
        searchSubmitButton.click();
    }

    public void clickNavCart() {
        navCart.click();
    }

    public void hoverOverSignInLink() {
        Actions actions = new Actions(driver);
        actions.moveToElement(signInLink).perform();
    }

    public void clickStartHereLink() {
        startHereLink.click();
    }


}
