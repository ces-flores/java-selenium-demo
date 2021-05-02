package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.HelpAndCustomerServicePage;
import pages.SearchBarModule;
import utils.AbstractBaseTest;

import java.util.Arrays;
import java.util.List;

public class SignIn extends AbstractBaseTest {


    @Test(groups = "Smoke")
    public void search() {
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        SearchBarModule searchBarModule = new SearchBarModule(driver);
        searchBarModule.hoverOverSignInLink();
        searchBarModule.clickStartHereLink();
        //TODO add Create Account page assert
        String dummyName = "Cecilia";
        String dummyEmail = "Firstname.Lastname@fake.com";
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.enterName(dummyName);
        createAccountPage.enterEmail(dummyEmail);
        createAccountPage.clickConditionsOfUseLink();
        //TODO assert Help Page
        HelpAndCustomerServicePage helpAndCustomerServicePage = new HelpAndCustomerServicePage(driver);
        helpAndCustomerServicePage.enterSearchText("Echo");
        helpAndCustomerServicePage.clickEchoSupportLink();
        List<String> helpOptions = helpAndCustomerServicePage.getOptionsList();
        List<String> expectedHelpOptions = Arrays.asList("Getting Started", "Wi-Fi and Bluetooth", "Device Software and Hardware", "Troubleshooting");
        Assert.assertTrue(helpOptions.containsAll(expectedHelpOptions));

    }
}
