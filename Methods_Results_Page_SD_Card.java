package methods;

import org.openqa.selenium.WebDriver;
import pageObjectRepositories.Objects_Results_Page_SD_Card;
import utility.Log;
import utility.Utils;

public class Methods_Results_Page_SD_Card{
	
	//Declare variables 
	private static String sAnyCategory;
	private static String sCategoryOne;
	private static String sCategoryTwo;
	private static String sCategoryThree;
	private static String sCategoryFinal;
	private static String sRefinerOne;
	private static String sRefinerTwo;
	private static String sRefinerThree;
	private static String sRefinerFour;
	private static String sRefinerFive;
	private static String sRefinerSix;
	private static String sRefinerSeven;
	private static String sRefinerEight;
	private static String sRefinerNine;
	private static String sRefinerTen;
	
	/* **************************************************************************************************
	* Method: getTableValues
	* Author: Rory Cruickshank
	* Date: 12/09/2017
	* Purpose: This method gets values for all of the associated variables
	* Arguments: 
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
	public static void getTableValues(int iRow) {
		
		sAnyCategory = Utils.assignStringVariable("AnyCategory", iRow);
		sCategoryOne = Utils.assignStringVariable("CategoryOne", iRow); 
		sCategoryTwo = Utils.assignStringVariable("CategoryTwo", iRow);
		sCategoryThree = Utils.assignStringVariable("CategoryThree", iRow);;
		sCategoryFinal = Utils.assignStringVariable("CategoryFinal", iRow);
		sRefinerOne = Utils.assignStringVariable("RefinerOne", iRow);
		sRefinerTwo = Utils.assignStringVariable("RefinerTwo", iRow);
		sRefinerThree = Utils.assignStringVariable("RefinerThree", iRow);
		sRefinerFour = Utils.assignStringVariable("RefinerFour", iRow);
		sRefinerFive = Utils.assignStringVariable("RefinerFive", iRow);
		sRefinerSix = Utils.assignStringVariable("RefinerSix", iRow);
		sRefinerSeven = Utils.assignStringVariable("RefinerSeven", iRow);
		sRefinerEight = Utils.assignStringVariable("RefinerEight", iRow);
		sRefinerNine = Utils.assignStringVariable("RefinerNine", iRow);
		sRefinerTen = Utils.assignStringVariable("RefinerTen", iRow);

	//END OF GET TABLE VALUES METHOD
	}
	
	/* **************************************************************************************************
	* Method: checkResultsPage
	* Author: Rory Cruickshank
	* Date: 12/09/2017
	* Purpose: This method handles selecting which areas of the results page to check 
	* Arguments: driver, bCheckHeader, bCheckSidebar, iRow
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
	public static void checkResultsPage(WebDriver driver, Boolean bCheckHeader, Boolean bCheckSidebar, Boolean bCheckFooter, int iRow) throws Exception{
	
		//Get the table values
		getTableValues(iRow);
		
		if (bCheckHeader == true) {
			Methods_Results_Page_SD_Card.checkHeader(driver);
		}
		
		if (bCheckSidebar == true) {
			Methods_Results_Page_SD_Card.checkSidebar(driver);
		}	
		
		if (bCheckFooter == true) {
			Methods_Results_Page_SD_Card.checkFooter(driver);
		}	
		
	//END OF CHECK RESULTS PAGE METHODS
	}
	
	/* **************************************************************************************************
	* Method: checkHeader
	* Author: Rory Cruickshank
	* Date: 12/09/2017
	* Purpose: This method handles checking the header on the results page
	* Arguments: 
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
	public static void checkHeader(WebDriver driver) throws Exception{
	
		//Declare our method name variable
		String sMethodName = "checkHeader";
		
		//Handle the objects on the Header
		//Cutting this line as the Amazon site sometimes does not return 'x of y' part of string
		/*Utils.checkLabelText(sMethodName, "hdr_Results_For", Objects_Results_Page_SD_Card.Header.hdr_Results_For(driver), 
				"1-24 of over 200,000 results for " + sCategoryOne + " : " + sCategoryTwo + " : " + sCategoryThree + " : " + sCategoryFinal);*/
		Utils.checkLabelText(sMethodName, "lbl_Category_One", Objects_Results_Page_SD_Card.Header.lbl_Category_One(driver), sCategoryOne);
		Utils.checkLabelText(sMethodName, "lbl_Category_Two", Objects_Results_Page_SD_Card.Header.lbl_Category_Two(driver), sCategoryTwo);
		Utils.checkLabelText(sMethodName, "lbl_Category_Three", Objects_Results_Page_SD_Card.Header.lbl_Category_Three(driver), sCategoryThree);
		Utils.checkLabelText(sMethodName, "lbl_Category_Final", Objects_Results_Page_SD_Card.Header.lbl_Category_Final(driver), sCategoryFinal);
		Utils.checkLabelText(sMethodName, "lbl_Sort_By", Objects_Results_Page_SD_Card.Header.lbl_Sort_By(driver), "Sort by ");
		if (Objects_Results_Page_SD_Card.Header.ddl_Sort_By(driver).isDisplayed()) {
			Log.info(sMethodName + "| \"Sort by\" dropdown list displayed as expected");
		}else {
			Log.info(sMethodName + "| \"Sort by\" dropdown list expected but not displayed");
		}
		
