package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageFactory.Guru99HomePage;
import PageFactory.Guru99Login;

public class TestGuruLoginWIthPageFactory {
	String driverPath = "D:\\BrowserDrivers\\chromedriver.exe";
	WebDriver d;
	Guru99Login objLogin;
	Guru99HomePage objHomePage;
	String baseUrl;
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		d = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));
		baseUrl = "http://demo.guru99.com/V4/";
		d.manage().window().maximize();
		
	}
	@AfterTest
	public void close() {
		d.quit();
	}
	@Test(priority = 0)
	public void testHomePageAPpearCorrect() {
		d.get(baseUrl);
		objLogin = new Guru99Login(d);
		String loginPageTitle = objLogin.getLoginTitle();
		Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
		objLogin.loginToGuru99("mngr333542", "yjYrypy");
		objHomePage = new Guru99HomePage(d);
		Assert.assertTrue(objHomePage.getHomePageDshboardUsername().toLowerCase().contains("manger id : mngr333542"));
		
	}
}
