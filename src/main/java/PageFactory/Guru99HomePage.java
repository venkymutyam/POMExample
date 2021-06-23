package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Guru99HomePage {
	WebDriver d;
	@FindBy(xpath="//table//tr[@class='heading3']") WebElement homePageUerName;
	
	public Guru99HomePage(WebDriver d) {
		this.d = d;
		//This initElements method will create all WebElements
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(d, 100);
		//PageFactory.initElements(d, this);
		PageFactory.initElements(factory, this);

	}
	//get the username from the home page
	public String getHomePageDshboardUsername() {
		return homePageUerName.getText();
	}

}
