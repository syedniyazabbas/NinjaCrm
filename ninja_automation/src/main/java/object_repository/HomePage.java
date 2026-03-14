package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.WebDriverUtility;

public class HomePage {
	WebDriver driver;
	WebDriverUtility wu;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wu=new WebDriverUtility(driver);
	}
	@FindBy(xpath = "//div[@class='user-icon']")
	private WebElement profile;
	public WebElement getProfileicon()
	{
		return profile;
	}
	
	@FindBy(xpath = "//div[@class='dropdown-item logout']")
	private WebElement signout;
	public WebElement getSignoutBtn()
	{
		return signout;
	}
	public void logout()
	{
	wu.hover(profile);
	wu.leftClick(signout);
	}
	
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaigns;
	public WebElement getCampLink()
	{
		return campaigns;
	}
	public void clickCampaignLink()
	{
		wu.leftClick(campaigns);
	
	}
	
	
	
	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement contacts;
	public WebElement getContactLink()
	{
		return contacts;
	}
	public void clickContactLink()
	{
		wu.leftClick(contacts);
		
	}
	@FindBy(xpath = "//a[text()='Leads']")
	private WebElement leads;
	public WebElement getLeadLink()
	{
		return leads;
	}
	public void clickLeadLink()
	{
		wu.leftClick(leads);
		
	}
	@FindBy(xpath = "//a[text()='Opportunities']")
	private WebElement opportunity;
	public WebElement getOppLink()
	{
		return opportunity;
	}
	public void clickOppLink()
	{
		wu.leftClick(opportunity);
		
	}
	@FindBy(xpath = "//a[text()='Products']")
	private WebElement products;
	public WebElement getProdLink()
	{
		return products;
	}
	public void clickProductLink()
	{
		wu.leftClick(products);
		
	}
	@FindBy(xpath = "//a[text()='Quotes']")
	private WebElement quotes;
	public WebElement getQuoteLink()
	{
		return quotes;
	}
	public void clickQuotesLink()
	{
		wu.leftClick(quotes);
		
	}
	@FindBy(xpath = "//a[text()='Purchase Order']")
	private WebElement purchaseOrder;
	public WebElement getPurchaseLink()
	{
		return purchaseOrder;
	}
	public void clickPOLink()
	{
		wu.leftClick(purchaseOrder);
		
	}
	@FindBy(xpath = "//a[text()='Sales Order']")
	private WebElement saleOrder;
	public WebElement getSaleOrderLink()
	{
		return saleOrder;
	}
	public void clickSOLink()
	{
		wu.leftClick(saleOrder);
		
	}
	@FindBy(xpath = "//a[text()='Invoice']")
	private WebElement invoice;
	public WebElement getInvoiceLink()
	{
		return invoice;
	}
	public void clickInvoiceLink()
	{
		wu.leftClick(invoice);
		
	}
	
	
	
	
	
	
	

}
