package link.apiTest.nhs.stepDefinitionsAPI;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import link.uiTest.nhs.pages.SystemSettingsPage;
import link.uiTest.nhs.utils.DriverHelper;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SystemSettingsStepDefAPI {

    Response response;

    WebDriver driver = DriverHelper.getDriver();
    SystemSettingsPage systemSettingsPage = new SystemSettingsPage(driver);

    @Given("User has valid url")
    public void user_has_valid_url() {
        Assert.assertNotNull(RestAssured.baseURI);
        Assert.assertNotNull(RestAssured.basePath);
    }
    @When("User sends a request to get all diseases")
    public void user_sends_a_request_to_get_all_diseases() {
        response = RestAssured.given().accept(ContentType.JSON)
                .cookie("connect.sid=s%3AtFzDO5LMkH4nBlmXlo2HEhWbN-oWzagT.qbtzTVOULa6el9EgNCzgrGYHj0xVHjX4RBPygkkTrn4; _ga=GA1.2.1302257321.1678560762; _gid=GA1.2.700352361.1678560762; _gat=1")
                .when()
                .get();
    }
    @Then("User validates status code is {int}")
    public void user_validates_status_code_is(Integer expectedStatusCode) {
        Integer actualStatusCode = response.statusCode();
        Assert.assertEquals(expectedStatusCode,actualStatusCode);
    }

    @Then("User validates list of diseases")
    public void user_validates_list_of_diseases() {
        Map<String,Integer> parsedResponse = response.as(new TypeRef<Map<String, Integer>>() {
        });
        List<String> expectedDiseases = systemSettingsPage.getAllDiseases();
        List<String> actualDiseases = new ArrayList<>(parsedResponse.keySet());
        Assert.assertEquals(expectedDiseases,actualDiseases);
    }
}
