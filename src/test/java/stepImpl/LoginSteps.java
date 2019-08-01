package stepImpl;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	ChromeDriver driver;
	
	@Given("Launch for Browser")
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@And("Enter the URL")
	public void enterURL() {
		driver.get("http://leaftaps.com/opentaps/control/main");
	}
	@And("Enter the username as (.*)")
	public void enterUName(String Uname) {
		driver.findElementById("username").sendKeys(Uname);
		
	}
	@And("Enter the password as (.*)")
	public void password(String password) {
		driver.findElementById("password").sendKeys(password);
	}
	@When("Click on the login button")
	public void clickLogin() {
		driver.findElementByClassName("decorativeSubmit").click();
	}
	
	@Then("Verify login is Success")
	public void verifyLogin() {
		System.out.println("Login Success");
	}
	
	@And("click CRMSFA link")
	public void clickCRMSFA() {
		driver.findElementByLinkText("CRM/SFA").click();
	}
	@And("click Leads link")
	public void clickLeads() {
		driver.findElementByXPath("//a[@href='/crmsfa/control/leadsMain']").click();
	}
	@And("click Create Lead link")
	public void clickcreateLead() {
		driver.findElementByLinkText("Create Lead").click();
	}
	@And("Enter Company Name as (.*)")
	public void enterCompanyName(String CompanyName) {
		driver.findElementByClassName("inputBox").sendKeys(CompanyName);
	}
	@And("Enter First Name as (.*)")
	public void enterFirstName(String FirstName) {
		driver.findElementById("createLeadForm_firstName").sendKeys(FirstName);
	}
	@And("Enter Last Name as (.*)")
	public void enterLastName(String LastName) {
		driver.findElementById("createLeadForm_lastName").sendKeys(LastName);
	}
	@When("Click Create lead")
	public void clickCreateLead() {
		driver.findElementByClassName("smallSubmit").click();
	}
	@Then("Create Lead Success")
	public void verifyCreateLead() {
		System.out.println("Lead Created");
	}

	

}
