package automationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import java.util.concurrent.TimeUnit;

//import org.junit.After;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import helper.BrowserHelper;
import pageObjects.LogIn_Page;

public class POMTest  {
	private WebDriver driver = null;
	private String userName = "tomsmith";
	private String passWord = "SuperSecretPassword!";
	private String myUrl = null;
	
	
@Test
public void loginTest(String browser) {
	//System.out.println("Talk:"+jumping);
	driver = BrowserHelper.SelectBrowser(browser);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	LogIn_Page loginPage = new LogIn_Page(driver);
	loginPage.navigate("https://the-internet.herokuapp.com/login");
	myUrl = loginPage.getURL();
	driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	loginPage.typePassword("JKJKJK");
	loginPage.buttonPress("login");
	assertNotNull(loginPage.getFlashMsg());
	
	loginPage.typeUserName(userName);
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	
	assertEquals(loginPage.getUserName(),userName);
	
	loginPage.typePassword(passWord);
	assertEquals(loginPage.getPassWord(),passWord);
	
	loginPage.buttonPress("login");
	
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	assertNotSame(myUrl,loginPage.getURL());
	assertNotNull(loginPage.getFlashMsg());
	
	loginPage.buttonPress("logout");
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	assertNotNull(loginPage.getFlashMsg());
	
	assertEquals(myUrl,loginPage.getURL());
	
	driver.quit();
	//System.out.println("THis is after the facts.");
	
}

//@After
public void tearDown(){
	System.out.println("This is the After notation");
	//driver.quit();
}
	

}
