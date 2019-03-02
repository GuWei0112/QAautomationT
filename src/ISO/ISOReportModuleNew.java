package ISO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class ISOReportModuleNew {
	WebDriver driver;
	@BeforeSuite
	public void initdriver() throws Exception{
		/* IE 1 */
//		System.setProperty("webdriver.ie.driver", "c:\\IEDriverServer.exe");
//		driver = new InternetExplorerDriver();
    	
		/* IE 2 */
    	DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        System.setProperty("webdriver.ie.driver", "D://Gu/自動測試工具/selenium/Eclipse/workspace/Selenium/IEDriverServer.exe");
        capabilities.setCapability("ignoreZoomSetting", true);
        driver = new InternetExplorerDriver(capabilities);
		
        /*Chrome*/
//		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
//	    driver = new ChromeDriver();
		
		/*firefox*/
		//driver = new FirefoxDriver();
	}
	
	@BeforeClass
	public void URL() throws Exception{
		driver.get("http://127.0.0.1:8086/NaNaWeb");
//		driver.get("http://10.20.9.26:8106/NaNaWeb");		
	}
	@Test(priority=1)
	public void login(){
		
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.manage().window().maximize();

		/* 登入 */
		Select select = new Select(driver.findElement(By.id("ddlLanguage")));
		select.selectByVisibleText("繁體中文");
		driver.findElement(By.id("txtUserId")).sendKeys("administrator"); // 帳號
		//driver.findElement(By.id("txtPassword")).sendKeys("1234");// 密碼
		WebElement webElement = driver.findElement(By.id("txtPassword"));// 密碼打完執行Enter
		webElement.sendKeys(Keys.ENTER);
	}
	/*ISO相關文件清單 */
	@Test(priority=2)
	public void ISODocumentsList() throws Exception{
		Thread.sleep(5000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().frame("ifmNavigator");
		driver.findElement(By.id("module00000000000000000000000002")).click(); // 修改
																				// WMS\Templates\NavigatorMenu.jsp
																				// line506
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
		}
		driver.findElement(By.partialLinkText("ISO相關文件清單")).click();

		driver.switchTo().frame("ifmFucntionLocation");
		Thread.sleep(1000);
		driver.findElement(By.id("ValidFromS_btn")).click();
		driver.findElement(By.xpath("//td[@class='day false selected today']")).click();
		
		driver.findElement(By.id("btnRefDoc")).click();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
		}
		driver.findElement(By.id("1")).click();
		driver.findElement(By.id("btnChooseDocTypes")).click();
		
		Thread.sleep(500);
				for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
		}
		driver.switchTo().frame("ifmFucntionLocation");
		
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@value='查詢']")).click();
		Alert alert = driver.switchTo().alert();//需刪除
		alert.accept();
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[contains(@onclick,'btnToExcel')]")).click();
		alert.accept();
	}
	
	/* ISO生效失效文件 */
	@Test(priority=3)
	public void ISOEffectInvalidList() throws Exception{
		Thread.sleep(1000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().frame("ifmNavigator");
		driver.findElement(By.id("module00000000000000000000000002")).click(); // 修改
																				// WMS\Templates\NavigatorMenu.jsp
																				// line506
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
		}
		driver.findElement(By.partialLinkText("ISO生效失效文件")).click();
		
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnQuery")).click();
		driver.findElement(By.id("btnToExcel")).click();
	}
	
	/*ISO使用記錄查詢 */
	@Test(priority=4)
	public void ISOFileQueryList() throws Exception{
		Thread.sleep(1000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().frame("ifmNavigator");
		driver.findElement(By.id("module00000000000000000000000002")).click(); // 修改
																				// WMS\Templates\NavigatorMenu.jsp
																				// line506
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
		}
		driver.findElement(By.partialLinkText("ISO使用記錄查詢")).click();
		
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnQuery")).click();
		driver.findElement(By.id("btnToExcel")).click();
	}
	
	/* ISO變更明細表 */
	@Test(priority=5)
	public void ISOChangeFileList() throws Exception{
		Thread.sleep(1000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().frame("ifmNavigator");
		driver.findElement(By.id("module00000000000000000000000002")).click(); // 修改
																				// WMS\Templates\NavigatorMenu.jsp
																				// line506
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
		}
		driver.findElement(By.partialLinkText("ISO變更明細表")).click();

		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnQuery")).click();
		driver.findElement(By.id("btnToExecl")).click();
	}
	
	/*ISO文件一覽表 */
	@Test(priority=6)
	public void ISOList() throws Exception{
		Thread.sleep(1000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().frame("ifmNavigator");
		driver.findElement(By.id("module00000000000000000000000002")).click(); // 修改
																				// WMS\Templates\NavigatorMenu.jsp
																				// line506
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
		}
		driver.findElement(By.partialLinkText("ISO文件一覽表")).click();

		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnQuery")).click();
		driver.findElement(By.id("btnToExcel")).click();
	}
	
	/* ISO紙本文件分發及歸還紀錄 */
	@Test(priority=7)
	public void ISOReleaseDocumentsList() throws Exception{
		Thread.sleep(1000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().frame("ifmNavigator");
		driver.findElement(By.id("module00000000000000000000000002")).click(); // 修改
																				// WMS\Templates\NavigatorMenu.jsp
																				// line506
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
		}
		driver.findElement(By.partialLinkText("ISO紙本文件分發及歸還紀錄")).click();
		
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnQuery")).click();
		driver.findElement(By.id("btnToExcel")).click();
	}
}
