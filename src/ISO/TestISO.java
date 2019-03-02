package ISO;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestISO {
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
  
  
//  @Test(priority=2)
//  public void test() throws Exception{
//	  Thread.sleep(5000);
//	  driver.switchTo().frame("ifmNavigator");
//	  driver.findElement(By.id("module00000000000000000000000001")).click();
//	  for (String winHandle : driver.getWindowHandles()) {
//		    driver.switchTo().window(winHandle); //轉換成系統管理工具-小視窗
//		}
//		driver.findElement(By.partialLinkText("文件類別管理")).click();
//		Thread.sleep(4000);
//		driver.switchTo().frame("ifmFucntionLocation");
//		WebElement Directory = driver.findElement(By.className("dojoTreeNodeLabel"));
//		Actions actions = new Actions(driver);
//		actions.contextClick(Directory).sendKeys(Keys.DOWN).build().perform();
//		Thread.sleep(3000);
//		driver.findElement(By.className("dojoMenuItem2Icon")).click();
//		Thread.sleep(1000);
//		Alert alert=driver.switchTo().alert();
//		driver.switchTo().alert().sendKeys("Helllo");
//		alert.accept();
//		Thread.sleep(3000);
//		WebElement Directory1 =driver.findElement(By.xpath("//*[@id='divForScrollbarHeight']/table/tbody/tr/td/div/table/tbody/tr/td/div[2]/div/div/div[2]/div/div/span[1]/span/a"));
//		Actions actions1 = new Actions(driver);
//		actions1.contextClick(Directory1).sendKeys(Keys.DOWN).build().perform();
		
		
////		for (String winHandle : driver.getWindowHandles()) {
////		    driver.switchTo().window(winHandle); //轉換成系統管理工具-小視窗
////		}
////		driver.switchTo().frame("ifmFucntionLocation");
////		WebElement Directory1 = driver.findElement(By.xpath("//a[@text='ISO1']"));
////		Actions actions1 = new Actions(driver);
////		actions1.contextClick(Directory1).sendKeys(Keys.DOWN).build().perform();
//  }
@Test(priority=3)
public void DocDataManagement() throws Exception{//文件檔案管理
//	  Thread.sleep(5000);
//	  String test = driver.getWindowHandle();
//	  for (String winHandle : driver.getWindowHandles()) {
//		    driver.switchTo().window(winHandle); //換成新的頁面
//		}
//	  driver.switchTo().frame("ifmNavigator");
//	  driver.findElement(By.id("module00000000000000000000000001")).click();
//	  for (String winHandle : driver.getWindowHandles()) {
//		    driver.switchTo().window(winHandle); //轉換成系統管理工具-小視窗
//		}
//		driver.findElement(By.partialLinkText("文件檔案管理")).click();
//		
//		Thread.sleep(4000);
//		driver.switchTo().frame("ifmFucntionLocation");		
//		driver.findElement(By.xpath("//a[contains(@href,'javaScript:obtainUnIndexedDocs()')]")).click();
//		Thread.sleep(4000);
//		driver.findElement(By.xpath("//a[contains(@href,'javaScript:obtainUnDeployedDocs()')]")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.id("btnTestPDFConverter")).click();
//		for (String winHandle : driver.getWindowHandles()) {
//		    driver.switchTo().window(winHandle); //轉換成系統管理工具-小視窗
//		}
//		WebElement element = driver.findElement(By.name("fileDocument"));
//		element.sendKeys("D:\\Gu\\註冊產品碼.png");
//		driver.findElement(By.id("btnUploadDocument")).click();
//		driver.switchTo().window(test);

}
//@Test(priority=2)
//public void DocManagement() throws Exception{//文件總管
//	  Thread.sleep(5000);
//	  driver.switchTo().frame("ifmNavigator");
//	  driver.findElement(By.id("module00000000000000000000000001")).click();
//	  for (String winHandle : driver.getWindowHandles()) {
//		    driver.switchTo().window(winHandle); //轉換成系統管理工具-小視窗
//		}
//		driver.findElement(By.partialLinkText("文件總管")).click();		
//		Thread.sleep(4000);
//		driver.switchTo().frame("ifmFucntionLocation");		
//		driver.findElement(By.id("btnOpenDocumentQueryTask")).click();
//		
//		 driver.findElement(By.id("txtDocName")).sendKeys("ISO");
//		 driver.findElement(By.id("btnExecuteQuery")).click();
//}
	@Test(priority=2)
	public void Test() throws Exception{
		Thread.sleep(5000);
		  for (String winHandle : driver.getWindowHandles()) {
			    driver.switchTo().window(winHandle); //轉換成系統管理工具-小視窗
			}
			driver.switchTo().frame("ifmNavigator");
			driver.findElement(By.xpath("//p[contains(@onclick,'gotoSystemManage()')]")).click();//系統管理工具
			for (String winHandle : driver.getWindowHandles()) {
			    driver.switchTo().window(winHandle); //轉換成系統管理工具-小視窗
			}
			driver.findElement(By.partialLinkText("查詢表單資料")).click();
			driver.switchTo().frame("ifmFucntionLocation");
			driver.findElement(By.id("btnChooseProcessPackages")).click();
			for (String winHandle : driver.getWindowHandles()) {
			    driver.switchTo().window(winHandle); //轉換成系統管理工具-小視窗
			}
			for (String winHandle : driver.getWindowHandles()) {
			    driver.switchTo().window(winHandle); //轉換成系統管理工具-小視窗
			}
			driver.findElement(By.xpath("//td[contains(@value='測試關卡')]")).click();
			driver.findElement(By.id("btnReturnValues")).click();
			for (String winHandle : driver.getWindowHandles()) {
			    driver.switchTo().window(winHandle); //換成新的頁面
			}
			Thread.sleep(3000);
			driver.switchTo().frame("ifmFucntionLocation");
			driver.findElement(By.id("btnCreatedTimeBegin")).click();
			List<WebElement> allDates2=driver.findElements(By.xpath("//div[@class='calendar']//tr//td"));
			System.out.println(allDates2);
			for(WebElement ele:allDates2)
			{			
				String date=ele.getText();
				System.out.println(date);
				if(date.equalsIgnoreCase("‹"))
				{
					ele.click();				
				}
				if(date.equalsIgnoreCase("5"))
				{
				ele.click();
				break;
				}			
			}
			driver.findElement(By.id("btnCreatedTimeEnd")).click();
			Thread.sleep(3000);
			List<WebElement> allDates1=driver.findElements(By.xpath("//div[@class='calendar']//td"));
			for(WebElement ele:allDates1)
			{			
				String date=ele.getText();
				if(date.equalsIgnoreCase("3"))
				{
					ele.click();
					break;
				}			
			}	
			
			driver.findElement(By.id("chkProcessState_all")).click();
			driver.findElement(By.id("btnAdvanceOption")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("btnChooseProcessRequesters")).click();
			for (String winHandle : driver.getWindowHandles()) {
			    driver.switchTo().window(winHandle); //換成新的頁面
			}
			for (String winHandle : driver.getWindowHandles()) {
			    driver.switchTo().window(winHandle); //轉換成系統管理工具-小視窗
			}
			driver.findElement(By.xpath("//td[contains(text(),'1')]")).click();
//			driver.findElement(By.id("txtConditionValue")).sendKeys("副理");
//			driver.findElement(By.id("btnStartQuerying")).click();
//			driver.findElement(By.id("chkChosenOptions")).click();
//			driver.findElement(By.id("btnReturnValues")).click();
			for (String winHandle : driver.getWindowHandles()) {
			    driver.switchTo().window(winHandle); //返回BPM畫面
			}
			driver.switchTo().frame("ifmFucntionLocation");
			driver.findElement(By.id("btnSetProcessConditions")).click();
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			alert.accept();
			Thread.sleep(2000);
			driver.findElement(By.id("btnChooseFormDefinition")).click();
			for (String winHandle : driver.getWindowHandles()) {
			    driver.switchTo().window(winHandle); //返回BPM畫面
			}
			Thread.sleep(2000);
			driver.findElement(By.id("Data0")).click();
			for (String winHandle : driver.getWindowHandles()) {
			    driver.switchTo().window(winHandle); //返回BPM畫面
			}
			driver.switchTo().frame("ifmFucntionLocation");
			driver.findElement(By.id("btnSearchFormData")).click();
			
	}
  @BeforeClass
  public void beforeClass() {
	  driver.get("http://127.0.0.1:8086/NaNaWeb");
  }

  @AfterClass
  public void afterClass() {
  }

}
