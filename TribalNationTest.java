package gov.michigan.mdot.automation.ECOMod.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
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
import gov.michigan.mdot.automation.ECOMod.pages.TribalNationsPage;
import gov.michigan.mdot.automation.base.TestBase;
import gov.michigan.mdot.automation.listeners.CustomListener;
import gov.michigan.mdot.automation.utilities.TestUtil;
import gov.michigan.mdot.automation.ECOMod.pages.CoordinatorsAdminTasksPage;
import gov.michigan.mdot.automation.ECOMod.pages.NavigationPage;


@Listeners(CustomListener.class)
public class TribalNationTest extends TestBase
{
    /**
     * Rigorous Test :-)
     * @throws Exception 
     * @throws Exception 
     */
   @Test(enabled=true,dataProvider="AddTribalNationData", priority =1)
    		 public void AddTribalNation(String TribalNation, String ShortName, String SharesGeographyWithMichigan, String Region,String Address, String City, String State, String ZipCode) throws Exception {
    System.out.println("### Inside Function AddTribalNation...");
    test.log(LogStatus.INFO, "<b>Test Case:</b> AddTribalNation <br/> "
            + "<b>Test Description#</b><br/>"
            + "<b>Page:</b> /ecomod/TribalNations <br/>"
            + "<b>Steps:</b><br/>"
            + "1. Navigate to Tribal Nations<br/>"
            + "2. Click the Add button<br/>"
            + "3. Insert Tribal Nation Name<br/>"
            + "4. Insert Short Name<br/>"
            + "5. Select Shares Geograhphy with Michigan<br/>"
            +" 6. Select Region<br/>"
            + "7. Insert Address<br/>"
            + "8. Insert City<br/>"
            + "9. Select State<br/>"
            + "10. Insert Zip Code<br/>"
            + "11. Click Save<br/>"
            + "<b>Test Data:</b> TribalNation: " + TribalNation
            + "; ShortName: " + ShortName
            + "; ShareGeographyWithMichigan:" + SharesGeographyWithMichigan
            + "; Address: " + Address
            + "; City: " + City
            + "; State: " + State
            + "; ZipCode: " + ZipCode);

   
        TribalNationsPage tribalNationsPage = new TribalNationsPage(driver);

        // Step 1: Navigate to Tribal Nations
        tribalNationsPage.TribalNations();
        String screenShotName = TestUtil.captureScreenShot();
        test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
        test.log(LogStatus.PASS, "<b>Step 1:</b> Navigate to Tribal Nations - <b>Done!</b>");

        // Step 2: Click the Add button
        tribalNationsPage.ClickAdd();
        screenShotName = TestUtil.captureScreenShot();
        test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
        test.log(LogStatus.PASS, "<b>Step 2:</b> Click the Add button - <b>Done!</b>");

        // Step 3: Insert Tribal Nation Name
        tribalNationsPage.InsertTribalNationName(TribalNation);
        screenShotName = TestUtil.captureScreenShot();
        test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
        test.log(LogStatus.PASS, "<b>Step 3:</b> Insert Tribal Nation Name - <b>Done!</b>");

        // Step 4: Insert Short Name
        tribalNationsPage.InsertShortName(ShortName);
        screenShotName = TestUtil.captureScreenShot();
        test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
        test.log(LogStatus.PASS, "<b>Step 4:</b> Insert Short Name - <b>Done!</b>");
        
        // Step 5: Select Shares Geography With Michigan
        tribalNationsPage.selectSharesGeographyWithMichigan(SharesGeographyWithMichigan);
        screenShotName = TestUtil.captureScreenShot();
        test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
        test.log(LogStatus.PASS, "<b>Step 5:</b> Select Shares Geography with Michigan - <b>Done!</b>");
        
        // Step 6: Select Region
        tribalNationsPage.SelectRegion(Region);
        screenShotName = TestUtil.captureScreenShot();
        test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
        test.log(LogStatus.PASS, "<b>Step 6:</b> Select Region - <b>Done!</b>");

        // Step 7: Insert Address
        tribalNationsPage.InsertAddress(Address);
        screenShotName = TestUtil.captureScreenShot();
        test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
        test.log(LogStatus.PASS, "<b>Step 7:</b> Insert Address - <b>Done!</b>");

        // Step 8: Insert City
        tribalNationsPage.InsertCity(City);
        screenShotName = TestUtil.captureScreenShot();
        test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
        test.log(LogStatus.PASS, "<b>Step 8:</b> Insert City - <b>Done!</b>");

        // Step 9: Select State
        tribalNationsPage.SelectState(State);
        screenShotName = TestUtil.captureScreenShot();
        test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
        test.log(LogStatus.PASS, "<b>Step 9:</b> Select State - <b>Done!</b>");

        // Step 10: Insert Zip Code
        tribalNationsPage.InsertZipCode(ZipCode);
        screenShotName = TestUtil.captureScreenShot();
        test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
        test.log(LogStatus.PASS, "<b>Step 10:</b> Insert Zip Code - <b>Done!</b>");

        // Step 11: Click Save
        tribalNationsPage.ClickSave();
        Thread.sleep(7000);
        screenShotName = TestUtil.captureScreenShot();
        test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
        test.log(LogStatus.PASS, "<b>Step 11:</b> Click Save - <b>Done!</b>");
        //Thread.sleep(20000);
        
        //Validate the Nation Addition Message
        tribalNationsPage.validateNationAddition();
        
       //Step 12: Validate the Tribal Nation has been added
        tribalNationsPage.validateTribalNationInTable(Region, TribalNation, Address);
        screenShotName = TestUtil.captureScreenShot();
		test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
   
   }
    @Test(enabled=true,dataProvider="AddTribalNationData", priority =2)
			 public void AddSameTribalNation(String TribalNation, String ShortName, String SharesGeographyWithMichigan, String Region,String Address, String City, String State, String ZipCode) throws Exception {
		System.out.println("### Inside Function AddTribalNation...");
		test.log(LogStatus.INFO, "<b>Test Case:</b> AddTribalNation <br/> "
		   + "<b>Test Description#</b><br/>"
		   + "<b>Page:</b> /ecomod/TribalNations <br/>"
		   + "<b>Steps:</b><br/>"
		   + "1. Navigate to Tribal Nations<br/>"
		   + "2. Click the Add button<br/>"
		   + "3. Insert Tribal Nation Name<br/>"
		   + "4. Insert Short Name<br/>"
		   + "5. Select Shares Geograhphy with Michigan<br/>"
		   +" 6. Select Region<br/>"
		   + "7. Insert Address<br/>"
		   + "8. Insert City<br/>"
		   + "9. Select State<br/>"
		   + "10. Insert Zip Code<br/>"
		   + "11. Click Save<br/>"
		   + "<b>Test Data:</b> TribalNation: " + TribalNation
		   + "; ShortName: " + ShortName
		   + "; ShareGeographyWithMichigan:" + SharesGeographyWithMichigan
		   + "; Address: " + Address
		   + "; City: " + City
		   + "; State: " + State
		   + "; ZipCode: " + ZipCode);
		
		
		TribalNationsPage tribalNationsPage = new TribalNationsPage(driver);
		
		// Step 1: Navigate to Tribal Nations
		tribalNationsPage.TribalNations();
		String screenShotName = TestUtil.captureScreenShot();
		test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
		test.log(LogStatus.PASS, "<b>Step 1:</b> Navigate to Tribal Nations - <b>Done!</b>");
		
		// Step 2: Click the Add button
		tribalNationsPage.ClickAdd();
		screenShotName = TestUtil.captureScreenShot();
		test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
		test.log(LogStatus.PASS, "<b>Step 2:</b> Click the Add button - <b>Done!</b>");
		
		// Step 3: Insert Tribal Nation Name
		tribalNationsPage.InsertTribalNationName(TribalNation);
		screenShotName = TestUtil.captureScreenShot();
		test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
		test.log(LogStatus.PASS, "<b>Step 3:</b> Insert Tribal Nation Name - <b>Done!</b>");
		
		// Step 4: Insert Short Name
		tribalNationsPage.InsertShortName(ShortName);
		screenShotName = TestUtil.captureScreenShot();
		test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
		test.log(LogStatus.PASS, "<b>Step 4:</b> Insert Short Name - <b>Done!</b>");
		
		// Step 5: Select Shares Geography With Michigan
		tribalNationsPage.selectSharesGeographyWithMichigan(SharesGeographyWithMichigan);
		screenShotName = TestUtil.captureScreenShot();
		test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
		test.log(LogStatus.PASS, "<b>Step 5:</b> Select Shares Geography with Michigan  - <b>Done!</b>");
		
		// Step 6: Select Region
		tribalNationsPage.SelectRegion(Region);
		screenShotName = TestUtil.captureScreenShot();
		test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
		test.log(LogStatus.PASS, "<b>Step 6:</b> Select Region - <b>Done!</b>");
		
		// Step 7: Insert Address
		tribalNationsPage.InsertAddress(Address);
		screenShotName = TestUtil.captureScreenShot();
		test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
		test.log(LogStatus.PASS, "<b>Step 7:</b> Insert Address - <b>Done!</b>");
		
		// Step 8: Insert City
		tribalNationsPage.InsertCity(City);
		screenShotName = TestUtil.captureScreenShot();
		test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
		test.log(LogStatus.PASS, "<b>Step 8:</b> Insert City - <b>Done!</b>");
		
		// Step 9: Select State
		tribalNationsPage.SelectState(State);
		screenShotName = TestUtil.captureScreenShot();
		test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
		test.log(LogStatus.PASS, "<b>Step 9:</b> Select State - <b>Done!</b>");
		
		// Step 10: Insert Zip Code
		tribalNationsPage.InsertZipCode(ZipCode);
		screenShotName = TestUtil.captureScreenShot();
		test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
		test.log(LogStatus.PASS, "<b>Step 10:</b> Insert Zip Code - <b>Done!</b>");
		
		// Step 11: Click Save
		tribalNationsPage.ClickSave();
		Thread.sleep(7000);
		screenShotName = TestUtil.captureScreenShot();
		test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
        test.log(LogStatus.PASS, "<b>Step 11:</b> Click Save - <b>Done!</b>");
        Thread.sleep(20000);
		
     // Validate Error Message
        String expectedHeadlineErrorMessage = "Error on page";
        String expectedDetailedErrorMessage = "File cannot be uploaded. Please contact the ECO administrator.";
        Thread.sleep(20000);
        tribalNationsPage.validateDuplicateContactError(expectedHeadlineErrorMessage, expectedDetailedErrorMessage);
       
        //Go back to Tribal Nations Page
        Thread.sleep(10000);
        tribalNationsPage.ClickBack();
        Thread.sleep(10000);
        tribalNationsPage.ClickLeave();
        Thread.sleep(10000);
        screenShotName = TestUtil.captureScreenShot();
		test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
        
      
		
        
		}
    @Test(enabled=true,dataProvider="EditTribalNationData", priority =3)
    public void EditTribalNation(String TribalNation, String ShortName, String Region, String NewTribalNation, String NewShortName, String NewRegion) throws Exception {
        System.out.println("### Inside Function EditTribalNationContact...");
        //String updatedTribalNationName = TribalNation; // Generate updated Tribal Nation name
        test.log(LogStatus.INFO, "<b>Test Case:</b> EditTribalNationContact <br/>"
                + "<b>Test Description#</b><br/>"
                + "<b>Page:</b> /ecomod/TribalNationContacts <br/>"
                + "<b>Steps:</b><br/>"
                + "1. Navigate to Tribal Nation<br/>"
                + "2. Click the Edit button for the created contact<br/>"
                + "3. Insert New Tribal Nation <br/>"
                + "3. Insert New Short Name<br/>"
                + "3. Insert New Region <br/>"
                + "4. Click Save<br/>"
                + "6. Validate that the edited contact is updated<br/>"
                + "<b>Test Data:</b><br/>"
                + "NewTribalNation: " + NewTribalNation + "<br/>"
                + "NewShortName: " + NewShortName + "<br/>"
                + "NewRegion: " + NewRegion); 


        
        	TribalNationsPage tribalNationsPage = new TribalNationsPage(driver);

         // Step 1: Navigate to Tribal Nations
    		tribalNationsPage.TribalNations();
    		String screenShotName = TestUtil.captureScreenShot();
    		test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
    		test.log(LogStatus.PASS, "<b>Step 1:</b> Navigate to Tribal Nations - <b>Done!</b>");
    		

            // Step 2: Click the Edit button for the created contact
    		tribalNationsPage.ClickEdit(TribalNation);
    		screenShotName = TestUtil.captureScreenShot();
    		test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
            test.log(LogStatus.PASS, "<b>Step 2:</b> Click the Edit button for the created Tribal Nation - <b>Done!</b>");

            // Step 3: Insert New Tribal Nation 
            tribalNationsPage.InsertNewTribalNation(NewTribalNation);
            screenShotName = TestUtil.captureScreenShot();
            test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
            test.log(LogStatus.PASS, "<b>Step 3:</b> Insert Updated Tribal Nation Name - <b>Done!</b>");
            Thread.sleep(10000);
            
            // Step 4: Insert New Short Name
            tribalNationsPage.InsertNewShortName(NewShortName);
            screenShotName = TestUtil.captureScreenShot();
            test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
            test.log(LogStatus.PASS, "<b>Step 4:</b> Insert New Short Name - <b>Done!</b>");
            Thread.sleep(10000);
            
            // Step 5: Select New Region
            tribalNationsPage.SelectNewRegion(NewRegion);
            screenShotName = TestUtil.captureScreenShot();
            test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
            test.log(LogStatus.PASS, "<b>Step 5:</b> Select New Region - <b>Done!</b>");
            Thread.sleep(10000);

        
            // Step 6: Click Save
            tribalNationsPage.ClickSave();
            Thread.sleep(7000);
            test.log(LogStatus.PASS, "<b>Step 6:</b> Click Save - <b>Done!</b>");
            //Thread.sleep(20000);
            
          //Validate the Nation Addition Message
            tribalNationsPage.validateNationAddition();
                      

         // Step 7: Validate that the edited Tribal Nation is updated
           tribalNationsPage.validateEditedTribalNation(NewTribalNation, NewShortName, NewRegion);
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
	public Object[][] AddTribalNationData() throws Exception { 
		return excelReader.getTableArray("AddTribalNation"); 
		}
	@DataProvider 
	public Object[][] EditTribalNationData() throws Exception { 
		return excelReader.getTableArray("EditTribalNation"); 
		}
		 
}

    
