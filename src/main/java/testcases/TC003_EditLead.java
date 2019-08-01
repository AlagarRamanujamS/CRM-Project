package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import wdMethods.ProjectMethods;

public class TC003_EditLead extends ProjectMethods {
	
	@BeforeTest
	public void setData() {
		testCaseName = "TC003_EditLead";
		testDesc = "Edit the Lead";
		category = "Smoke";
		author = "Alagar";
		dataSheetName  = "TC003";
	}
	
	
	@Test(dataProvider = "fecthData")
	public void editLead(String uName, String password, String uFName, String uLName) {
		
		new LoginPage()
		.enterUserName(uName)
		.enterPassword(password)
		.clickLogin()
		.clickCRM()
		.clickLeads()
		.findLead()
		.enterCompanyName()
		.clickFindLead()
		.clickFirstLead()
		.editLead()
		.updateFirstName(uFName)
		.updateLastName(uLName)
		.clickUpdate()
		.verifyUpdatedFirstName(uFName);
	
		
	}

}
