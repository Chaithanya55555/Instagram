import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/feature/AddComment.feature"},
                plugin = {"pretty"})
public class testRunner extends AbstractTestNGCucumberTests {

}
