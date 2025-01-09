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

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

import gov.michigan.mdot.automation.MiADART.pages.ApproveDistributionsPage;
import gov.michigan.mdot.automation.MiADART.pages.CalculateDistributionsPage;
import gov.michigan.mdot.automation.MiADART.pages.DistributionsPage;
import gov.michigan.mdot.automation.MiADART.pages.MileagePage;
import gov.michigan.mdot.automation.MiADART.pages.NavigationsPage;
import gov.michigan.mdot.automation.MiADART.pages.ReportsDriverPage;
import gov.michigan.mdot.automation.base.TestBase;
import gov.michigan.mdot.automation.listeners.CustomListener;


@Listeners(CustomListener.class)
public class AmountValidationTest extends TestBase{
 
@Test(enabled=true)
public void US_95446_Amount_Validation() throws Exception {
	test.log(LogStatus.INFO, " : "+"<br/>"+" : " +"<br/>");
	
	    NavigationsPage navigationsPage = new NavigationsPage(driver);
	    DistributionsPage distributionsPage = new DistributionsPage(driver);
	    CalculateDistributionsPage calculateDistributionsPage = new CalculateDistributionsPage(driver);
	    ApproveDistributionsPage approveDistributionsPage = new ApproveDistributionsPage(driver);
	   
	   

	    Thread.sleep(5000);
	    distributionsPage.CalculateDistributions();
	    Thread.sleep(5000);
	    double calculationsCounty = calculateDistributionsPage.getCountyValue();
	    System.out.println("Retrieved Calculations MTF County Value: " + calculationsCounty);
	    Thread.sleep(5000);
	    double calculationsCityVillage = calculateDistributionsPage.getCityVillageValue();
	    System.out.println("Retrieved Calculations City/Village value: " + calculationsCityVillage);
	    Thread.sleep(5000);
	    double calculationsCountyLRP = calculateDistributionsPage.getCountyLRPValue();
	    System.out.println("Retrieved Calculations County LRP value: " + calculationsCountyLRP);
	    Thread.sleep(5000);
	    double calculationsCityVillageLRP = calculateDistributionsPage.getCityVillageLRPValue();
	    System.out.println("Retrieved Calculations City/Village LRP value: " + calculationsCityVillageLRP);
	    
	    //Screenshot 
	    Thread.sleep(5000);
	    distributionsPage.validateCalculateDistributions();

	   
        //Approve Distributions
        Thread.sleep(5000);
        distributionsPage.ApproveDistributions();
        Thread.sleep(7000);
   
        double approveCounty = approveDistributionsPage.getCountyValue();
        System.out.println("Retrieved Approve MTF County Value: " + approveCounty);
        Thread.sleep(7000);
        double approveCityVillage = approveDistributionsPage.getCityVillageValue();
        System.out.println("Retrieved Approve MTF City/Village Value: " + approveCityVillage);
        Thread.sleep(7000);
        double approveCountyLRP = approveDistributionsPage.getCountyLRPValue();
        System.out.println("Retrieved Approve County LRP value: " + approveCountyLRP);
        Thread.sleep(7000);
        double approveCityVillageLRP = approveDistributionsPage.getCityVillageLRPValue();
        Thread.sleep(7000);
        System.out.println("Retrieved Approve City/Village LRP value: " + approveCityVillageLRP);
        double approveAmountsAvailableTotal = approveDistributionsPage.getAmountsAvailableTotalValue();
        Thread.sleep(7000);
        System.out.println("Retrieved Approve Amounts Available Total: " + approveAmountsAvailableTotal);
        Thread.sleep(7000);
        
        //Screenshots
        distributionsPage.validateApproveDistributions();
       


       // Validate values match between Calculations and Approve Distributions pages
        Assert.assertEquals(approveCounty, calculationsCounty, "County value match between Calculations and Approve Distribution pages!");
        Assert.assertEquals(approveCityVillage, calculationsCityVillage, "City/Village value match between Calculations and Approve Distribution pages!");
        Assert.assertEquals(approveCountyLRP, calculationsCountyLRP, "County LRP value match between Calculations and Approve Distribution pages!");
        Assert.assertEquals(approveCityVillageLRP, calculationsCityVillageLRP, "City/Village LRP value match between Calculations and Approve Distribution pages!");
        Assert.assertTrue(approveAmountsAvailableTotal > 0, "Amounts Available Total should be greater than 0.");
        
	  
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
 	  return excelReader.getTableArray("");
}

}
