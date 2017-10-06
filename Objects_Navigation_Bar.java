package pageObjectRepositories;
 
    import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
    import utility.Log;
 
/* *******************************************************************
* Author: Rory Cruickshank
* Date: 06/09/2017
* Function: Objects_Navigation_Bar
* Purpose: This class contains all of the elements on the Navigation Bar
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
 public class Objects_Navigation_Bar {
 
    private static WebElement element = null;
    private static String sRepositoryName = "Objects_Home_Page";
 
   	public static WebElement lnk_Logo(WebDriver driver){
    	 
   		try {
   			element = driver.findElement(By.xpath(".//*[@id='nav-logo']/a[1]/span[1]"));
    	}catch(Exception e){
    		Log.error(sRepositoryName + " | lnk_Logo not found | Exception desc : "+e.getMessage());		
   		}
   		return element;
   	}

   	public static WebElement lbl_Shop_By(WebDriver driver){
   	 
   		try {
   			element = driver.findElement(By.xpath(".//*[@id='nav-link-shopall']/span[1]"));
    	}catch(Exception e){
    		Log.error(sRepositoryName + " | lbl_Shop_By not found | Exception desc : "+e.getMessage());		
   		}
   		return element;
   	}

   	public static WebElement txt_Search(WebDriver driver){
      	 
   		try {
   			element = driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']"));
    	}catch(Exception e){
    		Log.error(sRepositoryName + " | txt_Search not found | Exception desc : "+e.getMessage());		
   		}
   		return element;
   	}
   	
   	public static WebElement btn_Search(WebDriver driver){
   	 
   		try {
   			element = driver.findElement(By.xpath(".//*[@id='nav-search']/form/div[2]/div/input"));
    	}catch(Exception e){
    		Log.error(sRepositoryName + " | btn_Search not found | Exception desc : "+e.getMessage());		
   		}
   		return element;
   	}

   	public static WebElement lnk_Your_Amazon(WebDriver driver){
     	 
   		try {
   			element = driver.findElement(By.xpath(".//*[@id='nav-your-amazon']"));
    	}catch(Exception e){
    		Log.error(sRepositoryName + " | lnk_Your_Amazon not found | Exception desc : "+e.getMessage());		
   		}
   		return element;
   	}
   	
   	public static WebElement lnk_Todays_Deals(WebDriver driver){
     	 
   		try {
   			element = driver.findElement(By.xpath(".//*[@id='nav-xshop']/a[2]"));
    	}catch(Exception e){
    		Log.error(sRepositoryName + " | lnk_Todays_Deals not found | Exception desc : "+e.getMessage());		
   		}
   		return element;
   	}
   	
   	public static WebElement lnk_Gift_Cards_And_Top_Up(WebDriver driver){
     	 
   		try {
   			element = driver.findElement(By.xpath(".//*[@id='nav-xshop']/a[3]"));
    	}catch(Exception e){
    		Log.error(sRepositoryName + " | lnk_Gift_Cards_And_Top_Up not found | Exception desc : "+e.getMessage());		
   		}
   		return element;
   	}
   	
   	public static WebElement lnk_Sell(WebDriver driver){
     	 
   		try {
   			element = driver.findElement(By.xpath(".//*[@id='nav-xshop']/a[4]"));
    	}catch(Exception e){
    		Log.error(sRepositoryName + " | lnk_Sell not found | Exception desc : "+e.getMessage());		
   		}
   		return element;
   	}
   	
   	public static WebElement lnk_Help(WebDriver driver){
      	 
   		try {
   			element = driver.findElement(By.xpath(".//*[@id='nav-xshop']/a[5]"));
    	}catch(Exception e){
    		Log.error(sRepositoryName + " | lnk_Help not found | Exception desc : "+e.getMessage());		
   		}
   		return element;
   	}

   	public static WebElement lbl_Hello_Sign_In(WebDriver driver){
    	 
   		try {
   			element = driver.findElement(By.xpath(".//*[@id='nav-link-yourAccount']/span[1]"));
    	}catch(Exception e){
    		Log.error(sRepositoryName + " | lbl_Hello_Sign_In not found | Exception desc : "+e.getMessage());		
   		}
   		return element;
   	}

   	public static WebElement lnk_Orders(WebDriver driver){
    	 
   		try {
   			element = driver.findElement(By.xpath(".//*[@id='nav-orders']/span[2]"));
    	}catch(Exception e){
    		Log.error(sRepositoryName + " | lnk_Orders not found | Exception desc : "+e.getMessage());		
   		}
   		return element;
   	}
   	
   	public static WebElement lbl_Try_Prime(WebDriver driver){
     	 
   		try {
   			element = driver.findElement(By.xpath(".//*[@id='nav-link-prime']/span[1]"));
    	}catch(Exception e){
    		Log.error(sRepositoryName + " | lbl_Try_Prime not found | Exception desc : "+e.getMessage());		
   		}
   		return element;
   	}

   	public static WebElement lnk_Try_Prime(WebDriver driver){
   	 
   		try {
   			element = driver.findElement(By.xpath(".//*[@id='nav-link-prime']/span[2]"));
    	}catch(Exception e){
    		Log.error(sRepositoryName + " | lnk_Try_Prime not found | Exception desc : "+e.getMessage());		
   		}
   		return element;
   	}
   	
   	public static WebElement lbl_Your_Lists(WebDriver driver){
    	 
   		try {
   			element = driver.findElement(By.xpath(".//*[@id='nav-link-wishlist']/span[1]"));
    	}catch(Exception e){
    		Log.error(sRepositoryName + " | lbl_Your_Lists not found | Exception desc : "+e.getMessage());		
   		}
   		return element;
   	}

   	public static WebElement lnk_Your_Lists(WebDriver driver){
   	 
   		try {
   			element = driver.findElement(By.xpath(".//*[@id='nav-link-wishlist']/span[2]"));
    	}catch(Exception e){
    		Log.error(sRepositoryName + " | lnk_Your_Lists not found | Exception desc : "+e.getMessage());		
   		}
   		return element;
   	}
   	
   	public static WebElement lnk_Basket(WebDriver driver){
    	 
   		try {
   			element = driver.findElement(By.xpath(".//*[@id='nav-cart']/span[2]"));
    	}catch(Exception e){
    		Log.error(sRepositoryName + " | lnk_Basket not found | Exception desc : "+e.getMessage());		
   		}
   		return element;
   	}

//END OF METHODS    
}
