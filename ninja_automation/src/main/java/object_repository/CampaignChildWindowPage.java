package object_repository;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.WebDriverUtility;

public class CampaignChildWindowPage {

	WebDriver driver;
	WebDriverUtility wu;

	public CampaignChildWindowPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wu = new WebDriverUtility(driver);
	}

	@FindBy(xpath = "//div[@class='form-group']//div//button[@type='button']")
	private WebElement campaign;

	public WebElement getcampaignplusbtn() {
		return campaign;
	}

	public String openCampaignWIndow() {
		String pid = wu.getParentWindowAdd();
		campaign.click();
		Set<String> windows = wu.getAllWindowAdd();
		for (String win : windows) {
			if (!win.equals(pid)) {
				driver.switchTo().window(win);
				break;
			}

		}
		wu.maxWindow();

		return pid;

	}

	@FindBy(xpath = "//button[text()='Select']")
	private List<WebElement> selectbtn;

	public List<WebElement> getselectbtn() {
		return selectbtn;
	}

	@FindBy(xpath = "//table/tbody/tr")
	private List<WebElement> rows;

	public List<WebElement> getfullrow() {
		return rows;
	}

	@FindBy(xpath = "//button[text()='Next']")
	private WebElement nextbtn;

	public WebElement getnextbtn() {
		return nextbtn;
	}

	@FindBy(xpath = "//tbody/tr/td[1]")
	private List<WebElement> campid;

	public List<WebElement> getcampid() {
		return campid;
	}

	public void selectionbyid(String id) {
		while (true) {
			boolean found = false;

			for (WebElement row : rows) {
				String actualId = row.findElement(By.xpath("./td[1]")).getText();

				if (actualId.equals(id)) {
					row.findElement(By.xpath("./td[last()]//button")).click();

					found = true;
					break;
				}
			}

			if (found) {
				break;
			} else {
				nextbtn.click();
			}
		}
	}

	@FindBy(id = "search-input")
	private WebElement searchinput;

	public WebElement getSearchbox() {
		return searchinput;
	}

	@FindBy(xpath = "//tbody/tr[1]")
	private WebElement row;

	public WebElement getRow() {
		return row;
	}

	public void selectionbyidsearch(String id) {

		searchinput.sendKeys(id);
		wu.waitForElementToBeVisible(row);

		String searchedid = row.findElement(By.xpath("/td[1]")).getText();
		if (searchedid.equals(id)) {
			row.findElement(By.xpath("./td[last()]/button")).click();

		} else
			throw new NullPointerException("Id not present");
	}

}
