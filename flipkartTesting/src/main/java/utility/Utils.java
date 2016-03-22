package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils 
{

	public static WebDriver driver=null;
	
	public static WebElement subElementToClick;
	
	 public static WebElement mouseHoverAction(WebElement mainElement, String subElement)
	 {
		 
		 Actions action =new Actions(driver);
		 action.moveToElement(mainElement).perform();
		 
		 if(subElement.equals("Logout"))
		 {
			 
			 //action.moveToElement(driver.findElement(By.xpath("//a[text()='Logout']"))).perform();
			 
			 WebElement subElementToClick=driver.findElement(By.xpath("//a[text()='Log Out']"));
			 
			 return subElementToClick;
			 
			 
		 }
		 
		 else
		 return null;
		 
		 
	 }
	
	
	 public static String getTestCaseName(String sTestCase)throws Exception{
		 
			String value = sTestCase;
	 
			try{
	 
				int posi = value.indexOf("@");
	 
				value = value.substring(0, posi);
	 
				posi = value.lastIndexOf(".");	
	 
				value = value.substring(posi + 1);
	 
				return value;
	 
					}catch (Exception e)
						{
						throw (e);
	 
						}
	 
				}
	 
	 
	 public static WebDriver OpenBrowser(int iTestCaseRow) throws Exception
	 
	 {

			String sBrowserName;

			try{

			sBrowserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Browser);

			if(sBrowserName.equals("Mozilla")){

				driver = new FirefoxDriver();



			    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



			    driver.get(Constant.URL);



				}

			}catch (Exception e){

				e.printStackTrace();

			}

			return driver;

		}

	 
	 public static void waitForElement(WebElement element){

		 WebDriverWait wait = new WebDriverWait(driver, 10);

	     wait.until(ExpectedConditions.elementToBeClickable(element));

	 	

	

	 	}
	 
}
