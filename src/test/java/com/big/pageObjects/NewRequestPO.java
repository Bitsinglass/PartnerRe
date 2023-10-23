package com.big.pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.big.utils.TestReusables;

public class NewRequestPO extends TestReusables{
	
	public NewRequestPO()
	{
		super();
		}
	
	@FindBy(xpath="//span[text()='New Request']")
	WebElement clkNewReqBtn;
	
	@FindBy(xpath="//label[text()='Requester']/parent::div/following-sibling::div/descendant::input")
	WebElement entrRequester;
	
	@FindBy(xpath="//span[text()='Region']/parent::div/following-sibling::div/descendant::span")
	WebElement clkRegion;
	
	@FindBy(xpath="//div[text()='APAC']")
	WebElement slctRegion;
	
	@FindBy(xpath="//div[@class='DropdownWidget---dropdown_value DropdownWidget---placeholder DropdownWidget---inSideBySideItem']/child::span")
	WebElement clkCountry;
	
	@FindBy(xpath="//div[text()='Australia']")
	WebElement slctCountry;
	
	@FindBy(xpath="//label[text()='Subject']/parent::div/following-sibling::div/descendant::input")
	WebElement entrSubject;
	
	@FindBy(xpath="//label[text()='Request Description']/parent::div/following-sibling::div/descendant::textarea")
	WebElement reqDescp;
	
	@FindBy(xpath="//span[text()='Upload']")
	WebElement clkUpldBtn;
	
	@FindBy(xpath="//span[text()='Create']")
	WebElement clkCreateBtn;
	
	public void clk_Create_Btn()
	{
		click(clkCreateBtn,"createBtnClk");
	}
	
	public void create_Request()
	{
		enterText(entrRequester,"requester","Serviceprovider");
		click(clkRegion,"region");
		click(slctRegion,"regionSlct");
		click(clkCountry,"contryClk");
		click(slctCountry,"contrySlct");
		enterText(entrSubject,"subjEntr","Services");
		enterText(reqDescp,"descp","Test");
		click(clkUpldBtn,"uplodClk");
	}
	
	public void clk_NewReq_Btn()
	{
		click(clkNewReqBtn,"newReq");
	}
	
	public void flie_Upload() throws Exception 
	{
		Robot rb = new Robot();
        rb.delay(2000);
        StringSelection str = new StringSelection("C:\\Users\\DELL\\Downloads\\dummy.pdf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        
     // press Contol+V for pasting
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
    
       // release Contol+V for pasting
       rb.keyRelease(KeyEvent.VK_CONTROL);
       rb.keyRelease(KeyEvent.VK_V);
    
       // for pressing and releasing Enter
       rb.keyPress(KeyEvent.VK_ENTER);
       rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	

}
