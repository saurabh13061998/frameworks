package com.cjc.mt.webapp.pages;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MercuryLoginPages {
	WebDriver driver;
	
	@FindBy (css = "input[name='userName']")
    WebElement username;
	
	@FindBy(css = "input[name='password']")
	WebElement password;
	
	@FindBy (css = "input[name='submit']")
	WebElement submit;
	
	
	public MercuryLoginPages(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	
	public void login(String un,String pass) throws IOException
	{
		
		
		//driver.navigate().to("https://demo.guru99.com/test/newtours/index.php");
		
		username.sendKeys(un);
		password.sendKeys(pass);
		submit.click();
		
		}
}

