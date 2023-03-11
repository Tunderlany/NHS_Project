package link.uiTest.nhs.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import link.uiTest.nhs.utils.BrowserUtils;
import link.uiTest.nhs.utils.DriverHelper;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Hook {

    public WebDriver driver;

    @Before
    public void setup(){

        driver = DriverHelper.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown(Scenario scenario){
        BrowserUtils.getScreenShotCucumber(scenario,driver);
        driver.quit();
    }


}
