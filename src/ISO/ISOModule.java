package ISO;

import java.awt.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ISOModule {
	@Test
	public void f() throws InterruptedException {
		/* 前置設定 */
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://127.0.0.1:8086/NaNaWeb");

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.manage().window().maximize();

		/* 登入 */
		Select select = new Select(driver.findElement(By.id("ddlLanguage")));
		select.selectByVisibleText("繁體中文");
		driver.findElement(By.id("txtUserId")).sendKeys("administrator"); // 帳號
		driver.findElement(By.id("txtPassword")).sendKeys("1234");// 密碼
		WebElement webElement = driver.findElement(By.id("txtPassword"));// 密碼打完執行Enter
		webElement.sendKeys(Keys.ENTER);

		
		
		
		/* 文件型態管理 */
//		Thread.sleep(1000);
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle);
//		}
//		driver.switchTo().frame("ifmNavigator");
//		driver.findElement(By.id("module00000000000000000000000001")).click();// 修改 WMS\Templates\NavigatorMenu.jsp line506
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle);
//		}
//		driver.findElement(By.partialLinkText("文件型態管理")).click();
//
//		/* 新增 */
//		Thread.sleep(1000);
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("btnCreateDocType")).click();
//
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//
//		driver.findElement(By.id("txtDocTypeId")).sendKeys("ISO9001");// ISO9000
//		driver.findElement(By.id("txtDocTypeName")).sendKeys("ISO9001");// ISO9000
//
//		driver.findElement(By.id("txtDocLevelId")).sendKeys("Lv011");// Lv01
//		driver.findElement(By.id("txtDocLevelName")).sendKeys("品質手冊");// 品質手冊
//		driver.findElement(By.id("btnSaveDocLevel")).click();
//
//		driver.findElement(By.id("txtDocLevelId")).sendKeys("Lv021");// Lv02
//		driver.findElement(By.id("txtDocLevelName")).sendKeys("管理辦法");// 管理辦法
//		driver.findElement(By.id("btnSaveDocLevel")).click();
//
//		driver.findElement(By.id("txtDocLevelId")).sendKeys("Lv031");// Lv03
//		driver.findElement(By.id("txtDocLevelName")).sendKeys("作業規範");// 作業規範
//		driver.findElement(By.id("btnSaveDocLevel")).click();
//
//		driver.findElement(By.id("txtDocLevelId")).sendKeys("789");// 789
//		driver.findElement(By.id("txtDocLevelName")).sendKeys("789");// 789
//		driver.findElement(By.id("btnSaveDocLevel")).click();
//
//		driver.findElement(By.xpath("//input[contains(@onclick,'789')][@value='編輯']")).click();
//
//		driver.findElement(By.id("txtDocLevelName")).clear();// 789
//		driver.findElement(By.id("txtDocLevelName")).sendKeys("abc");// abc
//		driver.findElement(By.id("btnSaveDocLevel")).click();
//
//		driver.findElement(By.xpath("//input[contains(@onclick,'789')][@value='刪除']")).click();
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
//
//		driver.findElement(By.id("btnCreateDocType")).click();
//
//		/* 新增_刪除/修改使用 */
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("btnCreateDocType")).click();
//
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//
//		driver.findElement(By.id("txtDocTypeId")).sendKeys("abc");
//		driver.findElement(By.id("txtDocTypeName")).sendKeys("abc");
//
//		driver.findElement(By.id("txtDocLevelId")).sendKeys("abc");
//		driver.findElement(By.id("txtDocLevelName")).sendKeys("abc");
//		driver.findElement(By.id("btnSaveDocLevel")).click();
//
//		driver.findElement(By.id("btnCreateDocType")).click();
//
//		/* 修改 */
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("abc")).click();// 修改 WMS\ManageDocType\ManageDocTypeMain.jsp line182
//		driver.findElement(By.id("btnModifyDocType")).click();
//
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//
//		driver.findElement(By.xpath("//input[@value='編輯']")).click();
//
//		driver.findElement(By.id("txtDocLevelId")).clear();
//		driver.findElement(By.id("txtDocLevelName")).clear();
//		driver.findElement(By.id("txtDocLevelId")).sendKeys("bca");
//		driver.findElement(By.id("txtDocLevelName")).sendKeys("bca");
//		driver.findElement(By.id("btnSaveDocLevel")).click();
//
//		driver.findElement(By.id("txtDocLevelId")).sendKeys("abc");
//		driver.findElement(By.id("txtDocLevelName")).sendKeys("abc");
//		driver.findElement(By.id("btnSaveDocLevel")).click();
//
//		driver.findElement(By.xpath("//input[contains(@onclick,'abc')][@value='刪除']")).click();
//		alert.accept();
//
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//
//		driver.findElement(By.id("btnModifyDocType")).click();
//
//		/* 刪除 */
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("abc")).click();// 修改 WMS\ManageDocType\ManageDocTypeMain.jsp line182
//		driver.findElement(By.id("btnDeleteDocType")).click();
//		alert.accept();

		
		
		
		/* 文件類別管理 */
		// Thread.sleep(1000);
		// for(String winHandle : driver.getWindowHandles()){
		// driver.switchTo().window(winHandle);
		// }
		// driver.switchTo().frame("ifmNavigator");
		// driver.findElement(By.id("module00000000000000000000000001")).click();
		// // 修改 WMS\Templates\NavigatorMenu.jsp line506
		// for (String winHandle : driver.getWindowHandles()) {
		// driver.switchTo().window(winHandle); //轉換成系統管理工具-小視窗
		// }
		// driver.findElement(By.partialLinkText("文件類別管理")).click();

