package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Constant;
import utility.ExcelUtils;

public class ProductListing_Page extends BaseClass
{
	
	public static WebElement element=null;
	
	public ProductListing_Page(WebDriver driver) {
		super(driver);
		
	}

	public static String itemTitle()
	{
		String itemName=driver.findElement(By.xpath("//a[@class='cross rmargin10 ']")).getText();
		return itemName;
	}
	
	
	public static String getItemFromDataSheet(int iTestCaseRow) throws Exception
	
	{
		
		String ItemToSearch=ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Exact_Product_Name);
		return ItemToSearch;
	}

	
	
}
