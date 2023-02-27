package stepdefinitions;

import Pages.CalculatorPage;
import Pojo.CalculatorPojo;
import calculatorLogic.CalculateLogic;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

import java.util.Arrays;

public class HappyPath {
    CalculatorPojo pojo =new CalculatorPojo();
    CalculatorPage page=new CalculatorPage();

    @When("user click {string} buttom")
    public void user_click_buttom(String MetricUnit) {
        page.cleanButton.click();
page.MetricUnitButton.click();

    }
    @Given("the user enters their age as {string}")
    public void the_user_enters_their_age_as(String age) {
        page.age.click();
        page.age.sendKeys(age);
        Driver.waitForClickablility(page.age,15);
        pojo.setAge(Integer.parseInt(age));
        System.out.println(pojo.getAge());

      //  Actions actions=new Actions(Driver.getDriver());
   //     actions.sendKeys(age);
            }


    @Given("the user selects their gender as {string}")
    public void the_user_selects_their_gender_as(String desiredGender) {
        pojo.setGender(desiredGender);
        for (WebElement genderRadioButton : page.gender) {

            String gender = genderRadioButton.getAttribute("value");
            System.out.println(gender);
            if (gender.equalsIgnoreCase(desiredGender.substring(0,1))) {
                if (!genderRadioButton.isSelected()) {
                    genderRadioButton.click();
                    break;
                }
            }

        }
    }
    @Given("the user enters their height as {string}")
    public void the_user_enters_their_height_as(String height) {
        pojo.setHeight(Integer.parseInt(height));
       page.height.sendKeys(height);
    }
    @Given("the user enters their weight as {string}")
    public void the_user_enters_their_weight_as(String weight) {
        pojo.setWeight(Integer.parseInt(weight));
        page.weight.sendKeys(weight);
    }
    @Given("the user selects their activity level as {string}")
    public void the_user_selects_their_activity_level_as(String activity) {
       Select dropDown=new Select(page.activityDropDown);
     dropDown.selectByIndex(Integer.parseInt(activity));
     pojo.setActivityLevel(dropDown.getFirstSelectedOption().getText());


    }
    @When("the user submits the form")
    public void the_user_submits_the_form() throws InterruptedException {
       page.calculateButtom.click();
   Thread.sleep(3000);


    }
    @Then("verify the calculated carbohydrate intake should be {string} calories per day")
    public void verify_the_calculated_carbohydrate_intake_should_be_grams_per_day(String expectedCarbs) {
        Assert.assertEquals("Result", page.resultText.getText());
       // System.out.println(pojo.getHeight());
       // System.out.println(pojo.getGender());

       //Here i assert expected data from calculatePage class, actual data from webSite
        //I could automate the expected Carbs in Scenario Outline, but I wanted to show a different method.
       // Assert.assertEquals(expectedCarbs,page.calorieTable.getText());
        Assert.assertEquals( CalculateLogic.calculateWeightMaintenanceCalories(pojo),page.calorieTable.getText());



    }


}