//		 Thread.sleep(1000);
//		 driver.switchTo().frame("ifmNavigator");
//		 //WebElement Directory =
//		 driver.findElement(By.xpath("//a[@text='文件類別樹']"));
//		 WebElement Directory =
//		 driver.findElement(By.xpath("//a[text()[contains(.,'文件類別樹')]]"));
//		 Actions actions = new Actions(driver);
//		 actions.contextClick(Directory).sendKeys(Keys.DOWN).build().perform();
//		 Thread.sleep(5000);

				
		
		
		/* 自動編號規則管理 */
//		Thread.sleep(1000);
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle);
//		}
//		driver.switchTo().frame("ifmNavigator");
//		driver.findElement(By.id("module00000000000000000000000001")).click();
//		// 修改 WMS\Templates\NavigatorMenu.jsp line506
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
//		}
//		driver.findElement(By.partialLinkText("自動編號規則管理")).click();
//
//		/* 新增 */
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("btnCreateSnGenRule")).click();
//
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//
//		driver.findElement(By.id("snId")).sendKeys("BPM");
//		driver.findElement(By.id("snName")).sendKeys("BPM產品部");
//		driver.findElement(By.id("snDigit")).sendKeys("3");
//		driver.findElement(By.id("description")).sendKeys("BPM產品部編碼");
//
//		Select select1 = new Select(driver.findElement(By.id("ddlSnElementType")));
//		select1.selectByVisibleText("生效日期");
//		driver.findElement(By.xpath("//input[@value='套用']")).click();
//
//		select1.selectByVisibleText("製作日期");
//		driver.findElement(By.xpath("//input[@value='套用']")).click();
//		driver.findElement(By.xpath("//input[contains(@onclick,'1')][@value='刪除']")).click();
//
//		driver.findElement(By.xpath("//input[@value='編輯']")).click();
//		select1.selectByVisibleText("製作日期");
//		driver.findElement(By.xpath("//input[@value='套用']")).click();
//
//		driver.findElement(By.id("btnCreateSnGenRule")).click();
//		alert.accept();
//
//		/* 新增_刪除/修改使用 */
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("btnCreateSnGenRule")).click();
//
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//
//		driver.findElement(By.id("snId")).sendKeys("BPM_test");
//		driver.findElement(By.id("snName")).sendKeys("BPM產品部");
//		driver.findElement(By.id("snDigit")).sendKeys("3");
//		driver.findElement(By.id("description")).sendKeys("BPM產品部編碼");
//
//		Select select2 = new Select(driver.findElement(By.id("ddlSnElementType")));
//		select2.selectByVisibleText("生效日期");
//		driver.findElement(By.xpath("//input[@value='套用']")).click();
//
//		select2.selectByVisibleText("製作日期");
//		driver.findElement(By.xpath("//input[@value='套用']")).click();
//		driver.findElement(By.xpath("//input[contains(@onclick,'1')][@value='刪除']")).click();
//
//		driver.findElement(By.xpath("//input[@value='編輯']")).click();
//		select2.selectByVisibleText("製作日期");
//		driver.findElement(By.xpath("//input[@value='套用']")).click();
//
//		driver.findElement(By.id("btnCreateSnGenRule")).click();
//		alert.accept();
//
//		/* 修改 */
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("BPM_test")).click();// 修改 WMS\ManageSnGenRule\ManageSnGenRuleMain.jsp line204
//		driver.findElement(By.id("btnModifySnGenRule")).click();
//
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		Select select3 = new Select(driver.findElement(By.id("ddlSnElementType")));
//		select3.selectByVisibleText("生效日期");
//		driver.findElement(By.xpath("//input[@value='套用']")).click();
//		driver.findElement(By.xpath("//input[contains(@onclick,'0')][@value='刪除']")).click();
//
//		driver.findElement(By.xpath("//input[@value='編輯']")).click();
//		select3.selectByVisibleText("製作日期");
//		driver.findElement(By.xpath("//input[@value='套用']")).click();
//
//		driver.findElement(By.id("btnModifySnGenRule")).click();
//		alert.accept();
//
//		/* 刪除 */
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("BPM_test")).click();// 修改 WMS\ManageDocType\ManageDocTypeMain.jsp line182
//		driver.findElement(By.id("btnDeleteSnGenRule")).click();
//		alert.accept();

		
		
		
		/* 機密等級管理 */
