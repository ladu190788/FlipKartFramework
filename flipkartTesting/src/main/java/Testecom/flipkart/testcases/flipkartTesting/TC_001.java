package Testecom.flipkart.testcases.flipkartTesting;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import appModules.Search_Action;
import appModules.SignIn_Action;
import appModules.SignOut_Action;
import pageObjects.BaseClass;
import pageObjects.ProductListing_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Utils;

public class TC_001
{

	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	
	@BeforeMethod
	public void beforeMethod() throws Exception
	
	{
	
		sTestCaseName=this.toString();
		sTestCaseName=Utils.getTestCaseName(sTestCaseName);
		
		ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData, "Sheet1");
		
		iTestCaseRow=ExcelUtils.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
		
		driver=Utils.OpenBrowser(iTestCaseRow);
		
		new BaseClass(driver);
				
	}
	
	
	@Test
	public void mainTest() throws Exception
	{
		
		driver.get(Constant.URL);
		
		SignIn_Action.Execute(iTestCaseRow);
		
		Search_Action.searchAnItem(iTestCaseRow);
		
		String ReturnedItemTitle=ProductListing_Page.itemTitle();
		
		String ExpectedTitle=ExcelUtils.getCellData(iTestCaseRow, Constant.Col_saerchItem);
		System.out.println(ExpectedTitle);
		Assert.assertEquals(ExpectedTitle.toString(),ReturnedItemTitle.toString().trim());
		
		SignOut_Action.signOutExecute();
	
		System.out.println("Change from ladu");
	}
	
	@AfterMethod

	  public void afterMethod() 
			{
	
		    driver.close();
	 
	  		}
	
}
