package pages;





import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import wdMethods.ProjectMethods;

public class FindLeadsPage extends ProjectMethods{
	
	
	
	
	public FindLeadsPage() {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(how = How.XPATH, using = "(//input[@name='companyName'])[2]")
	WebElement eleCompanyName;
	@FindBy(how = How.XPATH, using = "(//button[@class='x-btn-text'])[7]")
	WebElement eleClickFindLead;
	@FindBy(how = How.XPATH,using = "(//a[@href='/crmsfa/control/viewLead?partyId=11231'])[5]")
	WebElement eleClickFirstResult;
	@FindBy(how = How.XPATH,using = "//input[@name='firstName']")
	WebElement eleFirstName;
	@FindBy(how = How.XPATH,using = "(//button[@type='button'])[1]")
	WebElement eleFindLeadM;
	@FindBy(how = How.XPATH,using = "(//a[@class='linktext'])[1]")
	WebElement eleSelectFirstName;
	@FindBy(how = How.XPATH, using = "(//input[@name='companyName'])[2]")
	WebElement eleCompanyNameM;
	@FindBy(how = How.XPATH,using = "(//button[@type='button'])[1]")
	WebElement eleFindLeadM1;
	@FindBy(how = How.XPATH,using = "(//a[@class='linktext'])[6]")
	WebElement eleSecondLead;
	
	//EditLead
	public FindLeadsPage enterCompanyName() {
		type(eleCompanyName, "Renault");
		return this;
	}
	public FindLeadsPage clickFindLead() {
		click(eleClickFindLead);
		return this;
	}
	public ViewLeadPage clickFirstLead() {
		click(eleClickFirstResult);
		return new ViewLeadPage();
	}
	
	//MergeLead
	public FindLeadsPage enterFirstNameM() {
		type(eleFirstName, "Alagar");
		return this;
	}
	public FindLeadsPage clickFindLeadM() {
		click(eleFindLeadM);
		return this;
	}
	public MergeLeadPage selectFirstLead() {
		clickWithoutSnap(eleSelectFirstName);
		switchToWindow(0);
		return new MergeLeadPage();
	}
	public FindLeadsPage enterCompanyNameM() {
		type(eleCompanyNameM, "Renault");
		return this;
	}
	public FindLeadsPage clickFindLeadM1() {
		click(eleFindLeadM1);
		return this;
	}
	
	public MergeLeadPage selectSecondLead() {
		clickWithoutSnap(eleSecondLead);
		switchToWindow(0);
		return new MergeLeadPage();
	}
}
