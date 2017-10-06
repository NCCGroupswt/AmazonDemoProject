/* *******************************************************************
* Test Case Name: Test_Results_Page_Check_Layout_Firefox
* Author: Rory Cruickshank
* Date: 12/09/2017
* Purpose: This test views the layout elements of a products listing page in Firefox
*
**********************************************************************
* Change Log:
* 
* Date:
* Author: 
* Details:
*
*********************************************************************/

package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import methods.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import utility.*;
import pageObjectRepositories.Objects_Navigation_Bar;
import pageObjectRepositories.Objects_Product_Page_SD_Card;
import pageObjectRepositories.Objects_Results_Page_SD_Card;

public class Test_Select_First_Item_Firefox {

	//Declare our test variables
	public WebDriver driver;	
	private String sTestCaseName;
	private int iTestCaseRow;
	private String sItemName;
	
	//Get data and open the browser
	@BeforeMethod
	public void beforeMethod() throws Exception {
	
		DOMConfigurator.configure("log4j.xml");
	
	    sTestCaseName = Utils.getTestCaseName(this.toString());
	
	    Log.startTestCase(sTestCaseName);
	
	    ExcelUtils.setExcelFile(Constant.Path_TestData + sTestCaseName + ".xlsx","Sheet1");
	
	    iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
	
	    driver = Utils.openBrowser(iTestCaseRow);
	    
		//Verify that we are on the correct page
		Objects_Navigation_Bar.lnk_Logo(driver).isDisplayed();
		Log.info("Logo link displayed");	
	
	}
	
	//Run the test
	@Test
	public void main() throws Exception {
		//Search for a product to navigate to the Results screen	
		Methods_Navigation_Bar.searchForProduct(driver, sTestCaseName, iTestCaseRow);
		//Now check that we have arrived at the results page
		Methods_Results_Page_SD_Card.checkResultsPage(driver, true, false, false, iTestCaseRow);
		//Now select the first item and check that it is available at checkout
		sItemName = Objects_Results_Page_SD_Card.lnk_First_Result_Description(driver).getText();
		Objects_Results_Page_SD_Card.lnk_First_Result(driver).click();
		if (Objects_Product_Page_SD_Card.hdr_Product_Title(driver).getText().contains(sItemName)) {
			
		}
	}
	
	//Log out
	@AfterMethod
	public void afterMethod() {
	
	    driver.quit();
	    
	    Log.endTestCase(sTestCaseName);        
	
	}
}

