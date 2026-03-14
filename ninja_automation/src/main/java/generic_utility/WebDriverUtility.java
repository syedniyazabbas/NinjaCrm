package generic_utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	WebDriver driver=null;
	Actions act=null;
	JavascriptExecutor js=null;
	String parentId;
	public WebDriverUtility(WebDriver driver) {
		
		this.driver=driver;
		this.act=new Actions(driver);
		this.js=(JavascriptExecutor)driver;
	}
	public void waitForElementToBeVisible(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

	public void maxWindow() {
		driver.manage().window().maximize();
	}
	public void fullscreen()
	{
		driver.manage().window().fullscreen();
	}
	private Select getSelect(WebElement element)
	{
	 return new Select(element);
	}
	public void selectDropdowns(WebElement element,String value,String type)
	{
		Select s=getSelect(element);
     	switch(type.toLowerCase()) {
     	case "index":
     		s.selectByIndex(Integer.parseInt(value));
     		break;
     	case "value":
     		s.selectByValue(value);
     		break;
     	case "text":
     		s.selectByVisibleText(type);
     		break;
     	default:
     		System.out.println("Invalid selection type");
     		
     	}
	}
    
	public List<WebElement> getAllDropdowns(WebElement element)
	{
		return getSelect(element).getOptions();
	}
	public int getDropdownCount(WebElement element)
	{
		return getSelect(element).getOptions().size();
	}
	public String getFirstSelectedDropdown(WebElement element)
	{
		return getSelect(element).getFirstSelectedOption().getText();
	}
	public List<WebElement> getAllSelectedDropdown(WebElement element)
	{
		return getSelect(element).getAllSelectedOptions();
	}
	public boolean isMultipleDropdown(WebElement element)
	{
		return getSelect(element).isMultiple();
	}
	public void deselectDropdown(WebElement element,String value,String type)
	{
		Select s=getSelect(element);
		switch(type.toLowerCase())
		{
		case "index":
			s.deselectByIndex(Integer.parseInt(value));
			break;
		case "value":
			s.deselectByValue(value);
			break;
		case "text":
			s.deselectByVisibleText(value);
			break;
		case "all":
			s.deselectAll();
			break;
			default:
				System.out.println("Dropdown is not selected");
		}
	}
	public void hover(WebElement element)
	{
	 act.moveToElement(element).build().perform();
	}
	public void leftClick(WebElement element)
	{
		act.click(element).build().perform();	
	}
	public void rightClick(WebElement element)
	{
		act.contextClick(element).build().perform();
	}
	public void doubleClick(WebElement element)
	{
		act.doubleClick(element).build().perform();	
	}
	public void clickAndHold(WebElement element)
	{
		act.clickAndHold(element).build().perform();	
	}
	public void scrollIntoView(WebElement element)
	{
	
	js.executeScript("arguments[0].scrollIntoView();", element);
	}
	public void moveByOffset(WebElement element,int x, int y)
	{
	act.moveByOffset(x, y);
	}
	public void webpageScreenshot(String path) throws IOException
	{
		TakesScreenshot tks=(TakesScreenshot)driver;
	File source=tks.getScreenshotAs(OutputType.FILE);
	File desti=new File(path);
	FileHandler.copy(source, desti);
	}
	public void ElementScreenshot(WebElement element,String path) throws IOException
	{
	File source=	element.getScreenshotAs(OutputType.FILE);
	File desti= new File(path);
	FileHandler.copy(source, desti);
	}
	public void jsClick(WebElement element)
	{
		js.executeScript("arguments[0].click();", element);
	}
	public void JsSendkey(WebElement element,String value)
	{
		js.executeScript("arguments[0].value=arguments[1];", element,value);
	}
	public void switchByTitle(String title)
	{
    Set<String> list= driver.getWindowHandles();
    for(String window:list)
    {
    	driver.switchTo().window(window);
    	String currentTitle=driver.getTitle();
    	if(currentTitle.contains(title)) {
    		break;
    	}
    }
	}
	public void switchByURL(String url)
	{
		Set<String> windows= driver.getWindowHandles();
		for(String window: windows)
		{
			driver.switchTo().window(window);
			String curl=driver.getCurrentUrl();
			if(curl.contains(url))
			{
				break;
			}
		}
	}
	public void closeAllChild(String parentId)
	{
	Set<String> windows=driver.getWindowHandles();
		for(String window:windows)
		{
		driver.switchTo().window(window);
		if(!window.equals(parentId))
		{
			driver.close();
		}
		}
		driver.switchTo().window(parentId);
	}
	public String getParentWindowAdd()
	{
	return driver.getWindowHandle();
	}
	public Set<String> getAllWindowAdd()
	{
		return driver.getWindowHandles();
	}
	
	
		
		


}
