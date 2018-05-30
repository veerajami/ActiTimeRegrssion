package com.actitime.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.base.TestBase;

public class LoginPage extends TestBase{

	public LoginPage()
	{
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username_textbox;
	
	@FindBy(xpath="//input[@name='pwd']")
	WebElement password_textbox;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement login_button;
	
	@FindBy(xpath="//a[@class='copyright']")
	WebElement actimind_link;
	
	public boolean validateLoginPage()
	{
		return driver.getCurrentUrl().contains("login.do");
	}
	
	public boolean validateTitle() {
		return driver.getTitle().contains("actiTIME - Login");
		
	}
	
	public boolean validateCopyright() {
		
		return driver.findElement(By.xpath("//td[@class='copyright']")).getAttribute("innerHTML").contains("2008 Actimind, Inc");
		
	}
	public HomePage login()
	{
		username_textbox.sendKeys("admin");
		password_textbox.sendKeys("manager");
		login_button.click();
		return new HomePage();
	}
	
	public HomePage loginWithKeyboard()
	{
		username_textbox.sendKeys("admin",Keys.TAB,"manager",Keys.ENTER);
	
		return new HomePage();

	}
	
   public HomePage loginWithTestData(String username,String password)
   {
	   username_textbox.sendKeys(username);
		password_textbox.sendKeys(password);
		login_button.click();
	    return new HomePage();
   }
   public ActimindCustomerDevelopmentPage clickOnActimindLink() {
	   
	 actimind_link.click();
	 
	 return new ActimindCustomerDevelopmentPage();
   }
	
   public boolean validateActimindLink() {
	   
	   actimind_link.click();
	   
	  return driver.getTitle().contains("Actimind – Custom Software Development");
	   
   }
	
	
	
	
}
