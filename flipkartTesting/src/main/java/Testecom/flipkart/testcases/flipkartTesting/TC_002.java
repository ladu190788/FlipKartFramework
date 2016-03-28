package Testecom.flipkart.testcases.flipkartTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import appModules.Search_Action;
import appModules.SignIn_Action;
import appModules.SignOut_Action;
import pageObjects.BaseClass;
import pageObjects.ProductDetails;
import pageObjects.ProductListing_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Utils;

public class TC_002 

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
			
			System.out.println("Signin is Done");
			
			Thread.sleep(10000);
			
			Search_Action.searchInSpecificCatagory(iTestCaseRow,driver);
			
			System.out.println("search is done");
			
			String ReturnedItemTitle=ProductListing_Page.itemTitle();
			
			System.out.println("returned item price:  "+ReturnedItemTitle);
			
			String GetUserItem=ProductListing_Page.getItemFromDataSheet(iTestCaseRow);
			
			System.out.println("Get User item is :  "+GetUserItem);
			
			WebElement UserItem=driver.findElement(By.xpath("//a[contains(text(),"+"'"+GetUserItem+"'"+")]"));
			System.out.println("THe userITem is : "+UserItem.getText());
			
			
			String UserItemPrice=driver.findElement(By.xpath("//div[div[a[contains(text(),"+"'"+GetUserItem+"'"+")]]]/div//div[@class='pu-final']/span[contains(text(),'Rs.')]")).getText();
			
			System.out.println("The UserItemPrice is : "+UserItemPrice);
			
			UserItem.click();
			
			String ProductDetailsItemPrice=ProductDetails.productPrice().getText();
			
			System.out.println("The Product details price is : "+ProductDetailsItemPrice);
			
			Assert.assertEquals(UserItemPrice, ProductDetailsItemPrice);
			
			String ExpectedTitle=ExcelUtils.getCellData(iTestCaseRow, Constant.Col_saerchItem);
			
			System.out.println(ExpectedTitle);
			
			Assert.assertEquals(ExpectedTitle.toString(),ReturnedItemTitle.toString().trim());
			
			SignOut_Action.signOutExecute();
		
			
		}
		
		@AfterMethod

		  public void afterMethod() 
				{
		
			    driver.close();
		 
		  		}
		
	}


