package wdMethods;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.Parameters;


import utils.ReadExcel;
public class ProjectMethods extends SeMethods{
	
	@BeforeSuite
	public void startTest() {
		startResult();
	}
	
	
	//@Parameters({"url" , "username" , "password"})
	@BeforeMethod
	public void login() {
		setBeforeData();
		startApp("chrome", "http://leaftaps.com/opentaps/");
		
		
	}
	
	
	@AfterMethod
	public void close() {
		closeBrowser();
		
	}
	@AfterSuite
	public void endTest() {
		endResult();
	}
	
	@DataProvider(name = "fecthData")
	public Object[][] getData() throws IOException {
		
		Object[][] sheet = ReadExcel.readexcel(dataSheetName);
		return sheet;
		
		
		
	}
}
