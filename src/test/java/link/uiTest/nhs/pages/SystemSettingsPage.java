package link.uiTest.nhs.pages;

import link.uiTest.nhs.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SystemSettingsPage {

    public SystemSettingsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "diseaseName")
    WebElement diseaseNameBox;

    @FindBy(name = "diseaseScore")
    WebElement diseaseScoreBox;

    @FindBy(xpath = "//input[@value='Add disease']")
    WebElement addDiseaseButton;

    @FindBy(xpath = "//table[@id='diseases-table']//tr/td[1]")
    List<WebElement> allDiseases;

    @FindBy(xpath = "//table[@id='diseases-table']//input[@type='checkbox']")
    List<WebElement> allDiseaseCheckboxes;

    @FindBy(xpath = "//input[@value='Delete diseases']")
    WebElement deleteDiseasesButton;


    public void fillDiseaseInfo(String diseaseName, String diseaseScore){
        diseaseNameBox.sendKeys(diseaseName);
        diseaseScoreBox.sendKeys(diseaseScore);
    }

    public void clickAddDisease(){
        addDiseaseButton.click();
    }

    public List<String> getAllDiseases(){
        List<String> diseases = new ArrayList<>();
        for(WebElement disease : allDiseases){
            diseases.add(BrowserUtils.getText(disease));
        }
        return diseases;
    }

    public boolean validateDiseaseSortingOrder(){
        List<String> actualOrder = getAllDiseases();
        Collections.sort(getAllDiseases());
        List<String> expectedOrder = getAllDiseases();
        return expectedOrder.equals(actualOrder);
    }

    public void selectDisease(String diseaseName){
        for(int i=0; i<allDiseases.size(); i++){
            if(BrowserUtils.getText(allDiseases.get(i)).equalsIgnoreCase(diseaseName)){
                allDiseaseCheckboxes.get(i).click();
            }
        }
    }

    public void clickDeleteDiseases(){
        deleteDiseasesButton.click();
    }




}
