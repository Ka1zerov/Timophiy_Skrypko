package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//*[@id=\"menu_admin_viewAdminModule\"]")
    WebElement adminTab;

    @FindBy(xpath = "//*[@id=\"menu_admin_UserManagement\"]")
    WebElement userManagementTab;

    @FindBy(xpath = "//*[@id=\"menu_admin_viewSystemUsers\"]")
    WebElement users;

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkAdminTabIsDisplayed(){
        this.adminTab.isDisplayed();
    }

    public void clickOnAdminUsers(){
        this.adminTab.click();
        this.userManagementTab.click();
        this.users.click();
    }



}
