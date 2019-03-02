package User;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class UserTest {
	WebDriver driver ;
	@BeforeSuite
	public void initDriver() throws Exception {
	 driver = new FirefoxDriver();
//	 System.setProperty("webdriver.chrome.driver", "D://eclipse_BPM_develop/WorkSpace/TEST/chromedriver.exe");
//        driver = new ChromeDriver();
//		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
//       capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//        System.setProperty("webdriver.ie.driver", "D://Gu/自動測試工具/selenium/Eclipse/workspace/Selenium/IEDriverServer.exe");
//        capabilities.setCapability("ignoreZoomSetting", true);
//        driver = new InternetExplorerDriver(capabilities);
	    }
	@BeforeClass
	  public void Explorer() {
		 driver.get("http://10.20.9.26:8106/NaNaWeb"); //BPM URL
	  }
  @Test(priority=1)
  public void login() {
	  	 driver.manage().window().maximize();
	  	transferNewWindow();
		//多語系 - 繁體中文
		Select select = new Select(driver.findElement(By.id("ddlLanguage")));
		select.selectByVisibleText("繁體中文");
		driver.findElement(By.id("txtUserId")).sendKeys("0003"); //帳號
		driver.findElement(By.id("txtPassword")).sendKeys("0003");//密碼
		WebElement webElement = driver.findElement(By.id("txtPassword"));//密碼打完執行Enter
		webElement.sendKeys(Keys.ENTER);
  }
  @Test(priority=2)
  public void SettingUser() throws Exception{
	  	Thread.sleep(5000);
	  	ChooseMenu("GetProfileMenu");
		Thread.sleep(1000);
		ChooseModel("SetPersonalInfo");
		driver.switchTo().frame("ifmFucntionLocation");
		/*修改密碼
		driver.findElement(By.id("btnChangePassword")).click();
		transferNewWindow();
		driver.findElement(By.id("txtOldPassword")).sendKeys("0004");//舊密碼
		driver.findElement(By.id("txtNewPassword")).sendKeys("1");//新密碼
		driver.findElement(By.id("txtRepeatNewPassword")).sendKeys("1");//確認新密碼
		driver.findElement(By.id("btnConfirm")).click();
		Alert Confirmalert = driver.switchTo().alert();
		Confirmalert.accept();
		Alert Cookiealert = driver.switchTo().alert();
		Cookiealert.accept();
		Alert Alarmalert = driver.switchTo().alert();
		Alarmalert.accept();
		transferNewWindow();
		driver.findElement(By.xpath("//a[contains(@href,'javaScript:logout()')]")).click();
		Alert Logoutalert = driver.switchTo().alert();
		Logoutalert.accept();
		//修改回原密碼
		JavascriptExecutor st = (JavascriptExecutor)driver;
		st.executeScript("alert('hello world');");		
		Select select = new Select(driver.findElement(By.id("ddlLanguage")));
		select.selectByVisibleText("繁體中文");
		driver.findElement(By.id("txtUserId")).sendKeys("0004"); //帳號
		driver.findElement(By.id("txtPassword")).sendKeys("1");//密碼
		WebElement webElement = driver.findElement(By.id("txtPassword"));//密碼打完執行Enter
		webElement.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//a[contains(@href,'javascript:getProfileMenu()')]")).click();
		driver.findElement(By.partialLinkText("設定個人資訊")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnChangePassword")).click();
		transferNewWindow();
		driver.findElement(By.id("txtOldPassword")).sendKeys("1");
		driver.findElement(By.id("txtNewPassword")).sendKeys("0004");
		driver.findElement(By.id("txtRepeatNewPassword")).sendKeys("0004");
		driver.findElement(By.id("btnConfirm")).click();
		Alert Confirmalert1 = driver.switchTo().alert();
		Confirmalert1.accept();
		Alert Cookiealert1 = driver.switchTo().alert();
		Cookiealert1.accept();
		Alert Alarmalert1 = driver.switchTo().alert();
		Alarmalert1.accept();
		transferNewWindow();
		*/
		driver.findElement(By.id("AddSignImage")).click(); //選擇簽名圖檔
		transferNewWindow();
		WebElement element = driver.findElement(By.name("fileDocument_0"));
		element.sendKeys("D:\\Gu\\修改文件\\20140807124942686.jpg");//檔案位址自行修改
		driver.findElement(By.id("btnUploadDocument")).click();
		Alert alertUpload = driver.switchTo().alert();
		alertUpload.accept();
		Thread.sleep(500);
		transferNewWindow();	
		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("DelSignImage")).click();
//		Alert alertDel = driver.switchTo().alert();
//		alertDel.accept();
		driver.findElement(By.xpath("//a[contains(@href,'javaScript:switchTab(1)')]")).click();
		Thread.sleep(1000);
		driver.switchTo().frame("ifmOperation");
		driver.findElement(By.id("btnCreate")).click();
		transferNewWindow();		
		driver.findElement(By.id("btnChooseDefaultSubstitutes")).click();
		transferNewWindow();
		List<WebElement> rad2 = driver.findElements(By.id("chkChosenOptions"));
		rad2.get(1).click();	
		driver.findElement(By.id("btnReturnValues")).click();
		Thread.sleep(500);
		transferNewWindow();
		driver.findElement(By.id("btnConfirm")).click();
		transferNewWindow();
		driver.switchTo().frame("ifmFucntionLocation");
		driver.switchTo().frame("ifmOperation");
		List<WebElement> rad7 = driver.findElements(By.name("chkSubstituteIndex"));
		rad7.get(0).click();
		driver.findElement(By.id("btnEdit")).click();		
		transferNewWindow();
		driver.findElement(By.id("btnChooseDefaultSubstitutes")).click();
		transferNewWindow();
		List<WebElement> rad3 = driver.findElements(By.id("chkChosenOptions"));
		rad3.get(2).click();
		driver.findElement(By.id("btnReturnValues")).click();
		Thread.sleep(500);
		transferNewWindow();
		driver.findElement(By.id("btnConfirm")).click();
		transferNewWindow();
		driver.switchTo().frame("ifmFucntionLocation");
		Thread.sleep(500);
		driver.switchTo().frame("ifmOperation");
		List<WebElement> rad8 = driver.findElements(By.name("chkSubstituteIndex"));
		rad8.get(0).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("btnSave")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(1000);
		transferNewWindow();
		driver.switchTo().frame("ifmFucntionLocation");
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[contains(@href,'javaScript:switchTab(2)')]")).click();
		driver.switchTo().frame("ifmOperation");
		driver.findElement(By.id("btnCreate")).click();
		transferNewWindow();
		Thread.sleep(1000);
		driver.findElement(By.id("btnChooseProcessPackage")).click();
		transferNewWindow();		
		List<WebElement> rad4 = driver.findElements(By.id("chkChosenOptions"));
		rad4.get(1).click();
		driver.findElement(By.id("btnReturnValues")).click();
		Thread.sleep(500);
		transferNewWindow();
		driver.findElement(By.id("btnChooseProcessSubstitutes")).click();
		transferNewWindow();
		Thread.sleep(500);
		List<WebElement> rad5 = driver.findElements(By.id("chkChosenOptions"));
		rad5.get(1).click();
		driver.findElement(By.id("btnReturnValues")).click();
		Thread.sleep(500);
		transferNewWindow();
		driver.findElement(By.id("btnConfirm")).click();
		transferNewWindow();
		driver.switchTo().frame("ifmFucntionLocation");
		driver.switchTo().frame("ifmOperation");
		List<WebElement> rad9 = driver.findElements(By.name("chkSubstituteIndex"));
		rad9.get(0).click();
		driver.findElement(By.id("btnEdit")).click();
		Thread.sleep(500);
		transferNewWindow();
		driver.findElement(By.id("btnChooseProcessSubstitutes")).click();
		transferNewWindow();
		List<WebElement> rad6 =driver.findElements(By.id("chkChosenOptions"));
		rad6.get(1).click();
		driver.findElement(By.id("btnReturnValues")).click();
		Thread.sleep(500);
		transferNewWindow();
		driver.findElement(By.id("btnConfirm")).click();
		transferNewWindow();
		driver.switchTo().frame("ifmFucntionLocation");
		driver.switchTo().frame("ifmOperation");
		List<WebElement> rad10 = driver.findElements(By.name("chkSubstituteIndex"));
		rad10.get(0).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("btnSave")).click();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		/*driver.findElement(By.id("btnChangeRelationship")).click();
		transferNewWindow();
		String winHandleBefore = driver.getWindowHandle();
		driver.findElement(By.id("btnChooseRelationships")).click();
		transferNewWindow();
		driver.findElement(By.className("Data2")).click();
		driver.findElement(By.id("btnReturnValues")).click();
		driver.switchTo().window(winHandleBefore);
		Alert alertRelation = driver.switchTo().alert();
		alertRelation.sendKeys("主管");
		alertRelation.accept();
		String winHandleBefore1 = driver.getWindowHandle();
		driver.findElement(By.id("btnConfirm")).click();
		Alert alertConfirm = driver.switchTo().alert();
		alertConfirm.accept();
		driver.switchTo().window(winHandleBefore1);
	((JavascriptExecutor) driver).executeScript("window.confirm()"
			+ " = function(msg) { "
				+ " alert('123');  return true; }");
	
		//Alert alertConfirm1 = driver.switchTo().alert();		
		//alertConfirm1.accept();		 	
		 */
	}
  	@Test(priority =3)
  public void PersonalSetting() throws Exception{ //自定義維護
	  	Thread.sleep(5000);
	  	transferNewWindow();
		driver.switchTo().frame("ifmNavigator");
		ChooseMenu("PersonalSetting");
		transferNewWindow();
		driver.switchTo().frame("ifmFucntionLocation");
		WebElement Directory = driver.findElement(By.id("treeDemo_1_span"));
		Actions actions = new Actions(driver);
		actions.contextClick(Directory).sendKeys(Keys.DOWN).build().perform();
		driver.findElement(By.id("addParent")).click();	
		Thread.sleep(3000);
		driver.findElement(By.id("treeDemo_2_span")).sendKeys(Keys.ENTER);
		WebElement Directory1 = driver.findElement(By.id("treeDemo_2_span"));
		Actions actions1 = new Actions(driver);
		actions1.contextClick(Directory1).sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.id("addLeaf")).click();
		driver.findElement(By.id("cuzProgramName")).sendKeys("123");
		Select select = new Select(driver.findElement(By.id("ddlURL")));
		select.selectByVisibleText("追蹤流程");
		Select select1 = new Select(driver.findElement(By.id("ddlProcessCategory")));
		select1.selectByVisibleText("未分類");
		Select select2 = new Select(driver.findElement(By.id("ddlProcessPkgName")));
		select2.selectByVisibleText("簽呈");
		driver.findElement(By.id("btnToRight")).click();
		driver.findElement(By.xpath("//input[@value='確認']")).click();
		WebElement Directory2 = driver.findElement(By.id("treeDemo_3_span"));
		Actions actions2 = new Actions(driver);
		actions2.contextClick(Directory2).sendKeys(Keys.DOWN).build().perform();
		driver.findElement(By.id("edit")).click();
		driver.findElement(By.id("cuzProgramName")).sendKeys("456");
		Select select3 = new Select(driver.findElement(By.id("ddlURL")));
		select3.selectByVisibleText("追蹤流程");
		Select select4 = new Select(driver.findElement(By.id("ddlProcessCategory")));
		select4.selectByVisibleText("未分類");
		Select select5 = new Select(driver.findElement(By.id("ddlProcessPkgName")));
		select5.selectByVisibleText("簽呈");
		driver.findElement(By.id("btnToRight")).click();
		driver.findElement(By.xpath("//input[@value='確認']")).click();
		WebElement Directory3 = driver.findElement(By.id("treeDemo_2_span"));
		Actions actions3 = new Actions(driver);
		actions3.contextClick(Directory3).sendKeys(Keys.DOWN).build().perform();
		driver.findElement(By.id("remove")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.findElement(By.id("btnSetProgramAccessRight")).click();//存檔
	}
  @Test(priority=4)
  public void InvokeProcess() throws Exception{ //發起流程
	  Thread.sleep(5000);
	  transferNewWindow();
	  driver.switchTo().frame("ifmNavigator");
	  driver.findElement(By.xpath("//*[@id='CenterleftOuter']/div[1]/p")).click(); //發起流程
		transferNewWindow();
		driver.switchTo().frame("ifmFucntionLocation");
		Select select1 = new Select(driver.findElement(By.id("ddlProcessCategory")));
		select1.selectByVisibleText("未分類");
		Thread.sleep(3000);
		List<WebElement> rad2 = driver.findElements(By.className("a7"));
		rad2.get(0).click();
		Thread.sleep(3000);
		driver.findElement(By.id("btnInvokeProcess")).click();		
  }  

  @AfterClass
  public void logout() throws Exception {
//	  Thread.sleep(5000);
//	  transferNewWindow();
//		 driver.findElement(By.xpath("//a[contains(@href,'javaScript:logout()')]")).click();
//			Alert Logoutalert = driver.switchTo().alert();
//			Logoutalert.accept();
//		System.out.println("Logout");
  }
  public void transferNewWindow(){
	  for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle);
		}
  }
  public void ChooseMenu(String Function) throws Exception{
		 Thread.sleep(5000);
		 for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
		 if(Function=="GetProfileMenu"){
			 driver.findElement(By.xpath("//a[contains(@href,'javascript:getProfileMenu()')]")).click();
		}else{
			System.out.println("SystemManage");
		}
		 for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
		driver.switchTo().frame("ifmNavigator");		 
		if(Function =="Program"){
			driver.findElement(By.xpath("//p[contains(@onclick,'gotoSystemManage()')]")).click();//系統管理工具
		}else if(Function =="PersonalSetting"){
			driver.findElement(By.xpath("//p[contains(@class,'cuz')]")).click(); //自定義維護
		}
	 }
	 public  void ChooseModel(String Function) throws Exception{
		 Thread.sleep(1000);
		
		String funcName = null;
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		switch (Function) {
		case "ManagePhrase":
			funcName = "管理片語";
			break;
		case "SetPersonalInfo":
			funcName = "設定個人資訊";
			break;
		default:
			funcName = "";
		}
		driver.findElement(By.partialLinkText(funcName)).click();
		Thread.sleep(3000);
	 }


}
