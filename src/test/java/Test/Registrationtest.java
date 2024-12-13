package Test;

import org.testng.annotations.Test;

import Base.Baseclass;
import Page.Registration;

public class Registrationtest extends Baseclass{
	@Test
	public void testing1() throws InterruptedException
	{
		Registration ob=new Registration(driver);
		ob.clicklogin();
		Thread.sleep(1000);
		ob.clickcreateaccount();
		ob.setvalues("Nandhana","Prasanth","nandhanast2wrong@gmail.com","bearhugs@2124!");
		ob.click_create();
    }
}
