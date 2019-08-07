package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class BrowserHelper {
	private static  WebDriver driver = null;
	
	/*There are many ways of setting this up....this is one idea*/
	
	public static WebDriver SelectBrowser(String browser) {
		
		//If browser is Firefox
		if(browser.equalsIgnoreCase("firefox")) {
			
			
			/*Set property can also be set as a system variable/// (as in to run in teamcity)*/
			
			/*You will need to set your own path to this exe*/
			System.setProperty("webdriver.gecko.driver", "C:/Users/NeverEnder43/Downloads/geckodriver-v0.24.0-win32/geckodriver.exe");
			
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setCapability("marionette", true);
			driver = new FirefoxDriver(firefoxOptions);
			
		}
		else if(browser.equalsIgnoreCase("ie")) {
			
			/*You will need to set your own path to this exe*/
			System.setProperty("webdriver.ie.driver", "C:/Users/NeverEnder43/Downloads/IEDriverServer_x64_3.14.0/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		
		return driver;
	}
	

}
