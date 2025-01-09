package gov.michigan.mdot.automation.ECOMod.pages;
import gov.michigan.mdot.automation.base.TestBase;
import gov.michigan.mdot.automation.utilities.CommonLibsFramework;
import gov.michigan.mdot.automation.utilities.TestUtil;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
public class TribalNationContactListPage  extends BasePage{
	
	String screenShotName = "";
   
    public TribalNationContactListPage( WebDriver driver )
    {
        super( driver );
    }
    
    
    @FindBy(xpath= "//som-header//som-button-dropdown//div[text()='Tribal']")
   	WebElement TribalMainNav;
    
    @FindBy(xpath ="//som-button-dropdown//a[normalize-space(text())='Tribal Nation Contact List']")
   	WebElement TribalNationContactList;
    
    @FindBy(xpath="//som-button[@color='primary']//button[@aria-label='Add a tribal contact']")
    WebElement Add;
   
    @FindBy(xpath="//input[@id='firstName']")
    WebElement FirstName;
    
    @FindBy(xpath="//input[@id='lastName']")
    WebElement LastName;
    
    @FindBy(xpath="//input[@id='contactRole']")
    WebElement Role;
    
    @FindBy(xpath="//select[./option[text()='Test Tribal Nation']]")
    WebElement TribalNation;
  
    @FindBy(xpath="//button[@aria-label='Save']")
    WebElement Save;
    
    @FindBy(xpath="(//button[@aria-label='Cancel'])[1]")
    WebElement Cancel;
    
    @FindBy(xpath="//button[@aria-label='Edit Test Test']")
    WebElement Edit;
    
    @FindBy(xpath="//som-checkbox[@id='sect106Ind']//label")
    WebElement Section106Protected;
    
    @FindBy(xpath="//som-alert[contains(@class, 'alert')]//div[contains(text(), 'Contact successfully added')]")
    WebElement ContactSuccessfullyAdded;
    
    @FindBy(xpath="//som-modal[@id='tribalNationContactModal']//dialog[@class='modal modal-lg' and @open]")
    WebElement AddATribalNationContactModal;
    
    @FindBy(xpath ="//dialog[@class='modal modal-lg' and @open]//button[@class='close-button' and @aria-label='Close modal']")
	WebElement xButton;
    
    @FindBy(xpath="//som-modal[@id='tribalNationContactModal']//som-alert[@type='error']//div[contains(@class, 'alert-content') and .//div[text()='Error on page']]")
    WebElement ErrorOnPage;
    
    @FindBy(xpath="//input[@id='som-input61' and @type='search' and @placeholder='Search...']")
    WebElement SearchContact;

public void TribalNationContactList() 
{
	TribalMainNav.click();
	TribalNationContactList.click();

	
}

public void ClickAdd() 
{
	Add.click();
}
public void ClickSave() 
{
	Save.click();
}

public void ClickCancel() 
{
	Cancel.click();
}
public void ClickSection106Protectected() 
{
	Section106Protected.click();
}
public void InsertFirstName(String firstName) {
	FirstName.sendKeys(firstName);

}
public void InsertLastName(String lastName) 
{
	LastName.sendKeys(lastName);
}
public void InsertRole(String role) 
{
	
	Role.sendKeys(role);
}

public void SelectTribalNation(String tribalNation) 
{
	Select select = new Select(TribalNation); 
    select.selectByVisibleText(tribalNation);
	    
}
public void searchForEditedContact(String newFirstName, String newLastName) throws Exception {
    // Combine first name and last name
    String fullName = newFirstName + " " + newLastName;

    // Locate the search box using its unique XPath
    WebElement searchBox = driver.findElement(By.xpath("//input[@id='som-input61' and @type='search' and @placeholder='Search...']"));

    // Wait until the search box is visible and clickable
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(searchBox));

    // Enter the full name into the search box
    searchBox.clear();
    Thread.sleep(1000); // Optional: Ensure the field is cleared
    searchBox.sendKeys(fullName);

