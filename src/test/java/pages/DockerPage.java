package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class DockerPage extends CommonMethods {
    @FindBy(xpath="//input[@id='username']")
    public WebElement login;

    @FindBy(xpath="//input[@type='password']")
    public WebElement password;
    @FindBy(xpath="//button[@type='submit']")
    public WebElement submitButton;
    @FindBy(xpath="//*[@id=\"flash\"]")
    public WebElement welcome;
    public DockerPage(){
        PageFactory.initElements(driver, this);
    }
}
