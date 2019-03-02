package ISO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class ISOModuleFirefox {
	WebDriver driver = new FirefoxDriver();
	@Test(priority=1)
	  public void login() {
		  driver.manage().window().maximize();
			for (String winHandle : driver.getWindowHandles()) {
			    driver.switchTo().window(winHandle); //換成新的頁面
			}
			System.out.println("Newly open Window Title is: " + driver.getTitle());
			//多語系 - 繁體中文
			Select select = new Select(driver.findElement(By.id("ddlLanguage")));
			select.selectByVisibleText("繁體中文");
			driver.findElement(By.id("txtUserId")).sendKeys("administrator"); //帳號
			driver.findElement(By.id("txtPassword")).sendKeys("1234");//密碼
			//driver.findElement(By.id("login")).click();
			WebElement webElement = driver.findElement(By.id("txtPassword"));//密碼打完執行Enter
			webElement.sendKeys(Keys.ENTER);
	  }
	@Test(priority=2)
	public void DocTypeManagement() throws Exception{
		/* 文件型態管理 */
		Thread.sleep(5000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().frame("ifmNavigator");
		driver.findElement(By.id("module00000000000000000000000001")).click();// 修改 WMS\Templates\NavigatorMenu.jsp line506
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.findElement(By.partialLinkText("文件型態管理")).click();
		Thread.sleep(3000);
		/* 新增 */
		Thread.sleep(1000);
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnCreateDocType")).click();

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); // 換成新的頁面
		}
		driver.switchTo().frame("ifmFucntionLocation");

		driver.findElement(By.id("txtDocTypeId")).sendKeys("ISO9009");// ISO9000
		driver.findElement(By.id("txtDocTypeName")).sendKeys("ISO9001");// ISO9000

		driver.findElement(By.id("txtDocLevelId")).sendKeys("Lv011");// Lv01
		driver.findElement(By.id("txtDocLevelName")).sendKeys("品質手冊");// 品質手冊
		driver.findElement(By.id("btnSaveDocLevel")).click();

		driver.findElement(By.id("txtDocLevelId")).sendKeys("Lv021");// Lv02
		driver.findElement(By.id("txtDocLevelName")).sendKeys("管理辦法");// 管理辦法
		driver.findElement(By.id("btnSaveDocLevel")).click();

		driver.findElement(By.id("txtDocLevelId")).sendKeys("Lv031");// Lv03
		driver.findElement(By.id("txtDocLevelName")).sendKeys("作業規範");// 作業規範
		driver.findElement(By.id("btnSaveDocLevel")).click();

		driver.findElement(By.id("txtDocLevelId")).sendKeys("789");// 789
		driver.findElement(By.id("txtDocLevelName")).sendKeys("789");// 789
		driver.findElement(By.id("btnSaveDocLevel")).click();

		driver.findElement(By.xpath("//input[contains(@onclick,'789')][@value='編輯']")).click();

		driver.findElement(By.id("txtDocLevelName")).clear();// 789
		driver.findElement(By.id("txtDocLevelName")).sendKeys("abc");// abc
		driver.findElement(By.id("btnSaveDocLevel")).click();

		driver.findElement(By.xpath("//input[contains(@onclick,'789')][@value='刪除']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();

		driver.findElement(By.id("btnCreateDocType")).click();
		System.out.println("1");
		/* 新增_刪除/修改使用 */
		Thread.sleep(1000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); // 換成新的頁面
		}
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnCreateDocType")).click();

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); // 換成新的頁面
		}
		driver.switchTo().frame("ifmFucntionLocation");

		driver.findElement(By.id("txtDocTypeId")).sendKeys("abc");
		driver.findElement(By.id("txtDocTypeName")).sendKeys("abc");

		driver.findElement(By.id("txtDocLevelId")).sendKeys("abc");
		driver.findElement(By.id("txtDocLevelName")).sendKeys("abc");
		driver.findElement(By.id("btnSaveDocLevel")).click();

		driver.findElement(By.id("btnCreateDocType")).click();

		/* 修改 */
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); // 換成新的頁面
		}
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("abc")).click();// 修改 WMS\ManageDocType\ManageDocTypeMain.jsp line182
		driver.findElement(By.id("btnModifyDocType")).click();

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); // 換成新的頁面
		}
		driver.switchTo().frame("ifmFucntionLocation");

		driver.findElement(By.xpath("//input[@value='編輯']")).click();

		driver.findElement(By.id("txtDocLevelId")).clear();
		driver.findElement(By.id("txtDocLevelName")).clear();
		driver.findElement(By.id("txtDocLevelId")).sendKeys("bca");
		driver.findElement(By.id("txtDocLevelName")).sendKeys("bca");
		driver.findElement(By.id("btnSaveDocLevel")).click();

		driver.findElement(By.id("txtDocLevelId")).sendKeys("abc");
		driver.findElement(By.id("txtDocLevelName")).sendKeys("abc");
		driver.findElement(By.id("btnSaveDocLevel")).click();

		driver.findElement(By.xpath("//input[contains(@onclick,'abc')][@value='刪除']")).click();
		alert.accept();

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); // 換成新的頁面
		}
		driver.switchTo().frame("ifmFucntionLocation");

		driver.findElement(By.id("btnModifyDocType")).click();

		/* 刪除 */
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); // 換成新的頁面
		}
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("abc")).click();// 修改 WMS\ManageDocType\ManageDocTypeMain.jsp line182
		driver.findElement(By.id("btnDeleteDocType")).click();
		alert.accept();
	}
  @BeforeClass
  public void beforeClass() {
	  driver.get("http://127.0.0.1:8086/NaNaWeb");
  }

  @AfterClass
  public void afterClass() {
  }

}
