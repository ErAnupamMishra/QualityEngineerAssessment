/**Test Runner file for Amazon E2E shopping
#Author: anupam.mishra13@gmail.com
#Version : 1.0 
#Status :Published
#Summary : Automation Framework in Selenium using Cucumber as BDD Tool for Amazon Shopping E2E Scenario 
*/
package testRunner;

/**Importing Junit Runner and Cucumber API */
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

//Running test classes
@RunWith(Cucumber.class)
// Options to provide a link between the feature files and step definition files
@Cucumber.Options(features="features"
,glue={"stepDefs"})
public class TestRunner {
	// class Test Runner
}
