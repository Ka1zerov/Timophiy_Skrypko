package WhenAndThen;

import org.junit.Assert;
import pageFactory.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class NewUser {
    WebDriver driver;
    LoginPage login;
    HomePage home;
    UsersPage usersPage;
    AddUsersPage addUsersPage;

    @Before
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
    }

    @After
    public void teardown() {
        driver.quit();
    }


    @Given("user is on login page")
    public void userIsOnLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @When("user enters the username and password")
    public void userEntersTheUsernameAndPassword() {
        login = new LoginPage(driver);
        login.enterLogin("Admin");
        login.enterPassword("admin123");

    }

    @And("clicks on login button")
    public void clicksOnLoginButton() {
        login.clickOnLogin();
    }

    @Then("user is navigated to the homepage")
    public void userIsNavigatedToTheHomepage() {
        home = new HomePage(driver);
        home.checkAdminTabIsDisplayed();
    }

    @Given("user is on Users page")
    public void userIsOnUsersPage() {
        home.clickOnAdminUsers();
    }

    @When("user clicks on add")
    public void userClicksOnAdd() {
        usersPage = new UsersPage(driver);
        usersPage.clickOnAddButton();
    }

    @And("enters <Name> <Username> <Password> <Confirmed Password>")
    public void entersNameUsernamePasswordConfirmedPassword(){
        addUsersPage = new AddUsersPage(driver);
        addUsersPage.usersNameTextInput("Cassidy Hope");
        addUsersPage.usersUsernameTextInput("Pureshka");
        addUsersPage.usersPasswordTextInput("password1");
        addUsersPage.usersConfirmedPasswordTextInput("password1");
    }

    @And("clicks save")
    public void clicksSave() throws InterruptedException {
        Thread.sleep(3000);
        addUsersPage.clickOnSaveButton();
    }

    @Then("user sees his new data on Users page")
    public void userSeesHisNewDataOnUsersPage() {
        Assert.assertTrue(usersPage.checkIfNameDisplayed("Cassidy Hope"));
    }

    @When("user clicks on [Username] field")
    public void userClicksOnUsernameField() {
        usersPage.enterUsername("Pureshka");
    }

    @And("click on Search button")
    public void clickOnSearchButton() throws InterruptedException {
        Thread.sleep(3000);
        addUsersPage.clickOnSearchButton();
    }

    @Then("user sees User Role, Employer Name, Status after Search")
    public void userSeesUserRoleEmployerNameStatusAfterSearch() {
        Assert.assertTrue(usersPage.checkIfUserRoleDisplayed("ESS"));
        Assert.assertTrue(usersPage.checkIfNameDisplayed("Cassidy Hope"));
        Assert.assertTrue(usersPage.checkIfStatusDisplayed("Enabled"));
    }

    @When("user clicks Reset button")
    public void userClicksResetButton() {
        usersPage.clickResetButton();
    }

    @Then("user sees User Role, Employer Name. Status")
    public void userSeesUserRoleEmployerNameStatus() {
        Assert.assertTrue(usersPage.checkIfUserRoleDisplayed("ESS"));
        Assert.assertTrue(usersPage.checkIfNameDisplayed("Cassidy Hope"));
        Assert.assertTrue(usersPage.checkIfStatusDisplayed("Enabled"));
    }

    @When("user ticks his <Username>")
    public void userTicksHisUsername() {
        usersPage.clickUsernameCheckbox("Pureshka");
    }

    @And("clicks Delete button")
    public void clicksDeleteButton() {
        usersPage.clickOnDeleteButton();
    }

    @And("clicks ok")
    public void clicksOk() {
        usersPage.clickOnOkButton();
    }

    @Then("user sees his field is deleted on Users page")
    public void userIsObservedHisFieldIsDeletedOnUsersPage() {
    }
}
