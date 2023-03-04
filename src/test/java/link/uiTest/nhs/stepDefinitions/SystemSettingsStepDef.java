package link.uiTest.nhs.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import link.uiTest.nhs.pages.DashboardPage;
import link.uiTest.nhs.pages.SystemSettingsPage;
import link.uiTest.nhs.utils.DriverHelper;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class SystemSettingsStepDef {

    WebDriver driver = DriverHelper.getDriver();

    DashboardPage dashboardPage = new DashboardPage(driver);
    SystemSettingsPage systemSettingsPage = new SystemSettingsPage(driver);

    @Given("User clicks system settings link")
    public void user_clicks_system_settings_link() {
        dashboardPage.clickSystemSettings();
    }
    @When("User fills out disease information {string} and {string}")
    public void user_fills_out_disease_information_and(String diseaseName, String diseaseScore) {
        systemSettingsPage.fillDiseaseInfo(diseaseName,diseaseScore);
    }
    @When("User clicks add disease button")
    public void user_clicks_add_disease_button() {
        systemSettingsPage.clickAddDisease();
    }
    @Then("User validates disease {string} has successfully been added")
    public void user_validates_disease_has_successfully_been_added(String diseaseName) {
        Assert.assertTrue(systemSettingsPage.getAllDiseases().contains(diseaseName));
    }
    @Then("User validates diseases are sorted by disease name")
    public void user_validates_diseases_are_sorted_by_disease_name() {
        Assert.assertTrue(systemSettingsPage.validateDiseaseSortingOrder());
    }





    @When("User selects disease {string}")
    public void user_selects_disease(String diseaseName) {
        systemSettingsPage.selectDisease(diseaseName);
    }
    @When("User clicks delete diseases button")
    public void user_clicks_delete_diseases_button() {
        systemSettingsPage.clickDeleteDiseases();
    }
    @Then("User validates disease {string} has successfully been deleted")
    public void user_validates_disease_has_successfully_been_deleted(String diseaseName) {
        Assert.assertFalse(systemSettingsPage.getAllDiseases().contains(diseaseName));
    }




    @When("User adds new room {string}")
    public void user_adds_new_room(String roomName) {
        systemSettingsPage.addNewRoom(roomName);
    }
    @Then("User validates room {string} has successfully been added")
    public void user_validates_room_has_successfully_been_added(String roomName) {
        Assert.assertTrue(systemSettingsPage.getAllRooms().contains(roomName));
    }
    @Then("User validates rooms are sorted by room name")
    public void user_validates_rooms_are_sorted_by_room_name() {
        Assert.assertTrue(systemSettingsPage.validateRoomSortingOrder());
    }




    @When("User adds  existing room {string}")
    public void user_adds_existing_room(String roomName) {
        systemSettingsPage.addExistingRoom(roomName);
    }
    @Then("User validates room {string} has NOT been added again")
    public void user_validates_room_has_not_been_added_again(String roomName) {
        Assert.assertEquals(1,systemSettingsPage.getRoomNameOccurrence(roomName));
    }




    @When("User selects room {string}")
    public void user_selects_room(String roomName) {
        systemSettingsPage.selectRoom(roomName);
    }
    @When("User clicks delete room button")
    public void user_clicks_delete_room_button() {
        systemSettingsPage.clickDeleteRooms();
    }
    @Then("User validates room {string} has successfully been deleted")
    public void user_validates_room_has_successfully_been_deleted(String roomName) {
        Assert.assertFalse(systemSettingsPage.getAllRooms().contains(roomName));
    }


}
