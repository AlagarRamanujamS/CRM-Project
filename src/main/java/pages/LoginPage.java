package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import wdMethods.ProjectMethods;

public class LoginPage extends ProjectMethods {
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	//page Factory @Find - > used to locate to Element
	@FindBy(how = How.ID, using = "username") 
	WebElement eleUserName;
	
	@FindBy(how = How.ID, using ="password") 
	WebElement elepassword;
	
	@FindBy(how = How.CLASS_NAME, using = "decorativeSubmit") 
	WebElement eleLogin;
	
	public LoginPage enterUserName(String uName) {
		//WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, uName);
		return this;
		
	}
	
	public LoginPage enterPassword(String password) {
		//WebElement elepassword = locateElement("id", "passwod");
		type(elepassword, password);
		return this;
	}
	
	public HomePage clickLogin() {
		//WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);
		return new HomePage();
	}
}
