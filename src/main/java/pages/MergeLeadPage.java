package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import wdMethods.ProjectMethods;

public class MergeLeadPage extends ProjectMethods{

	public MergeLeadPage() {
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(how = How.XPATH,using = "(//img[@alt='Lookup'])[1]")
	WebElement eleFirstLeadM;
	@FindBy(how = How.XPATH,using = "(//img[@alt='Lookup'])[2]")
	WebElement eleSecondLeadM;
	@FindBy(how = How.CLASS_NAME,using = "buttonDangerous")
	WebElement eleClickMergeLead;
	
	public FindLeadsPage clickFirstLead() {
		click(eleFirstLeadM);
		switchToWindow(1);
		return new FindLeadsPage();
	}
	
	public FindLeadsPage clickSecondLead() {
		click(eleSecondLeadM);
		switchToWindow(1);
		return new FindLeadsPage();
	}
	
	public ViewLeadPage clickMergeLead() {
		clickWithoutSnap(eleClickMergeLead);
		acceptAlert();
		return new ViewLeadPage();
	}

}
