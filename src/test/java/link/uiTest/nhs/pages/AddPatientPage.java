package link.uiTest.nhs.pages;

import link.uiTest.nhs.utils.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddPatientPage {

    public AddPatientPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#first-name")
    WebElement firstNameBox;

    @FindBy(name = "lastName")
    WebElement lastNameBox;

    @FindBy(name = "hospitalNumber")
    WebElement hospitalNoBox;

    @FindBy(name = "dateOfBirth")
    WebElement birthDateBox;

    @FindBy(css = ".btn-primary")
    List<WebElement> sexButtons;

    @FindBy(xpath = "//input[@type='checkbox']")
    List<WebElement> diseaseCheckboxes;

    @FindBy(xpath = "//tr/td[1]")
    List<WebElement> allDiseases;

    @FindBy(css = ".btn-success")
    WebElement addPatientButton;

    public void fillPatientInfo(String firstName, String lastName, String hospitalNo, String dateOfBirth, String sex) throws InterruptedException {
        this.firstNameBox.sendKeys(firstName);
        this.lastNameBox.sendKeys(lastName);
        this.hospitalNoBox.sendKeys(hospitalNo);
        this.birthDateBox.sendKeys(dateOfBirth);

        for(WebElement sexButton : sexButtons){
            if(BrowserUtils.getText(sexButton).equalsIgnoreCase(sex)){
                sexButton.click();
            }
        }
        Thread.sleep(1000);
    }

    public void selectDisease(List<String> diseases) throws InterruptedException {
        for(int i=0; i<allDiseases.size(); i++){
            for(int j=0; j<diseases.size(); j++){
                if(BrowserUtils.getText(allDiseases.get(i)).equalsIgnoreCase(diseases.get(j))){
                    diseaseCheckboxes.get(i).click();
                    Assert.assertTrue(diseaseCheckboxes.get(i).isSelected());
                }
            }
        }
        Thread.sleep(1000);
    }

    public void clickAddPatientButton() throws InterruptedException {
        addPatientButton.click();
        Thread.sleep(500);
    }
}
