package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	public LeadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//span[text()='Create Lead']")
	private WebElement createLead;
	public WebElement getCreateLeadBtn()
	{
		return createLead;
	}
	public void clickLeadCreateBtn()
	{
		createLead.click();
	}
	
	
	
	

}