//		Thread.sleep(1000);
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle);
//		}
//		driver.switchTo().frame("ifmNavigator");
//		driver.findElement(By.id("module00000000000000000000000001")).click(); // 修改 WMS\Templates\NavigatorMenu.jsp line506
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
//		}
//		driver.findElement(By.partialLinkText("機密等級管理")).click();
//
//		/* 新增 */
//		/* 新增_刪除/修改使用 */
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("btnCreateLevel")).click();
//		
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//
//		driver.findElement(By.id("txtID")).sendKeys("abc");
//		driver.findElement(By.id("txtName")).sendKeys("abc");
//		driver.findElement(By.id("txtDescription")).sendKeys("abc");
//		driver.findElement(By.id("btnAddLevel")).click();
//
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("btnAdjustLevel")).click();
//		
//		/* 第一層級_高 */
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("btnCreateLevel")).click();
//
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//
//		driver.findElement(By.id("txtID")).sendKeys("S30");// S3
//		driver.findElement(By.id("txtName")).sendKeys("極機密1");// 極機密
//		driver.findElement(By.id("txtDescription")).sendKeys("極機密");// 極機密
//		driver.findElement(By.id("btnAddLevel")).click();
//
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("btnAdjustLevel")).click();
//
//		/* 第二層級_中 */
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("btnCreateLevel")).click();
//
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//
//		driver.findElement(By.id("txtID")).sendKeys("S20");// S2
//		driver.findElement(By.id("txtName")).sendKeys("機密1");// 機密
//		driver.findElement(By.id("txtDescription")).sendKeys("機密");// 機密
//		driver.findElement(By.id("btnAddLevel")).click();
//
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("btnAdjustLevel")).click();
//
//		/* 第三層級_低 */
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("btnCreateLevel")).click();
//
//		driver.findElement(By.id("txtID")).sendKeys("S0");// 0
//		driver.findElement(By.id("txtName")).sendKeys("公開1");// 公開
//		driver.findElement(By.id("txtDescription")).sendKeys("公開");// 公開
//		driver.findElement(By.id("btnAddLevel")).click();
//
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("btnAdjustLevel")).click();
//
//		/*修改*/
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("abc")).click();//修改 WMS\ManageSecurityLevel\SecurityLevelMain.jsp line202
//		driver.findElement(By.id("btnModifyLevel")).click();
//		 
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		
//		driver.findElement(By.id("txtName")).clear();
//		driver.findElement(By.id("txtDescription")).clear();
//		driver.findElement(By.id("txtName")).sendKeys("bca");
//		driver.findElement(By.id("txtDescription")).sendKeys("bca");
//		driver.findElement(By.id("btnEditLevel")).click();
//
//		/*刪除*/
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("abc")).click();//修改 WMS\ManageSecurityLevel\SecurityLevelMain.jsp line202
//		driver.findElement(By.id("btnDeleteLevel")).click();
//		alert.accept();
//		
//		/* 排序 */
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("btnSortLevel")).click();
//
//		driver.findElement(By.xpath("//td[@value='S30']")).click();// S3
//		driver.findElement(By.id("Button1")).click();
//		driver.findElement(By.id("Button1")).click();
//
//		driver.findElement(By.xpath("//td[@value='S0']")).click();// 0
//		driver.findElement(By.id("Button2")).click();
//		driver.findElement(By.id("btnAdjustLevel")).click();
		
		
		
		
		/* 權限屬性管理 */
