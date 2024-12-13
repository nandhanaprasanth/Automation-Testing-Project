package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration {
	WebDriver driver;
	//object repository
	@FindBy(xpath="//*[@id=\"shopify-section-static-header\"]/div[1]/div[2]/ul/li/a[1]/span[2]")
	WebElement login;
	@FindBy(xpath="//*[@id=\"customer_register_link\"]")
	WebElement createaccount;
	@FindBy(xpath="//*[@id=\"register_first_name\"]")
	WebElement firstname;
	@FindBy(xpath="//*[@id=\"register_last_name\"]")
	WebElement lastname;
	@FindBy(xpath="//*[@id=\"register_email\"]")
	WebElement email;
	@FindBy(xpath="//*[@id=\"register_password\"]")
	WebElement password;
	@FindBy(xpath="//*[@id=\"create_customer\"]/div[2]/button")
	WebElement createbtn;
	public Registration(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void clicklogin()
	{
		login.click();
	}
	public void clickcreateaccount()
	{
		createaccount.click();
	}
	public void setvalues(String firstname1,String lastname1,String email1,String password1)
	{
		firstname.sendKeys(firstname1);
		lastname.sendKeys(lastname1);
		email.sendKeys(email1);
		password.sendKeys(password1);
	}
	public void click_create()
	{
		createbtn.click();	
	}
}
