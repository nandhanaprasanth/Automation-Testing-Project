package Test;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.Baseclass;
import Page.Account;

public class Accounttest extends Baseclass{
@Test
public void testingacc() 
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
	Account ob=new Account(driver);
	ob.click_viewaddress();
	ob.address_setvalues("Nandha", "prasanth", "luminar", "tholkudiyil", "ishal hostel", "Kakkanad", "686665", "8590804935");
    
    ob.dropdown_country("United States"); // Change the country to the desired one
    
    ob.dropdown_province("Texas");
    wait.until(ExpectedConditions.visibilityOf(ob.getaddAddressbtn()));
  System.out.print("add address");
    ob.click_addAddressbtn();
    System.out.print("add address btn clicked");
  ob.click_delete();
  ob.hndle_alert();
  //  Navigate back to the homepage
  driver.get("https://bearhugsofficial.com/");  // Direct navigation to the homepage
  System.out.println("Navigated back to the homepage.");
}
}
