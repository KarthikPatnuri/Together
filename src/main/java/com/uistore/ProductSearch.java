package com.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductSearch
{
	WebDriver driver;
	public ProductSearch(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	By search=By.xpath("//*[@id='twotabsearchtextbox']");
	By enter=By.xpath("//*[@id='twotabsearchtextbox']");
	By go=By.xpath("//*[@id='nav-search-submit-button']");
	
	public WebElement Search()
	{
		return driver.findElement(search);
	}
	public WebElement Product()
	{
		return driver.findElement(enter);
	}
	public WebElement Go()
	{
		return driver.findElement(go);
	}
}
