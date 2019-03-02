package ISO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class NewTest {
	
	WebDriver driver ;
	@BeforeSuite
	public void initDriver() throws Exception {
//		System.setProperty("webdriver.chrome.driver", "D://eclipse_BPM_develop/WorkSpace/TEST/chromedriver.exe");
//	        driver = new ChromeDriver();
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
       capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        System.setProperty("webdriver.ie.driver", "D://Gu/自動測試工具/selenium/Eclipse/workspace/Selenium/IEDriverServer.exe");
        capabilities.setCapability("ignoreZoomSetting", true);
        driver = new InternetExplorerDriver(capabilities);
	    }

  @Test
  public void f() throws Exception {	 
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); //換成新的頁面
		}		
		driver.manage().window().maximize();
		System.out.println("Newly open Window Title is: " + driver.getTitle());
		//多語系 - 繁體中文
		Select select = new Select(driver.findElement(By.id("ddlLanguage")));
		select.selectByVisibleText("繁體中文");
		driver.findElement(By.id("txtUserId")).sendKeys("administrator"); //帳號
		
		//driver.findElement(By.id("txtPassword")).sendKeys("1234");//密碼
		//driver.findElement(By.id("login")).click();
		WebElement webElement = driver.findElement(By.id("txtPassword"));//密碼打完執行Enter
		webElement.sendKeys(Keys.ENTER);
  }
  @BeforeClass
  public void beforeClass() {
	  
	  driver.get("http://127.0.0.1:8086/NaNaWeb");
  }

  @AfterClass
  public void afterClass() {
  }

}
