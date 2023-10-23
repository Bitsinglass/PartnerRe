package com.big.stepdef;
import java.io.IOException;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.big.pageObjects.*;
import com.big.utils.TestReusables;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)

public class login extends TestReusables {
	
	LoginScreenPO lgin = new LoginScreenPO();
	
	

	@Given("^user is on login page$")
	public void user_user_is_on_login_page() {
		System.out.println("I am on login screen");
		
		
	}

	@When("^user enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_username_and_Password(String Username,String Password) {

		lgin.login();	
				    
	}
	
	@When("^user clicks login button$")
	public void user_clicks_login_button()
	{
		lgin.clk_signInBtn();
	}
	
	@Then("^user should be logged in$")
	public void user_should_be_logged_in()
	{
		lgin.get_Title();
	}
	
//	
//
//	@Then("Message displayed login successfull")
//	public void vbn() {
//		try {
//			WebElement logo = driver.findElement(By.xpath("//body/div[@id='content']/div[1]/div[3]/div[1]/div[1]/nav[1]/div[1]/a[1]/img[1]"));
//			if(logo.isDisplayed())
//			{
//				System.out.println("user login successfully");
//			}
//			else
//				System.out.println("user login failed");
//		}
//		catch(Exception e)
//		{
//			System.out.println("user login failed "+e.getMessage());
//			driver.quit();
//		}
//	    

}
	
	   


