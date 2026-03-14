package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.WebDriverUtility;

public class ContactsPage {
	WebDriver driver;
	WebDriverUtility wu;
	public ContactsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wu=new WebDriverUtility(driver);
		
	}
	@FindBy(xpath = "//span[text()='Create Contact']")
	private WebElement createContact;
	public WebElement getCreateContactBtn()
	{
		return createContact;
	}
	public void clickCreateContactLink()
	{
		wu.leftClick(createContact);
		
	}
	

}
