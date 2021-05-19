package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchBarModule;
import pages.SearchResultPage;
import pages.ShoppingCartPage;

public class Search extends AbstractBaseTest {

    @Test(groups = "Smoke")
    public void searchProduct() {
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        String item = "Samsung Galaxy Note 20";
        SearchBarModule searchBarModule = new SearchBarModule(driver);
        searchBarModule.enterSearchedItem(item);
        searchBarModule.clickSearchSubmitButton();
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        Assert.assertTrue(searchResultPage.searchResultText.isDisplayed());
        String price = searchResultPage.getFirstProductPrice();
        searchResultPage.clickFirstItem();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        //Assert.assertEquals(itemDetailsPage.getPrice(), price);
        productDetailsPage.clickAddToCart();
        searchBarModule.clickNavCart();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.getProductPrice();
        shoppingCartPage.clickDelete();
        //Assert item is deleted
    }

}
