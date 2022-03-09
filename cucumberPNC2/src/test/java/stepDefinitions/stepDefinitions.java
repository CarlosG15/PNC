package stepDefinitions;

import io.cucumber.junit.Cucumber;
import objDriver.objDriver;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
public class stepDefinitions{
    WebDriver driver;
    objDriver oDriver;
    @io.cucumber.java.en.Given("^Open Browser$")
    public void openBrowser() {
        oDriver = new objDriver(driver);
        oDriver.openBrowser();
    }

    @io.cucumber.java.en.When("^Enter url and click on Login button$")
    public void enterUrlAndClickOnLoginButton() {
        oDriver.pagePNC();
        oDriver.Click("(//button[span[text()='SIGN ON']])[2]");
    }

    @io.cucumber.java.en.Then("^Enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void enterAnd(String username, String password) throws Throwable {
        oDriver.credentials("(//input[@name='userId'])[2]").sendKeys(username);
        oDriver.credentials("(//input[@name='password'])[2]").sendKeys(password);
    }

    @io.cucumber.java.en.And("^Click on Login button$")
    public void clickOnLoginButton() {
        oDriver.Click("(//input[@value='Login'])[2]");
    }

    @io.cucumber.java.en.Then("^Go to Virtual Wallet$")
    public void goToVirtualWallet() {
        oDriver.vWallet();
        oDriver.Click("//a[contains(text(),'Virtual')]");
    }

    @io.cucumber.java.en.And("^CLose Session$")
    public void closeSession() {
        oDriver.close();
    }
}
