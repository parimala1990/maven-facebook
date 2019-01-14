package com.facebookpage.Tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.facebookpage.Pages.HomePage;

import BaseClass.BrowserFactory;
import BaseClass.ReadExcelSheet;

public class LoginFacebook  {
	
	WebDriver driver;
	@Test(dataProvider="FaceBookData")
	public void Login(String username1,String password1) throws InterruptedException
	{
		driver=BrowserFactory.getBrowserName("chrome","http://usea1wresrent1/web/base/logindisp?tenant=RES_QA1");
		HomePage page=PageFactory.initElements(driver, HomePage.class);
		Reporter.log("=================Execution started=================");
		page.enterLogInDetails(username1, password1);
		Thread.sleep(10000);
	
		//assertTrue(driver.getTitle().contains("Infor ResRent"),"login failed");
		BrowserFactory.assertFunction();
		Reporter.log("Execution ended");
		
	}
	@DataProvider(name="FaceBookData")
	public Object[][] passData()
	{
		ReadExcelSheet excel1 = new ReadExcelSheet("C:\\Users\\pbalaraju\\eclipse-workspace\\facebookpage\\TestData\\Book1.xlsx");
		int rows=excel1.rowCount(0);
		Object [][] data = new Object[rows][2];
		for(int i=0; i<rows; i++)
		{
			data[i][0]=excel1.ReadData(0, i, 0);
			data[i][1]=excel1.ReadData(0, i, 1);
		}
		
		return data;
	}
	
	@AfterMethod
	public void TerarDown()
	{
		driver.close();
	}

	
}
