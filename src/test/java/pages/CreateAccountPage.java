package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends PageObject {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "ap_customer_name")
    WebElement nameTextbox;

    @FindBy(id = "ap_email")
    WebElement emailTextbox;

    @FindBy(xpath = "//a[text()='Conditions of Use']")
    WebElement conditionsOfUseLink;

    public void enterName(String name) {
        nameTextbox.sendKeys(name);
    }

    public void enterEmail(String email) {
        emailTextbox.sendKeys(email);
    }

    public void clickConditionsOfUseLink() {
        conditionsOfUseLink.click();
    }

}
