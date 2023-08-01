package steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import utils.CommonMethods;
import utils.Constants;
import java.util.concurrent.TimeUnit;
public class DockerPractice extends CommonMethods {
    @When("enter login and password")
    public void enter_login_and_password() {
        driver.get("http://localhost:7080/login");
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        docker.login.sendKeys("tomsmith");
        docker.password.sendKeys("SuperSecretPassword!");
        docker.submitButton.click();
    }
    @Given("you are logined successfully")
    public void you_are_logined_successfully() {
        String actualText = docker.welcome.getText();
        String expectedText = "You logged into a secure area!";
        Assert.assertTrue("Element text contains the expectedText", actualText.contains(expectedText));
    }
    @Given("enter not correct login and password")
    public void enter_not_correct_login_and_password() {
        driver.get("http://localhost:7080/login");
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        docker.login.sendKeys("tomsmith2");
        docker.password.sendKeys("SuperSecretPassword!2");
        docker.submitButton.click();
    }
    @Given("you are logined not correct")
    public void you_are_logined_not_correct() {
        String actualText = docker.welcome.getText();
        String notExpectedText = "Your username is invalid!";
        Assert.assertTrue("Element text should not equal the notExpectedText", actualText.contains(notExpectedText));
    }
}

