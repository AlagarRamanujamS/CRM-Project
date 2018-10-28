package wdMethods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
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
import org.openqa.selenium.support.ui.Select;

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
			/*else if (browser.equalsIgnoreCase("firefox")) {			
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}*/
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
			case "id": return driver.findElementById(locValue);
			case "class": return driver.findElementByClassName(locValue);
			case "xpath": return driver.findElementByXPath(locValue);
			case "linktext":return driver.findElementByLinkText(locValue);
			}
		} catch (NoSuchElementException e) {
			reportStep("FAIL", "The Element Is Not Located ");
			//System.out.println("The Element Is Not Located ");
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
			System.out.println("The Element Is Not Located ");
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
			reportStep("PASS", "The data: "+data+" is clicked successfully");
			
		} catch (Exception e) {
            reportStep("FAIL", "The data: "+data+" is not click");
		}
		takeSnap();
	}

	@Override
	public void click(WebElement ele) {
		ele.click();
		reportStep("PASS", "The Element "+ele+" Clicked Successfully");
		//System.out.println("The Element "+ele+" Clicked Successfully");
		takeSnap();
	}

	
	public void clickWithoutSnap(WebElement ele) {
		ele.click();
		reportStep("PASS", "The Element "+ele+" Clicked Successfully");
		System.out.println("The Element "+ele+" Clicked Successfully");
	}

	@Override
	public String getText(WebElement ele) {
		String text = ele.getText();
		return text;
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

	@Override
	public boolean verifyTitle(String expectedTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void verifyExactText(WebElement ele, String expectedText) {
		try {
			if (getText(ele).equals(expectedText)) {
				reportStep("The text: "+getText(ele)+" matches with the value :"+expectedText,"PASS");
				
			} else {
				reportStep("The text "+getText(ele)+" doesn't matches the actual "+expectedText,"FAIL");

			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Text", "FAIL");
		}
	}

	@Override
	public void verifyPartialText(WebElement ele, String expectedText) {
		try {
			if(getText(ele).contains(expectedText)) {
				reportStep("The expected text contains the actual "+expectedText,"PASS");
			}else {
				reportStep("The expected text doesn't contain the actual "+expectedText,"FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Text", "FAIL");
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
		// TODO Auto-generated method stub

	}

	@Override
	public void verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub

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
			reportStep("switch In to the Frame "+ele,"PASS");
		} catch (NoSuchFrameException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
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
      driver.close();
	}

	@Override
	public void closeAllBrowsers() {
		// TODO Auto-generated method stub

	}

	
}
