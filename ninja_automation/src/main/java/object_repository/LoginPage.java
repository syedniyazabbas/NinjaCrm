package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
WebDriver driver=null;
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(id = "username")
	private WebElement un;
	public WebElement getUn()
	{
		return un;
	}
	
	@FindBy(id = "inputPassword")
	private WebElement pwd;
	public WebElement getPwd()
	{
		return pwd;
	}
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement loginBtn;
	public WebElement getLoginBtn()
	{
		return loginBtn;
	}
	
	public void login(String url,String username,String password)
	{
		driver.get(url);
		WebElement un=getUn();
		WebElement pwd=getPwd();
		un.sendKeys(username);
		pwd.sendKeys(password);
		WebElement loginBtn=getLoginBtn();
		loginBtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
