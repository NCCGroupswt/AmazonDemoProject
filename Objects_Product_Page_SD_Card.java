package pageObjectRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;

/* *******************************************************************
* Author: Rory Cruickshank
* Date: 06/09/2017
* Function: Objects_Product_Page_SD_Card
* Purpose: This class contains all of the elements on the Products Page for SD Card 
* Arguments: 
* 			
* Returns: 
**********************************************************************
* Change Log:
* 
* Date:
* Author: 
* Details:
*
*********************************************************************/

public class Objects_Product_Page_SD_Card {
   
    private static WebElement element = null;
    private static String sRepositoryName = "Objects_Product_Page_SD_Card";

	public static WebElement hdr_Product_Title(WebDriver driver){
	   	 
		try{
			element = driver.findElement(By.xpath(".//*[@id='productTitle']"));
 		}catch(Exception e){
			Log.error(sRepositoryName + " | hdr_Product_Title not found | Exception desc : "+e.getMessage());		
 		} 
		return element;
	}
    
    public static class Header {
    
		public static WebElement hdr_Results_For(WebDriver driver){
		   	 
			try{
				element = driver.findElement(By.xpath(".//*[@id='s-result-count']"));
	 		}catch(Exception e){
				Log.error(sRepositoryName + " | hdr_Results_For not found | Exception desc : "+e.getMessage());		
	 		} 
			return element;
		}
		
		public static WebElement lbl_Category_One(WebDriver driver){
		   	 
			try{
				element = driver.findElement(By.xpath(".//*[@id='s-result-count']/span/a[1]"));
	 		}catch(Exception e){
				Log.error(sRepositoryName + " | lbl_Category_One not found | Exception desc : "+e.getMessage());		
	 		} 
			return element;
		}
		
		public static WebElement lbl_Category_Two(WebDriver driver){
		   	 
			try{
				element = driver.findElement(By.xpath(".//*[@id='s-result-count']/span/a[2]"));
	 		}catch(Exception e){
				Log.error(sRepositoryName + " | lbl_Category_Two not found | Exception desc : "+e.getMessage());		
	 		} 
			return element;
		}
		
		public static WebElement lbl_Category_Three(WebDriver driver){
		   	 
			try{
				element = driver.findElement(By.xpath(".//*[@id='s-result-count']/span/a[3]"));
	 		}catch(Exception e){
				Log.error(sRepositoryName + " | lbl_Category_Three not found | Exception desc : "+e.getMessage());		
	 		} 
			return element;
		}
    	
		public static WebElement lbl_Category_Final(WebDriver driver){
		   	 
			try{
				element = driver.findElement(By.xpath(".//*[@id='bcKwText']/span"));
	 		}catch(Exception e){
				Log.error(sRepositoryName + " | lbl_Category_Final not found | Exception desc : "+e.getMessage());		
	 		} 
			return element;
		}
		
		public static WebElement lbl_Sort_By(WebDriver driver){
	   	 
			try{
				element = driver.findElement(By.xpath(".//*[@id='sort_by_text']"));
	 		}catch(Exception e){
				Log.error(sRepositoryName + " | lbl_Sort_By not found | Exception desc : "+e.getMessage());		
	 		} 
			return element;
		}
		
		public static WebElement ddl_Sort_By(WebDriver driver){
		   	 
			try{
				element = driver.findElement(By.xpath(".//*[@id='sort']"));
	 		}catch(Exception e){
				Log.error(sRepositoryName + " | ddl_Sort_By not found | Exception desc : "+e.getMessage());		
	 		} 
			return element;
		}		
    
    //END OF HEADER METHODS
    }
    	
//END OF METHODS	    
}
