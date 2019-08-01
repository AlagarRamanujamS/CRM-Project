package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import wdMethods.ProjectMethods;

public class ViewLeadPage extends ProjectMethods{
	
	public ViewLeadPage() {
		PageFactory.initElements(driver, this);
		
	}
		
	@FindBy(how = How.ID , using = "viewLead_firstName_sp" )
	WebElement eleViewFirstName;
	@FindBy(how = How.XPATH,using = "(//a[@class='subMenuButton'])[3]")
	WebElement eleClickEdit;
	@FindBy(how = How.ID , using = "viewLead_firstName_sp")
	WebElement eleVerifyFirstName;

	public ViewLeadPage verifyFirstName(String data) {
		verifyExactText(eleViewFirstName, data);
		return this;
	}
	public EditLeadPage editLead() {
		click(eleClickEdit);
		return new EditLeadPage();
	}
	public ViewLeadPage verifyUpdatedFirstName(String data) {
		verifyExactText(eleVerifyFirstName, data);
		return this;
	}
		

}
