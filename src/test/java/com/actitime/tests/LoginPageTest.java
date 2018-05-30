package com.actitime.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.actitime.base.TestBase;
import com.actitime.pages.HomePage;
import com.actitime.pages.LoginPage;
import com.actitime.util.Utility;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	
	LoginPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		initialize();
		loginpage=new LoginPage();
	}
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	@Test(priority=1, groups="Page Validation", description="TestCase ID:5141")
	public void validateLoginPageTest() {
		Assert.assertTrue(loginpage.validateLoginPage());
	}

	@Test(priority=2, groups="Page Validation", description="TestCase ID:5142" )
	public void validateLoginPageTitleTest() {
		Assert.assertTrue(loginpage.validateTitle());
	}

	@Test(priority=3,groups="Page Validation", description="TestCase ID:5143")
	public void validateCopyrightTest() {
		Assert.assertTrue(loginpage.validateCopyright());
	}
	
	@Test(priority=4, groups="Page Validation", description="TestCase ID:5144")
	public void validateActimindLinkTest() {
		Assert.assertTrue(loginpage.validateActimindLink());
	}
	@Test(priority=5, groups="Navigation Functionality Validation", description="TestCase ID:5145")
	public void loginTest()
	{
		
		homepage=loginpage.login();
		Assert.assertTrue(homepage.validateHomePage());
	}
	
	@Test(priority=6, groups="Navigation Functionality Validation", description="TestCase ID:5146")
	public void loginWithKeyboardTest() {
		
		homepage=loginpage.loginWithKeyboard();
		Assert.assertTrue(homepage.validateHomePage());
		
	}
	
	@Test(priority=7, groups="Application Functionality", dataProvider="getTestData", description="TestCase ID:5147")
	public void loginWithTestDataTest(String username, String password, String result)
	{	
		homepage=loginpage.loginWithTestData(username, password);
	    boolean status=Utility.getInputResult(result);
		Assert.assertTrue(status==homepage.validateHomePage());
		
	}
	
//#################################################  Test Data   ######################################################################
	@DataProvider
	public Object[][] getTestData()
	{
	
		return new Utility().getTestData("LoginPageData");
		
	}


}
