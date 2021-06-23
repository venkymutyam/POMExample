package test;



import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Guru99HomepPage;
import pages.Guru99Login;

public class TestGuruLogin {
	String driverPath = "D:\\BrowserDrivers\\chromedriver.exe";
	WebDriver d;
	Guru99Login objLogin;
	Guru99HomepPage objHomePage;
	String baseUrl;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		d = new ChromeDriver();
		baseUrl = "http://demo.guru99.com/V4/";
		d.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));
	}
	@AfterTest
	public void close() {
		d.quit();
	}
	@Test(priority = 0)
	public void testHomePageAppearCorrect() {
		
		try {
			d.get(baseUrl);
			
			//create login page object
			objLogin = new Guru99Login(d);
			
			//verufy login page title
			String loginPageTitle = objLogin.getLoginTitle();
			Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
			
			//login to application
			objLogin.loginToGuru99("mngr333542", "yjYrypy");
			//go to the next page
			objHomePage = new Guru99HomepPage(d);
			
			//verify home page
			Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mngr333542"));
			
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}

}
