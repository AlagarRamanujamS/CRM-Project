package stepImpl;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import wdMethods.SeMethods;

public class Hooks extends SeMethods{
	@Before
	public void beforeScenario(Scenario sc) {
		startResult();
		startTestModule(sc.getName(), sc.getId());
		startApp("chrome", "http://leaftaps.com/opentaps/");
		System.out.println("Test Case name:"+sc.getName());
		System.out.println("Data:"+sc.getId());
		
	}
	@After
	public void afterScenario(Scenario sc) {
		closeBrowser();
		endResult();
		System.out.println("Test case Status:"+sc.getStatus());
		
	}

}
