package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetails extends BaseClass
{

	public ProductDetails(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static WebElement productPrice()
	{
		
		WebElement ProductPriceDetails = null;
		try
		{
			ProductPriceDetails=driver.findElement(By.xpath("//div[span[text()='Selling Price']]/div/span[contains(text(),'Rs.')]"));
			
		}catch (Exception e)
		{
			ProductPriceDetails=driver.findElement(By.xpath("//div[span[span[contains(text(),'List Price')]]]/div/span[contains(text(),'Rs.')]"));
					
		}
		return ProductPriceDetails;
	}
}
