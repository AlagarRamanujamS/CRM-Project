package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import wdMethods.ProjectMethods;

public class TC002_CreateLead extends ProjectMethods{
	
	@BeforeTest
	public void setData() {
		testCaseName = "TC002_CreateLead";
		testDesc = "Create New Lead";
		category = "Smoke";
		author = "Alagar";
		dataSheetName  = "TC002";
	}
	
	
	
	
	@Test(dataProvider = "fecthData")
	public void createLead(String uName,String password,String cName,String fName , String lName) {
		
		new LoginPage()
		.enterUserName(uName)
		.enterPassword(password)
		.clickLogin()
		.clickCRM()
		.clickLeads()
		.createLead()
		.enterCompanyName(cName)
		.enterFirstName(fName)
		.enterLastName(lName)
		.createLeat();
		
		
	}

}
