package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_Page_main extends BaseClass
{
	
	   private static WebElement element = null;
	   
	public Home_Page_main(WebDriver driver)
	{
		super(driver);
		
	}

	 public static WebElement lnk_MyAccount() throws Exception{
		 
         try{ 

	        	 element = driver.findElement(By.xpath("//a[contains(text(),'Hi ')]"));

	             

         }catch (Exception e){

        		

        		throw(e);

        		}

        	return element;

     }
	
	 
	 public static WebElement lnk_LogOut() throws Exception{
		 
         try{

	        	element = driver.findElement(By.id("account_logout"));

	           
         }catch (Exception e){

         	

        		throw(e);

        		}

        	return element;

     }

	 
	 public static WebElement lnk_LogIn() throws Exception
	 {
		 try
		 {
			 
			element=driver.findElement(By.xpath("//a[text()='Log In']")); 
			 
			 
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return element;
		
	 }
	
	 
	 public static WebElement lnk_Search() throws Exception
	 {
		 try
		 {
			 element=driver.findElement(By.xpath("//input[@value='SEARCH']"));
			
			//input[@value='SEARCH']
			 
			 
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 
		 return element;
	 }
	 
	 public static void search_AnItem(WebElement SearchButton, String searchText)
	 {
		 
		 driver.findElement(By.xpath("//input[@name='q' and @placeholder='So, what are you wishing for today?']")).sendKeys(searchText);
		 SearchButton.click();
	 }

}
