package object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.WebDriverUtility;

public class LeadSuccessPage {
	WebDriver driver;
	WebDriverUtility wu;

	public LeadSuccessPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wu = new WebDriverUtility(driver);
	}
	
	public void closeSuccessAlert()
	{
		WebElement alert= driver.findElement(By.xpath("//div[@role='alert']"));
		alert.click();
		
	}
	@FindBy(xpath = "//tbody/tr[1]")
	private WebElement row;
	public WebElement getRow()
	{
		return row;
	}
	public String getCreatedLeadId()
	{
		String cid=row.findElement(By.xpath("./td[1]")).getText();
		
		return cid;
		
	}
	public String getActualCampaignId()
	{
		String actualcampaignId=row.findElement(By.xpath("./td[3]")).getText();
		return actualcampaignId;
	}
	
	
	
	
	
	
}
