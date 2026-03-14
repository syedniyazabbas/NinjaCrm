package base_utility;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import generic_utility.FileUtility;
import generic_utility.JavaUtility;
import generic_utility.WebDriverUtility;
import object_repository.HomePage;
import object_repository.LoginPage;

@Listeners(generic_utility.ListenerImplementation.class)
public class BaseClass {

	protected WebDriver driver;
	public static WebDriver sdriver = null;
	protected FileUtility fu;
	protected WebDriverUtility wu;
	protected JavaUtility ju;

	@BeforeClass
	public void openBrowser() throws IOException {
		fu = new FileUtility();
		String browser = fu.getDataFromPropertyFile("bro");
		ChromeOptions opt = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();

		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("profile.password_manager_leak_detection", false);

		opt.setExperimentalOption("prefs", prefs);

		if (browser.equals("chrome")) {
			driver = new ChromeDriver(opt);
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Invalid browser value");
		}
		sdriver = driver;

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wu = new WebDriverUtility(driver);
		ju = new JavaUtility();
	}

	@BeforeMethod
	public void login() throws IOException {
		String URL = fu.getDataFromPropertyFile("url");
		String USERNAME = fu.getDataFromPropertyFile("un");
		String PASSWORD = fu.getDataFromPropertyFile("pwd");

		LoginPage lp = new LoginPage(driver);
		lp.login(URL, USERNAME, PASSWORD);

	}

	@AfterMethod
	public void logout() {

		HomePage hp = new HomePage(driver);
		hp.logout();

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