	//END OF CHECK HEADER METHOD
	}
	
	/* **************************************************************************************************
	* Method: checkSidebar
	* Author: Rory Cruickshank
	* Date: 12/09/2017
	* Purpose: This method handles checking the header on the results page 
	* Arguments: 
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
	public static void checkSidebar(WebDriver driver) throws Exception{
	
		//Declare our method name variable
		String sMethodName = "checkHeader";
		
		//Handle the objects on the Sidebar
		Utils.checkLabelText(sMethodName, "hdr_Show_Results_For", Objects_Results_Page_SD_Card.Sidebar.hdr_Show_Results_For(driver), "Show results for");
		Utils.checkLabelText(sMethodName, "lnk_Any_Category", Objects_Results_Page_SD_Card.Sidebar.lnk_Any_Category(driver), sAnyCategory);
		Utils.checkLabelText(sMethodName, "lnk_Category_One", Objects_Results_Page_SD_Card.Sidebar.lnk_Category_One(driver), sCategoryOne);
		Utils.checkLabelText(sMethodName, "lnk_Category_Two", Objects_Results_Page_SD_Card.Sidebar.lnk_Category_Two(driver), sCategoryTwo);
		Utils.checkLabelText(sMethodName, "hdr_Category_Three", Objects_Results_Page_SD_Card.Sidebar.hdr_Category_Three(driver), sCategoryThree);
		Utils.checkLabelText(sMethodName, "hdr_Refine_By", Objects_Results_Page_SD_Card.Sidebar.hdr_Refine_By(driver), "Refine by");
		Utils.checkLabelText(sMethodName, "hdr_Refiner_One", Objects_Results_Page_SD_Card.Sidebar.hdr_Refiner_One(driver), sRefinerOne);
		Utils.checkLabelText(sMethodName, "hdr_Refiner_Two", Objects_Results_Page_SD_Card.Sidebar.hdr_Refiner_Two(driver), sRefinerTwo);
		Utils.checkLabelText(sMethodName, "hdr_Refiner_Three", Objects_Results_Page_SD_Card.Sidebar.hdr_Refiner_Three(driver), sRefinerThree);
		Utils.checkLabelText(sMethodName, "hdr_Refiner_Four", Objects_Results_Page_SD_Card.Sidebar.hdr_Refiner_Four(driver), sRefinerFour);
		Utils.checkLabelText(sMethodName, "hdr_Refiner_Five", Objects_Results_Page_SD_Card.Sidebar.hdr_Refiner_Five(driver), sRefinerFive);
		Utils.checkLabelText(sMethodName, "hdr_Refiner_Six", Objects_Results_Page_SD_Card.Sidebar.hdr_Refiner_Six(driver), sRefinerSix);
		Utils.checkLabelText(sMethodName, "hdr_Refiner_Seven", Objects_Results_Page_SD_Card.Sidebar.hdr_Refiner_Seven(driver), sRefinerSeven);
		Utils.checkLabelText(sMethodName, "hdr_Refiner_Eight", Objects_Results_Page_SD_Card.Sidebar.hdr_Refiner_Eight(driver), sRefinerEight);
		Utils.checkLabelText(sMethodName, "hdr_Refiner_Nine", Objects_Results_Page_SD_Card.Sidebar.hdr_Refiner_Nine(driver), sRefinerNine);
		Utils.checkLabelText(sMethodName, "hdr_Refiner_Ten", Objects_Results_Page_SD_Card.Sidebar.hdr_Refiner_Ten(driver), sRefinerTen);
		
	//END OF CHECK SIDEBAR METHOD	
	}
	
	/* **************************************************************************************************
	* Method: checkFooter
	* Author: Rory Cruickshank
	* Date: 12/09/2017
	* Purpose: This method handles checking the footer on the results page 
	* Arguments: 
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
	public static void checkFooter(WebDriver driver) throws Exception{
		
		//Placeholder to demonstrate that we can call methods as required

	//END OF CHECK FOOTER METHOD	
	}
	
//END OF METHODS
}