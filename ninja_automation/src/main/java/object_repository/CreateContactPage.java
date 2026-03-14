package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.WebDriverUtility;

public class CreateContactPage {
	WebDriver driver;
	WebDriverUtility wu;
	
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wu=new WebDriverUtility(driver);
		
	}
	@FindBy(name = "organizationName")
	private WebElement organizationName;
	public WebElement getorganizationName()
	{
		return organizationName;
	}
	@FindBy(name = "title")
	private WebElement Title;
	public WebElement gettitle()
	{
		return Title;
	}
	@FindBy(name = "department")
	private WebElement department;
	public WebElement getdepartment()
	{
		return department;
	}
	@FindBy(name = "officePhone")
	private WebElement officePhone;
	public WebElement getofficePhone()
	{
		return officePhone;
	}
	@FindBy(name = "contactName")
	private WebElement contactName;
	public WebElement getcontactName()
	{
		return contactName;
	}
	@FindBy(name = "mobile")
	private WebElement Mobile;
	public WebElement getmobile()
	{
		return Mobile;
	}
	@FindBy(name = "email")
	private WebElement Email;
	public WebElement getemail()
	{
		return Email;
	}
	
	@FindBy(xpath = "//div[@class='form-group']//div//button[@type='button']")
	private WebElement campaign;
	public WebElement getcampaignplusbtn()
	{
		return campaign;
	}
	
	
	
	
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submit;
	public WebElement getSubmitBtn()
	{
		return submit;
	}
	public void fillDetails(String org, String title,String dept,String officephone,String contactname,
			String mobile,String email) throws InterruptedException
	{
		organizationName.sendKeys(org);
		Title.sendKeys(title);
		department.sendKeys(dept);
		officePhone.sendKeys(officephone);
		contactName.sendKeys(contactname);
		Mobile.sendKeys(mobile);
		Email.sendKeys(email);
	}
		
	
	
	
	
	

}
