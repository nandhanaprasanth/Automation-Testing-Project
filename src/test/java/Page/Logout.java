package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Base.Baseclass;

public class Logout extends Baseclass {
	@FindBy(xpath="//*[@id=\"shopify-section-static-header\"]/div[1]/div[2]/ul/li/span[2]/a[2]")
	WebElement logout;
	public Logout(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void clicklogout()
	{
		logout.click();
	}
	
	
    


}
