package com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/*
	By username=By.id("ap_email");//Page object pattern without page factory 
	By conti=By.id("continue");
	//*[@id="nav-link-accountList-nav-line-1"]
	By pass=By.xpath("//input[@type='password']");
	By submit=By.id("signInSubmit");
	*/
	@FindBy(xpath="//*[@class='nav-line-1-container']")
	WebElement click;
	
	
	@FindBy(id="ap_email")
	WebElement username;
	
	@FindBy(id="continue")
	WebElement conti;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement pass;
	
	@FindBy(id="signInSubmit")
	WebElement submit;
	
	
	public WebElement Button()
	{
		return click;
	}
	public WebElement EmailId()
	{
		return username;
	}
	
	public WebElement Continue()
	{
		return conti;
	}
	
	public WebElement Password()
	{
		return pass;
	}
	
	public WebElement Submit()
	{
		return submit;
	}
	
}
