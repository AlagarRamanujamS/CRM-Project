package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import wdMethods.ProjectMethods;

public class MyLeadsPage extends ProjectMethods {
	
	public MyLeadsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.LINK_TEXT, using = "Create Lead") 
	WebElement elecreateLead;
	@FindBy(how = How.LINK_TEXT , using = "Find Leads")
	WebElement eleFindLead;
	@FindBy(how = How.LINK_TEXT,using = "Merge Leads")
	WebElement eleMergeLead;
	
	public CreateLeadPage createLead() {
		click(elecreateLead);
		return new CreateLeadPage();
	}
	
	public FindLeadsPage findLead() {
		click(eleFindLead);
		return new FindLeadsPage();
	}
	public MergeLeadPage mergeLead() {
		click(eleMergeLead);
		return new MergeLeadPage();
	}
}

