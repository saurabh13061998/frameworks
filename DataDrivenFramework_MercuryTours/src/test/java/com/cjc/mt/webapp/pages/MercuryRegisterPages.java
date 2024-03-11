package com.cjc.mt.webapp.pages;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MercuryRegisterPages {
	
     WebDriver driver;
     
	@FindBy(css = "input[name='firstName']")
	WebElement firstname;
	
	
	@FindBy(css = "input[name='lastName']")
	WebElement lastname;
	
	@FindBy(css = "input[name='phone']")
	WebElement phone;
	
	@FindBy(css = "input[name='userName']")
	WebElement email;
	
	
	@FindBy(css = "input[name='address1']")
	WebElement address;
	
	@FindBy(css = "input[name='city']")
	WebElement city;
	
	@FindBy(css = "input[name='state']")
	WebElement state ;
	
	@FindBy(css = "input[name='postalCode']")
	WebElement postcode;
	
	@FindBy(css = "select[name='country']")
	WebElement country ;
	
	@FindBy(css = "input[name='email']")
	WebElement username;
	
	
	@FindBy(css = "input[name='password']")
	WebElement password;
	
	@FindBy(css = "input[name='confirmPassword']")
	WebElement conpassword;
	
	@FindBy(css = "input[type='submit']")
	WebElement submit;
	
	
	
	
	public MercuryRegisterPages(WebDriver driver)
	{
		this.driver=driver;
	}

	public void register(String nm,String ln,String ph,String em,String ad,String ct,String st,String poco,String co,String usn,String pas,String cpass) throws InterruptedException 
	{
		
		Thread.sleep(1000);
		firstname.sendKeys(nm);
		lastname.sendKeys(ln);
		phone.sendKeys(ph);
		email.sendKeys(em);
		address.sendKeys(ad);
     	city.sendKeys(ct);
	    state.sendKeys(st);
		postcode.sendKeys(poco);
		country.sendKeys(co);		
		username.sendKeys(usn);
		password.sendKeys(pas);
		conpassword.sendKeys(cpass);
		submit.click();
		
	}

}

