package link.uiTest.nhs.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import link.uiTest.nhs.pages.AddPatientPage;
import link.uiTest.nhs.pages.DashboardPage;
import link.uiTest.nhs.utils.DriverHelper;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class DashboardStepDef {

    WebDriver driver = DriverHelper.getDriver();

    DashboardPage dashboardPage = new DashboardPage(driver);
    AddPatientPage addPatientPage = new AddPatientPage(driver);

    @Then("User validates the number of cards is {int}")
    public void user_validates_the_number_of_cards_is(Integer nrOfCards) {
        Assert.assertEquals(nrOfCards, dashboardPage.getNumberOfCards());
    }

    @Then("User validates the text on the cards")
    public void user_validates_the_text_on_the_cards(DataTable cardText) {
        Assert.assertEquals(cardText.asList(),dashboardPage.getTextFromCards());
    }

    @Then("User validates the color of the cards")
    public void user_validates_the_color_of_the_cards(DataTable cardColor) {
        Assert.assertEquals(cardColor.asList(),dashboardPage.getColorOfCards());
    }

    @Then("User validates the numbers on the cards")
    public void user_validates_the_numbers_on_the_cards() {
        dashboardPage.validateNumbers();
    }






    @Then("User validates the number of tables is {int}")
    public void user_validates_the_number_of_tables_is(Integer nrOfTables) {
        Assert.assertEquals(nrOfTables,dashboardPage.getNumberOfTables());
    }

    @Then("User validates the table headers")
    public void user_validates_the_table_headers(io.cucumber.datatable.DataTable tableHeader) {
        Assert.assertEquals(tableHeader.asList(),dashboardPage.getTextOfHeader());
    }






    @Given("User clicks add patient link")
    public void user_clicks_add_patient_link() {
        dashboardPage.clickAddPatient();
    }

    @When("User fills out patient information {string}, {string}, {string}, {string}, {string}")
    public void user_fills_out_patient_information(String firstName, String lastName,
                                                   String hospitalNumber, String dateOfBirth, String sex) throws InterruptedException {
        addPatientPage.fillPatientInfo(firstName,lastName,hospitalNumber,dateOfBirth,sex);
    }

    @When("User selects patient disease")
    public void user_selects_patient_disease(io.cucumber.datatable.DataTable diseases) throws InterruptedException {
        addPatientPage.selectDisease(diseases.asList());
    }
    @When("User clicks add patient button")
    public void user_clicks_add_patient_button() {
        addPatientPage.clickAddPatientButton();
    }
    @Then("User validates patient {string} has successfully been added to waiting list")
    public void user_validates_patient_has_successfully_been_added_to_waiting_list(String patient) throws InterruptedException {
        Assert.assertTrue(dashboardPage.getAllWaitingPatients().contains(patient));
    }
}
