package Test;



import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Baseclass;
import Page.Logout;

public class Logouttest extends Baseclass{
	@Test
	public void testing1() throws InterruptedException
	{
		Logout ob=new Logout(driver);
		ob.clicklogout();
		String exp="https://bearhugsofficial.com/";
	String act=driver.getCurrentUrl();
	Assert.assertEquals(act, exp,"not matching");
}
}