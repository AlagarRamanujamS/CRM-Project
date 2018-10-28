package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import wdMethods.ProjectMethods;

public class HomePage extends ProjectMethods {
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.CLASS_NAME, using = "decorativeSubmit") 
	WebElement eleLogOut;
	@FindBy(how = How.LINK_TEXT, using = "CRM/SFA")
	WebElement eleclickcrm;
	
	
	public MyHomePage clickCRM() {
		click(eleclickcrm);
		return new MyHomePage();
		
	}
	
	public LoginPage clickLogOut() {
		//WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogOut);
		return new LoginPage();
	}
}
