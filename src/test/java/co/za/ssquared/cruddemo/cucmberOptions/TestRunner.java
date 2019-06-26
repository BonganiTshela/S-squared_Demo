package co.za.ssquared.cruddemo.cucmberOptions;


//use cucumber options annotation

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepDefinations",

        plugin = {"pretty","html:target/cucumber", "json:target/cucumber.json", "junit:target/cukes.xml"}
)
public class TestRunner {


}
