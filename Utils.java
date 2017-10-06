/*
 * LIST OF METHODS CONTAINED IN THIS CLASS
 * 
 * openBrowser
 * getTestCaseName
 * selectFromCombobox
 * getUniqueReference
 * takeScreenshot
 * assignStringVariable
 * assignIntVariable
 * attachLeadingZero
 * checkForWarning
 * checkboxHandler
 * checkTableForEntry
 * checkNewPage
 * checkSearchFilter
 * waitForTime
 * 
 */

//START OF METHODS  
package utility;

//List all of the required imports
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ExcelUtils;

public class Utils {

	public static WebDriver driver = null;

	/* **************************************************************************************************
	* Function: openBrowser
	* Author: Rory Cruickshank
	* Date: 17/03/2016
	* Purpose: Selects the browser according to input
	* Arguments: iTestCaseRow
	* 
	* Returns: driver
	*****************************************************************************************************
	* Change Log:
	* 
	* Date:
	* Author: 
	* Details:
	*
	****************************************************************************************************/
	public static WebDriver openBrowser(int iTestCaseRow) throws Exception{

        String sBrowserName;
        String sURL;

        try{
        sBrowserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Browser);
        //The URL will always be the same, so set that here
    	sURL = "https://" + Constant.URL;        
     
        switch(sBrowserName){
	        case "Firefox" :
        	
	        	//FirefoxProfile profile = new FirefoxProfile();
	        	//profile.setPreference("network.proxy.type", 4);
	        	System.setProperty("webdriver.gecko.driver","C:\\Eclipse\\Selenium\\geckodriver.exe");
	        	driver = new FirefoxDriver();//(profile);	
	            Log.info("New Firefox driver instantiated");
	
	            driver.manage().window().maximize();
	            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
	            Log.info("Implicit wait applied on the driver for 20 seconds");
	
	            driver.get(sURL);
	            Log.info("Web application launched successfully");
	            break;
	            
	        case "IE" :

	            DesiredCapabilities cap = new DesiredCapabilities();
	            cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	            cap.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
	            cap.setCapability("ignoreZoomSetting", true);
	            
	            System.setProperty("webdriver.ie.driver","C:\\Eclipse\\Selenium\\IEDriverServer.exe"); 

	            driver = new InternetExplorerDriver(cap);
	            Log.info("New IE driver instantiated");
	            
	            driver.manage().window().maximize();
	            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
	            Log.info("Implicit wait applied on the driver for 20 seconds");

	            driver.get(sURL);
	            Log.info("Web application launched successfully");
	            break;   
	            
	        case "Chrome" :
	        	
	        	ChromeOptions options = new ChromeOptions();
	        	options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
	        	File file = new File("C:\\eclipse\\Selenium\\chromedriver.exe"); 
	        	System.setProperty("webdriver.chrome.driver", file.getAbsolutePath()); 
	        	//DesiredCapabilities Capability = DesiredCapabilities.chrome();
	        	System.setProperty("webdriver.chrome.logfile", "C:\\eclipse\\selenium\\chromedriver.log");
	        	WebDriver driver = new ChromeDriver(options);	
	            driver.get(sURL);
	            Log.info("New Chrome driver instantiated");
	
	            driver.manage().window().maximize();
	            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
	            Log.info("Implicit wait applied on the driver for 20 seconds");
	
	            driver.get(Constant.URL);	
	            Log.info("Web application launched successfully");
	            break;   

	        default :
	            Log.error("No valid browser selected");	            	
	            
            }
        }catch (Exception e){
            Log.error("Class Utils | Method OpenBrowser | Exception desc : "+e.getMessage());
        }
        return driver;
    }
	
	/* **************************************************************************************************
	* Function: getTestCaseName
	* Author: Rory Cruickshank
	* Date: 17/03/2016
	* Purpose: Get the test name from the test path String
	* Arguments: sTestCase
	* 
	* Returns: value
	*****************************************************************************************************
	* Change Log:
	* 
	* Date:
	* Author: 
	* Details:
	*
	****************************************************************************************************/
    public static String getTestCaseName(String sTestCase)throws Exception{
 
        String value = sTestCase;
 
        try{
            int posi = value.indexOf("@");
            value = value.substring(0, posi);
            posi = value.lastIndexOf(".");    
            value = value.substring(posi + 1);
            return value;
         }catch (Exception e){
             Log.error("Class Utils | Method getTestCaseName | Exception desc : "+e.getMessage());
             throw (e);
        }
        
    }
    
	/* **************************************************************************************************
	* Function: clickOrViewLink
	* Author: Rory Cruickshank
	* Date: 06/09/2017
	* Purpose: Check if a link is to be clicked. If yes, click and check that correct page is returned, else
	* 			check that correct link text is displayed
	* Arguments: sMethodName, bClickLink, eLink, sLandingPageObjectName, eLandingPageObject, sLinkText
	* 
	* Returns: 
	*****************************************************************************************************
	* Change Log:
	* 
	* Date:
	* Author: 
	* Details:
	*
	****************************************************************************************************/
    public static void clickOrViewLink(String sMethodName, Boolean bClickLink, String sLinkName, WebElement eLink, String sLinkText)throws Exception{
    
		try{
			if (bClickLink == true) {
				eLink.click();
			}else if (bClickLink == false) {
				//Check if we have a text value for the link to be checked
				if (sLinkText.length() > 0) {
					if (eLink.getText().contentEquals(sLinkText)) {
						Log.info("Class Utils | Method " + sMethodName + " | \"" + eLink.getText() + "\" displayed as " + sLinkName + " link text");		
					}else {
						Log.error("Class Utils | Method " + sMethodName + " | Unexpected result for link text. Expected: \"" + sLinkText + "\" but actual: \"" + eLink.getText() + "\".");
					}
				}else {
					//Just check that the object is displayed
					if (eLink.isDisplayed()) {
						Log.info("Class Utils | Method " + sMethodName + " | Link " + sLinkName + " displayed as expected.");
					}
				}
			}else {
				Log.error("Class Utils | Method " + sMethodName + " | Unexpected result for bClickLink variable on element \"" + sLinkName + "\". Expected 'True' or 'False' but actual result: " + bClickLink);
			}
		}catch (Exception e) {
			Log.error("Class Utils | Method " + sMethodName + " | Exception desc : "+e.getMessage());
		    throw (e);
	    } 
    }
    
	/* **************************************************************************************************
	* Function: checkLabelText
	* Author: Rory Cruickshank
	* Date: 06/09/2017
	* Purpose: Check if correct text is displayed for a label
	* Arguments: sMethodName, sLabelName, eLabelObject, sLabelText
	* 
	* Returns: 
	*****************************************************************************************************
	* Change Log:
	* 
	* Date:
	* Author: 
	* Details:
	*
	****************************************************************************************************/
    public static void checkLabelText(String sMethodName, String sLabelName, WebElement eLabelObject, String sLabelText)throws Exception{
    
    	try {
    		if (eLabelObject.getText().contentEquals(sLabelText)) {
    			Log.info("Class Utils | Method " + sMethodName + " | " + sLabelName + " label text \"" + eLabelObject.getText() + "\" displayed as expected.");
    		}else {
    			Log.error("Class Utils | Method " + sMethodName + " | Label text not displayed as expected for " + sLabelName + ". Expected: \"" + sLabelText + "\" but actual: \"" + eLabelObject.getText() + "\"");
    		}
    	}catch (Exception e) {
	        Log.error("Class Utils | Method " + sMethodName + " | Exception desc : "+e.getMessage());
	        throw (e);
    	}
    }
    
	/* **************************************************************************************************
	* Function: textBoxHandler
	* Author: Rory Cruickshank
	* Date: 06/09/2017
	* Purpose: Check if correct text is displayed for a label
	* Arguments: sMethodName, sTextBoxName, eTextBoxObject, sPlaceholderText, sInputValue
	* 
	* Returns: 
	*****************************************************************************************************
	* Change Log:
	* 
	* Date:
	* Author: 
	* Details:
	*
	****************************************************************************************************/
    public static void textBoxHandler(String sMethodName, String sTextBoxName, WebElement eTextBoxObject, String sPlaceholderText, String sInputValue) {
    	
       	try {
       		//Check if we need to look for placeholder text
    		if (sPlaceholderText.length() > 0) {
    			//Now check that the expected value is returned
    			if (eTextBoxObject.getAttribute("placeholder").contentEquals(sPlaceholderText)) {
	    			Log.info("Class Utils | Method " + sMethodName + " | " + sTextBoxName + " input value \"" + eTextBoxObject.getText() + "\" displayed as expected.");
	    		}else {
	    			Log.error("Class Utils | Method " + sMethodName + " | Text not displayed as expected for " + sTextBoxName + ". Expected: \"" + sInputValue + "\" but actual: \"" + eTextBoxObject.getText() + "\"");
	    		} 			
    		}
    		//Check if we need to input a value to the textbox
    		if(sInputValue.length() > 0) {
    			eTextBoxObject.sendKeys(sInputValue);
    			//Now check that the expected value is returned
    			if (eTextBoxObject.getAttribute("value").contentEquals(sInputValue)) {
	    			Log.info("Class Utils | Method " + sMethodName + " | " + sTextBoxName + " input value \"" + eTextBoxObject.getText() + "\" displayed as expected.");
	    		}else {
	    			Log.error("Class Utils | Method " + sMethodName + " | Text not displayed as expected for " + sTextBoxName + ". Expected: \"" + sInputValue + "\" but actual: \"" + eTextBoxObject.getText() + "\"");
	    		}
    		}else {
    			Log.info("Class Utils | Method " + sMethodName + " | No input value given for textbox " + sTextBoxName);	
    		}
    	}catch (Exception e) {
	        Log.error("Class Utils | Method " + sMethodName + " | Exception desc : "+e.getMessage());
	        throw (e);
    	}
    }
    
	/* **************************************************************************************************
	* Function: selectFromCombobox
	* Author: Rory Cruickshank
	* Date: 21/03/2016
	* Purpose: Get the test name from the test path String
	* Arguments: sIDName
	* 
	* Returns: value
	*****************************************************************************************************
	* Change Log:
	* 
	* Date:
	* Author: 
	* Details:
	*
	****************************************************************************************************/
    public static String selectFromCombobox(String sIDName)throws Exception{
    	
	    try {
	    	WebElement element = driver.findElement(By.id(sIDName));
	    	Select oSelect = new Select(element);
	    	oSelect.selectByValue(sIDName);
	    	return "Combobox set to " + sIDName;
	    }catch (Exception e){
	        Log.error("Class Utils | Method selectFromCombobox | Exception desc : "+e.getMessage());
	        throw (e);
	    }   
    }  

	/* **************************************************************************************************
	* Function: getUniqueReference
	* Author: Rory Cruickshank
	* Date: 21/03/2016
	* Purpose: Generate a unique value based on an original reference
	* Arguments: sOriginalReference
	* 
	* Returns: value
	*****************************************************************************************************
	* Change Log:
	* 
	* Date:
	* Author: 
	* Details:
	*
	****************************************************************************************************/
    public static String getUniqueReference(String sOriginalReference) throws Exception{

    	//Set our initial variables
    	String dateStart = "11/23/2013 07:00:00";
	    SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	    Date date1 = null;
	    Date date2 = Calendar.getInstance().getTime();
	
	    //Try to get difference between two times and return appended string
	    try {
	        date1 = format.parse(dateStart);
	        //in milliseconds
	        long diff = date2.getTime() - date1.getTime();
	        return sOriginalReference + diff;
	    } catch (Exception e) {
            Log.error("Class Utils | Method getUniqueNumber | Exception desc : "+e.getMessage());
            throw (e);
	    }
    }
    
    /* **************************************************************************************************
	* Function: takeScreenshot
	* Author: Rory Cruickshank
	* Date: 30/03/2016
	* Purpose: Take a screenshot and save with the test name
	* Arguments: driver
	* 			sTestCaseName
	* Returns: void
	*****************************************************************************************************
	* Change Log:
	*
	* Date:
	* Author: 
	* Details:
	*
	****************************************************************************************************/
  	 public static void takeScreenshot(WebDriver driver, String sTestCaseName) throws Exception{
		
  		 //Get the current date and time for adding to file
  		 Date now = Calendar.getInstance().getTime();
  	     SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-hhmmss");
  	     String appendDate = formatter.format(now);
  	     
  	     //Now try taking a screenshot and saving with the supplied test case name and created date
  		 try{
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String fileName = Constant.Path_ScreenShot + sTestCaseName + appendDate + ".jpg";
			FileUtils.copyFile(scrFile, new File(fileName));	
			Log.info("Class Utils | Method takeScreenshot | Screenshot saved as " + fileName);
  		 } catch (Exception e){
			Log.error("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "+e.getMessage());
			throw new Exception();
  		 }
	 }

    /* **************************************************************************************************
 	* Function: assignStringVariable
 	* Author: Rory Cruickshank
 	* Date: 05/04/2016
 	* Purpose: Assign a variable according to the cell contents from Excel
 	* Arguments: sVariableName
 	* 			iRow
 	* Returns: void
 	*****************************************************************************************************
 	* Change Log:
 	* 
 	* Date:
 	* Author: 
 	* Details:
 	*
 	****************************************************************************************************/
 	public static String assignStringVariable(String sVariableName, Integer iRow){

 		String sVarAssigned;
		try{
			sVarAssigned = ExcelUtils.getCellData(iRow, ExcelUtils.getColContains(sVariableName, 0));	
			Log.info(sVariableName + " picked from Excel is \"" + sVarAssigned + "\"");
			return sVarAssigned;
		} catch (Exception e){
			return "Class Utils | Assign variable to " + sVariableName +" | Exception desc : "+e.getMessage();			
		}
 	}
 	
    /* **************************************************************************************************
	* Function: assignUniqueVariable
	* Author: Rory Cruickshank
	* Date: 06/04/2016
	* Purpose: Assign a variable according to the cell contents from Excel
	* Arguments: sVariableName
	* 			iRow
	* 			iCol
	* Returns: void
	*****************************************************************************************************
	* Change Log:
	* 
	* Date:
	* Author: 
	* Details:
	*
	****************************************************************************************************/
	public static String assignUniqueVariable(String sVariableName, Integer iRow){

		String sVarAssigned;
		try{
			sVarAssigned = Utils.getUniqueReference(ExcelUtils.getCellData(iRow, ExcelUtils.getColContains(sVariableName, 0)));	
			Log.info(sVariableName + " picked from Excel is \"" + sVarAssigned + "\"");
			return sVarAssigned;
		} catch (Exception e){
			return "Class Breaking_News_Add_New_Item | Assign variable to " + sVariableName + " | Exception desc : "+e.getMessage();			
		}
	}
 	
    /* **************************************************************************************************
	* Function: assignIntVariable
	* Author: Rory Cruickshank
	* Date: 05/04/2016
	* Purpose: Assign a variable according to the cell contents from Excel
	* Arguments: sVariableName
	* 			iRow
	* 			iCol
	* Returns: void
	*****************************************************************************************************
	* Change Log:
	* 
	* Date:
	* Author: 
	* Details:
	*
	****************************************************************************************************/
 	public static Integer assignIntVariable(String sVariableName, Integer iRow){

 		Integer iVarAssigned;
		
 		try{
			iVarAssigned = ExcelUtils.getIntCellData(iRow, ExcelUtils.getColContains(sVariableName, 0));	
			Log.info(sVariableName + " picked from Excel is \""+ iVarAssigned + "\"");
			return iVarAssigned;
		} catch (Exception e){
			Log.error("Class Utils | Assign variable to " + sVariableName +" | Exception desc : "+e.getMessage());
			return 0;
		}
 	}
    
    /* **************************************************************************************************
	* Function: attachLeadingZero
	* Author: Rory Cruickshank
	* Date: 06/04/2016
	* Purpose: Check if a leading zero is required, attach if necessary and return as a string
	* Arguments: iNumberToCheck
	* 			
	* Returns: void
	*****************************************************************************************************
	* Change Log:
	* 
	* Date:
	* Author: 
	* Details:
	*
	****************************************************************************************************/
 	public static String attachLeadingZero(Integer iNumberToCheck){
 		
		//Check if this needs a zero added
 		String sNumberToCheck = iNumberToCheck.toString();
		if (sNumberToCheck.length() == 1){
			sNumberToCheck = "0" + sNumberToCheck;
			Log.info("Number set to \"" + iNumberToCheck + "\"");
			return sNumberToCheck;
		}else{
			Log.info("Number \"" + sNumberToCheck + "\" already at desired length so no action required");
			return sNumberToCheck;
		}
 	}

    /* **************************************************************************************************
	* Function: checkForWarning
	* Author: Rory Cruickshank
	* Date: 06/04/2016
	* Purpose: Check if a warning message is displayed and returns the text
	* Arguments: sMethodName
	* 			sWarningObject
	* Returns: void
	*****************************************************************************************************
	* Change Log:
	* 
	* Date:
	* Author: 
	* Details:
	*
	****************************************************************************************************/
 	public static void checkForWarning(String sMethodName, WebElement sWarningObject){
	
		if(sWarningObject.isDisplayed() == true){
			Log.info(sMethodName + "Warning message displayed: \"" + sWarningObject.getText() + "\"");
		}else{
			Log.error(sMethodName + "Warning message not displayed for object: " + sWarningObject);
		}
 			
 	}
 	
    /* **************************************************************************************************
	* Function: checkboxHandler
	* Author: Rory Cruickshank
	* Date: 06/04/2016
	* Purpose: Handles whether a checkbox should be set to on or off
	* Arguments: sCheckboxName
	* 			sCheckboxObject
	* 			bExpectedState
	* Returns: void
	*****************************************************************************************************
	* Change Log:
	* 
	* Date:
	* Author: 
	* Details:
	*
	****************************************************************************************************/
 	public static void checkboxHandler(String sCheckboxName, WebElement sCheckboxObject, Boolean bExpectedState){

 		if (bExpectedState == true){
			//Check if the box has been selected
			if (sCheckboxObject.isSelected() == true){
				Log.info(sCheckboxName + " checkbox is already set to true as expected. No action required");
			}else{
				sCheckboxObject.click();
				Log.info(sCheckboxName + " checkbox set to true");				
			}
		}else if (bExpectedState == false){
			//Check that the box has not been selected
			if (sCheckboxObject.isSelected() == false){
				Log.info(sCheckboxName + " checkbox is already set to false as expected. No action required");
			}else{
				sCheckboxObject.click();
				Log.info(sCheckboxName + " checkbox set to false");				
			}
		}else{
			Log.info(sCheckboxName + " is not defined. No action required");
		}
 	}
 	
    /* **************************************************************************************************
	* Function: checkTableForEntry
	* Author: Rory Cruickshank
	* Date: 06/04/2016
	* Purpose: Handles whether a checkbox should be set to on or off
	* Arguments: sCheckboxName
	* 			sCheckboxObject
	* 			bExpectedState
	* Returns: void
	*****************************************************************************************************
	* Change Log:
	* 
	* Date:
	* Author: 
	* Details:
	*
	****************************************************************************************************/
 	public static void checkTableAndClickEntryIfRequired(WebElement sTableObject, String sSearchedEntry, String sTableName, Boolean bClickOnACell){
 		
 		List<WebElement> rows = sTableObject.findElements(By.tagName("tr"));
 		WebElement sLinkToClick;
 		Boolean bEntryFound = false;
 		
 		//Iterate through the rows
 		for(WebElement row : rows){
 			List<WebElement> columns = row.findElements(By.tagName("td"));
 			//Now through each column of the rows
 			for(WebElement column : columns){
 				String sCurrentEntry = column.getText();
				//If we find what we're looking for, set our boolean to true and stop searching				
 				if (sCurrentEntry.contains(sSearchedEntry) == true){
 					bEntryFound = true;
 					if (bClickOnACell == true){
	 					//Click on the cell containing our searched for data 
						sLinkToClick = row.findElement(By.partialLinkText(sSearchedEntry));
						sLinkToClick.click();
 					}
 					break;
 				}
 			}
 			if (bEntryFound == true){
 				break;
 			}
 		}
 
 		//Now check to see if we have successfully found the entry we are looking for
 		if (bEntryFound = true){
			Log.info("checkTableForEntry | Searched entry \"" + sSearchedEntry + "\" found in table " + sTableName );
		}else{
			Log.error("checkTableForEntry | Searched entry \"" + sSearchedEntry + "\" not found in table " + sTableName );			
		}
 	
 	}

    /* **************************************************************************************************
	* Function: checkNewPage
	* Author: Rory Cruickshank
	* Date: 07/04/2016
	* Purpose: Handles checking that correct page has been returned
	* Arguments: sPageName
	* 			sDestinationCheck
	* Returns: void
	*****************************************************************************************************
	* Change Log:
	* 
	* Date:
	* Author: 
	* Details:
	*
	****************************************************************************************************/	
 	public static void checkNewPage(String sMethodName, String sPageName, WebElement eDestinationCheck){
 		
 		try{
 			//Check that we have found the correct page
 			if(eDestinationCheck.isDisplayed() == true){
 				Log.info("Class Utils | Method " + sMethodName + " | " + sPageName + " page found on clicking link");
 			}else{
 				Log.error("Class Utils | Method " + sMethodName + " | " + sPageName + " page not found on clicking link");
 			}
 		}catch(Exception e){
			Log.error("Class Utils | Method " + sMethodName + " | Navigate to " + sPageName +" | Exception desc : "+e.getMessage());		
 		}
 	}
 	
    /* **************************************************************************************************
	* Function: checkSearchFilter
	* Author: Rory Cruickshank
	* Date: 09/06/2016
	* Purpose: Handles checking that correct search filter has been applied
	* Arguments: sExpectedResult
	* 			sReturnedResult
	* Returns: void
	*****************************************************************************************************
	* Change Log:
	* 
	* Date:
	* Author: 
	* Details:
	*
	****************************************************************************************************/	
 	public static void checkSearchFilter(String sExpectedResult, String sReturnedResult){
 		
 		try{
 			//Check that we have found the correct page
 			if(sReturnedResult.contentEquals(sExpectedResult) == true){
 				Log.info(sExpectedResult + " page found on clicking link");
 			}else{
 				Log.error("checkSearchFilter | " + sExpectedResult + " page not found on clicking link");
 			}
 		}catch(Exception e){
			Log.error("checkSearchFilter | Navigate to " + sExpectedResult +" | Exception desc : "+e.getMessage());		
 		}
 	}
 	
    /* **************************************************************************************************
	* Function: waitForTime
	* Author: Rory Cruickshank
	* Date: 28/04/2016
	* Purpose: Handles checking that a wait has been correctly processed
	* Arguments: iWaitPeriod
	* 			sTestCaseName
	* Returns: void
	*****************************************************************************************************
	* Change Log:
	* 
	* Date:
	* Author: 
	* Details:
	*
	****************************************************************************************************/
 	public static void waitForTime(int iWaitPeriod, String sTestCaseName){
		
 		try {
			Thread.sleep(iWaitPeriod);
		} catch (InterruptedException ie) {
			Log.error(sTestCaseName + " | Exception occurred | Exception desc : " + ie.getMessage());
		}
 	}
 		
    /* **************************************************************************************************
 	* Function: passAuthentication
 	* Author: Rory Cruickshank
 	* Date: 21/06/2016
 	* Purpose: Handles sending authentication checks until all popups have been resolved
 	* Arguments: sTestCaseName
 	* 			sUserName
 	* 			sPassword
 	* Returns: void
 	*****************************************************************************************************
 	* Change Log:
 	* 
 	* Date:
 	* Author: 
 	* Details:
 	*
 	****************************************************************************************************/
 	public static void passAuthentication(String sTestCaseName, String sUserName, String sPassword){
	
 		for (int iCount = 0; iCount < 10; iCount++){
			WebDriverWait wait = new WebDriverWait(driver, 10);
			try{
				Alert alert = wait.until(ExpectedConditions.alertIsPresent());    
				alert.authenticateUsing(new UserAndPassword(sUserName, sPassword));
			}catch(Exception e){
				Log.info(sTestCaseName + " | Authentication popup not found after " + iCount + " iterations");
				break;
			}
		}
 	}
 	
//END OF METHODS    
}
