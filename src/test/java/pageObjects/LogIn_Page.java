package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogIn_Page {
	
	private WebDriver driver;
	private String returnText;
	
	
	private WebElement userName; 
	private WebElement passWord; 
	private WebElement flash; 
	
	
	public LogIn_Page(WebDriver driver) {
		this.driver = driver;
		
		
	}
	
	public void navigate(String url) {
		driver.navigate().to(url);
	}
	
	public void typeUserName(String text) {
		userName =driver.findElement(By.id("username"));
		userName.sendKeys(text);
	}
	
	public void typePassword(String password) {
		passWord = driver.findElement(By.id("password"));
		passWord.sendKeys(password);
		
		
	}
	public void buttonPress(String kind) {
		if(kind.equalsIgnoreCase("login")) {
		
			driver.findElement(By.className("radius")).click();
		}
		else if(kind.equalsIgnoreCase("logout")) {
			//logoutButton.click();
			driver.findElement(By.xpath("//*[contains(text(),'Logout')]")).click();
		}
	}
	
	public String getUserName() {
		returnText = null;
	//	userName =driver.findElement(By.id("username"));
		returnText = userName.getAttribute("value");
		return returnText;
	}
	
	public String getPassWord() {
		returnText = null;
		returnText = passWord.getAttribute("value");
		return returnText;
	}
	
	public String getFlashMsg() {
		flash = driver.findElement(By.id("flash"));
		
		returnText = null;
		returnText = flash.getText();
		return returnText;
	}
	
	public String getURL() {
		returnText = null;
		returnText = driver.getCurrentUrl();
		return returnText;
	}
	
	

	
}
