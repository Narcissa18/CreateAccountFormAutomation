package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoginPage {

    @FindBy(id = "first-name")
    WebElement firstName;
    @FindBy(id = "last-name")
    WebElement lastName;
    @FindBy(xpath = ("//*[ contains (text(),'Female')]"))
    WebElement gender;
    @FindBy(id = "dob")
    WebElement dob;
    @FindBy(id = "address")
    WebElement address;
    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "company")
    WebElement company;
    @FindBy(id = "role")
    WebElement role;
    @FindBy(id = "expectation")
    WebElement expectations;
    @FindBys(@FindBy(xpath = ("//input[@type='checkbox']")))
    List<WebElement> options;
    @FindBy(id = "comment")
    WebElement comment;
    @FindBy(id = "submit-msg")
    WebElement submitMsg;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void setUserName(String firstName, String lastName) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);

    }


    public void selectGender() {
        this.gender.click();
    }

    public void setUserInfo(String dob, String address, String email, String password, String company) {
        this.dob.sendKeys(dob);
        this.address.sendKeys(address);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.company.sendKeys(company);
    }

    public void selectRole(String role) {
        Select roles = new Select(this.role);
        roles.selectByVisibleText(role);
    }

    public void selectExpectations(ArrayList<String> expectation) {

        Select checklist = new Select(expectations);

        for (String expectation1 : expectation) {
            checklist.selectByVisibleText(expectation1);
        }

    }

    public void setOptions() {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(options.size());
            options.get(index).click();
        }

    }

    public void fillComment(String comment) {
        this.comment.sendKeys(comment);
    }

    public void submit() {
        this.comment.submit();
    }

    public void successMsg() {
        Assert.assertEquals(this.submitMsg.getText(), "Successfully submitted!");
    }

}

