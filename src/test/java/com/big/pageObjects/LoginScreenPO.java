package com.big.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.big.utils.TestReusables;
import com.big.utils.Utilities;
import org.openqa.selenium.support.PageFactory;

public class LoginScreenPO extends TestReusables {
	
//	public LoginScreenPO(RemoteWebDriver driver) {
//		this.driver=driver;
//		PageFactory.initElements(driver, this);
//	}
	
	
	
	@FindBy(xpath="//input[@name='un']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='pw']")
	WebElement password;
	
	@FindBy(xpath="//div[@class='button_box_links']/following-sibling::div/child::input")
	WebElement logIn; 
	
	
	public void clk_signInBtn()
	{
		click(logIn,"login");
	}	
	
	public void get_Title()
	{
		String title = driver.getTitle();
		System.out.println("title is "+title);
		
		if(title.equals("Home - Case Manager"))
		{
			System.out.println("Login successfull");
		}
		else
			System.out.println("Login failed");
	}
	
	
	
	public void login()
	{
		Utilities un = new Utilities();
		
		try {
			
			
			enterText(username, "username",un.getProeprty("Username"));
			enterText(password, "password",un.getProeprty("Password"));
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
			
			
		}
		
	}		
		
	
	}
	
	

	
		
			
	


