package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class TablePage extends CommonMethods {

    @FindBy(xpath="//a[@href='http://website.multiformis.com/sort-and-tables/']")
    public WebElement SortandTables;

    public TablePage(){
        PageFactory.initElements(driver, this);
    }
}
