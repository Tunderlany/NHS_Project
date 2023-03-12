package link.apiTest.nhs.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/api",
        glue = {"link/apiTest/nhs/stepDefinitionsAPI",
                "link/uiTest/nhs/stepDefinitions"},
        tags = "@NA-56",
        plugin = {"pretty", "json:target/report.json"},
        dryRun = false
)
public class RunnerAPI {
}
