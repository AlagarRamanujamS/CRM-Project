package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import wdMethods.ProjectMethods;

public class CreateLeadPage extends ProjectMethods {
	
	public CreateLeadPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	//page Factory @Find - > used to locate to Element
	@FindBy(how = How.CLASS_NAME, using = "inputBox") 
	WebElement elecName;
	
	@FindBy(how = How.ID, using ="createLeadForm_firstName") 
	WebElement eleFName;
	
	@FindBy(how = How.ID, using = "createLeadForm_lastName") 
	WebElement eleLName;
	
	@FindBy(how = How.CLASS_NAME, using = "smallSubmit")
	WebElement eleCreateLead;
	
	public CreateLeadPage enterCompanyName(String cName) {
		//WebElement eleUserName = locateElement("id", "username");
		type(elecName, cName);
		return this;
		
	}
	
	public CreateLeadPage enterFirstName(String fName) {
		//WebElement elepassword = locateElement("id", "passwod");
		type(eleFName, fName);
		return this;
	}
	
	public CreateLeadPage enterLastName(String lName) {
		//WebElement eleLogin = locateElement("class", "decorativeSubmit");
		type(eleLName, lName);
		return this;
	}
	
	public ViewLeadPage createLeat() {
		click(eleCreateLead);
		return new ViewLeadPage();
	}
}
