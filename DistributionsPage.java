package gov.michigan.mdot.automation.MiADART.pages;

import gov.michigan.mdot.automation.base.TestBase;
import gov.michigan.mdot.automation.utilities.CommonLibsFramework;
import gov.michigan.mdot.automation.utilities.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import gov.michigan.mdot.automation.base.BasePage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DistributionsPage  extends BasePage{
	
	String screenShotName = "";
   
    public DistributionsPage( WebDriver driver )
    {
        super( driver );
    }
    
    
    @FindBy(xpath= "//som-header//som-button-dropdown//div[text()='Distributions']")
   	WebElement DistributionsMainNav;
    
    @FindBy(xpath ="//som-button-dropdown//a[normalize-space(text())='Calculate Distributions']")
   	WebElement CalculateDistributions;
    
    @FindBy(xpath ="//som-sidebar//som-list-item[3]//a[contains(text(), 'Approve Distribution')]")
   	WebElement ApproveDistributions;
    
  

public void CalculateDistributions() throws Exception
{
	DistributionsMainNav.click();
	CalculateDistributions.click();
	DistributionsMainNav.click();
	
}

public void ApproveDistributions() throws Exception
{
	DistributionsMainNav.click();
	
	ApproveDistributions.click();
	
}
public void validateApproveDistributions()
{
	try {
		this.ApproveDistributions.click();
		test.log(LogStatus.PASS, "Validate the numbers match for Amounts Available for Distribution: Successful!");
		Thread.sleep(500);
		screenShotName = TestUtil.captureScreenShot();
		test.log(LogStatus.PASS, test.addScreenCapture(screenShotName));
		
	}catch(Exception e) {
		test.log(LogStatus.FAIL, "If the numbers don't match for Amounts Available for Distribution: Unsuccessful!");
		e.printStackTrace();
	}
}
public void validateCalculateDistributions()
{ 
	System.out.println("Validate numbers displaying");
	try {
		this.DistributionsMainNav.click();
		CalculateDistributions.click();
		DistributionsMainNav.click();
		test.log(LogStatus.PASS, "Validate the numbers match for Calculate Distributions: Successful!");
		Thread.sleep(500);
		String screenShotName = TestUtil.captureScreenShot();
		test.log(LogStatus.PASS, test.addScreenCapture(screenShotName));
		
		
	}catch(Exception e) {
		test.log(LogStatus.FAIL, "If the numbers don't match for Calculate Distributions: Unsuccessful!");
		e.printStackTrace();
	}
}
}
