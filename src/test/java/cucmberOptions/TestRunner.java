package cucmberOptions;


//use cucumber options annotation

import co.za.ssquared.cruddemo.CruddemoApplicationTests;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "co.za.ssquared.cruddemo.cucumber.module.employee.steps",

        plugin = {"pretty","html:target/cucumber", "json:target/cucumber.json", "junit:target/cukes.xml"}
)
public class TestRunner extends CruddemoApplicationTests {


}
