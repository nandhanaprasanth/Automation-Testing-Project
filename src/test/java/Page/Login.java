package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Baseclass;

public class Login extends Baseclass {
	
	@FindBy(xpath="//*[@id=\"shopify-section-static-header\"]/div[1]/div[2]/ul/li/a[1]/span[2]")
    WebElement login;
	@FindBy(xpath="//*[@id=\"customer_email\"]")
	WebElement email;
	@FindBy(xpath="//*[@id=\"customer_password\"]")
	WebElement password;
	@FindBy(xpath="//*[@id=\"customer_login\"]/div[3]/button")
	WebElement loginbtn;
	
	public Login(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public WebElement getLoginButton() {
	    return login;
	}

	public void clicklogin()
	{if (login.isDisplayed()) {
	    System.out.println("Login button found and displayed.");
	} else {
	    System.out.println("Login button not visible.");
	}

		login.click();
	}
	public void logsetvalues(String email1,String password1)
	{
		email.sendKeys(email1);
		password.sendKeys(password1);
	}
	public void clicksignin()
	{
		loginbtn.click();
	}
}
