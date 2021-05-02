package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageObject {

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "priceblock_ourprice")
    public WebElement price;

    @FindBy(id = "add-to-cart-button")
    public WebElement addToCartButton;

    public String getPrice(){
        return price.getText().substring(1);
    }

    public void clickAddToCart(){
        addToCartButton.click();
    }
}
