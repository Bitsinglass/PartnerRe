package com.big.stepdef;
import java.awt.AWTException;
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

public class NewRequest extends NewRequestPO {
	
	LoginScreenPO lgscrn = new LoginScreenPO();
	Reusable_methods rm = new Reusable_methods(driver);
	
	@Given("I am on dashboard page")
	public void i_am_on_dashboard_page() {
		lgscrn.login();
		lgscrn.clk_signInBtn();
	}
	
	@When("I click on new cedent button")
    public void i_click_on_new_cedent_button() {
		rm.Select_dropdown("Main Benefit","TPD");
		rm.Select_dropdown("Country","Japan");
//		rm.clk_Cedent();
    }
	
	@When("I click on new request button")
	public void i_click_on_new_request_button() {
		clk_NewReq_Btn();
	}

	@When("I click on new request id")
	public void i_click_on_new_request_id() {
		rm.clk_RequestId();
	}
	
	@When("I complete all details on create request form")
	public void i_complete_all_details_on_create_request_form() throws Throwable  {
		create_Request();
		flie_Upload();
	}
	
	@Then("^I search for life$")
    public void i_search_for_life() {
		rm.Search_text("Jack Sparrow");
		rm.click_Life_chkbox();
	}

	@When("I click on submit button")
	public void i_click_on_submit_button() {
		clk_Create_Btn();
	}

	@Then("I should see the new request in system")
	public void i_should_see_the_new_request_in_system() {
	    System.out.println("New request added successfully");
	}



}
