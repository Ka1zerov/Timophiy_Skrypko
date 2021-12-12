package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddUsersPage {

    @FindBy(xpath = "//*[@id=\"systemUser_employeeName_empName\"]")
    WebElement nameText;

    @FindBy(xpath = "//*[@id=\"systemUser_userName\"]")
    WebElement usernameText;

    @FindBy(xpath = "//*[@id=\"systemUser_password\"]")
    WebElement passwordText;

    @FindBy(xpath = "//*[@id=\"systemUser_confirmPassword\"]")
    WebElement confirmedPasswordText;

    @FindBy(xpath = "//*[@id=\"btnSave\"]")
    WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"btnSearch\"]")
    WebElement searchButton;

    WebDriver driver;

    public AddUsersPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void usersUsernameTextInput(String UsernameText){
        this.usernameText.sendKeys(UsernameText);
    }
    public void usersNameTextInput(String NameText){
        this.nameText.sendKeys(NameText);
    }

    public void usersPasswordTextInput(String PasswordText){
        this.passwordText.sendKeys(PasswordText);
    }

    public void usersConfirmedPasswordTextInput(String PasswordText){
        this.confirmedPasswordText.sendKeys(PasswordText);
    }

    public void clickOnSaveButton(){
        this.saveButton.click();
    }
    public void clickOnSearchButton(){
        this.searchButton.click();
    }

}