//		Thread.sleep(1000);
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle);
//		}
//		driver.switchTo().frame("ifmNavigator");
//		driver.findElement(By.id("module00000000000000000000000001")).click();
//		// 修改 WMS\Templates\NavigatorMenu.jsp line506
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
//		}
//		driver.findElement(By.partialLinkText("權限屬性管理")).click();
//
//		/* 新增 */
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("btnCreateAccessRight")).click();
//
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//
//		driver.findElement(By.id("txtID")).sendKeys("abc");
//		driver.findElement(By.id("txtName")).sendKeys("abc");
//		driver.findElement(By.id("txtDescription")).sendKeys("abc");
//
//		Select select3 = new Select(driver.findElement(By.id("selSecurityLevel")));
//		select3.selectByVisibleText("公開");
//		Select select4 = new Select(driver.findElement(By.id("selAccessType")));
//		select4.selectByVisibleText("讀取權限");
//		Select select5 = new Select(driver.findElement(By.id("selType")));
//		select5.selectByVisibleText("所有人員");
//
//		driver.findElement(By.id("btnSaveAccessRight")).click();
//		driver.findElement(By.id("btnSubmitAccessRight")).click();
//
//		/*修改*/
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("abc")).click();//修改 WMS\ManageAccessRight\AccessRightMain.jsp line167
//		driver.findElement(By.id("btnModifyAccessRight")).click();
//		
//		driver.findElement(By.xpath("//input[@value='編輯']")).click();
//		Select select33 = new Select(driver.findElement(By.id("selSecurityLevel")));
//		select33.selectByVisibleText("機密");
//		driver.findElement(By.xpath("//input[@value='套用']")).click();
//		
//		driver.findElement(By.id("btnSubmitAccessRight")).click();
//		
//		/*刪除*/
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("abc")).click();
//		driver.findElement(By.id("btnDeleteAccessRight")).click();
//		Alert alert = driver.switchTo().alert();//需刪除
//		alert.accept();
		
		
		
		/* 文件預先取號 */
