package gov.michigan.mdot.automation.MiADART.pages;

import gov.michigan.mdot.automation.base.TestBase;
import gov.michigan.mdot.automation.utilities.CommonLibsFramework;
import gov.michigan.mdot.automation.utilities.TestUtil;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.ToIntBiFunction;

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
import gov.michigan.mdot.automation.utilities.TestUtil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MileagePage extends BasePage {
	String screenShotName = "";
   
    public MileagePage( WebDriver driver )
    {
        super( driver );
        
    }
    
	//################################################################
	
   	@FindBy(linkText ="Mileage")
	WebElement MilageMainNav;
		
	@FindBy(xpath= "//som-tab[@name='County Mileage']")
	WebElement CountyMileageTab;
		
	@FindBy(xpath= "//som-tab[@name='City/Village Mileage']")
	WebElement CityVillageMileageTab;

//		@FindBy(css = "#som-tab-panel17 > som-content")
//		private WebElement shashadowHostdowHost;
    
	@FindBy(xpath=" //div[div[h2[text()='County Mileage Details']]]/preceding-sibling::div//div[text()='Download allocation package ']")
	WebElement DownloadAllocationPackageCounty;
	@FindBy(xpath = "//div[div[h2[text()='County Mileage Details']]]/following-sibling::div//select")
	WebElement CountyMileageTableDropDown; 
		
	@FindBy(xpath = "//div[div[h2[text()='City/Village Mileage Details']]]/following-sibling::div//select")
	WebElement cityVillageMileageTableDropDown; 
		
	@FindBy(xpath="//div[div[h2[text()='County Mileage Details']]]/following-sibling::div//table")
	List<WebElement> CountyMileageTable;
		
	@FindBy(xpath="//div[div[h2[text()='City/Village Mileage Details']]]/following-sibling::div//input']")
	WebElement SearchCityVillageMileage;
		
	@FindBy(xpath = "//div[div[h2[text()='City/Village Mileage Details']]]/following-sibling::div//table")
	WebElement CityVillageMileageTable;
		
	@FindBy(xpath="//div[div[h2[text()='County Mileage Details']]]/following-sibling::div//table")
	WebElement CountyMileagesTable;
		
	@FindBy(xpath="//div[div[h2[text()='City/Village Mileage Details']]]/following-sibling::div//button")
	WebElement CityVillageMileageReport ;
		
	@FindBy(xpath="//label[text()='MTF processing month']/following-sibling::select[1]")
	WebElement MTFProcessingMonth;
	
	@FindBy(xpath = "//div[div[h2[text()='City/Village Mileage Details']]]/preceding-sibling::div//select")
	WebElement MtfDropdownCityVillage;
	
	@FindBy(xpath = "//div[div[h2[text()='County Mileage Details']]]/preceding-sibling::div//select")
	WebElement MtfDropdownCounty;
	
	@FindBy(xpath="//div[div[h2[text()='City/Village Mileage Details']]]/preceding-sibling::div//div[text()='Download allocation package ']")
	WebElement DownloadAllocationPackageCityVillage;
	
	@FindBy(xpath = "//som-button//div[text()='Download Excel']")
	WebElement DownloadExcel;
    	//################################################################
		public void clickonMilageMainNav()
		{
			System.out.println("#### Inside function: clickonMilageMainNav.... ");
			try {
				this.MilageMainNav.click();
				test.log(LogStatus.PASS, "Navigate to Mileage page: Successful!");
				Thread.sleep(500);
				screenShotName = TestUtil.captureScreenShot();
				test.log(LogStatus.PASS, test.addScreenCapture(screenShotName));
				
			}catch(Exception e) {
				test.log(LogStatus.FAIL, "Navigate to Mileage page: Unsuccessful!");
				e.printStackTrace();
			}
		}
		
		public void clickonCountyMileageTab()
		{
			System.out.println("#### Inside function: clickonCountyMileageTab.... ");
			try {
				this.CountyMileageTab.click();
				test.log(LogStatus.PASS, "Click on CountyMileageTab: Successful!");
				Thread.sleep(500);
				screenShotName = TestUtil.captureScreenShot();
				test.log(LogStatus.PASS, test.addScreenCapture(screenShotName));
			}catch(Exception e) {
				test.log(LogStatus.FAIL, "Click on CountyMileageTab: Unsuccessful!");
				e.printStackTrace();
			}
		}
		public void clickonCityVillageMileageTab() throws Exception
		{
			System.out.println("#### Inside function: clickonCityVillageMileageTab.... ");
			try {
				this.CityVillageMileageTab.click();
				test.log(LogStatus.PASS, "Click on City/Village MileageTab: Successful!");
				Thread.sleep(500);
				screenShotName = TestUtil.captureScreenShot();
				test.log(LogStatus.PASS, test.addScreenCapture(screenShotName));
			}catch(Exception e) {
				test.log(LogStatus.FAIL, "Click on City/Village MileageTab: Unsuccessful!");
				e.printStackTrace();
			}
		}

		public void SelectAllInCountryMilageTable() {
			System.out.println("#### Inside function: SelectAllInCountryMilageTable.... ");
	        WebElement shadowHost = driver.findElement(By.cssSelector("#root > som-header")); 
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        Object shadowRoot = js.executeScript("return arguments[0].shadowRoot", shadowHost);
	        if (shadowRoot == null) {
	            throw new RuntimeException("Shadow root is not accessible.");
	        }
	        WebElement selectElement = (WebElement) js.executeScript("return arguments[0].querySelector('select#som-input13')", shadowRoot);
	        if (selectElement == null) {
	            throw new RuntimeException("Select element is not found within the shadow root.");
	        }
	        Select select = new Select(selectElement);
	        select.selectByVisibleText("All");
	        System.out.println("#### Successfully selected 'All' from the dropdown....");
    
	        
		}
	public void SelectAllInCountryMileageTable() {
	        System.out.println("#### Inside function: SelectAllInCountryMileageTable.... ");
	        
	        try {
	        	Select dropdown = new Select(CountyMileageTableDropDown);
	        	String X="";
	            for (WebElement option : dropdown.getOptions()) {				//Dynamically select "All" option in dropdown 
	                X= option.getAttribute("value");
	            }
	            Thread.sleep(500);
	            dropdown.selectByValue(X);
	            Thread.sleep(1000);
	            String screenShotName = TestUtil.captureViewPortShot();
				test.log(LogStatus.PASS, test.addScreenCapture(screenShotName));
				test.log(LogStatus.PASS, "Selected all rows in the CountyMileageTable, Total Row:  "+ X);
	            
	            
	            WebElement x = CountyMileageTable.get(1);
	            List<WebElement> rows = x.findElements(By.xpath(".//tr"));
	            for (int i = 0; i < rows.size(); i++) {
	            	List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
	            	for (WebElement cell : cells) {
	            		if (cell.getText().length()<5) 
	            			System.out.print(cell.getText() +"\t\t\t\t" +  " | ");
	            		else if (cell.getText().length()>13)
	            			System.out.print(cell.getText() +"\t\t" +  " | ");
	            		else
	            			System.out.print(cell.getText() +"\t\t\t" +  " | ");
	            	}
	            	System.out.println();
	            }
	        }catch (Exception e) {
	          System.err.println("An error occurred: " + e.getMessage());
	        }
	        
	    }
		public int[] calculateSumOfCountyMileageTable() {
			System.out.println("#### Inside function: calculateSumOfCountyMileageTable.... ");
			this.clickonMilageMainNav();
			this.clickonCountyMileageTab();
			try {
				this.SelectAllInCountryMileageTable();
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			return null;
		}

		public Boolean VerifySumInCountyMileageTable(int[] sumInTABLE) {
			
			return null;
		}

	public void SearchCityVillageMileage(String CityOrVillageXL, String PopulationXL,String AdjustedStateTrunklineMilesXL, 
				String Section10AMilesXL, String MajorMilesXL, String LocalMilesXL) {
			System.out.println("#### Inside function: SearchCityVillageMileage.... ");
			SearchCityVillageMileage.clear();
			SearchCityVillageMileage.sendKeys(CityOrVillageXL);
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<String> read = readTable();
//			System.out.println(read);
//			System.out.println((CityOrVillageXL+","+ PopulationXL+","+ AdjustedStateTrunklineMilesXL+","
//								+ Section10AMilesXL+","+ MajorMilesXL+","+ LocalMilesXL));
			if(CityOrVillageXL!=null && CityOrVillageXL.equals(read.get(1)) 
					&& Float.parseFloat(PopulationXL.replaceAll(",", "")) == Float.parseFloat(read.get(2).replaceAll(",", "")) 
					&& Float.parseFloat(AdjustedStateTrunklineMilesXL) == Float.parseFloat(read.get(3)) 
					&& Float.parseFloat(Section10AMilesXL) == Float.parseFloat(read.get(4)) 
					&& Float.parseFloat(MajorMilesXL.replaceAll(",", "")) == Float.parseFloat(read.get(5).replaceAll(",", "")) 
					&& Float.parseFloat(LocalMilesXL.replaceAll(",", "")) == Float.parseFloat(read.get(6).replaceAll(",", ""))) {
				System.out.println(Float.parseFloat(PopulationXL.replaceAll(",", "")) + "  "+ Float.parseFloat(read.get(2).replaceAll(",", "")));
				try {
					screenShotName = TestUtil.captureScreenShot();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				test.log(LogStatus.PASS, test.addScreenCapture(screenShotName));
				test.log(LogStatus.PASS, "Validation successful for "+ CityOrVillageXL);
			}
			else {
//				System.out.println(CityOrVillageXL+"\n"+read.get(1)+"\n\n"+PopulationXL+"\n"+read.get(2)+"\n\n"+AdjustedStateTrunklineMilesXL
//						+"\n"+read.get(3)+"\n\n"+Section10AMilesXL+"\n"+read.get(4)+"\n\n"+MajorMilesXL+"\n"+read.get(5)+"\n\n"
//						+"\n"+LocalMilesXL+"\n"+read.get(6));
				test.log(LogStatus.FAIL, "Validation failed for "+ CityOrVillageXL);
			}
			
		}

		private List<String> readTable() {									// Faulty Function
			System.out.println("#### Inside function: readTable.... ");
			try{
				List<WebElement> rows = CityVillageMileageTable.findElements(By.xpath(".//tr"));
				List<String> returnVal = new ArrayList<>();
				for (int i = 0, j= 0; i < rows.size()-1; i++) {  
					if (j != 0) {  
					    List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
					    for (WebElement cell : cells) {
					        returnVal.add(cell.getText());
					    }
					    //System.out.println(returnVal);
					    return returnVal;
				    }
					j++;
				}
		    }catch (Exception e) {
		      System.err.println("An error occurred: " + e.getMessage());
		    }
			return null;
		}

	public void DownloadCityVillageMilageReport() {
			System.out.println("#### Inside function: DownloadCityVillageMilageReport.... ");
			try {
				CommonLibsMiADART.deletePreviousReports("MiADART_City_Village_Mileage_","xlsx");
				CityVillageMileageReport.click();
				Thread.sleep(5000);
				CommonLibsMiADART.checkDownloadedReport("MiADART_City_Village_Mileage_092024","xlsx");;
				System.out.println("Downloaded CityVillageMileageReport......");
				
			}catch(Exception e){
				
			}
			
			
		}

		
		
		// Change right Mileage Tab
		public void selectMileageTab(String tab) { 
			if (tab.equalsIgnoreCase("City/Village"))		// If tab is City/Village
				CityVillageMileageTab.click();				// Navigate to City/Village tab
			else if (tab.equalsIgnoreCase("County"))
				CountyMileageTab.click();
			else
				System.out.println("Illegal input!!!");
		}
		// Selected All Entries from Mileage details 
		public void selectedAllEntries(String tab) {
			Select select = new Select(cityVillageMileageTableDropDown);   // default City/Village
			
			if (tab.equalsIgnoreCase("City/Village")) {
				select = new Select(cityVillageMileageTableDropDown);	   // Creating select web element  
			}
			else if (tab.equalsIgnoreCase("County")) {
				select = new Select(CountyMileageTableDropDown);
			}
			else
				System.out.println("Illegal input!!!");
			
			String val="";
			List<WebElement> getAvailableOptions = select.getOptions();						// Listing available options
			for(WebElement a:getAvailableOptions) {											// For every options 
				if(a.getAttribute("label").equals("All"))									// check label text and if it is same as provided value 
					val = a.getAttribute("Value");											// Note the value of the option
			}
			select.selectByValue(val);														// Select ALL option by value 
			
		}
		// Select a month in 
		public void selectMTFProcessingMonth(String mtfProcessingMonth) {
			
			Select select = new Select(MTFProcessingMonth);
			select.selectByVisibleText(mtfProcessingMonth);									// Select MTF Processing Month
			
		}

	public HashMap<String, List<String>> loadHTMLTableDataInHashMap(String tab) {
			HashMap<String, List<String>> WebData = new HashMap<String, List<String>>();
			if (tab.equalsIgnoreCase("City/Village")) {
				WebData = CommonLibsMiADART.ReadWebTableDataFromWebTable(CityVillageMileageTable); // Send City/Millage Table to parse
			}
			else if (tab.equalsIgnoreCase("County")) {
				WebData = CommonLibsMiADART.ReadWebTableDataFromWebTable(CountyMileagesTable);
			}
			else
				System.out.println("Illegal input!!!");
			return WebData;
		}

		public HashMap<String, List<String>> reformatWebData(HashMap<String, List<String>> webData) {
			HashMap<String, List<String>> reformattedWebData = new HashMap<String, List<String>>();
			
			for (List<String> value : webData.values()) {
				List<String> newValue = new ArrayList<String>();
				String cityVillage = value.get(0);
				String population = value.get(1);
				String adjustedStateTrunklineMiles = value.get(2);
				String section10AMiles = value.get(3);
				String majorMiles = value.get(4);
				String localAMiles = value.get(5);
				String populationFactor = calculatePopulationFactor(population.replace(",","")); 			// Calculating population factor 
				//String equvalentMajorMiles = String.format("%.3f",Float.parseFloat(majorMiles)*Float.parseFloat(populationFactor));  
				String equvalentMajorMiles = (Float.parseFloat(majorMiles)*Float.parseFloat(populationFactor))+""; // Need to identify right logic
				newValue.add(cityVillage);
				newValue.add(populationFactor);
				newValue.add(adjustedStateTrunklineMiles);
				newValue.add(section10AMiles);
				newValue.add(majorMiles);
				newValue.add(equvalentMajorMiles);
				newValue.add(population);
				newValue.add(localAMiles);
				reformattedWebData.put(cityVillage, newValue);												// Put reformatted data in Hashmap and return 
	        } 
			return reformattedWebData;
		}

		private String calculatePopulationFactor(String population) {
			float floatPopulation = Integer.parseInt(population);
			if (floatPopulation <= 2000) {
	            return 1.0+"";
	        } else if (floatPopulation <= 10000) {
	            return 1.1+"";
	        } else if (floatPopulation <= 20000) {
	            return 1.2+"";
	        } else if (floatPopulation <= 30000) {
	            return 1.3+"";
	        } else if (floatPopulation <= 40000) {
	            return 1.4+"";
	        } else if (floatPopulation <= 50000) {
	            return 1.5+"";
	        } else if (floatPopulation <= 65000) {
	            return 1.6+"";
	        } else if (floatPopulation <= 80000) {
	            return 1.7+"";
	        } else if (floatPopulation <= 95000) {
	            return 1.8+"";
	        } else if (floatPopulation <= 160000) {
	            return 1.9+"";
	        } else if (floatPopulation <= 320000) {
	            return 2.0+"";
	        } else if (floatPopulation <= 480000) {
	            return 2.1+"";
	        } else if (floatPopulation <= 640000) {
	            return 2.2+"";
	        } else if (floatPopulation <= 800000) {
	            return 2.3+"";
	        } else if (floatPopulation <= 960000) {
	            return 2.4+"";
	        } else {
	            return ""; // Invalid population (greater than 960,000)
	        }
		}

		public int compareAndPrint(List<String> dataFromWeb, List<String> dataFromExcel) {
			int misMatchCount = 0;
			if(dataFromWeb.get(0).equals(dataFromExcel.get(0))){
				if (dataFromWeb.get(1).equals(dataFromExcel.get(1))
						&& Float.parseFloat(dataFromWeb.get(2).replace(",",""))== Float.parseFloat(dataFromExcel.get(2).replace(",",""))
						&& Float.parseFloat(dataFromWeb.get(3).replace(",",""))== Float.parseFloat(dataFromExcel.get(3).replace(",","")) 
						&& Float.parseFloat(dataFromWeb.get(4).replace(",",""))== Float.parseFloat(dataFromExcel.get(4).replace(",","")) 
						//&& Float.parseFloat(dataFromWeb.get(5).replace(",",""))== Float.parseFloat(dataFromExcel.get(5).replace(",",""))  // Excluding Equivalent Major from counting 
						&& Float.parseFloat(dataFromWeb.get(6).replace(",",""))== Float.parseFloat(dataFromExcel.get(6).replace(",",""))
						&& Float.parseFloat(dataFromWeb.get(7).replace(",","")) == Float.parseFloat(dataFromExcel.get(7).replace(",",""))) {
					
				}
				else {
					System.out.println(dataFromWeb.get(0));
					System.out.println(Float.parseFloat(dataFromWeb.get(2).replace(",",""))+" "+ Float.parseFloat(dataFromExcel.get(2).replace(",",""))
					+"\n"+ Float.parseFloat(dataFromWeb.get(3).replace(",","")) +" "+ Float.parseFloat(dataFromExcel.get(3).replace(",","")) 
					+"\n"+ Float.parseFloat(dataFromWeb.get(4).replace(",",""))+" "+ Float.parseFloat(dataFromExcel.get(4).replace(",","")) 
					+"\n"+ Float.parseFloat(dataFromWeb.get(5).replace(",",""))+" "+  Float.parseFloat(dataFromExcel.get(5).replace(",",""))
					+"\n"+ Float.parseFloat(dataFromWeb.get(6).replace(",",""))+" "+  Float.parseFloat(dataFromExcel.get(6).replace(",",""))
					+"\n"+ Float.parseFloat(dataFromWeb.get(7).replace(",","")) +" "+  Float.parseFloat(dataFromExcel.get(7).replace(",","")));
					misMatchCount++;
					test.log(LogStatus.FAIL, "Mismatch Found for Data - Web: "+dataFromWeb.get(0)+";Excel: "+dataFromExcel.get(0));
				}
			}
			else {
				misMatchCount++;
				test.log(LogStatus.FAIL, "Mismatch Found in Names- Web:"+dataFromWeb.get(0)+" ;Excel"+dataFromExcel.get(0));
			}
			return misMatchCount;
		}
public void selectCountyMileage() 
    {
    	CountyMileageTab.click();
   
    }
    public void selectCityVillageMileage() 
    {
    	CityVillageMileageTab.click();
   
    }
    public void downloadAllocationPackageCounty() 
    {
    	DownloadAllocationPackageCounty.click();
    }
   
    public boolean isDownloadAllocationCountyButtonClickable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(DownloadAllocationPackageCityVillage));
            return true;  
        } catch (Exception e) {
            return false; 
        }
    }
  
    public void downloadAllocationPackageCityVillage() 
    {               		
    	DownloadAllocationPackageCityVillage.click();
    }
     
    public boolean isDownloadAllocationCityVillageButtonClickable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(DownloadAllocationPackageCityVillage));
            return true;  
        } catch (Exception e) {
            return false; 
        }
    }
    public boolean isDownloadButtonEnabledCityVillage() {
        WebElement downloadButton = driver.findElement(By.xpath("//div[div[h2[text()='City/Village Mileage Details']]]/preceding-sibling::div//div[text()='Download allocation package ']")); 
        return downloadButton.isEnabled();
    }

    public boolean isDownloadButtonEnabledCounty() {
        WebElement downloadButton = driver.findElement(By.xpath("//div[div[h2[text()='County Mileage Details']]]/preceding-sibling::div//div[text()='Download allocation package ']")); 
        return downloadButton.isEnabled();
    }

    
    public void downloadExcel() 
    {
    	DownloadExcel.click();
    	    
    }
  
    public void selectMonthCityVillage(String month) 
    {
    	Select select = new Select(MtfDropdownCityVillage);
    	select.selectByVisibleText(month);
    	
    
    }
    public void selectMonthCounty(String month) 
    {
    	Select select = new Select(MtfDropdownCounty);
    	select.selectByVisibleText(month);
    	
    
    }
    public void logDownloadedFiles() {
        String downloadPath = System.getProperty("user.home")+"\\Downloads";
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();
        System.out.println("Files in the download folder:");
        for (File file : dirContents) {
            System.out.println(file.getName());
        }
    }
    public void clearDownloadDirectory() {
    	String downloadPath =System.getProperty("user.home")+"\\Downloads";
        File dir = new File(downloadPath);
        for (File file : dir.listFiles()) {
            file.delete();
        }
    }

    public boolean isFileDownloaded(String fileName) throws InterruptedException {
    	String downloadPath = System.getProperty("user.home")+"\\Downloads";
        File dir = new File(downloadPath);
        int retries = 15; 
        int waitTime = 3000; 
        for (int i = 0; i < retries; i++) {
            File[] dirContents = dir.listFiles();
            if (dirContents != null) {
                for (File file : dirContents) {
                    if (file.getName().equals(fileName)) {
                        return true;
                    }
                }
            }
            Thread.sleep(waitTime);
        }
        return false;
    }



