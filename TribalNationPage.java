package gov.michigan.mdot.automation.ECOMod.pages;
import gov.michigan.mdot.automation.base.TestBase;
import gov.michigan.mdot.automation.utilities.CommonLibsFramework;
import gov.michigan.mdot.automation.utilities.TestUtil;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
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
public class TribalNationsPage  extends BasePage{
	
	String screenShotName = "";
   
    public TribalNationsPage( WebDriver driver )
    {
        super( driver );
    }
    
    
    @FindBy(xpath= "//som-header//som-button-dropdown//div[text()='Tribal']")
   	WebElement TribalMainNav;
    
    @FindBy(xpath ="//som-button-dropdown//a[normalize-space(text())='Tribal Nations']")
   	WebElement TribalNations;
    
    @FindBy(xpath="//button[@aria-label='Add a Tribal Nation']")
    WebElement Add;
   
    @FindBy(xpath="//input[@id='trblNatnName']")
    WebElement TribalNationName;
    
    @FindBy(xpath="//som-input[@input-id='shortDesc']//input[@type='text']")
    WebElement ShortName;
    
    @FindBy(xpath="(//som-input[@input-id='govAddress']//input[@type='text'])[1]")
    WebElement Address;
    
    @FindBy(xpath="//input[@id='govAddressCity']")
    WebElement City;
    
    @FindBy(xpath="//select[./option[text()='MI']]")
    WebElement State;
    
    @FindBy(xpath="//input[@id='govAddressZip']")
    WebElement ZipCode;
    
    @FindBy(xpath="//button[@type='submit' and @aria-label='Save']//div[contains(@class, 'btn-content')]")
    WebElement Save;
    
    @FindBy(xpath="//som-radio-button-group[@label='Shares Geography with Michigan' and @required-ind='true']")
    WebElement SharesGeogrpahyWithMichigan;
    
    @FindBy(xpath="//label[@for='regionCd']/following-sibling::select")
    WebElement Region;
    
    @FindBy(xpath="//som-grid//table/tbody/tr[7]/td[1]//som-button/button")
    WebElement Edit;
    
    @FindBy(xpath="//a[@href='/ecomod/TribalNations' and normalize-space()='Back']")
    WebElement Back;
    
    @FindBy(xpath="//button[@aria-label='Leave']//div[text()='Leave']")
    WebElement Leave;
    
    @FindBy(xpath="//div[@class='headline has-icon' and text()='Tribal Nation saved successfully.']")
    WebElement TribalNationSaved;
    
    @FindBy(xpath="//som-alert[@type='error' and @headline='Error on page']")
    WebElement ErrorOnPage;

public void TribalNations() 
{
	TribalMainNav.click();
	TribalNations.click();
}
public void ClickAdd() 
{
	Add.click();
}

public void ClickBack()
{
	Back.click();
}

public void InsertTribalNationName(String tribalNation) {
	TribalNationName.sendKeys(tribalNation);

}
public void InsertShortName(String shortName) 
{
	ShortName.sendKeys(shortName);
}
public void InsertAddress(String address) 
{
	Address.sendKeys(address);
}

public void SelectState(String state) 
{
	Select select = new Select(State); 
    select.selectByVisibleText(state);
	    
}
public void InsertCity(String city) 
{
	City.sendKeys(city);
}
public void InsertZipCode(String zipCode) 
{
	ZipCode.sendKeys(zipCode);
}

public void ClickSave() 
{
	Save.click();
}
public void ClickLeave() 
{
	Leave.click();
}
public void InsertNewTribalNation(String newTribalNation) throws Exception {
    WebElement tribalNationField = driver.findElement(By.xpath("//input[@id='trblNatnName']"));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(tribalNationField));
    Thread.sleep(3000);
    tribalNationField.clear();
    Thread.sleep(3000);
    tribalNationField.sendKeys(newTribalNation);
}
public void InsertNewShortName(String newShortName) throws Exception {
    WebElement shortNameField = driver.findElement(By.xpath("//som-input[@input-id='shortDesc']//input[@type='text']"));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(shortNameField));
    Thread.sleep(3000);
    shortNameField.clear();
    Thread.sleep(3000);
    shortNameField.sendKeys(newShortName);
}
public void SelectNewRegion(String newRegion) throws InterruptedException 
{
	Thread.sleep(3000);
	Select select = new Select(Region);
	Thread.sleep(3000);
    select.selectByVisibleText(newRegion);
}

