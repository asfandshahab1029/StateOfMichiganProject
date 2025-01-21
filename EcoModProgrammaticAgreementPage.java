package gov.michigan.mdot.automation.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import gov.michigan.mdot.automation.base.BasePage;

public class EcoModProgrammaticAgreementPage extends BasePage {
	String screenShotName = "";
	   
    public EcoModProgrammaticAgreementPage( WebDriver driver )
    {
        super( driver );
    }
	@FindBy (xpath="//som-header//som-button-dropdown//div[text()='Admin Tasks']")
	WebElement AdminTasks;
	
	@FindBy (xpath ="//som-button-dropdown//a[normalize-space(text())='Programmatic Agreement']")
	WebElement ProgrammaticAgreement;
	
	@FindBy (xpath="//table/tbody/tr[1]/td[3]//button[contains(@aria-label, 'Edit Reasons')]")
	WebElement EditAccessControl;
	
	@FindBy (xpath ="(//input[@id='categoricalExclusionReason'])[2]")
	WebElement Reason; 
	
	@FindBy (xpath ="//button[@aria-label='Save']")
	WebElement Save;
	


	public void ProgrammaticAgreement() 
	{
		AdminTasks.click();
		ProgrammaticAgreement.click();
		
		
	}
	
	public void EditAccessControl() 
	{
		EditAccessControl.click();
		
	}
	
	public void EditReason() throws Exception
	{
    Thread.sleep(3000);
    Reason.sendKeys("_Auto");
 }
	public void EditReasonToAccessControl() throws Exception
	{
	Thread.sleep(3000);
    Reason.clear();
    Thread.sleep(3000);
    Reason.sendKeys("Access Control");
    Thread.sleep(3000);
    Reason.sendKeys(Keys.TAB);
}
	
	public void ClickSave() 
	{
		Save.click();
		
	}
}