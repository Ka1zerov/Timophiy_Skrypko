package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath = "//*[@id=\"txtUsername\"]")
    WebElement login;

    @FindBy(xpath = "//*[@id=\"txtPassword\"]")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"btnLogin\"]")
    WebElement logInButton;

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterLogin(String admin){
        this.login.sendKeys(admin);
    }
    public void enterPassword(String password1){
        this.password.sendKeys(password1);
    }
    public void clickOnLogin(){
        this.logInButton.click();
    }
}
