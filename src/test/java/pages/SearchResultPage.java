package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends PageObject {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@data-component-type ='s-result-info-bar']//span[text() ='\"Samsung Galaxy Note 20\"']")
    public WebElement searchResultText;


    @FindBy(xpath = "//span[contains(@cel_widget_id,'MAIN-SEARCH_RESULTS')]//span[@class = 'a-price-whole']")
    public List<WebElement> listOfProductsWithPrice;


    //TODO fix getting price
    public String getFirstProductPrice() {
        WebElement firstProductWithPrice = listOfProductsWithPrice.get(1);
        String price = firstProductWithPrice.getText();
        try {
            price += firstProductWithPrice.findElement(By.xpath("/following-sibling::span[@class='a-price-fraction']")).getText();
        } catch (Exception e) {
            System.out.println(e);
        }
        return price;

    }

    public void clickFirstItem() {
        listOfProductsWithPrice.get(1).click();
    }

}
