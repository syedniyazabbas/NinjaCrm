package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.WebDriverUtility;

public class CampaignPage {
	
	WebDriver driver;
	WebDriverUtility wu;
	
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wu=new WebDriverUtility(driver);
		
	}
	@FindBy(xpath = "//span[text()='Create Campaign']")
	private WebElement createCamp;
	public WebElement getCreateCampBtn()
	{
		return createCamp;
	}
	public void clickCreateCampBtn()
	{
		wu.leftClick(createCamp);
	}
	
	@FindBy(xpath = "//div[@role='alert']")
	private WebElement successpopup;
	public WebElement getsuccesspopup()
	{
		return successpopup;
	}

	public void closeSuccessAlert()
	{
		successpopup.click();
		
	}
	
	@FindBy(xpath = "//tbody/tr[1]/td[1]")
	private WebElement newcreatedcampid;
	public WebElement getGeneratedId()
	{
		return newcreatedcampid;
	}
	@FindBy(xpath = "//tbody/tr[1]/td[2]")
	private WebElement campname;
	public WebElement getCreatedCampName()
	{
		return campname;
	}
	public String getGeneratedIdText()

	{
		return newcreatedcampid.getText();
	}
	public String getCreatedCampNameText()
	{
		return campname.getText();
	}
	

	
	
	
	
	

}
