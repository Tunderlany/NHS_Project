package link.apiTest.nhs.stepDefinitionsAPI;

import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class HookAPI {

    @Before
    public void setup(){

        RestAssured.baseURI = "http://www.techtorialacademy.link/app";
        RestAssured.basePath = "getdiseases";
    }
}