public String getCurrentMonthYear() {
	 LocalDate currentDate = LocalDate.now();
	    return currentDate.format(DateTimeFormatter.ofPattern("MMMM yyyy")); 
	
}
public String getFileMonthCode(String monthYear) {
    // Map custom month codes
    Map<String, String> monthCodeMap = new HashMap<>();
    monthCodeMap.put("January", "12");
    monthCodeMap.put("February", "01");
    monthCodeMap.put("March", "02");
    monthCodeMap.put("April", "03");
    monthCodeMap.put("May", "04");
    monthCodeMap.put("June", "05");
    monthCodeMap.put("July", "06");
    monthCodeMap.put("August", "07");
    monthCodeMap.put("September", "08");
    monthCodeMap.put("October", "09");
    monthCodeMap.put("November", "10"); 
    monthCodeMap.put("December", "11"); 

    // Split the input into month and year
    String[] parts = monthYear.split(" ");
    if (parts.length != 2) {
        throw new IllegalArgumentException("month-year format: " + monthYear);
    }

    String month = parts[0];
    String year = parts[1];

    // Get the mapped code for the month
    String monthCode = monthCodeMap.get(month);
    if (monthCode == null) {
        throw new IllegalArgumentException("month name: " + month);
    }
    String fileCode = monthCode + year;

    // Print the generated file code for validation
    System.out.println("Generated file code for \"" + monthYear + "\": " + fileCode);

    return fileCode;
}

}

	
	
	
 

