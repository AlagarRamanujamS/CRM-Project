package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import wdMethods.ProjectMethods;

public class TC001_LoginLogout extends ProjectMethods{
	
	@BeforeTest
	public void setData() {
		testCaseName = "TC001_LoginLogout";
		testDesc = "Login info Leaftap";
		category = "Smoke";
		author = "Alagar";
		dataSheetName = "TC001";
	}
	
	
	@Test(dataProvider = "fecthData")
	public void loginLogout(String uName, String password) {
		new LoginPage()
		.enterUserName(uName)
		.enterPassword(password)
		.clickLogin();
		
		
	}
}
