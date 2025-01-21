package gov.michigan.mdot.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import gov.michigan.mdot.automation.base.BasePage;

public class EcoModTribalSearchPage extends BasePage {
	String screenShotName = "";
	   
    public EcoModTribalSearchPage( WebDriver driver ) 
    {
        super( driver );
    }
	@FindBy (xpath="//som-header//som-button-dropdown//div[text()='Tribal']")
	WebElement Tribal;
	
	@FindBy (xpath="//som-button-dropdown//a[normalize-space(text())='Search']")
	WebElement TribalSearch;
	
	@FindBy (xpath="//select[@id='typeOfSearch']")
	WebElement TypeOfSearch;
	
	@FindBy (xpath="//div[@id='interactionStsMultiSelectId']")
	WebElement InteractionStatus;
	
	@FindBy (xpath="//div[@id='interactionStsMultiSelectId']//span[text()='Final Submission']")
	WebElement FinalSubmission;
	
	//@FindBy (xpath="//div[contains(@class, 'dropdown-container') and @aria-readonly='true']")
	//WebElement InteractionStatus;
	
	
	@FindBy (xpath="//button[@aria-label='Search']")
	WebElement Search;
	
	
	

	public void TribalSearch() 
	{
		Tribal.click();
		TribalSearch.click();
		
	}
	public void SelectTypeOfSearch() throws InterruptedException 
	{
		Thread.sleep(3000);
		Select select = new Select(TypeOfSearch);
		Thread.sleep(3000);
	    select.selectByVisibleText("Interaction/Report Narrative");
		    
	}
	public void SelectFinalSubmission() throws InterruptedException 
	{
		Thread.sleep(3000);
		InteractionStatus.click();
		Thread.sleep(3000);
		FinalSubmission.click();
		    
	}
	public void ClickSearch() 
	{
		Search.click();
		
	}
	
	public boolean isTableDataDisplayed() {
	    // Locate the table
	    WebElement table = driver.findElement(By.xpath("//table[@aria-label='Data Table for Search Results']"));

	    // Locate rows inside the table body
	    List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

	    // Check if rows are present
	    return rows.size() > 0;
	}
}
