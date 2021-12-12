package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {
    @FindBy(xpath = "//*[@id=\"btnAdd\"]")
    WebElement addButton;

    @FindBy(xpath = "//*[@id=\"btnDelete\"]")
    WebElement deleteButton;

    @FindBy(xpath = "//*[@id=\"resetBtn\"]")
    WebElement resetButton;

    @FindBy(xpath = "//*[@id=\"dialogDeleteBtn\"]")
    WebElement okButton;

    WebDriver driver;

    public UsersPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnOkButton() {
        okButton.click();
    }

    public void clickOnAddButton(){
        addButton.click();
    }

    public void clickOnDeleteButton() {
        deleteButton.click();
    }

    public void clickResetButton(){
        resetButton.click();
    }

    public void clickOnUsernameField(String Name){
        driver.findElement(By.xpath("//a[contains(text(), '"+Name+"')]")).click();
    }

    public boolean checkIfNameDisplayed(String Name){
        return !driver
                .findElements(By.xpath("//a[contains(text(), '"+Name+"')]")).isEmpty();
    }

    public boolean checkIfUserRoleDisplayed(String status){
        return !driver
                .findElements(By.xpath("//tr//*[text()='"+status+"']"))
                .isEmpty();
    }

    public boolean checkIfStatusDisplayed(String status){
        return !driver
                .findElements(By.xpath("//tr//*[text()='"+status+"']"))
                .isEmpty();
    }

    public void clickUsernameCheckbox(String User){
        driver.findElement(By.xpath("//tr//td//a[text()='"+User+"']//..//..//td//input")).click();
    }


}
