package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features="src/test/java/Features/LeafTap.feature",glue="Steps",monochrome=true,publish=true)
public class LeafTapRunner extends AbstractTestNGCucumberTests{

}