    // Add a delay to allow search results to update (if necessary)
    Thread.sleep(2000);

    // Optional: Validate the result in the table or list
    WebElement searchResult = driver.findElement(By.xpath("//table//td[contains(text(),'" + fullName + "')]"));
    if (searchResult.isDisplayed()) {
        System.out.println("Search successful: Contact " + fullName + " found.");
    } else {
        System.out.println("Search failed: Contact " + fullName + " not found.");
    }
}

public void ClickEdit(String firstName, String lastName) {
    String fullName = firstName + " " + lastName;
    String xpath = "//button[@aria-label='Edit " + fullName + "']";
    WebElement editButton = driver.findElement(By.xpath(xpath));
    editButton.click();
}
public void InsertNewFirstName(String newFirstName) throws Exception {
    WebElement firstNameField = driver.findElement(By.xpath("//input[@id='firstName']"));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(firstNameField));
    Thread.sleep(3000);
    firstNameField.clear();
    Thread.sleep(3000);
    firstNameField.sendKeys(newFirstName);
}
public void InsertNewLastName(String newLastName) throws Exception {
    WebElement lastNameField = driver.findElement(By.xpath("//input[@id='lastName']"));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(lastNameField));
    Thread.sleep(3000);
    lastNameField.clear();
    Thread.sleep(3000);
    lastNameField.sendKeys(newLastName);
}
public void InsertNewRole(String newRole) throws Exception {
    WebElement roleField = driver.findElement(By.xpath("//input[@id='contactRole']"));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(roleField));
    Thread.sleep(3000);
    roleField.clear();
    Thread.sleep(3000);
    roleField.sendKeys(newRole);
}


public Boolean validateTribalContactInTable(String firstName, String lastName, String tribalNation) {
    System.out.println("### Inside Function validateTribalContactInTable...");
    try {
        // Wait for the table to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@aria-label='Data Table for Tribal Nation Contact List']")));

        // Locate the specific row based on provided details
        String rowXpath = "//table[@aria-label='Data Table for Tribal Nation Contact List']//tr[td[contains(normalize-space(),'" + firstName + "')] and td[contains(normalize-space(),'" + lastName + "')] and td[contains(normalize-space(),'" + tribalNation + "')]]";
        WebElement row = driver.findElement(By.xpath(rowXpath));

        // Retrieve columns for validation
        List<WebElement> columns = row.findElements(By.xpath(".//td"));
        int i = 0;
        Boolean isValid = true;

        for (WebElement column : columns) {
            // Validate each column based on expected order
            if (i == 0 && !column.getText().equals(firstName)) return false;
            if (i == 1 && !column.getText().equals(lastName)) return false;
            if (i == 2 && !column.getText().equals(tribalNation)) return false;
            i++;
        }

        test.log(LogStatus.INFO, "Validation of contact with First Name: " + firstName + ", Last Name: " + lastName + ", and Tribal Nation: " + tribalNation + " is successful!");
        return isValid;

    } catch (Exception e) {
        e.printStackTrace();
        test.log(LogStatus.FAIL, "Validation failed due to an exception: " + e.getMessage());
    }
    return false;
}

