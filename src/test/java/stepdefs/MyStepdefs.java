package stepdefs;

import Pages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;


public class MyStepdefs {

    WebDriver driver;
    LoginPage loginPage;

    @Before
    public void initializeWebDriver() {
        System.setProperty("webdriver.chrome.driver", "C://Selenium//chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }


    @Given("^user opens url$")
    public void userOpensUrl() {
        driver.navigate().to("http://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");

    }

    @When("^user fills \"([^\"]*)\" and  \"([^\"]*)\"$")
    public void userFillsAnd(String firstname, String lastname) {
        loginPage.setUserName(firstname, lastname);

    }

    @And("^user selects gender$")
    public void userSelectsGender() {
        loginPage.selectGender();

    }

    @And("^user fills \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and  \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userFillsAndAndAndAnd(String dob, String address, String email, String password, String company) {
        loginPage.setUserInfo(dob, address, email, password, company);

    }

    @And("^selects role$")
    public void selectsRole() {
        loginPage.selectRole("QA");

    }

    @And("^selects job expectations$")
    public void selectsJobExpectations() {
        ArrayList<String> expectations = new ArrayList<String>();
        expectations.add("Good teamwork");
        expectations.add("High salary");
        expectations.add("Challenging");
        loginPage.selectExpectations(expectations);

    }

    @And("^selects ways of development$")
    public void selectsWaysOfDevelopment() {
        loginPage.setOptions();

    }

    @And("^fills \"([^\"]*)\"$")
    public void fills(String comment) {
        loginPage.fillComment(comment);

    }

    @And("^clicks Submit$")
    public void clicksSubmit() {
        loginPage.submit();

    }


    @And("^success message is shown$")
    public void successMessageIsShown() {
        loginPage.successMsg();
    }

    @After
    public void closingWebDriver() {
        driver.quit();
    }


}
