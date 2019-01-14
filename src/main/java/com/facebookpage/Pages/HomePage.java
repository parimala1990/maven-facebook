package com.facebookpage.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import BaseClass.ReadExcelSheet;

public class HomePage {

	
	@FindBy(how=How.XPATH, using="//input[@name='userid' and @placeholder='User ID']")
	WebElement loginTextBox;
	
	
	@FindBy(how=How.XPATH, using="//input[@name='password' and @placeholder='PASSWORD']")
	WebElement passwordTextBox;
	
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Log In')]/ancestor::a[1]")
	WebElement clickButton;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Unable to login')]]")
	WebElement unableLogin;
	
	
	
	public void enterLogInDetails(String username ,String password)
	{
		loginTextBox.sendKeys(username);
		passwordTextBox.sendKeys(password);
		clickButton.click();
	}





	
	
}
