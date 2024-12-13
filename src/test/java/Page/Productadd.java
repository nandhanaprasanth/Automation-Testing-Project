package Page;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Baseclass;

public class Productadd extends Baseclass {

    @FindBy(xpath = "//*[@id=\"site-header-nav\"]/nav/ul/li[1]/details/summary")
    public WebElement eat;

    @FindBy(xpath = "//*[@id=\"site-header-nav\"]/nav/ul/li[1]/details/ul/li[3]/a")
    WebElement dropdownItem; // 3rd item in the dropdown
    @FindBy(xpath = "//*[@id=\"shopify-section-template--17751812374759__main\"]/div[1]/div[2]/ul/li[2]/div/a/figure/img")
    WebElement pdtlink; 
    @FindBy(xpath = "//*[@id=\"zipcode\"]")
    WebElement zipcode;
    @FindBy(xpath = "//*[@id=\"shopify-section-template--17751813193959__main\"]/section/article/div[2]/div/div[10]/div/div/input[2]")
    WebElement check;
    @FindBy(xpath = "//*[@id=\"quantity-box\"]/button[2]")
    WebElement plus;
    @FindBy(xpath = "//*[@id=\"product_form_8354381889767\"]/div[3]/div[2]/div/button/span[1]")
    WebElement addtocart;

    // Constructor to initialize WebElements
    public Productadd(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void hoverAndClickDropdownItem() {
        Actions a = new Actions(driver);

        // Hover over the "eat" element
        a.moveToElement(eat).perform();

        // Wait for the dropdown item to be visible and click it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(dropdownItem));
        dropdownItem.click();
    }
    public void addtocart() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(pdtlink));

        // Scroll to the element and then click
       // js.executeScript("arguments[0].scrollIntoView(true);", pdtlink);
        wait.until(ExpectedConditions.elementToBeClickable(pdtlink));
        pdtlink.click();
        
        // Scroll to the "zipcode" element
       // js.executeScript("arguments[0].scrollIntoView(true);", zipcode);
        wait.until(ExpectedConditions.elementToBeClickable(zipcode));
        zipcode.click();
    }

    public void zipsetvalue(String receivezip)
    {
    	zipcode.sendKeys(receivezip);
    }
    public void clickckeck()
    {
    	check.click();	
    }
    public void setcount_clickaddtocart()
    {
    	JavascriptExecutor js = (JavascriptExecutor) driver;

    	js.executeScript("window.scrollTo(0, 0);");
    	plus.click();
    	addtocart.click();
    }
    // Method to take a screenshot
    public void screenshot() throws IOException
	{
		File s1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
		FileHandler.copy(s1,new File("./screenshot/finalpage.png"));
	}

}
