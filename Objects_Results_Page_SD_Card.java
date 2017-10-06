package pageObjectRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;

/* *******************************************************************
* Author: Rory Cruickshank
* Date: 06/09/2017
* Function: Objects_Results_Page_SD_Card
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

public class Objects_Results_Page_SD_Card {
   
    private static WebElement element = null;
    private static String sRepositoryName = "Objects_Results_Page_SD_Card";

	public static WebElement lnk_First_Result(WebDriver driver){
	   	 
		try{
			element = driver.findElement(By.xpath(".//*[@id='result_0']/div/div[2]/div/div/"));
 		}catch(Exception e){
			Log.error(sRepositoryName + " | lnk_First_Result not found | Exception desc : "+e.getMessage());		
 		} 
		return element;
	}
	
	public static WebElement lnk_First_Result_Description(WebDriver driver){
	   	 
		try{
			element = driver.findElement(By.xpath(".//*[@id='result_0']/div/div[4]/div[1]/a/h2"));
 		}catch(Exception e){
			Log.error(sRepositoryName + " | lnk_First_Result_Description not found | Exception desc : "+e.getMessage());		
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
    
    public static class Sidebar{
    	
    	public static WebElement hdr_Show_Results_For(WebDriver driver){
        	 
    		try{
    			element = driver.findElement(By.xpath(".//*[@id='leftNavContainer']/h3[1]"));
     		}catch(Exception e){
    			Log.error(sRepositoryName + " | hdr_Show_Results_For not found | Exception desc : "+e.getMessage());		
     		} 
    	    return element;
    	}	

    	public static WebElement lnk_Any_Category(WebDriver driver){
       	 
    		try{
    			element = driver.findElement(By.xpath(".//*[@id='leftNavContainer']/ul[1]/li[1]/span/a/span"));
     		}catch(Exception e){
    			Log.error(sRepositoryName + " | lnk_Any_Category not found | Exception desc : "+e.getMessage());		
     		} 
    	    return element;
    	}	
    	
    	public static WebElement lnk_Category_One(WebDriver driver){
          	 
    		try{
    			element = driver.findElement(By.xpath(".//*[@id='leftNavContainer']/ul[1]/li[2]/span/a/span"));
     		}catch(Exception e){
    			Log.error(sRepositoryName + " | lnk_Category_One not found | Exception desc : "+e.getMessage());		
     		} 
    	    return element;
    	}	
    	
    	public static WebElement lnk_Category_Two(WebDriver driver){
          	 
    		try{
    			element = driver.findElement(By.xpath(".//*[@id='leftNavContainer']/ul[1]/li[3]/span/a/span"));
     		}catch(Exception e){
    			Log.error(sRepositoryName + " | lnk_Category_Two not found | Exception desc : "+e.getMessage());		
     		} 
    	    return element;
    	}	
    	
    	public static WebElement hdr_Category_Three(WebDriver driver){
          	 
    		try{
    			element = driver.findElement(By.xpath(".//*[@id='leftNavContainer']/ul[1]/li[4]/span/h4"));
     		}catch(Exception e){
    			Log.error(sRepositoryName + " | hdr_Category_Three not found | Exception desc : "+e.getMessage());		
     		} 
    	    return element;
    	}	
    	
    	public static WebElement hdr_Refine_By(WebDriver driver){
       	 
    		try{
    			element = driver.findElement(By.xpath(".//*[@id='leftNavContainer']/h3[2]"));
     		}catch(Exception e){
    			Log.error(sRepositoryName + " | hdr_Refine_By not found | Exception desc : "+e.getMessage());		
     		} 
    	    return element;
    	}
    	
    	public static WebElement hdr_Refiner_One(WebDriver driver){
         	 
    		try{
    			element = driver.findElement(By.xpath(".//*[@id='leftNavContainer']/h4[1]"));
     		}catch(Exception e){
    			Log.error(sRepositoryName + " | hdr_Refiner_One not found | Exception desc : "+e.getMessage());		
     		} 
    	    return element;
    	}
    	
    	public static WebElement hdr_Refiner_Two(WebDriver driver){
          	 
    		try{
    			element = driver.findElement(By.xpath(".//*[@id='leftNavContainer']/h4[2]"));
     		}catch(Exception e){
    			Log.error(sRepositoryName + " | hdr_Refiner_Two not found | Exception desc : "+e.getMessage());		
     		} 
    	    return element;
    	}
    	
    	public static WebElement hdr_Refiner_Three(WebDriver driver){
         	 
    		try{
    			element = driver.findElement(By.xpath(".//*[@id='leftNavContainer']/h4[3]"));
     		}catch(Exception e){
    			Log.error(sRepositoryName + " | hdr_Refiner_Three not found | Exception desc : "+e.getMessage());		
     		} 
    	    return element;
    	}
    	
    	public static WebElement hdr_Refiner_Four(WebDriver driver){
         	 
    		try{
    			element = driver.findElement(By.xpath(".//*[@id='leftNavContainer']/h4[4]"));
     		}catch(Exception e){
    			Log.error(sRepositoryName + " | hdr_Refiner_Four not found | Exception desc : "+e.getMessage());		
     		} 
    	    return element;
    	}
    	
    	public static WebElement hdr_Refiner_Five(WebDriver driver){
         	 
    		try{
    			element = driver.findElement(By.xpath(".//*[@id='leftNavContainer']/h4[5]"));
     		}catch(Exception e){
    			Log.error(sRepositoryName + " | hdr_Refiner_Five not found | Exception desc : "+e.getMessage());		
     		} 
    	    return element;
    	}
    	
    	public static WebElement hdr_Refiner_Six(WebDriver driver){
         	 
    		try{
    			element = driver.findElement(By.xpath(".//*[@id='leftNavContainer']/h4[6]"));
     		}catch(Exception e){
    			Log.error(sRepositoryName + " | hdr_Refiner_Six not found | Exception desc : "+e.getMessage());		
     		} 
    	    return element;
    	}
    	
    	public static WebElement hdr_Refiner_Seven(WebDriver driver){
         	 
    		try{
    			element = driver.findElement(By.xpath(".//*[@id='leftNavContainer']/h4[7]"));
     		}catch(Exception e){
    			Log.error(sRepositoryName + " | hdr_Refiner_Seven not found | Exception desc : "+e.getMessage());		
     		} 
    	    return element;
    	}
    	
    	public static WebElement hdr_Refiner_Eight(WebDriver driver){
         	 
    		try{
    			element = driver.findElement(By.xpath(".//*[@id='leftNavContainer']/h4[8]"));
     		}catch(Exception e){
    			Log.error(sRepositoryName + " | hdr_Refiner_Eight not found | Exception desc : "+e.getMessage());		
     		} 
    	    return element;
    	}
    	
    	public static WebElement hdr_Refiner_Nine(WebDriver driver){
         	 
    		try{
    			element = driver.findElement(By.xpath(".//*[@id='leftNavContainer']/h4[9]"));
     		}catch(Exception e){
    			Log.error(sRepositoryName + " | hdr_Refiner_Nine not found | Exception desc : "+e.getMessage());		
     		} 
    	    return element;
    	}
    	
    	public static WebElement hdr_Refiner_Ten(WebDriver driver){
         	 
    		try{
    			element = driver.findElement(By.xpath(".//*[@id='leftNavContainer']/h4[10]"));
     		}catch(Exception e){
    			Log.error(sRepositoryName + " | hdr_Refiner_Ten not found | Exception desc : "+e.getMessage());		
     		} 
    	    return element;
    	}
    	
    	public static WebElement hdr_Refiner_Eleven(WebDriver driver){
         	 
    		try{
    			element = driver.findElement(By.xpath(".//*[@id='leftNavContainer']/h4[11]"));
     		}catch(Exception e){
    			Log.error(sRepositoryName + " | hdr_Refiner_Eleven not found | Exception desc : "+e.getMessage());		
     		} 
    	    return element;
    	}
    	
    //END OF SIDEBAR METHODS
    }
	
//END OF METHODS	    
}
