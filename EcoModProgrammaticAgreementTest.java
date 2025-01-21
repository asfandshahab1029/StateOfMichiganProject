package gov.michigan.mdot.automation.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import gov.michigan.mdot.automation.base.TestBase;
import gov.michigan.mdot.automation.listeners.CustomListener;
import gov.michigan.mdot.automation.pages.EcoModProgrammaticAgreementPage;
import gov.michigan.mdot.automation.pages.EcoModTribalSearchPage;
import gov.michigan.mdot.automation.pages.MiLoginHomePage;
import gov.michigan.mdot.automation.pages.MiLoginPage;
import gov.michigan.mdot.automation.utilities.TestUtil;
@Listeners(CustomListener.class)
public class EcoModProgrammaticAgreementTest extends TestBase {

	@Test()
	public void EditAccessControl() throws Exception {

		MiLoginPage miLoginPage = new MiLoginPage(eventFiringDriver);
		MiLoginHomePage miLoginHomePage = new MiLoginHomePage(driver);
		
		miLoginPage.loginAndOpenMiLoginApp(System.getProperty("URL"),
				OR.getProperty("userId"), OR.getProperty("password"),
				"MDOT Environmental Clearance Organizer - ECOMOD");
		
		EcoModProgrammaticAgreementPage ecoModProgrammaticAgreementPage = new EcoModProgrammaticAgreementPage(driver);
		
		ecoModProgrammaticAgreementPage.ProgrammaticAgreement();
		Thread.sleep(3000);
		String screenShotName = TestUtil.captureScreenShot();
		test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
		test.log(LogStatus.PASS, "<b>Step 1:</b> Navigate to Programmatic Agreement - <b>Done!</b>");
		
		ecoModProgrammaticAgreementPage.EditAccessControl();
		Thread.sleep(3000);
		ecoModProgrammaticAgreementPage.EditReason();
		screenShotName = TestUtil.captureScreenShot();
		test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
		test.log(LogStatus.PASS, "<b>Step 2:</b> Editting the Reason for Access Control - <b>Done!</b>");
		
		ecoModProgrammaticAgreementPage.ClickSave();
		Thread.sleep(3000);
		screenShotName = TestUtil.captureScreenShot();
		test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
		test.log(LogStatus.PASS, "<b>Step 3:</b> Click Save - <b>Done!</b>");
		
		//Edit back to Original
		Thread.sleep(3000);
		ecoModProgrammaticAgreementPage.EditAccessControl();
		Thread.sleep(3000);
		ecoModProgrammaticAgreementPage.EditReasonToAccessControl();
		Thread.sleep(3000);
		ecoModProgrammaticAgreementPage.ClickSave();
		Thread.sleep(3000);
		screenShotName = TestUtil.captureScreenShot();
		test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
		test.log(LogStatus.PASS, "<b>Step 4:</b> Back to the Original - <b>Done!</b>");
		
		miLoginHomePage.logout();

	}
	@Test()
	public void SearchFinalSubmission() throws Exception {

		MiLoginPage miLoginPage = new MiLoginPage(eventFiringDriver);
		MiLoginHomePage miLoginHomePage = new MiLoginHomePage(driver);
		
		miLoginPage.loginAndOpenMiLoginApp(System.getProperty("URL"),
				OR.getProperty("userId"), OR.getProperty("password"),
				"MDOT Environmental Clearance Organizer - ECOMOD");
		
		EcoModTribalSearchPage ecoModTribalSearchPage = new EcoModTribalSearchPage(driver);
		
		ecoModTribalSearchPage.TribalSearch();
		Thread.sleep(3000);
		String screenShotName = TestUtil.captureScreenShot();
		test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
		test.log(LogStatus.PASS, "<b>Step 1:</b> Navigate to Tribal Search - <b>Done!</b>");
		
		ecoModTribalSearchPage.SelectTypeOfSearch();
		Thread.sleep(3000);
		screenShotName = TestUtil.captureScreenShot();
		test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
		test.log(LogStatus.PASS, "<b>Step 2:</b> Select Type of Search - <b>Done!</b>");
		
		Thread.sleep(3000);
		ecoModTribalSearchPage.SelectFinalSubmission();
		Thread.sleep(3000);
		screenShotName = TestUtil.captureScreenShot();
		test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
		test.log(LogStatus.PASS, "<b>Step 3:</b> Final Submission selected - <b>Done!</b>");
		
		ecoModTribalSearchPage.ClickSearch();
		Thread.sleep(3000);
		screenShotName = TestUtil.captureScreenShot();
		test.log(LogStatus.INFO, test.addScreenCapture(screenShotName));
		test.log(LogStatus.PASS, "<b>Step 4:</b> Validate data is displaying - <b>Done!</b>");
		Thread.sleep(3000);
		
		 // Validate that table data is displayed
	    boolean isDataDisplayed = ecoModTribalSearchPage.isTableDataDisplayed();

	    // Assert that data is displayed
	    Assert.assertTrue(isDataDisplayed, "Search results table is displaying any data.");
		
	    miLoginHomePage.logout();
		
	
	}
	
	
	

	  @BeforeMethod
	  public void setup() throws IOException, Exception {
		  System.setProperty("webdriver.edge.driver", "true");
	   	
		 
		   }
	   public void logOut() throws IOException{
	   		
	   	}
	
	
	
	 

	
}

