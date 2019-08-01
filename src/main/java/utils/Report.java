package utils;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public abstract class Report {
	public static ExtentTest logger ;
	public String testCaseName, testDesc, category , author, dataSheetName;
	public static ExtentHtmlReporter html ;
	public  static ExtentReports extent;

	//@BeforeSuite
	public void startResult() {
		html = new ExtentHtmlReporter("./reports/result.html");
		html.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(html);
	}
	
	public void reportStep(String status, String desc) {
		if (status.equalsIgnoreCase("pass")) {
			logger.log(Status.PASS, desc);			
		} else if (status.equalsIgnoreCase("fail")) {
			logger.log(Status.FAIL, desc);			
		}
	}
	//@AfterSuite
	public void endResult() {
		extent.flush();
	}
	
	public void startTestModule(String ScenarioName , String ScenarioId) {
		
	}
	//@BeforeMethod
	public void setBeforeData() {
		logger = extent.createTest(testCaseName, testDesc);
		logger.assignAuthor(author);
		logger.assignCategory(category);
		
		
	}

}
