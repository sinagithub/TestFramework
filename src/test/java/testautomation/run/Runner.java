package testautomation.run;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Before;
import org.junit.runner.RunWith;
import testautomation.utils.WebDriverUtils;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"testautomation.stepdefinitions", "testautomation.utils"},
        plugin = {"json:target/cucumber-reports/cucumber.json"},
        tags = "@wip")


public class Runner {

}
