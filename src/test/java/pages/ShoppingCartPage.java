package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageObject {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "span.sc-product-price")
    public WebElement productPrice;

    @FindBy(xpath = "//input[@data-action = 'delete']")
    public WebElement deleteButton;

    public String getProductPrice() {
        return productPrice.getText().substring(1);
    }

    public void clickDelete() {
        deleteButton.click();
    }
}
