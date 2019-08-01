package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import wdMethods.ProjectMethods;

public class MyHomePage extends ProjectMethods {
	
	public MyHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[@href='/crmsfa/control/leadsMain']") 
	WebElement eleleads;
	
	public MyLeadsPage clickLeads() {
		
		click(eleleads);
		return new MyLeadsPage();
	}
}