public boolean validateDuplicateContactError(String expectedFirstNameError, String expectedLastNameError, String expectedTribalNationError) throws Exception {
    System.out.println("### Inside Function validateDuplicateContactError...");
    try {
        // Locate and capture the error messages
        String firstNameErrorText = driver.findElement(By.xpath("//small[@id='firstName-help' and contains(@class, 'form-text text-error')]")).getText();
        System.out.println("This contact already exists.");
        String lastNameErrorText = driver.findElement(By.xpath("//*[@id='lastName-help']")).getText();
        System.out.println("This contact already exists.");
        String tribalNationErrorText = driver.findElement(By.xpath("//*[@id='trblNatnId-help']")).getText();
        System.out.println("This contact already exists.");

        // Validate the error messages
        if (firstNameErrorText.equals(expectedFirstNameError) &&
            lastNameErrorText.equals(expectedLastNameError) &&
            tribalNationErrorText.equals(expectedTribalNationError)) {

            String screenShotName = TestUtil.captureScreenShot();
            test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
            test.log(LogStatus.PASS, "Duplicate contact error messages validated successfully: <br/>" +
                    "First Name Error: " + firstNameErrorText + "<br/>" +
                    "Last Name Error: " + lastNameErrorText + "<br/>" +
                    "Tribal Nation Error: " + tribalNationErrorText);
        } else {
            String screenShotName = TestUtil.captureScreenShot();
            test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
            test.log(LogStatus.FAIL, "Error messages validation failed: <br/>" +
                    "Expected First Name Error: " + expectedFirstNameError + ", but found: " + firstNameErrorText + "<br/>" +
                    "Expected Last Name Error: " + expectedLastNameError + ", but found: " + lastNameErrorText + "<br/>" +
                    "Expected Tribal Nation Error: " + expectedTribalNationError + ", but found: " + tribalNationErrorText);
        }
    } catch (Exception e) {
        String screenShotName = TestUtil.captureScreenShot();
        test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
        test.log(LogStatus.FAIL, "An exception occurred during validation: " + e.getMessage() + "<br/> Check screenshot for details.");
        e.printStackTrace();
    }
    if(this.Cancel.isDisplayed())
    {this.Cancel.click();}
    
    
	return false;
}


public Boolean validateEditedContact(String newFirstName, String newLastName, String newRole) throws Exception {
    System.out.println("### Inside Function validateEditedContact...");
    try {
        // Wait for the table to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@aria-label='Data Table for Tribal Nation Contact List']")));

        // Locate the specific row based on provided details
        String rowXpath = "//table[@aria-label='Data Table for Tribal Nation Contact List']//tr[td[contains(normalize-space(),'" + newFirstName + "')] and td[contains(normalize-space(),'" + newLastName + "')] and td[contains(normalize-space(),'" + newRole + "')]]";
        WebElement row = driver.findElement(By.xpath(rowXpath));

        // Retrieve columns for validation
        List<WebElement> columns = row.findElements(By.xpath(".//td"));
        int i = 0;
        Boolean isValid = true;

        for (WebElement column : columns) {
            // Validate each column based on expected order
            if (i == 0 && !column.getText().equals(newFirstName)) return false;
            if (i == 1 && !column.getText().equals(newLastName)) return false;
            if (i == 2 && !column.getText().equals(newRole)) return false;
            i++;
        }

        // Log and take a screenshot for validation
        String screenShotName = TestUtil.captureScreenShot();
        test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
        test.log(LogStatus.PASS, "Validation of updated contact with First Name: " + newFirstName + ", Last Name: " + newLastName + ", and Role: " + newRole + " is successful!");

        return isValid;

    } catch (Exception e) {
        e.printStackTrace();
        String screenShotName = TestUtil.captureScreenShot();
        test.log(LogStatus.FAIL, "Validation failed due to an exception: " + e.getMessage() + "<br/> Check screenshot for details.");
        test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
    }
    return false;
}

public void validateContactAddition() {
    System.out.println("### Inside Function ValidateContactAddition...");
    try {
        // Check if "Contact successfully added" message is displayed
        if (ContactSuccessfullyAdded.isDisplayed()) {
            System.out.println("Contact successfully added message is displayed.");
            test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
         
        } 
    } catch (Exception e) {
        System.out.println("This message is not found");
    }
    
    try {
        // Check if the modal dialog appears when adding a duplicate contact
        if (ErrorOnPage.isDisplayed()) {
            System.out.println("Error Message is dispplayed");
            // Click the 'x' button to close the modal
            test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
            Cancel.click();
            Thread.sleep(1000);
        } else {
            System.out.println("No modal dialog displayed for duplicate contact.");
        }
    } catch (Exception e) {
        System.out.println("No modal dialog found");
    }

 
}


}



