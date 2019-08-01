package wdMethods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.InvalidElementStateException;
//import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Report;

//import com.aventstack.extentreports.Status;



public class SeMethods extends Report implements WdMethods{
	public int i = 1;
	public static RemoteWebDriver driver;

	public void startApp(String browser, String url) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {			
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
				
			}else if (browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			} 
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//System.out.println("The Browser "+browser+" Launched Successfully");
			reportStep("PASS", "The Browser "+browser+" Launched Successfully");
		} catch (WebDriverException e) {
			reportStep("FAIL", "The Browser "+browser+" not Launched ");
			//System.out.println("The Browser "+browser+" not Launched ");
		} finally {
			takeSnap();			
		}
	}


	public WebElement locateElement(String locator, String locValue) {
		try {
			switch(locator) {
			case("id"): return driver.findElementById(locValue);
			case("link"): return driver.findElementByLinkText(locValue);
			case("xpath"):return driver.findElementByXPath(locValue);
			case("name"): return driver.findElementByName(locValue);
			case("class"): return driver.findElementByClassName(locValue);
			case("tag"):return driver.findElementByTagName(locValue);
			}
		} catch (NoSuchElementException e) {
			reportStep("The element with locator "+locator+" not found.","FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while finding "+locator+" with the value "+locValue, "FAIL");
		}
		return null;
	}
	
	public List<WebElement> locateElements(String locator, String locValue) {
		try {
			switch(locator) {
			case "id": return driver.findElementsById(locValue);
			case "class": return driver.findElementsByClassName(locValue);
			case "xpath": return driver.findElementsByXPath(locValue);
			case "linktext":return driver.findElementsByLinkText(locValue);
			}
		} catch (NoSuchElementException e) {
			reportStep("FAIL", "The Element Is Not Located ");
		}
		return null;
	}

	@Override
	public WebElement locateElement(String locValue) {
		return driver.findElementById(locValue);
	}

	@Override
	public void type(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			reportStep("The data: "+data+" entered successfully in the field :"+ele, "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+ele,"FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+ele, "FAIL");
		}
		takeSnap();
	}

	@Override
	public void click(WebElement ele) {
		String text = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));			
			text = ele.getText();
			ele.click();
			reportStep("The element "+text+" is clicked", "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The element: "+text+" could not be clicked", "FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while clicking in the field :", "FAIL");
		} 
		takeSnap();
	}

	
	public void clickWithoutSnap(WebElement ele) {
		ele.click();
		reportStep("PASS", "The Element "+ele+" Clicked Successfully");
		//System.out.println("The Element "+ele+" Clicked Successfully");
	}

	@Override
	public String getText(WebElement ele) {
		String bReturn = "";
		try {
			bReturn = ele.getText();
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "FAIL");
		}
		return bReturn;
	}

	@Override
	public void selectDropDownUsingText(WebElement ele, String value) {
		Select dd = new Select(ele);
		dd.selectByVisibleText(value);
		reportStep("PASS", "The DropDown Is Selected with "+value);
		//System.out.println("The DropDown Is Selected with "+value);
	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		// TODO Auto-generated method stub

	}
	public String getTitle() {		
		String bReturn = "";
		try {
			bReturn =  driver.getTitle();
		} catch (WebDriverException e) {
			reportStep("Unknown Exception Occured While fetching Title", "FAIL");
		} 
		return bReturn;
	}
	@Override
	public boolean verifyTitle(String title) {
		boolean bReturn =false;
		try {
			if(getTitle().equals(title)) {
				reportStep("The title of the page matches with the value :"+title,"PASS");
				bReturn= true;
			}else {
				reportStep("The title of the page:"+driver.getTitle()+" did not match with the value :"+title, "FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		} 
		return bReturn;
	}

	@Override
	public void verifyExactText(WebElement ele, String expectedText) {
		try {
			if (getText(ele).equals(expectedText)) {
				reportStep("PASS", "The text: "+getText(ele)+" matches with the value :"+expectedText);
				
			} else {
				reportStep("FAIL" , "The text "+getText(ele)+" doesn't matches the actual "+expectedText);

			}
		} catch (WebDriverException e) {
			reportStep("FAIL" , "Unknown exception occured while verifying the Text");
		}
	}

	@Override
	public void verifyPartialText(WebElement ele, String expectedText) {
		try {
			if(getText(ele).contains(expectedText)) {
				reportStep("PASS" , "The expected text contains the actual "+expectedText);
			}else {
				reportStep("FAIL" , "The expected text doesn't contain the actual "+expectedText);
			}
		} catch (WebDriverException e) {
			reportStep("FAIL" , "Unknown exception occured while verifying the Text");
		} 

	}

	@Override
	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void verifySelected(WebElement ele) {
		try {
			if(ele.isSelected()) {
				reportStep("The element "+ele+" is selected","PASS");
			} else {
				reportStep("The element "+ele+" is not selected","FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		}

	}

	@Override
	public void verifyDisplayed(WebElement ele) {
		try {
			if(ele.isDisplayed()) {
				reportStep("The element "+ele+" is visible","PASS");
			} else {
				reportStep("The element "+ele+" is not visible","FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} 

	}

	@Override
	public void switchToWindow(int index) {
		Set<String> allWindows = driver.getWindowHandles();
		List<String> listOfWindow = new ArrayList<String>();
		listOfWindow.addAll(allWindows);
		driver.switchTo().window(listOfWindow.get(index));
		reportStep("PASS", "The Window is Switched ");
		//System.out.println("The Window is Switched ");
	}
	
	

	@Override
	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
			reportStep("PASS","switch In to the Frame "+ele);
		} catch (NoSuchFrameException e) {
			reportStep("FAIL" , "WebDriverException : "+e.getMessage());
		} catch (WebDriverException e) {
			reportStep( "FAIL", "WebDriverException : "+e.getMessage());
		} 
	}

	@Override
	public void acceptAlert() {
		driver.switchTo().alert().accept();
		//takeSnap();
	}

	@Override
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
		//takeSnap();
	}

	@Override
	public String getAlertText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void takeSnap() {
		try {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dsc = new File("./snaps/img"+i+".png");
			FileUtils.copyFile(src, dsc);
		} catch (IOException e) {
			e.printStackTrace();
		}
		i++;
	}

	@Override
	public void closeBrowser() {
		try {
			driver.close();
			reportStep("The browser is closed","PASS");
		} catch (Exception e) {
			reportStep("The browser could not be closed","FAIL");
		}
	}

	@Override
	public void closeAllBrowsers() {
		try {
			driver.quit();
			reportStep("The opened browsers are closed","PASS");
		} catch (Exception e) {
			reportStep("Unexpected error occured in Browser","FAIL");
		}

	}

	
}
