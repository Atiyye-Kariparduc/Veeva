package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CalculatorPage {
   public CalculatorPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//img[@onclick='clearForm(document.calform);']")
    public WebElement cleanButton;
    @FindBy(xpath ="//a[.='Metric Units']")
  public WebElement MetricUnitButton;

   @FindBy(xpath = "//input[@name='cage']")
    public WebElement age;

   @FindAll({
    @FindBy(xpath = "(//input[@name='csex'])")
  })
   public  List<WebElement>gender;


   @FindBy(css="#cheightmeter")
    public WebElement height;

   @FindBy(css="#ckg")
    public WebElement weight;


           @FindBy(xpath = "//select")
    public WebElement activityDropDown;

@FindBy(xpath = "//input[@value='Calculate']")
    public WebElement calculateButtom;

@FindBy(xpath ="//h2[@class='h2result']")
    public WebElement resultText;

@FindBy(xpath = "//tbody//tr[2]//td[1]")
    public WebElement WeightTable;
@FindBy(xpath = "//tbody//tr[2]//td[2]")
    public WebElement calorieTable;


}
