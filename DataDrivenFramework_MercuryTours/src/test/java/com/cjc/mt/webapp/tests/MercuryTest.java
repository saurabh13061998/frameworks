package com.cjc.mt.webapp.tests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.cjc.mt.webapp.pages.MercuryLoginPages;
import com.cjc.mt.webapp.pages.MercuryRegisterPages;

public class MercuryTest {
	

	WebDriver driver;
	 Set<Cookie> cookies;
	
 @BeforeSuite
 public void browserOpen() 
 {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\shree\\OneDrive\\Desktop\\Selenium\\chromedriver-win32 (1)\\chromedriver.exe");
    driver=new ChromeDriver();
 }
 @Parameters({"url"})
 @BeforeTest
 public void UrlLaunch(String s) 
 {
	 driver.get(s);
	 
	 
 }
 
 @BeforeClass
 public void maximizeWindow() 
 {
	 driver.manage().window().maximize();
	 driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
	 
 }
 
 @BeforeMethod
 public void beforeMethod()
 {
 cookies=driver.manage().getCookies();
 System.out.println(cookies.size());
 }

 
 
 
 
 
 @Test (priority = 1,dataProvider = "getData")
 public void register(String nm,String ln,String ph,String em,String ad,String ct,String st,String poco,String co,String usn,String pas,String cpass) throws IOException, InterruptedException
 {
	  MercuryRegisterPages mrp=new MercuryRegisterPages(driver);
	  mrp.register(nm,ln,ph,em,ad,ct,st,poco,co, usn, pas, cpass);
	  
	  
 }
 

  @Test (priority=2,dataProvider = "getData1")
  public void login1(String un,String pass) throws IOException 
  {
	  MercuryLoginPages mlp=new MercuryLoginPages(driver);
	  mlp.login(un,pass);
	  
	  
  }
  
  
  
 
  
 
 
  @AfterMethod
  public void screenShot() throws IOException 
  {
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFileToDirectory(src, new File("C:\\Users\\shree\\OneDrive\\Desktop\\Selenium\\mercury tours")); 
  }

  

  @AfterClass
  public void deleteCookies() 
  {
	  driver.manage().deleteAllCookies();
  }

  
  @AfterTest
  public void dbClose() 
  {
	  System.out.println("databaseClose");
  }

  

  @AfterSuite
  public void closeBrowser() 
  {
	  //driver.close();
  }
  
  
  
  @DataProvider
  public Object [][] getData()
  {
	  return new Object [][]
			  {
		  new Object [] {"saurabh","mane","86952255","ndnn@88gmail.com","pune","maharashtra","4445558","INDIA","SSR255@hh","123456","123456"}
			  };
			  
  }
  
  
  @DataProvider
  public Object [][] getData1()
  {
	  return new Object [][]
			  {
		  new Object [] {"QQQQ","qqqq"}
			  };
			  
  }
}



