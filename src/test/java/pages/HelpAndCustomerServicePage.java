package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class HelpAndCustomerServicePage extends PageObject {

    public HelpAndCustomerServicePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "helpsearch")
    private WebElement helpSerchTextbox;

    @FindBy(xpath = "//a[text() = 'Echo Support']")
    private WebElement echoSupportLink;

    @FindBy(tagName = "h4")
    private List<WebElement> helpOptions;

    public void enterSearchText(String searchedText) {
        helpSerchTextbox.sendKeys(searchedText);
        helpSerchTextbox.sendKeys(Keys.ENTER);
    }

    public void clickEchoSupportLink() {
        echoSupportLink.click();
    }

    public List<String> getOptionsList() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(helpOptions));
        return helpOptions.stream().map(WebElement::getText).collect(Collectors.toList());
    }

}
