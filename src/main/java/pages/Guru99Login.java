package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Guru99Login {
	
	WebDriver d;
	By userGuru99Name = By.name("uid");
	By passwordGuru99 = By.name("password");
	By titleText = By.className("barone");
	By login = By.name("btnLogin");
	
	public Guru99Login(WebDriver d) {
		this.d = d;
	}
	//set username in textbox
	public void setUsername(String strUsername) {
		d.findElement(userGuru99Name).sendKeys(strUsername);
	}
	//set password in textbox
	public void setPassword(String strPassword) {
		d.findElement(passwordGuru99).sendKeys(strPassword);
	}
	//click on login button
	public void clickLogin() {
		d.findElement(login).click();
	}
	//get the title of the login page
	public String getLoginTitle() {
		return d.findElement(titleText).getText();
	}
	
	public void loginToGuru99(String strUsername, String strPassword) {
		
		this.setUsername(strUsername);
		this.setPassword(strPassword);
		this.clickLogin();
	}
	

}
