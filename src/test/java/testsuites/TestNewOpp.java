package testsuites;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseHooks;
public class TestNewOpp extends BaseHooks{
	
	@Test(dataProvider="datasendingmethod", dataProviderClass=testdata.TestDataProvider.class)
	public  void excelread(String[] data) {

		driver.findElement(By.id("username")).sendKeys(data[0]);
		driver.findElement(By.id("password")).sendKeys(data[1]);
		driver.findElement(By.id("Login")).click();	
		
	}
	
	
	
	
	
	
	
	
	
	

}
