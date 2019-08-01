package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import wdMethods.ProjectMethods;

public class EditLeadPage extends ProjectMethods{
	
	public EditLeadPage() {
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(how = How.ID, using = "updateLeadForm_firstName")
	WebElement eleFirstName; 
	@FindBy(how = How.ID,using = "updateLeadForm_lastName")
	WebElement eleLastName;
	@FindBy(how = How.XPATH,using = "(//input[@name='submitButton'])[1]")
	WebElement eleClickUpdate;
	
	public EditLeadPage updateFirstName(String uFName) {
		eleFirstName.clear();
		type(eleFirstName, uFName);
		return this;
	}
	public EditLeadPage updateLastName(String uLName) {
		eleLastName.clear();
		type(eleLastName, uLName);
		return this;
	}
	public ViewLeadPage clickUpdate() {
		click(eleClickUpdate);
		return new ViewLeadPage();
	}

}
