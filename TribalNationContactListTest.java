package gov.michigan.mdot.automation.ECOMod.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import gov.michigan.mdot.automation.ECOMod.pages.CoordinatorsAdminTasksPage;
import gov.michigan.mdot.automation.ECOMod.pages.NavigationPage;
import gov.michigan.mdot.automation.ECOMod.pages.TribalNationContactListPage;
import gov.michigan.mdot.automation.base.TestBase;
import gov.michigan.mdot.automation.listeners.CustomListener;
import gov.michigan.mdot.automation.utilities.TestUtil;
import gov.michigan.mdot.automation.ECOMod.pages.CoordinatorsAdminTasksPage;
import gov.michigan.mdot.automation.ECOMod.pages.NavigationPage;


@Listeners(CustomListener.class)
public class TribalNationContactListTest extends TestBase
{
    /**
     * Rigorous Test :-)
     * @throws IOException 
     * @throws InterruptedException 
     * @throws Exception 
     */
  @Test(enabled=true,dataProvider="AddTribalContactData", priority =1)
   
   public void AddTribalNationContact(String FirstName, String LastName, String Role, String TribalNation) throws IOException, InterruptedException {
	    System.out.println("### Inside Function AddTribalNationContact...");
	    test.log(LogStatus.INFO, "<b>Test Case:</b> AddTribalNationContact <br/>"
	            + "<b>Test Description#</b><br/>"
	            + "<b>Page:</b> /ecomod/TribalNationContacts <br/>"
	            + "<b>Steps:</b><br/>"
	            + "1. Navigate to Tribal Nation Contact List<br/>"
	            + "2. Click the Add button<br/>"
	            + "3. Insert First Name<br/>"
	            + "4. Insert Last Name<br/>"
	            + "5. Insert Role<br/>"
	            + "6. Select Tribal Nation<br/>"
	            + "7. Click Save<br/>"
	            + "8. Validate that the contact is added<br/>"
	            + "<b>Test Data:</b> FirstName: " + FirstName
	            + "; LastName: " + LastName
	            + "; Role: " + Role
	            + "; TribalNation: " + TribalNation);

	    
	        TribalNationContactListPage tribalNationContactListPage = new TribalNationContactListPage(driver);
	        NavigationPage navigationPage = new NavigationPage(driver);
	        // Step 1: Navigate to Tribal Nation Contact List
	        //tribalNationContactListPage.TribalNationContactList();
	        navigationPage.NavigateToTribalNationContactList();
	        test.log(LogStatus.PASS, "<b>Step 1:</b> Navigate to Tribal Nation Contact List - <b>Done!</b>");
	        
	        String screenShotName = TestUtil.captureScreenShot();
			test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
	        
	        // Step 2: Click the Add button
	        tribalNationContactListPage.ClickAdd();
	        test.log(LogStatus.PASS, "<b>Step 2:</b> Click the Add button - <b>Done!</b>");
	        
	        screenShotName = TestUtil.captureScreenShot();
			test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));

	        // Step 3: Insert First Name
	        tribalNationContactListPage.InsertFirstName(FirstName);
	        test.log(LogStatus.PASS, "<b>Step 3:</b> Insert First Name - <b>Done!</b>");

	        // Step 4: Insert Last Name
	        tribalNationContactListPage.InsertLastName(LastName);
	        test.log(LogStatus.PASS, "<b>Step 4:</b> Insert Last Name - <b>Done!</b>");

	        // Step 5: Insert Role
	        tribalNationContactListPage.InsertRole(Role);
	        test.log(LogStatus.PASS, "<b>Step 5:</b> Insert Role - <b>Done!</b>");

	        // Step 6: Select Tribal Nation
	        tribalNationContactListPage.SelectTribalNation(TribalNation);
	        test.log(LogStatus.PASS, "<b>Step 6:</b> Select Tribal Nation - <b>Done!</b>");
	        
	        screenShotName = TestUtil.captureScreenShot();
			test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));

	        // Step 7: Click Save
	        tribalNationContactListPage.ClickSave();
	        Thread.sleep(3000);
	        screenShotName = TestUtil.captureScreenShot();
			test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
	        
			
            tribalNationContactListPage.validateContactAddition();
			
	        test.log(LogStatus.PASS, "<b>Step 7:</b> Click Save - <b>Done!</b>");
	  
	       //Step 8: Validate that the contact is added
	        tribalNationContactListPage.validateTribalContactInTable(FirstName, LastName, TribalNation);
  }

   
  @Test(enabled=true,dataProvider="AddTribalContactData", priority =2)
   
  public void AddSameTribalNationContact(String FirstName, String LastName, String Role, String TribalNation) throws Exception {
	    System.out.println("### Inside Function AddSameTribalNationContact...");
	    
	    // Define the expected error messages
	    String expectedFirstNameError = "This contact already exists.";
	    String expectedLastNameError = "This contact already exists.";
	    String expectedTribalNationError = "This contact already exists.";
	    
	    test.log(LogStatus.INFO, "<b>Test Case:</b> AddSameTribalNationContact <br/>"
	            + "<b>Test Description#</b><br/>"
	            + "<b>Page:</b> /ecomod/TribalNationContacts <br/>"
	            + "<b>Steps:</b><br/>"
	            + "1. Navigate to Tribal Nation Contact List<br/>"
	            + "2. Click the Add button<br/>"
	            + "3. Insert Same First Name<br/>"
	            + "4. Insert Same Last Name<br/>"
	            + "5. Insert Same Role<br/>"
	            + "6. Select Same Tribal Nation<br/>"
	            + "7. Click Save<br/>"
	            + "8. Validate duplicate contact error messages<br/>"
	            + "<b>Test Data:</b><br/>"
	            + "FirstName: " + FirstName + "<br/>"
	            + "LastName: " + LastName + "<br/>"
	            + "Role: " + Role + "<br/>"
	            + "TribalNation: " + TribalNation);

	        TribalNationContactListPage tribalNationContactListPage = new TribalNationContactListPage(driver);

	        // Step 1: Navigate to Tribal Nation Contact List
	        tribalNationContactListPage.TribalNationContactList();
	        test.log(LogStatus.PASS, "<b>Step 1:</b> Navigate to Tribal Nation Contact List - <b>Done!</b>");
	        String screenShotName = TestUtil.captureScreenShot();
			test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));

	        // Step 2: Click the Add button
	        tribalNationContactListPage.ClickAdd();
	        test.log(LogStatus.PASS, "<b>Step 2:</b> Click the Add button - <b>Done!</b>");
	        screenShotName = TestUtil.captureScreenShot();
			test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));

	        // Step 3: Insert Same First Name
	        tribalNationContactListPage.InsertFirstName(FirstName);
	        test.log(LogStatus.PASS, "<b>Step 3:</b> Insert Same First Name - <b>Done!</b>");
	        screenShotName = TestUtil.captureScreenShot();
			test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));

	        // Step 4: Insert Same Last Name
	        tribalNationContactListPage.InsertLastName(LastName);
	        test.log(LogStatus.PASS, "<b>Step 4:</b> Insert Same Last Name - <b>Done!</b>");
	        screenShotName = TestUtil.captureScreenShot();
			test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));

	        // Step 5: Insert Same Role
	        tribalNationContactListPage.InsertRole(Role);
	        test.log(LogStatus.PASS, "<b>Step 5:</b> Insert Same Role - <b>Done!</b>");
	        screenShotName = TestUtil.captureScreenShot();
			test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));

	        // Step 6: Select Same Tribal Nation
	        tribalNationContactListPage.SelectTribalNation(TribalNation);
	        test.log(LogStatus.PASS, "<b>Step 6:</b> Select Same Tribal Nation - <b>Done!</b>");
	        screenShotName = TestUtil.captureScreenShot();
			test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));

	        // Step 7: Click Save
	        tribalNationContactListPage.ClickSave();
	        test.log(LogStatus.PASS, "<b>Step 7:</b> Click Save - <b>Done!</b>");
	        screenShotName = TestUtil.captureScreenShot();
			test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));

	        // Step 8: Validate duplicate contact error messages
	        tribalNationContactListPage.validateDuplicateContactError(expectedFirstNameError, expectedLastNameError, expectedTribalNationError);
  
  }
	


    		
   @Test(enabled=true,dataProvider="EditTribalContactData",priority =3)
    public void EditTribalNationContact(String FirstName, String LastName, String Role, String NewFirstName, String NewLastName, String NewRole) throws Exception {
        System.out.println("### Inside Function EditTribalNationContact...");
        String screenShotName = "";
        test.log(LogStatus.INFO, "<b>Test Case:</b> EditTribalNationContact <br/>"
                + "<b>Test Description#</b><br/>"
                + "<b>Page:</b> /ecomod/TribalNationContacts <br/>"
                + "<b>Steps:</b><br/>"
                + "1. Navigate to Tribal Nation Contact List<br/>"
                + "2. Click the Edit button for the created contact<br/>"
                + "3. Insert New First Name<br/>"
                + "4. Insert New Last Name<br/>"
                + "5. Insert New Role<br/>"
                + "6. Click Save<br/>"
                + "7. Validate that the edited contact is updated<br/>"
                + "<b>Test Data:</b><br/>"
                + "FirstName: " + FirstName + "<br/>"
                + "LastName: " + LastName + "<br/>"
                + "Role: " + Role + "<br/>"
                + "NewFirstName: " + NewFirstName + "<br/>"
                + "NewLastName: " + NewLastName + "<br/>"
                + "NewRole: " + NewRole);
                

            TribalNationContactListPage tribalNationContactListPage = new TribalNationContactListPage(driver);

            // Step 1: Navigate to Tribal Nation Contact List
            tribalNationContactListPage.TribalNationContactList();
            screenShotName = TestUtil.captureScreenShot();
			test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
			
            test.log(LogStatus.PASS, "<b>Step 1:</b> Navigate to Tribal Nation Contact List - <b>Done!</b>");

            // Step 2: Click the Edit button for the created contact
            tribalNationContactListPage.ClickEdit(FirstName, LastName);
            screenShotName = TestUtil.captureScreenShot();
			test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
            test.log(LogStatus.PASS, "<b>Step 2:</b> Click the Edit button for the created contact - <b>Done!</b>");
            
            // Step 3: Insert New First Name
	        tribalNationContactListPage.InsertNewFirstName(NewFirstName);
	        test.log(LogStatus.PASS, "<b>Step 3:</b> Insert New First Name - <b>Done!</b>");
	        screenShotName = TestUtil.captureScreenShot();
			test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));

	        // Step 4: Insert New Last Name
	        tribalNationContactListPage.InsertNewLastName(NewLastName);
	        test.log(LogStatus.PASS, "<b>Step 4:</b> Insert Same Last Name - <b>Done!</b>");
	        screenShotName = TestUtil.captureScreenShot();
			test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));

	        // Step 5: Insert Same Role
	        tribalNationContactListPage.InsertNewRole(NewRole);
	        test.log(LogStatus.PASS, "<b>Step 5:</b> Insert Same Role - <b>Done!</b>");
	        screenShotName = TestUtil.captureScreenShot();
			test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
            
            // Step 6: Click Save
            tribalNationContactListPage.ClickSave();
            Thread.sleep(3000);
	        screenShotName = TestUtil.captureScreenShot();
			test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
			Thread.sleep(2000);
            tribalNationContactListPage.validateContactAddition();
	        test.log(LogStatus.PASS, "<b>Step 6:</b> Click Save - <b>Done!</b>");
      
            // Step 7: Validate that the edited contact is updated
           tribalNationContactListPage.validateEditedContact(NewFirstName, NewLastName, NewRole);
           screenShotName = TestUtil.captureScreenShot();
		   test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
            
   }
   
    @BeforeClass
    public void setup() throws IOException, Exception{
    	  System.setProperty("webdriver.edge.driver", "true");
    	  loginAndOpenMiLoginApp(System.getProperty("URL"),
    			  OR.getProperty("UserID"), OR.getProperty("Password"),
    					"MDOT Environmental Clearance Organizer - ECOMOD");

    	   }

    @AfterClass
    public void logOut() throws IOException{
    		miLoginHomePage.logout();
    	}
		
	@DataProvider 
	public Object[][] AddTribalContactData() throws Exception { 
		return excelReader.getTableArray("AddTribalContact"); 
		}
	@DataProvider 
	public Object[][] EditTribalContactData() throws Exception { 
		return excelReader.getTableArray("EditTribalContact"); 
		}	 
}
