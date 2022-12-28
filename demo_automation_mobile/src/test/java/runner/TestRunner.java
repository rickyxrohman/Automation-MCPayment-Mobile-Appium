package runner;
import io.cucumber.testng.CucumberOptions;
import tests.TestBase;


@CucumberOptions(features="/Users/rickyrohman/Workspace/technical-test-qa-ricky/demo_automation_mobile/src/test/resources/features/BuyProduct.feature"
,glue={"steps"}
,plugin= {"pretty","html:target/cucumber-html-report.html"})
public class TestRunner extends TestBase {
}
