package object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.WebDriverUtility;

public class ContactCreatedPage {

	WebDriver driver;
	WebDriverUtility wu;
	public ContactCreatedPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wu=new WebDriverUtility(driver);
	}
	@FindBy(xpath = "//tbody/tr[1]")
	private WebElement row;
	public WebElement getRow()
	{
		return row;
	}
	public String getCreatedContactId()
	{
		String cid=row.findElement(By.xpath("./td[1]")).getText();
		
		return cid;
		
	}
	public String getActualOrgName()
	{
		String cname=row.findElement(By.xpath("./td[3]")).getText();
		return cname;
	}
	public void closeSuccessAlert()
	{
		WebElement alert= driver.findElement(By.xpath("//div[@role='alert']"));
		alert.click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
