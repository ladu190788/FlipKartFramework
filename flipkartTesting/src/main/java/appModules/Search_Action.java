package appModules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.Home_Page_main;
import utility.Constant;
import utility.ExcelUtils;
import utility.Utils;

public class Search_Action
{
	
	public static void  searchAnItem(int iTestCaseRow) throws Exception
	{
		
		String TextToSearch = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_saerchItem);
		Home_Page_main.search_AnItem(Home_Page_main.lnk_Search(), TextToSearch);
	}
	
	public static void searchInSpecificCatagory(int iTestCaseRow,WebDriver driver) throws Exception
	{
		System.out.println("inside Searchin specific catagory");
		
		String MainCatagory=ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Product_Category);
		
		System.out.println("The Main catagoryis " +MainCatagory);
		
		String SubCatagory=ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Product_Subcategory);
		
		System.out.println("The Subcatagory is "+SubCatagory);
		Thread.sleep(2000);
		
		WebElement MainDropDownCatagory=driver.findElement(By.xpath("//span[text()='Books & Media']"));
		
		System.out.println("THe main dropdown is: " +MainDropDownCatagory.getText());
		
		
		WebElement Submenu=Utils.mouseHoverAction(MainDropDownCatagory, SubCatagory);
		
		if (Submenu==null)
		{
			driver.findElement(By.xpath("//span[contains(text(),SubCatagory)]")).click();
		}
		
		
		String TextToSearch = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_saerchItem);
		
		Home_Page_main.search_AnItem(Home_Page_main.lnk_Search(), TextToSearch);
		
	}

}