//		Thread.sleep(1000);
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle);
//		}
//		driver.switchTo().frame("ifmNavigator");
//		driver.findElement(By.id("module00000000000000000000000001")).click();
//		// 修改 WMS\Templates\NavigatorMenu.jsp line506
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
//		}
//		driver.findElement(By.partialLinkText("文件預先取號")).click();
//		
//		/*新增*/
//		Thread.sleep(1000);
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle);
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("btnCreateDocDraft")).click();
//		
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle);
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		
//		driver.findElement(By.id("docName")).sendKeys("TEST");
//		driver.findElement(By.id("description")).sendKeys("TEST");
//		
//		driver.findElement(By.id("btnChooseSnGenRule")).click();
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle);
//		}
//		driver.findElement(By.id("ISO_DEFAULT_SN_RULE_USER_DEFINE1")).click();
//		
//		Thread.sleep(500);
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle);
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("btnCreateDocDraft")).click();
//		Alert alert = driver.switchTo().alert();//需刪除
//		alert.accept();
//		
//		/*選取*/
//		Thread.sleep(1000);
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle);
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.xpath("//td[contains(text(),'TEST')]")).click();
//       
//		/*選取_機密等級_*/
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
//		}
//		Select selectaaa = new Select(driver.findElement(By.id("selSecurityLevels")));
//		selectaaa.selectByVisibleText("公開");
//		
//		/*選取_文件屬性_制定單位*/
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
//		}
//		driver.findElement(By.id("btnChooseMaker")).click();
//		
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
//		}
//		driver.findElement(By.xpath("//td[contains(text(),'1')]")).click();
//		
//		/*選取_文件屬性_保管單位*/
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
//		}
//		driver.findElement(By.id("btnChooseOwner")).click();
//		
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
//		}
//		driver.findElement(By.xpath("//td[contains(text(),'1')]")).click();
//		
//		/*選取_文件屬性_生效日期*/
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
//		}
//		driver.findElement(By.id("btnChoosePublishStartTime")).click();
//		
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
//		}
//		driver.findElement(By.xpath("//td[@class='day selected today']")).click();
//		
//		/*選取_文件屬性_文件製作者*/
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
//		}
//		driver.findElement(By.id("btnChooseDocMaker")).click();
//		
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
//		}
//		driver.findElement(By.xpath("//td[contains(text(),'2')]")).click();
//		
//		/*選取_文件屬性_文件型態階層*/
//		Thread.sleep(500);
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
//		}
//		driver.findElement(By.id("btnChooseDocLevel")).click();
//		
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
//		}
//		driver.findElement(By.id("checkbox_1")).click();
//		driver.findElement(By.id("btnChooseDocLevels")).click();
//		
//		Thread.sleep(500);
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
//		}
//		Select selectaa = new Select(driver.findElement(By.id("ddlDocLevelRule")));
//		selectaa.selectByVisibleText("ISO9000-品質手冊");
//		
//		/*選取_文件屬性_文件類別*/
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
//		}
//		driver.findElement(By.id("btnChooseDocCategory")).click();
//		
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
//		}
//		driver.findElement(By.id("checkbox_2")).click();
//		driver.findElement(By.id("btnChooseDocCategories")).click();
//		
//		Thread.sleep(500);
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
//		}
//		Select selecta = new Select(driver.findElement(By.id("ddlDocCategoryRule")));
//		selecta.selectByVisibleText("測試");
//		
//		/*選取_文件檔案*/
//		
//		driver.findElement(By.xpath("//span[contains(text(),'文件檔案')]")).click();
//		driver.findElement(By.id("btnUploadDocFile")).click();//修改 WMS\ManageDocument\DocFileUploader.jsp line140
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
//		}
//		driver.findElement(By.id("fileDocument")).sendKeys("C:\\Users\\Bruce\\Desktop\\TEST.docx");
//		driver.findElement(By.id("btnUploadDocument")).click();
//		//Alert alert = driver.switchTo().alert();//需刪除
//		alert.accept();
//		driver.findElement(By.id("btnCancel")).click();
//		
//		Thread.sleep(500);
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
//		}
//		driver.findElement(By.id("btnCreateDocument")).click();
//		alert.accept();
//		alert.accept();
//		
//		Thread.sleep(5000);
		
		
		
		// /*文件檔案管理*/
//		Thread.sleep(1000);
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle);
//		}
//		driver.switchTo().frame("ifmNavigator");
//		driver.findElement(By.id("module00000000000000000000000001")).click();
//		// 修改 WMS\Templates\NavigatorMenu.jsp line506
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
//		}
//		driver.findElement(By.partialLinkText("文件檔案管理")).click();
//
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.xpath("//input[@value='PDF轉檔測試']")).click();
//		
//		
////		driver.findElement(By.xpath("//span[contains(text(),'文件檔案')]")).click();
////		driver.findElement(By.id("btnUploadDocFile")).click();//修改 WMS\ManageDocument\DocFileUploader.jsp line140
////		for (String winHandle : driver.getWindowHandles()) {
////			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
////		}
////		driver.findElement(By.id("fileDocument")).sendKeys("C:\\Users\\Bruce\\Desktop\\TEST.docx");
////		driver.findElement(By.id("btnUploadDocument")).click();
////		//Alert alert = driver.switchTo().alert();//需刪除
////		alert.accept();
//		driver.findElement(By.id("btnCancel")).click();

		
		
		
		/* 文件總管 */
		// Thread.sleep(1000);
		// for(String winHandle : driver.getWindowHandles()){
		// driver.switchTo().window(winHandle);
		// }
		// driver.switchTo().frame("ifmNavigator");
		// driver.findElement(By.id("module00000000000000000000000001")).click();
		// // 修改 WMS\Templates\NavigatorMenu.jsp line506
		// for (String winHandle : driver.getWindowHandles()) {
		// driver.switchTo().window(winHandle); //轉換成系統管理工具-小視窗
		// }
		// driver.findElement(By.partialLinkText("文件總管")).click();

		
		
		/* 文件條文管理 */
