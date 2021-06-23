package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Guru99HomepPage {
	WebDriver d;
	 By homePageUserName = By.xpath("//table//tr[@class='heading3']");
	 
	 public Guru99HomepPage(WebDriver d) {
		 this.d = d;
	 }
	 
	 //get the user name from the home page
	 public String getHomePageDashboardUserName() {
		 return d.findElement(homePageUserName).getText();
	 }

}
