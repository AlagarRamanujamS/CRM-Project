package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import wdMethods.ProjectMethods;

public class TC004_MergeLead extends ProjectMethods {
	
	@BeforeTest
	public void setData() {
		testCaseName = "TC004_MergeLead";
		testDesc = "Merge the Lead";
		category = "Smoke";
		author = "Alagar";
		dataSheetName  = "TC004";
	}
	
	@Test(dataProvider = "fecthData")
	public void mergeLead(String uName, String password) {
		new LoginPage()
		.enterUserName(uName)
		.enterPassword(password)
		.clickLogin()
		.clickCRM()
		.clickLeads()
		.mergeLead()
		.clickFirstLead()
		.enterFirstNameM()
		.clickFindLeadM()
		.selectFirstLead()
		.clickSecondLead()
		.enterCompanyNameM()
		.clickFindLeadM1()
		.selectSecondLead()
		.clickMergeLead();
				
	}

}
