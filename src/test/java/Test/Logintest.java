package Test;

import java.time.Duration;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Baseclass;
import Page.Login;
import Utilities.Excel_utilities;

public class Logintest extends Baseclass {
	@Test
	public void testing3() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		Login ob =new Login(driver);
		String xl="C:\\Users\\nandh\\OneDrive\\Desktop\\bearhugs\\logindata.xlsx";
		String sheet="Sheet1";
				int rowcount=Excel_utilities.getRowCount(xl,sheet);
				for(int i=1;i<=rowcount;i++)
				{
					String username=Excel_utilities.getCellValue(xl, sheet, i, 0);
					System.out.println("username "+username);
					String password=Excel_utilities.getCellValue(xl, sheet, i, 1);
					System.out.println("password "+password);
					wait.until(ExpectedConditions.visibilityOf(ob.getLoginButton()));
					ob.clicklogin();
					ob.logsetvalues(username,password);
					ob.clicksignin();
//					String exp="https://bearhugsofficial.com/account";
//					String act=driver.getCurrentUrl();
//					Assert.assertEquals(act, exp,"not in account page");

}
	}
}