public void selectSharesGeographyWithMichigan(String selection) {
    System.out.println("### Selecting 'Shares Geography with Michigan' option...");
    try {
        // XPath for the radio button group
        String radioButtonGroupXpath = "/html/body/div/div/main/div/div/div[2]/div[4]/div[1]/som-radio-button-group";

        // Determine which radio button to select
        String optionXpath;
        if (selection.equalsIgnoreCase("Yes")) {
            optionXpath = radioButtonGroupXpath + "//som-radio-button[@label='Yes']";
        } else if (selection.equalsIgnoreCase("No")) {
            optionXpath = radioButtonGroupXpath + "//som-radio-button[@label='No']";
        } else {
            throw new IllegalArgumentException("Invalid selection for 'Shares Geography with Michigan': " + selection);
        }

        // Locate and click the radio button
        WebElement radioButton = driver.findElement(By.xpath(optionXpath));
        radioButton.click();

        // Log success
        test.log(LogStatus.INFO, "'Shares Geography with Michigan' option set to: " + selection);

    } catch (Exception e) {
        e.printStackTrace();
        // Log failure
        test.log(LogStatus.FAIL, "Failed to select 'Shares Geography with Michigan' option: " + e.getMessage());
        throw new RuntimeException("Failed to select 'Shares Geography with Michigan' option", e);
    }
}



public void SelectRegion(String region) throws InterruptedException 
{
	Thread.sleep(3000);
	Select select = new Select(Region);
	Thread.sleep(3000);
    select.selectByVisibleText(region);
	    
}
public void ClickEdit(String tribalNation) {
    try {
        System.out.println("### Clicking edit button for Tribal Nation: " + tribalNation);
        // Construct a dynamic XPath based on the `aria-label` attribute
        String xpath = "//button[contains(@aria-label, 'Edit') and contains(@aria-label, 'TribalNation: " + tribalNation.trim() + "')]";
        System.out.println("Generated XPath: " + xpath);
        
        // Wait for the element to be visible and clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

        // Click the edit button
        editButton.click();
        System.out.println("### Successfully clicked the edit button for Tribal Nation: " + tribalNation);
        test.log(LogStatus.PASS, "Clicked edit button for Tribal Nation: " + tribalNation);
    } catch (Exception e) {
        e.printStackTrace();
        test.log(LogStatus.FAIL, "Failed to click edit button for Tribal Nation: " + tribalNation + ". Error: " + e.getMessage());
        throw new RuntimeException("Failed to click edit button for Tribal Nation: " + tribalNation, e);
    }
}
public void InsertNewTribalNationName(String TribalNation) throws Exception {
    WebElement tribalNationNameField = driver.findElement(By.xpath("//input[@id='trblNatnName']"));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(tribalNationNameField));
    Thread.sleep(5000);
    tribalNationNameField.clear();
    Thread.sleep(5000);
    tribalNationNameField.sendKeys(TribalNation,TribalNation);
    
}

