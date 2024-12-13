package Page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.Baseclass;

public class Account extends Baseclass{
	
	@FindBy(xpath="//*[@id=\"shopify-section-account\"]/section/div/div/div[2]/div[2]/p/a")
	WebElement viewAddress;
	@FindBy(xpath="//*[@id=\"customer_addr_new_firstname\"]")
	WebElement firstname;
	@FindBy(xpath="//*[@id=\"customer_addr_new_lastname\"]")
	WebElement lastname;
	@FindBy(xpath="//*[@id=\"customer_addr_new_company\"]")
	WebElement company;
	@FindBy(xpath="//*[@id=\"customer_addr_new_address1\"]")
	WebElement Address1;
	@FindBy(xpath="//*[@id=\"customer_addr_new_address2\"]")
	WebElement Address2;
	@FindBy(xpath="//*[@id=\"customer_addr_new_city\"]")
	WebElement city;
	@FindBy(xpath="//*[@id=\"customer_addr_new_zip\"]")
	WebElement zip;
	@FindBy(xpath="//*[@id=\"customer_addr_new_phone\"]")
	WebElement phone;
	@FindBy(xpath="//*[@id=\"customer_addr_new_country\"]")
	WebElement country;
	@FindBy(xpath="//*[@id=\"customer_addr_new_province\"]")
	WebElement province;
	@FindBy(xpath="//*[@id=\"submit-new\"]")
	WebElement addAddressbtn;
	@FindBy(xpath="//*[@id=\"shopify-section-addresses\"]/section/article/div/div[1]/ul/li[2]/div/button[2]")
	WebElement deletebtn;
	
	public Account(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
		public void click_viewaddress()
		{
			viewAddress.click();
		}
		public void address_setvalues(String fstname,String lstname,String company1,String Addrss1,String Addrss2,String city1,String zip1,String phone1)
		{
			firstname.sendKeys(fstname);
			lastname.sendKeys(lstname);
			company.sendKeys(company1);
			Address1.sendKeys(Addrss1);
			Address2.sendKeys(Addrss2);
			city.sendKeys(city1);
			zip.sendKeys(zip1);
			phone.sendKeys(phone1);
		}
		public void dropdown_country(String country1)
		{
			country.click();
			Select sc=new Select(country);
			sc.selectByValue(country1);
		}
		public void dropdown_province(String province1)
		{
//			province.click();
			Select sp=new Select(province);
			sp.selectByValue(province1);	
		}
		public WebElement getaddAddressbtn() {
			
		    return addAddressbtn;
		}

//		public void click_addAddressbtn() {
//		    try {
//		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addAddressbtn);
//		        if (addAddressbtn.isDisplayed() && addAddressbtn.isEnabled()) {
//		            addAddressbtn.click();
//		            System.out.println("Add Address button clicked.");
//		        } else {
//		            System.out.println("Add Address button not available.");
//		        }
//		    } catch (Exception e) {
//		        System.out.println("Exception while clicking addAddressbtn: " + e.getMessage());
//		    }
//		}
		public void click_addAddressbtn() {
		    try {
		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addAddressbtn);
		        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addAddressbtn);
		        System.out.println("Add Address button clicked using JavaScript.");
		    } catch (Exception e) {
		        System.out.println("Exception while clicking addAddressbtn: " + e.getMessage());
		    }
		}

		public void click_delete()
		{
			//deletebtn.click();
			 if (deletebtn.isDisplayed() && deletebtn.isEnabled()) {
		            deletebtn.click();
		        } else {
		            System.out.println("Delete button not available.");
		        }
		}
		public void hndle_alert()
		{
			 try {
			        Alert alert = driver.switchTo().alert();
			        alert.accept();
			        System.out.println("Alert accepted.");
			    } catch (Exception e) {
			        System.out.println("No alert present.");
			    }
			}
		}

	
	
	

	
	
	
	

