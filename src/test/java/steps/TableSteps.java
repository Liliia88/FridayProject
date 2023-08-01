package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.CommonMethods;

import java.util.List;

public class TableSteps extends CommonMethods {

    @When("From main menu click on {string}")
    public void from_main_menu_click_on(String string) {
    WebElement sort= driver.findElement(By.xpath("//a[text()='Sort and Tables']"));
     click(table.SortandTables);
    }

    @When("Check if table contains more than {int} records")
    public void check_if_table_contains_more_than_records(Integer int1) {
        List<WebElement> tab = driver.findElements(By.xpath("//table[@id='tablepress-2']/tbody/tr/td"));
        System.out.println("tab = " + tab.size());
        if( tab.size()>25){
            System.out.println("tab = " + tab.size()+", it is more than 25");
        } else {
            System.out.println("it is less than 25");
        }
            }

    @When("Sort the data by Age descending")
    public void sort_the_data_by_age_descending() {
        Actions action = new Actions(driver);
     WebElement dk = driver.findElement(By.xpath("//th[@class='column-8 sorting']"));
     action.doubleClick(dk).perform();
    }
    @Then("Check if the 1st person in the table is older than {int}")
    public void check_if_the_1st_person_in_the_table_is_older_than(Integer int1) {
        List<WebElement> tab = driver.findElements(By.xpath("//table[@id='tablepress-2']/tbody/tr[1]/td[8]"));
        for (int i = 0; i < tab.size(); i++) {
            String ageOf1stperson = tab.get(i).getText();
            int age = Integer.parseInt(ageOf1stperson);
            if (age>65){
                System.out.println("age is greater than 65");
            } else {
                System.out.println("age is less than 65");
            }
            }
        }
    }
