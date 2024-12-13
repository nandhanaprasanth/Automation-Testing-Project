package Test;

import java.time.Duration;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Baseclass;
import Page.Home;

public class Hometest extends Baseclass{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	@Test
	public void testing5() throws InterruptedException
	{
	Home ob1=new Home(driver);
	ob1.titleverification();
	ob1.textveri();
	
Thread.sleep(6000);

	
	ob1.handleWhatsAppIcon();
	ob1.scrolltobottom();
	ob1.handleSocialMediaIcons();
	ob1.Alllinkresponsecode();
}
}