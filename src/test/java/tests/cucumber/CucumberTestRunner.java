package tests.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/main_page.feature",
        glue = "tests.cucumber"
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}

