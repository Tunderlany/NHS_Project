package link.uiTest.nhs.pages;

import link.uiTest.nhs.utils.BrowserUtils;
import org.junit.Assert;
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

    @FindBy(name = "roomName")
    WebElement roomNameBox;

    @FindBy(xpath = "//input[@value='Add room']")
    WebElement addRoomButton;

    @FindBy(xpath = "//table[@id='rooms-table']//tr/td[1]")
    List<WebElement> allRooms;

    @FindBy(xpath = "//table[@id='rooms-table']//input[@type='checkbox']")
    List<WebElement> allRoomCheckboxes;

    @FindBy(xpath = "//input[@value='Delete rooms']")
    WebElement deleteRoomsButton;

    @FindBy(name = "username")
    WebElement usernameBox;

    @FindBy(name = "password")
    WebElement passwordBox;

    @FindBy(xpath = "//button[.='Add user']")
    WebElement addUserButton;

    @FindBy(linkText = "Logout")
    WebElement logoutButton;






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

    public void addNewRoom(String roomName){
        roomNameBox.sendKeys(roomName);
        addRoomButton.click();
    }

    public void addExistingRoom(String roomName){
        Assert.assertTrue(getAllRooms().contains(roomName));
        roomNameBox.sendKeys(roomName);
        addRoomButton.click();
    }

    public List<String> getAllRooms(){
        List<String> rooms = new ArrayList<>();
        for(WebElement room : allRooms){
            rooms.add(BrowserUtils.getText(room));
        }
        return rooms;
    }

    public boolean validateRoomSortingOrder(){
        List<String> actualOrder = getAllRooms();
        Collections.sort(getAllRooms());
        List<String> expectedOrder = getAllRooms();
        return expectedOrder.equals(actualOrder);
    }

    public int getRoomNameOccurrence(String roomName){
        int roomNameOccurrence = 0;
        for(WebElement room : allRooms){
            if(BrowserUtils.getText(room).equals(roomName)){
                roomNameOccurrence++;
            }
        }
        return roomNameOccurrence;
    }

    public void selectRoom(String roomName){
        for(int i=0; i<allRooms.size(); i++){
            if(BrowserUtils.getText(allRooms.get(i)).equalsIgnoreCase(roomName)){
                allRoomCheckboxes.get(i).click();
            }
        }

    }

    public void clickDeleteRooms(){
        deleteRoomsButton.click();
    }


    public void addUser(String username, String password){
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        addUserButton.click();
    }

    public void logout(){
        logoutButton.click();
    }






}
