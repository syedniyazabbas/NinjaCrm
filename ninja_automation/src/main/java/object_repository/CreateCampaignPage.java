package object_repository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.WebDriverUtility;

public class CreateCampaignPage {
	WebDriver driver;
	WebDriverUtility wu;
	
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wu=new WebDriverUtility(driver);
		
	}
	@FindBy(name = "campaignName")
	private WebElement campaignName;
	public WebElement getCampaignName()
	{
		return campaignName;
	}
	@FindBy(name = "campaignStatus")
	private WebElement campaignStatus;
	public WebElement getCampaignStatus()
	{
		return campaignStatus;
	}
	@FindBy(name = "targetSize")
	private WebElement targetSize;
	public WebElement getTargetSize()
	{
		return targetSize;
	}
	@FindBy(name = "expectedCloseDate")
	private WebElement expectedCloseDate;
	public WebElement getExpectedCloseDate()
	{
		return expectedCloseDate;
	}
	@FindBy(name = "targetAudience")
	private WebElement targetAudience;
	public WebElement getTargetAudience()
	{
		return targetAudience;
	}
	@FindBy(name = "description")
	private WebElement description;
	public WebElement getDescription()
	{
		return description;
	}
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submit;
	public WebElement getSubmitBtn()
	{
		return submit;
	}
	public  void createCampaign(String cname, String status,String size,String closedate,String taudience,String descp) throws InterruptedException
	{
		campaignName.sendKeys(cname);
		campaignStatus.sendKeys(status);
		int numsize=Integer.parseInt(size);
		targetSize.click();
		for(int i=1;i<=numsize;i++)
		{
			
			targetSize.sendKeys(Keys.ARROW_UP);
			
		}
		
		expectedCloseDate.sendKeys(closedate);
		wu.JsSendkey(targetAudience, taudience);
		wu.JsSendkey(description, descp);

		submit.click();
	}
	
	
	
	

}