public Boolean validateTribalNationInTable(String region, String tribalNation, String address) throws IOException {
    System.out.println("### Inside Function validateTribalNationInTable...");
    try {
        // Wait for the table to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//som-grid[@id='data-grid']")));

        // Locate the specific row based on provided details
        String rowXpath = "//som-grid[@id='data-grid']//tr[td[contains(normalize-space(),'" + region + "')] and td[contains(normalize-space(),'" + tribalNation + "')] and td[contains(normalize-space(),'" + address + "')]]";
        System.out.println(rowXpath);
        WebElement row = driver.findElement(By.xpath(rowXpath));

        // Retrieve columns for validation
        List<WebElement> columns = row.findElements(By.xpath(".//td"));
        int i = 0;
        Boolean isValid = true;

        for (WebElement column : columns) {
            // Validate each column based on expected order
        	//System.out.println(i+""+ column.getText()+" " + region);
        	if (i ==1) {if (column.getText().equals(region)) {} else { return false;} } // Validate Region
        	if (i ==2) {if (column.getText().equals(tribalNation)) {} else { return false;} } // Validate Tribal Nation
        	if (i ==3) {if (column.getText().equals(address)) {} else { return false;} } // Validate Address
            i++;
        }

        // Log success
        test.log(LogStatus.INFO, "Validation of Tribal Nation with Region: " + region + ", Tribal Nation: " + tribalNation + ", and Address: " + address + " is successful!");
        return isValid;

    } catch (Exception e) {
        e.printStackTrace();
        // Log failure with screenshot
        String screenShotName = TestUtil.captureScreenShot();
        test.log(LogStatus.FAIL, "Validation failed due to an exception: " + e.getMessage() + "<br/> Check screenshot for details.");
        test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
    }
    return false ;
}
public boolean validateDuplicateContactError(String expectedHeadlineErrorMessage, String expectedDetailedErrorMessage) throws Exception {
    System.out.println("### Inside Function validateDuplicateContactError...");
    try {
        // Wait for the error message to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement errorMessageHeadlineElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='commonAlert']//div[@class='alert-content']//div[1]")));
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='commonAlert']//div[@class='alert-content']//div[2]")));

        // Capture the actual error message text
        String headlineErrorMessage = errorMessageHeadlineElement.getText();
        System.out.println("Headline Error: " + headlineErrorMessage);
        String actualErrorMessage = errorMessageElement.getText();
        System.out.println("Detailed Error: " + actualErrorMessage);

        // Validate both error messages
        boolean isHeadlineValid = headlineErrorMessage.equals(expectedHeadlineErrorMessage);
        boolean isDetailedValid = actualErrorMessage.equals(expectedDetailedErrorMessage);

        if (isHeadlineValid && isDetailedValid) {
            // Log success with screenshots
            String screenShotName = TestUtil.captureScreenShot();
            test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
            test.log(LogStatus.PASS, "Both error messages validated successfully: " 
                + "Headline: " + headlineErrorMessage 
                + ", Detailed: " + actualErrorMessage);
            return true; // Validation is successful
        } else {
            // Log failure with a screenshot
            String screenShotName = TestUtil.captureScreenShot();
            test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
            test.log(LogStatus.FAIL, "Error message validation failed: <br/>"
                + "Expected Headline: " + expectedHeadlineErrorMessage + "<br/>"
                + "Actual Headline: " + headlineErrorMessage + "<br/>"
                + "Expected Detailed: " + expectedDetailedErrorMessage + "<br/>"
                + "Actual Detailed: " + actualErrorMessage);
            return false;
        }
    } catch (NoSuchElementException e) {
        // Log NoSuchElementException with a screenshot
        String screenShotName = TestUtil.captureScreenShot();
        test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
        test.log(LogStatus.FAIL, "Error message element not found. Exception: " + e.getMessage());
        e.printStackTrace();
        return false;
    } catch (Exception e) {
        // Log any other exception with a screenshot
        String screenShotName = TestUtil.captureScreenShot();
        test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
        test.log(LogStatus.FAIL, "An exception occurred during validation: " + e.getMessage());
        e.printStackTrace();
    }
    if(this.Leave.isDisplayed())
    {this.Leave.click();}
	return false;
}






public Boolean validateEditedTribalNation(String NewTribalNation, String NewShortName, String NewRegion) throws IOException {
    System.out.println("### Inside Function validateEditedTribalNation...");
    try {
        // Wait for the table to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//som-grid[@id='data-grid']")));

        // Locate the specific row that contains all three values in the same row
        String rowXpath = "//som-grid[@id='data-grid']//tr[td[contains(normalize-space(),'" + NewTribalNation + "')] and td[contains(normalize-space(),'" + NewShortName + "')] and td[contains(normalize-space(),'" + NewRegion + "')]]";
        WebElement row = driver.findElement(By.xpath(rowXpath));

        // If the row is found, validation is successful
        test.log(LogStatus.INFO, "Validation of Edited Tribal Nation: " + NewTribalNation + ", Short Name: " + NewShortName + ", Region: " + NewRegion + " is successful!");
        return true;

    } catch (NoSuchElementException e) {
        // If no row is found, validation failed
        test.log(LogStatus.FAIL, "Validation failed. Could not find a row with Tribal Nation: " + NewTribalNation + ", Short Name: " + NewShortName + ", Region: " + NewRegion);
        return false;
    } catch (Exception e) {
        e.printStackTrace();
        // Log failure with screenshot
        String screenShotName = TestUtil.captureScreenShot();
        test.log(LogStatus.FAIL, "Validation failed due to an exception: " + e.getMessage() + "<br/> Check screenshot for details.");
        test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
    }
    return false;
}
public void validateNationAddition() {
    System.out.println("### Inside Function ValidateContactAddition...");
    try {
        // Check if "Tribal Nation saved successfully." message is displayed
        if (TribalNationSaved.isDisplayed()) {
            System.out.println("Tribal Nation saved successfully.");
            test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
         
        } 
    } catch (Exception e) {
        System.out.println("This message is not found");
    }
    
    try {
        
        if (ErrorOnPage.isDisplayed()) {
            System.out.println("Error Message is dispplayed");
            
            test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
            Back.click();
            Thread.sleep(1000);
            Leave.click();
        } else {
            System.out.println("No modal dialog displayed for duplicate contact.");
        }
    } catch (Exception e) {
        System.out.println("No modal dialog found");
    }

 
}

}






