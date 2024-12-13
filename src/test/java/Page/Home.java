package Page;

import java.net.HttpURLConnection;
import java.net.URI;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import Base.Baseclass;

public class Home extends Baseclass {
	@FindBy(xpath="/html/body/header/div/div[1]/div[2]/div/a/span[2]")
	WebElement cartIcon;
	 @FindBy(xpath = "//*[@id=\"bob_whatsapp_widget_container\"]/a/img")
	    WebElement whatsappIcon;
	 @FindBy(xpath = "//*[@id=\"shopify-section-static-footer\"]/footer/section/div/div[2]/div/div[1]/div/div/a[2]")
	    WebElement facebook;
	 
	 @FindBy(xpath = "//*[@id=\"shopify-section-static-footer\"]/footer/section/div/div[2]/div/div[1]/div/div/a[3]")
	    WebElement instagram;
	 
	 @FindBy(xpath = "//*[@id=\"shopify-section-static-footer\"]/footer/section/div/div[2]/div/div[1]/div/div/a[4]")
	    WebElement linkedin;
	 @FindBy(xpath = "//*[@id=\"shopify-section-static-footer\"]/footer/section/div/div[2]/div/div[1]/div/div/a[5]")
	    WebElement twitter;
	 
    public Home(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void titleverification() {
        String atitle = driver.getTitle();
        System.out.println("Actual Title: " + atitle);

        String etitle = "Online Pet Store for Pet Products India | Pet Accessories Stores";

        // Assert for title comparison
        Assert.assertEquals(atitle, etitle, "Title verification failed!");
    }

    public void textveri() {
        String src = driver.getPageSource();
        String etext = "About";

        // Assert for text presence
        Assert.assertTrue(src.contains(etext), "Text verification failed! 'About' not found in page source.");
    }
    public void carticonvisibility()
    {
    	 Assert.assertTrue(cartIcon.isDisplayed(), "Cart icon is not visible on the homepage!");
    }
    public void Alllinkresponsecode()
	{
		List<WebElement>li=driver.findElements(By.tagName("a"));
		int linkcount=li.size();
		System.out.println("link count is actually "+linkcount);
		if(linkcount==30)
		{
			System.out.println("link count= 168");
		}
		else 
		{
			System.out.println("link count is "+linkcount);
			
		}
		for (WebElement ele : li) //ele is the reference name, li is the list name
        {  
           String link= ele.getAttribute("href");
           verify(link);
        }

}
	private void verify(String link) {
		// TODO Auto-generated method stub
		try {
			URI ob=new URI(link);
			HttpURLConnection con=(HttpURLConnection)ob.toURL().openConnection();
			if(con.getResponseCode()==200)
			{
				System.out.println("success response code is 200........"+link);
			}
			else if(con.getResponseCode()==404)
			{
				System.out.println("broken link response code is 404........"+link);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		}

	//WINDOW HANDLING 
	 public void handleWhatsAppIcon() throws InterruptedException {
	        // Click on the WhatsApp icon
	        whatsappIcon.click();

	        // Store the current window handle (home page)
	        String homePageHandle = driver.getWindowHandle();
	        System.out.println("Home Page Handle: " + homePageHandle);

	        // Wait for the new window to open
	        Thread.sleep(2000); // Adjust wait time if necessary

	        // Get all window handles
	        Set<String> allWindowHandles = driver.getWindowHandles();

	        // Ensure there are exactly two windows
	        if (allWindowHandles.size() == 2) {
	            // Switch to the new window (WhatsApp page)
	            for (String handle : allWindowHandles) {
	                if (!handle.equals(homePageHandle)) {
	                    driver.switchTo().window(handle);
	                    break;
	                }
	            }

	            // Print the title of the WhatsApp page
	            String whatsappPageTitle = driver.getTitle();
	            System.out.println("WhatsApp Page Title: " + whatsappPageTitle);

	            // Switch back to the home page
	            driver.switchTo().window(homePageHandle);
	            System.out.println("Switched back to Home Page. Title: " + driver.getTitle());
	        } 
	        else 
	        {
	            System.out.println("Unexpected number of windows open: " + allWindowHandles.size());
	        }
	    }
	 public void scrolltobottom()
	 {
	 //SCROLL TO BOTTOM OF PAGE
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	// Scroll to the bottom of the page
	 js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
}
	// WINDOW HANDLING FOR ALL SOCIAL MEDIA PAGES
	 public void handleSocialMediaIcons() throws InterruptedException {
	     // Store the current window handle (home page)
	     String homePageHandle = driver.getWindowHandle();
	     System.out.println("Home Page Handle: " + homePageHandle);

	     // List of social media icons to click
	     WebElement[] socialMediaIcons = {facebook, instagram, linkedin, twitter};

	     for (WebElement icon : socialMediaIcons) {
	         // Click the social media icon
	         Thread.sleep(6000);
	    	 icon.click();

	         // Wait for the new window to open
	         Thread.sleep(6000); // Adjust wait time if necessary

	         // Get all window handles
	         Set<String> allWindowHandles = driver.getWindowHandles();

	         // Check if a new window is opened
	         if (allWindowHandles.size() > 1) {
	             // Switch to the new window (social media page)
	             for (String handle : allWindowHandles) {
	                 if (!handle.equals(homePageHandle)) {
	                     driver.switchTo().window(handle);
	                     break;
	                 }
	             }

	             // Print the title of the social media page
	             String socialMediaPageTitle = driver.getTitle();
	             System.out.println("Social Media Page Title: " + socialMediaPageTitle);

	             // Close the social media tab/window
//	             driver.close();

	             // Switch back to the home page
	             driver.switchTo().window(homePageHandle);
	             System.out.println("Switched back to Home Page. Title: " + driver.getTitle());
	         } else {
	             System.out.println("No new window opened for the icon.");
	         }
	     }
	 }

	 
}
