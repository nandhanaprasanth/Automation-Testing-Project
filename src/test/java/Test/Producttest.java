package Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.Baseclass;
import Page.Productadd;

public class Producttest extends Baseclass {

    @Test
    public void testingpdt() throws IOException {
        Productadd p = new Productadd(driver); // Initialize the Productadd class
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the "eat" element to be visible
        wait.until(ExpectedConditions.visibilityOf(p.eat));

        // Hover over the element and click the dropdown item
        p.hoverAndClickDropdownItem();
        p.addtocart();
        p.zipsetvalue("686662");
        p.clickckeck();
        p.setcount_clickaddtocart();
     // Take screenshot
       p.screenshot();
    }
}
