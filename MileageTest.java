package gov.michigan.mdot.automation.MiADART.tests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
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

import gov.michigan.mdot.automation.MiADART.pages.MileagePage;
import gov.michigan.mdot.automation.MiADART.pages.NavigationsPage;
import gov.michigan.mdot.automation.MiADART.pages.ReportsDriverPage;
import gov.michigan.mdot.automation.base.TestBase;
import gov.michigan.mdot.automation.listeners.CustomListener;


@Listeners(CustomListener.class)
public class MileageTest extends TestBase{
 
@Test(enabled=true,dataProvider="MileageData")
public void US_94397_Download_Allocation_Package(String TabName,String MTFprocessingmonth) throws Exception {
	test.log(LogStatus.INFO, "TabName : "+TabName +"<br/>"+"MTFprocessingmonth : "+MTFprocessingmonth +"<br/>");
	
	 	Thread.sleep(5000);
	    NavigationsPage navigationsPage = new NavigationsPage(driver);
	    MileagePage mileagePage = new MileagePage(driver);

	    Thread.sleep(5000);
	    navigationsPage.mileagePageNav();

	    Thread.sleep(5000);
	    String expectedFileName = "MiADART_Allocation_Package_" + mileagePage.getFileMonthCode(MTFprocessingmonth) + ".zip";
	    //String currentMonthYear = mileagePage.getCurrentMonthYear();
	    String currentMonthYear = mileagePage.getCurrentMonthYear();
	    test.log(LogStatus.INFO, "Current Month-Year fetched dynamically: " + currentMonthYear);
	    
	    if (TabName.equalsIgnoreCase("City/Village Mileage")) {
	    	Thread.sleep(10000);
	        mileagePage.selectCityVillageMileage();
	        Thread.sleep(7000);
	        mileagePage.selectMonthCityVillage(MTFprocessingmonth);
	        Thread.sleep(7000);

	        // Check if the button is for the current month or not
	        if (MTFprocessingmonth.equals(currentMonthYear)) {
	        	Thread.sleep(10000);
	            mileagePage.downloadAllocationPackageCityVillage();
	            Thread.sleep(10000);
	            mileagePage.logDownloadedFiles();
	            Assert.assertTrue(mileagePage.isFileDownloaded(expectedFileName), "Allocation Package was downloaded for the current month.");
	        } else {
	           Assert.assertFalse(mileagePage.isDownloadButtonEnabledCityVillage(), "Download button should not be clickable for past months.");
	        }

	    } else if (TabName.equalsIgnoreCase("County Mileage")) {
	    	Thread.sleep(10000);
	        mileagePage.selectCountyMileage();
	        Thread.sleep(7000);
	        mileagePage.selectMonthCounty(MTFprocessingmonth);
	        Thread.sleep(7000);

	        if (MTFprocessingmonth.equals(currentMonthYear)) {
	        	Thread.sleep(10000);
	            mileagePage.downloadAllocationPackageCounty();
	            Thread.sleep(10000);
	            mileagePage.logDownloadedFiles();
	            Assert.assertTrue(mileagePage.isFileDownloaded(expectedFileName), "Allocation Package was downloaded for the current month.");
	        } else {
	            Assert.assertFalse(mileagePage.isDownloadButtonEnabledCounty(), "Download button should not be clickable for past months.");
	        }
	    }
	}
 

@BeforeClass
public void setup() throws IOException, Exception{
	  System.setProperty("webdriver.edge.driver", "true");
	  loginAndOpenMiLoginApp(System.getProperty("URL"),
			  OR.getProperty("UserID"), OR.getProperty("Password"),
					"MDOT MiADART - Michigan Act 51 Distribution and Reporting Tool - REACT");

	   }

@AfterClass
public void logOut() throws IOException{
		miLoginHomePage.logout();
	}
@DataProvider
public Object[][] MileageData() throws Exception {
 	  return excelReader.getTableArray("Mileage");
}

}