//		Thread.sleep(1000);
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle);
//		}
//		driver.switchTo().frame("ifmNavigator");
//		driver.findElement(By.id("module00000000000000000000000001")).click();
//		// 修改 WMS\Templates\NavigatorMenu.jsp line506
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
//		}
//		driver.findElement(By.partialLinkText("文件條文管理")).click();
//
//		/*新增*/
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("btnCreateDocClause")).click();
//		
//		driver.findElement(By.id("txtClauseNo")).sendKeys("Clouse02");
//		driver.findElement(By.id("txtClauseName")).sendKeys("ISO條文");
//		driver.findElement(By.id("txtClauseContent")).sendKeys("ISO條文內容");
//		
//		driver.findElement(By.id("btnDocTypeId")).click();
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.findElement(By.id("ISO9000")).click();
//		
//		Thread.sleep(500);
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("btnCreateDocClause")).click();
//		
//		/* 修改 */
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("Clouse02")).click();//修改 WMS\ManageDocClause\ManageDocClauseMain.jsp line199
//		driver.findElement(By.id("btnModifyDocClause")).click();
//		
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		
//		driver.findElement(By.id("txtClauseName")).sendKeys("123");
//		driver.findElement(By.id("txtClauseContent")).sendKeys("123");
//		driver.findElement(By.id("btnModifyDocClause")).click();
//		
//		/*刪除*/
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("Clouse02")).click();
//		driver.findElement(By.id("btnDeleteDocClause")).click();
//		Alert alert = driver.switchTo().alert();//需刪除
//		alert.accept();
		
		
		
		/* 生失效郵件範本管理 */
//		Thread.sleep(1000);
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle);
//		}
//		driver.switchTo().frame("ifmNavigator");
//		driver.findElement(By.id("module00000000000000000000000001")).click();
//		// 修改 WMS\Templates\NavigatorMenu.jsp line506
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
//		}
//		driver.findElement(By.partialLinkText("生失效郵件範本管理")).click();
//
//		/*修改*/
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.xpath("//input[@value='000zh_CN0NotificationContent0050']")).click();
//		driver.findElement(By.id("btnModifyNotificationContent")).click();
//		
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		
//		driver.findElement(By.xpath("//input[@value='true']")).click();
//		
//		Select select66 = new Select(driver.findElement(By.id("ddlAttribute")));
//		select66.selectByVisibleText("版號");
//		driver.findElement(By.id("btnAddSubMessage")).click();
//		driver.findElement(By.id("btnAddAttrMessage")).click();
//
//		driver.findElement(By.id("btnModifyNotificationContent")).click();
//		//Alert alert = driver.switchTo().alert();//需刪除
//		alert.accept();
		
		
		
		
		/* PDF浮水印屬性管理 */
