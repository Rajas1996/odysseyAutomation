import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) // Tells JUnit to use Cucumber
@CucumberOptions(
  features = {"resource/features",
		/*
		 * "C:/Users/Taurus11/Desktop/gitOdyssey/CucumberHybrid/resource/features/Quote.feature"
		 */
  },
  glue = "StepDefinitions", // Package with step definitions
  tags = "@smoke", // Run scenarios with this tag (optional)
  plugin = {
    "pretty", // Console output formatting
    "html:target/cucumber-report.html", // HTML report
    "json:target/cucumber.json" // JSON report for CI tools
  },
  monochrome = true // Clean console output
)



public class TestRunner {

}
