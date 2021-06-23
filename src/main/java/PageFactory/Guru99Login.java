package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99Login {
	WebDriver d;
	
	@FindBy(name="uid") WebElement userNameGuru99;
	@FindBy(name="password") WebElement passwordGuru99;
	@FindBy(className="barone") WebElement titleText;
	@FindBy(name="btnLogin") WebElement login;
	
	public Guru99Login(WebDriver d) {
		this.d = d;
		//This initElements() will create all web elements
		PageFactory.initElements(d, this);
	}
	//set username in textbox
	public void setUserName(String strUserName) {
		userNameGuru99.sendKeys(strUserName);
	}
	//set password in textbox
	public void setPassword(String strPassword) {
		passwordGuru99.sendKeys(strPassword);
	}
	//click on login button
	public void clickLogin() {
		login.click();
	}
	//get the title of the login page
	public String getLoginTitle() {
		return titleText.getText();
	}
	
	public void loginToGuru99(String strUserName, String strPassword) {
		this.setUserName(strUserName);
		this.setPassword(strPassword);
		this.clickLogin();
	}	

}