//		Thread.sleep(1000);
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle);
//		}
//		driver.switchTo().frame("ifmNavigator");
//		driver.findElement(By.id("module00000000000000000000000001")).click();// 修改 WMS\Templates\NavigatorMenu.jsp line506
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 轉換成系統管理工具-小視窗
//		}
//		driver.findElement(By.partialLinkText("PDF浮水印屬性管理")).click();
//		
//		/*新增_刪除用*/
//		Thread.sleep(1000);
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("btnCreateWatermarkPattern")).click();
//		
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("btnChooseOrg")).click();
//		
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.findElement(By.xpath("//td[contains(text(),'1')]")).click();
//		
//		Thread.sleep(500);
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		
//		Select select6 = new Select(driver.findElement(By.id("ddlAttribute")));
//		select6.selectByVisibleText("制定單位組織名稱");
//		driver.findElement(By.id("btnAddAttrContext")).click();
//		select6.selectByVisibleText("生效日期");
//		driver.findElement(By.id("btnAddAttrContext")).click();
//		
//		driver.findElement(By.id("txtWatermarkContext")).clear();
//		
//		select6.selectByVisibleText("制定單位組織名稱");
//		driver.findElement(By.id("btnAddAttrContext")).click();
//		
//		driver.findElement(By.xpath("//input[@value='false']")).click();
//		
//		Select select7 = new Select(driver.findElement(By.id("ddlPosition")));
//		select7.selectByVisibleText("下方置中");
//		
//		Select select8 = new Select(driver.findElement(By.id("ddlFontsize")));
//		select8.selectByVisibleText("60");
//		
//		Select select9 = new Select(driver.findElement(By.id("ddlTransparency")));
//		select9.selectByVisibleText("60");
//		
//		Select select10 = new Select(driver.findElement(By.id("ddlRotation")));
//		select10.selectByVisibleText("60");
//		
//		Select select11 = new Select(driver.findElement(By.id("ddlFontsharp")));
//		select11.selectByVisibleText("空心");
//		
//		driver.findElement(By.id("btnCreateWatermarkPattern")).click();
//		Alert alert = driver.switchTo().alert();//需刪除
//		alert.accept();
//		
//		/*新增_修改用*/
//		Thread.sleep(1000);
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("btnCreateWatermarkPattern")).click();
//		
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("btnChooseOrg")).click();
//		
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.findElement(By.xpath("//td[contains(text(),'1')]")).click();
//		
//		Thread.sleep(500);
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		
//		Select select60 = new Select(driver.findElement(By.id("ddlAttribute")));
//		select60.selectByVisibleText("制定單位組織名稱");
//		driver.findElement(By.id("btnAddAttrContext")).click();
//		select60.selectByVisibleText("生效日期");
//		driver.findElement(By.id("btnAddAttrContext")).click();
//		
//		driver.findElement(By.id("txtWatermarkContext")).clear();
//		
//		select60.selectByVisibleText("制定單位組織名稱");
//		driver.findElement(By.id("btnAddAttrContext")).click();
//		
//		driver.findElement(By.xpath("//input[@value='false']")).click();
//		
//		Select select70 = new Select(driver.findElement(By.id("ddlPosition")));
//		select70.selectByVisibleText("下方置中");
//		
//		Select select80 = new Select(driver.findElement(By.id("ddlFontsize")));
//		select80.selectByVisibleText("60");
//		
//		Select select90 = new Select(driver.findElement(By.id("ddlTransparency")));
//		select90.selectByVisibleText("60");
//		
//		Select select100 = new Select(driver.findElement(By.id("ddlRotation")));
//		select100.selectByVisibleText("60");
//		
//		Select select110 = new Select(driver.findElement(By.id("ddlFontsharp")));
//		select110.selectByVisibleText("空心");
//		
//		driver.findElement(By.id("btnCreateWatermarkPattern")).click();
//		alert.accept();
//		
//		/*刪除*/
//		Thread.sleep(1000);
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("(DGW)鼎新電腦")).click();//修改 WMS\ManageISOWatermarkPattern\ManageISOWatermarkPatternMain.jsp line185
//		driver.findElement(By.id("btnDeleteWatermarkPattern")).click();
//		alert.accept();
//		alert.accept();
//		
//		/*修改*/
//		Thread.sleep(1000);
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("(DGW)鼎新電腦")).click();//修改 WMS\ManageISOWatermarkPattern\ManageISOWatermarkPatternMain.jsp line185
//		driver.findElement(By.id("btnModifyWatermarkPattern")).click();
//		
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle); // 換成新的頁面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		
//		driver.findElement(By.id("txtWatermarkContext")).clear();
//		
//		Select select12 = new Select(driver.findElement(By.id("ddlAttribute")));
//		select12.selectByVisibleText("生效日期");
//		driver.findElement(By.id("btnAddAttrContext")).click();
//		
//		driver.findElement(By.xpath("//input[@value='true']")).click();
//		
//		Select select700 = new Select(driver.findElement(By.id("ddlPosition")));
//		select700.selectByVisibleText("水平垂直置中");
//		
//		Select select800 = new Select(driver.findElement(By.id("ddlFontsize")));
//		select800.selectByVisibleText("50");
//		
//		Select select900 = new Select(driver.findElement(By.id("ddlTransparency")));
//		select900.selectByVisibleText("50");
//		
//		Select select1000 = new Select(driver.findElement(By.id("ddlRotation")));
//		select1000.selectByVisibleText("45");
//		
//		Select select1100 = new Select(driver.findElement(By.id("ddlFontsharp")));
//		select1100.selectByVisibleText("實心");
//		
//		driver.findElement(By.id("btnModifyWatermarkPattern")).click();
//		alert.accept();
	}
}