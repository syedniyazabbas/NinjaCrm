package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.WebDriverUtility;

public class CreateLeadPage {
	WebDriverUtility wu;
	
	public CreateLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		wu=new WebDriverUtility(driver);
	}
	
	@FindBy(name = "name")
	private WebElement leadName;
	public WebElement getleadname()
	{
		return leadName;
	}
	@FindBy(name = "company")
	private WebElement Company;
	public WebElement getCompanyname()
	{
		return Company;
	}
	@FindBy(name = "leadSource")
	private WebElement leadSource;
	public WebElement getleadsource()
	{
		return leadSource;
	}
	@FindBy(name = "industry")
	private WebElement Industry;
	public WebElement getindustry()
	{
		return Industry;
	}
	@FindBy(name = "annualRevenue")
	private WebElement annualRevenue;
	public WebElement getannualRevenue()
	{
		return annualRevenue;
	}
	@FindBy(name = "noOfEmployees")
	private WebElement noOfEmployees;
	public WebElement getnoOfEmployees()
	{
		return noOfEmployees;
	}
	@FindBy(name = "phone")
	private WebElement Phone;
	public WebElement getphone()
	{
		return Phone;
	}
	@FindBy(name = "email")
	private WebElement Email;
	public WebElement getemail()
	{
		return Email;
	}
	@FindBy(name = "secondaryEmail")
	private WebElement secondaryEmail;
	public WebElement getsecondaryEmail()
	{
		return secondaryEmail;
	}
	@FindBy(name = "leadStatus")
	private WebElement leadStatus;
	public WebElement getleadStatus()
	{
		return leadStatus;
	}
	@FindBy(name = "rating")
	private WebElement Rating;
	public WebElement getrating()
	{
		return Rating;
	}
	@FindBy(name = "assignedTo")
	private WebElement assignedTo;
	public WebElement getassignedTo()
	{
		return assignedTo;
	}
	@FindBy(name = "address")
	private WebElement Address;
	public WebElement getaddress()
	{
		return Address;
	}
	@FindBy(name = "city")
	private WebElement City;
	public WebElement getcity()
	{
		return City;
	}
	@FindBy(name = "country")
	private WebElement Country;
	public WebElement getcountry()
	{
		return Country;
	}
	@FindBy(name = "postalCode")
	private WebElement postalCode;
	public WebElement getpostalCode()
	{
		return postalCode;
	}
	
	@FindBy(name = "website")
	private WebElement Website;
	public WebElement getwebsite()
	{
		return Website;
	}
	@FindBy(name = "description")
	private WebElement Description;
	public WebElement getdescription()
	{
		return Description;
	}
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submit;
	public WebElement getSubmitBtn()
	{
		return submit;
	}
	
	
	
	
	public  void fillDetails(String leadname, String company,String source,String industry,String annrevenue,
			String noofemp,String phone,String email,String secemail,String status,String rating,String assignto,
			String address,String city, String country,String postalcode, String website,String descrip)
	{
		leadName.sendKeys(leadname);
		Company.sendKeys(company);
		leadSource.sendKeys(source);
		Industry.sendKeys(industry);
		annualRevenue.clear();
		annualRevenue.sendKeys(annrevenue);
		noOfEmployees.clear();
		
		noOfEmployees.sendKeys(noofemp);
		Phone.sendKeys(phone);
		Email.sendKeys(email);
		secondaryEmail.sendKeys(secemail);
		leadStatus.sendKeys(status);
		Rating.clear();
		Rating.sendKeys(rating);
		assignedTo.sendKeys(assignto);
		Address.sendKeys(address);
		City.sendKeys(city);
		Country.sendKeys(country);
		postalCode.sendKeys(postalcode);
		Website.sendKeys(website);
//		wu.JsSendkey(Description, descrip);
		
}
	public void clickSubmit()
	{
		submit.click();
		
	}

}
