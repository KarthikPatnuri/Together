package com.pageobject;

import org.testng.annotations.Test;

import com.uistore.ProductSearch;
import com.utility.BaseClass;


public class HomePage extends BaseClass
{	
	@Test
	public void firstone()
	{
	
		log=report.createTest("Amazon Page");
		
		log.info("Amazon website is running");
		LoginPage l = new LoginPage(driver);
		l.Button().click();		
		l.EmailId().sendKeys(ex.getStringData("Login",0,0));
		l.Continue().click();
		l.Password().sendKeys(ex.getStringData("Login",0,1));
		l.Submit().click();
		log.pass("Successfully entered into the amazon website with valid credentials");
		System.out.println(l.Button().getText());
		ProductSearch s = new ProductSearch(driver);
		s.Search().click();
		s.Product().sendKeys("iphone 13");
		s.Go().click();
	}	
}
