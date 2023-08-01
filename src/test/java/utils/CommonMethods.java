package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import steps.PageInitializer;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class CommonMethods extends PageInitializer {

    public static WebDriver driver;
    public static SoftAssert softAssertion = new SoftAssert();
    public static void openBrowserAndLaunchApplication() {
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigReader.getPropertyValue("browser")) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name");
        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        initializePageObjects();

    }
    public static void closeBrowser() {
        driver.quit();
    }
    public static void sendText(WebElement element, String textToSend) {
        element.clear();
        element.sendKeys(textToSend);
    }
    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        return wait;
    }
    public static void waitForClickability(WebElement element) {

        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void click(WebElement element) {
        waitForClickability(element);
        element.click();
    }
    public static JavascriptExecutor getJSExecutor() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    public static void jsClick(WebElement element) {
        getJSExecutor().executeScript("arguments[0].click();", element);
    }
    public static void  jsScrolldown (String x){
        getJSExecutor().executeScript(x);
    }

    public static void selectDropdown(WebElement element, String text) {
        Select s = new Select(element);
        s.selectByVisibleText(text);
    }

    public static byte[] takeScreenshot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile,
                    new File(Constants.SCREENSHOT_FILEPATH + fileName + " " +
                            getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return picBytes;
    }

    public static String getTimeStamp(String pattern) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static void assertMethod(WebElement element) {
        softAssertion.assertTrue(element.isDisplayed());
        softAssertion.assertAll();
    }

    public static void calendar(WebElement table, WebElement tableClick, WebElement dropdownMonth, String month,
                                WebElement dropdownYear, String year, List<WebElement> tableFrom, String value) {
        assertMethod(table);
        click(tableClick);
        selectDropdown(dropdownMonth, month);
        selectDropdown(dropdownYear, year);
        boolean isFound = false;
        while (!isFound) {
            for (WebElement date : tableFrom) {
                String currentDate = date.getText();
                if (currentDate.equalsIgnoreCase(value)) {
                    date.click();
                    isFound = true;
                    break;
                }
            }
        }
    }
    }

