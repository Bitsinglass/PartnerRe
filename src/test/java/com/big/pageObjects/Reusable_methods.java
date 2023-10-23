package com.big.pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.big.utils.TestReusables;

public class Reusable_methods extends TestReusables{
	
	public Reusable_methods(RemoteWebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public Reusable_methods()
	{
		super();
	}
	
	@FindBy(xpath="//span[text()='%s']")
	WebElement filterDropdown;

	@FindBy(xpath="//li//div[text()='%s']")
	WebElement selected_value;
	
	@FindBy(xpath="//input[@placeholder='Search life']")
	WebElement Search_life_input;	
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement search_chkbox_list;
	
	//------------------------------------------------------------------------------------
	
	
	@FindBy(xpath="//tr[@data-dnd-name='row 2']//a")
	WebElement requestId;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement input_search;
	
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
		click(filterDropdown,"cedent_dropdown");
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
	
	public void Select_dropdown(String drpdownName,String srchTxt) 
	{
		setDynamicLocator(drpdownName);
		click(filterDropdown,"createBtnClk");
		//enterText(input_search,drpdownName,srchTxt);
		setDynamicLocator4Click(srchTxt);
		click(selected_value,"createBtnClk");
	}
	
    // Custom method to set the dynamic locator for the button
    public void setDynamicLocator(String text) {
        String modifiedXPath = String.format("//span[text()='%s']", text);
        filterDropdown = driver.findElement(By.xpath(modifiedXPath));
    }

    public void setDynamicLocator4Click(String text) {
        String modifiedXPath = String.format("//li//div[text()='%s']", text);
        selected_value = driver.findElement(By.xpath(modifiedXPath));
    }
    
	public void clk_Cedent()
	{
		click(filterDropdown,"createBtnClk");
	}

	public void clk_RequestId()
	{
		click(requestId,"ClickRequest");
	}	
	
	public void Search_text(String srchTxt)
	{
		enterText(Search_life_input,"SearchLifeInput",srchTxt);
		Search_life_input.sendKeys(Keys.ENTER);
	}	

	public void click_Life_chkbox()
	{
		click(search_chkbox_list,"ClickLife");
	}
//	public boolean search_record(String FilterName,String colname, String search_text)
//	{
//		boolean bool = false;
//		int count=0;
//		try
//		{	
//			// this line is to get the total no of pages
//			String no_of_pages = driver.findElement(By.xpath("//h2[contains(text(),'"+FilterName+"')]//ancestor::div[@class=' flex content layout-content-stacked  content-stacked ']//table[@role='presentation'][@id='grid-desktop-paginator']//button[@title='Next Page']//parent::nobr//parent::td//preceding-sibling::td[1]//label")).getText(); 
//			int i=Integer.parseInt(no_of_pages);
//			//System.out.println("pages "+i);
//			 
//			//this loop iterate thru total no of pages times 
//			for (int j=1;j<=i;j++) 
//			{
//				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//				List<WebElement> item_searched = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='gridLayoutTable']//tr//td[@data-attribute-name='"+colname+"']//span")));
//				for(int k=0;k<item_searched.size();k++)
//				{
//					
//					//System.out.println(item_searched.get(k).getText());
//					if(item_searched.get(k).getText().equalsIgnoreCase(search_text))
//					{ 
//						bool=true;
//						count = count+1;
//						//System.out.println(item_searched.get(k).getText());
//					}
//				}
//				WebElement nxt_button1 = driver.findElement(By.xpath("//h2[contains(text(),'"+FilterName+"')]//ancestor::div[@class=' flex content layout-content-stacked  content-stacked ']//table[@role='presentation'][@id='grid-desktop-paginator']//button[@title='Next Page']"));
//				click(nxt_button1,"Next Button");
//				Thread.sleep(3000);
//				
//			}
//		}
//			catch(Exception e) {
//				e.printStackTrace();
//			}
//		return bool;
//} 
	
}
