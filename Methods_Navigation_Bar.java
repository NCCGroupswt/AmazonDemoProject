package methods;

import org.openqa.selenium.WebDriver;
import pageObjectRepositories.Objects_Navigation_Bar;
import pageObjectRepositories.Objects_Results_Page_SD_Card;
import utility.Utils;

public class Methods_Navigation_Bar{
	
	//Declare variables 
	private static Boolean bHomeClick; 
	private static String sSearchPlaceholderText;
	private static String sSearchInputValue;
	private static Boolean bYourAmazonClick;
	private static String sYourAmazonText;
	private static Boolean bTodaysDealsClick;
	private static String sTodaysDealsText;
	private static Boolean bGiftCardsClick;
	private static String sGiftCardsText;
	private static Boolean bSellClick;
	private static String sSellText;
	private static Boolean bHelpClick;
	private static String sHelpText;
	private static Boolean bOrdersClick;
	private static String sOrdersText;
	private static Boolean bTryPrimeClick;
	private static String sTryPrimeText;
	private static Boolean bYourListsClick;
	private static String sYourListsText;
	private static Boolean bBasketClick;
	private static String sBasketText;
	
	/* **************************************************************************************************
	* Method: getTableValues
	* Author: Rory Cruickshank
	* Date: 06/09/2017
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
		
		bHomeClick = Boolean.valueOf(Utils.assignStringVariable("HomeClick", iRow)); 
		sSearchPlaceholderText = Utils.assignStringVariable("SearchPlaceholderText", iRow);
		sSearchInputValue = Utils.assignStringVariable("SearchInputValue", iRow);;
		bYourAmazonClick = Boolean.valueOf(Utils.assignStringVariable("YourAmazonClick", iRow));
		sYourAmazonText = Utils.assignStringVariable("YourAmazonText", iRow);
		bTodaysDealsClick = Boolean.valueOf(Utils.assignStringVariable("TodaysDealsClick", iRow));
		sTodaysDealsText = Utils.assignStringVariable("TodaysDealsText", iRow);
		bGiftCardsClick = Boolean.valueOf(Utils.assignStringVariable("GiftCardsClick", iRow));
		sGiftCardsText = Utils.assignStringVariable("GiftCardsText", iRow);
		bSellClick = Boolean.valueOf(Utils.assignStringVariable("SellClick", iRow));
		sSellText = Utils.assignStringVariable("SellText", iRow);
		bHelpClick = Boolean.valueOf(Utils.assignStringVariable("HelpClick", iRow));
		sHelpText = Utils.assignStringVariable("HelpText", iRow);
		bOrdersClick = Boolean.valueOf(Utils.assignStringVariable("OrdersClick", iRow));
		sOrdersText = Utils.assignStringVariable("OrdersText", iRow);
		bTryPrimeClick = Boolean.valueOf(Utils.assignStringVariable("TryPrimeClick", iRow));
		sTryPrimeText = Utils.assignStringVariable("TryPrimeText", iRow);
		bYourListsClick = Boolean.valueOf(Utils.assignStringVariable("YourListsClick", iRow));
		bBasketClick = Boolean.valueOf(Utils.assignStringVariable("BasketClick", iRow));
		sYourListsText = Utils.assignStringVariable("YourListsText", iRow);
		sBasketText = Utils.assignStringVariable("BasketText", iRow);

	//END OF GET TABLE VALUES METHOD
	}
	
	/* **************************************************************************************************
	* Method: navigateThroughBar
	* Author: Rory Cruickshank
	* Date: 06/09/2017
	* Purpose: This method handles the navigation bar depending on which variables are selected 
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
	public static void navigateThroughBar(WebDriver driver, String sTestCaseName, int iRow) throws Exception{
	
		//Declare our method name variable
		String sMethodName = "navigateThroughBar";
		//Get the table values
		getTableValues(iRow);
		
		//Handle the objects on the Navigation bar
		Utils.clickOrViewLink(sMethodName, bHomeClick, "lnk_Logo", Objects_Navigation_Bar.lnk_Logo(driver), "");
		if (bHomeClick == true) {
			Utils.checkNewPage(sMethodName, "", Objects_Navigation_Bar.lnk_Logo(driver));
		}
		Utils.checkLabelText(sMethodName, "lbl_Shop_By", Objects_Navigation_Bar.lbl_Shop_By(driver), "Shop by");
		Utils.clickOrViewLink(sMethodName, bYourAmazonClick, "lnk_Your_Amazon", Objects_Navigation_Bar.lnk_Your_Amazon(driver), sYourAmazonText);
		if (bYourAmazonClick == true) {
			Utils.checkNewPage(sMethodName, sYourAmazonText, Objects_Navigation_Bar.lnk_Your_Amazon(driver));
		}
		Utils.clickOrViewLink(sMethodName, bTodaysDealsClick, "lnk_Todays_Deals", Objects_Navigation_Bar.lnk_Todays_Deals(driver), sTodaysDealsText);
		if (bTodaysDealsClick == true) {
			Utils.checkNewPage(sMethodName, sTodaysDealsText, Objects_Navigation_Bar.lnk_Todays_Deals(driver));
		}
		Utils.clickOrViewLink(sMethodName, bGiftCardsClick, "lnk_Gift_Cards_And_Top_Up", Objects_Navigation_Bar.lnk_Gift_Cards_And_Top_Up(driver), sGiftCardsText);
		if (bGiftCardsClick == true) {
			Utils.checkNewPage(sMethodName, sGiftCardsText, Objects_Navigation_Bar.lnk_Gift_Cards_And_Top_Up(driver));
		}
		Utils.clickOrViewLink(sMethodName, bSellClick, "lnk_Sell", Objects_Navigation_Bar.lnk_Sell(driver), sSellText);
		if (bSellClick == true) {
			Utils.checkNewPage(sMethodName, sSellText, Objects_Navigation_Bar.lnk_Sell(driver));
		}
		Utils.clickOrViewLink(sMethodName, bHelpClick, "lnk_Help", Objects_Navigation_Bar.lnk_Help(driver), sHelpText);
		if (bHelpClick == true) {
			Utils.checkNewPage(sMethodName, sHelpText, Objects_Navigation_Bar.lnk_Help(driver));
		}
		Utils.checkLabelText(sMethodName, "lbl_Hello_Sign_In", Objects_Navigation_Bar.lbl_Hello_Sign_In(driver), "Hello. Sign in");
		//Check if we are looking for the Orders link
		if (sOrdersText.length() > 0) {
			Utils.clickOrViewLink(sMethodName, bOrdersClick, "lnk_Orders", Objects_Navigation_Bar.lnk_Orders(driver), sOrdersText);
			if (bOrdersClick == true) {
				Utils.checkNewPage(sMethodName, sOrdersText, Objects_Navigation_Bar.lnk_Orders(driver));
			}
		}
		Utils.checkLabelText(sMethodName, "lbl_Try_Prime", Objects_Navigation_Bar.lbl_Try_Prime(driver), "Try");
		Utils.clickOrViewLink(sMethodName, bTryPrimeClick, "lnk_Try_Prime", Objects_Navigation_Bar.lnk_Try_Prime(driver), sOrdersText);
		if (bTryPrimeClick == true) {
			Utils.checkNewPage(sMethodName, sTryPrimeText, Objects_Navigation_Bar.lnk_Try_Prime(driver));
		}
		//Check if we are looking for the Your Lists link
		if (sYourListsText.length() > 0) {
			Utils.checkLabelText(sMethodName, "lbl_Your_Lists", Objects_Navigation_Bar.lbl_Your_Lists(driver), "Your");
			Utils.clickOrViewLink(sMethodName, bYourListsClick, "lnk_Your_Lists", Objects_Navigation_Bar.lnk_Your_Lists(driver), sYourListsText);
			if (bYourListsClick == true) {
				Utils.checkNewPage(sMethodName, sYourListsText, Objects_Navigation_Bar.lnk_Your_Lists(driver));
			}
		}
		Utils.clickOrViewLink(sMethodName, bBasketClick, "lnk_Basket", Objects_Navigation_Bar.lnk_Basket(driver), sBasketText);
		if (bBasketClick == true) {
			Utils.checkNewPage(sMethodName, sBasketText, Objects_Navigation_Bar.lnk_Basket(driver));
		}
		Utils.takeScreenshot(driver, sTestCaseName);
		
	//END OF NAVIGATE THROUGH BAR METHOD
	}
	
	/* **************************************************************************************************
	* Method: searchForProduct
	* Author: Rory Cruickshank
	* Date: 12/09/2017
	* Purpose: This method handles using the search bar to search for products 
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
	public static void searchForProduct(WebDriver driver, String sTestCaseName, int iRow) throws Exception{
		
		//Declare our method name variable
		String sMethodName = "searchForProduct";
		//Get the table values
		getTableValues(iRow);
		
		//Handle the Search textbox and click Search button
		Utils.textBoxHandler(sMethodName, "txt_Search", Objects_Navigation_Bar.txt_Search(driver), sSearchPlaceholderText, sSearchInputValue);
		Objects_Navigation_Bar.btn_Search(driver).click();
		//Now check that we have reached the products page
		Utils.checkNewPage(sMethodName, "SD Card Product Results", Objects_Results_Page_SD_Card.Header.lbl_Category_Final(driver));
		Utils.takeScreenshot(driver, sTestCaseName);
		
	//END OF SEARCH FOR PRODUCT METHOD	
	}
	
//END OF METHODS
}