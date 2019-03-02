package Administrator;

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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class AdministratorTest {
	 WebDriver driver ;	
	 @BeforeSuite
		public void initDriver() throws Exception {
		 driver = new FirefoxDriver();
//		 System.setProperty("webdriver.chrome.driver", "D://eclipse_BPM_develop/WorkSpace/TEST/chromedriver.exe");
//	        driver = new ChromeDriver();
//			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
//	       capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//	        System.setProperty("webdriver.ie.driver", "D://Gu/自動測試工具/selenium/Eclipse/workspace/Selenium/IEDriverServer.exe");
//	        capabilities.setCapability("ignoreZoomSetting", true);
//	        driver = new InternetExplorerDriver(capabilities);
		    }
	 
  @Test(priority=1)
  public void Login() {	 
	  	driver.manage().window().maximize();
	  	transferNewWindow();
		driver.manage().window().maximize();
		Select select = new Select(driver.findElement(By.id("ddlLanguage")));
		select.selectByVisibleText("繁體中文");
		driver.findElement(By.id("txtUserId")).sendKeys("administrator"); //帳號
		driver.findElement(By.id("txtPassword")).sendKeys("1234");//密碼
		WebElement webElement = driver.findElement(By.id("txtPassword"));//密碼打完執行Enter
		webElement.sendKeys(Keys.ENTER);		
  }
  @Test(priority=2)
  public void Bigger() throws Exception{	 //放大鏡
	  Thread.sleep(2000);
	  ChooseMenu("Bigger");		
  }
  @Test(priority=4)  
  public void Phrase() throws Exception{//管理片語
	  Thread.sleep(3000);
	  ChooseMenu("GetProfileMenu");
	   ChooseModel("ManagePhrase");		
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("hdnPhraseContent")).sendKeys("test123");
		driver.findElement(By.id("btnCreatePhrase")).click(); //新增片語
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@alt='test123']")).click();
		driver.findElement(By.id("hdnPhraseContent")).sendKeys("test456");
		driver.findElement(By.id("btnModifyPhrase")).click();//修改片語
		driver.findElement(By.xpath("//input[@alt='test123test456']")).click();
		driver.findElement(By.id("btnDeletePhrase")).click();//刪除片語
		Thread.sleep(1000);
  }
  @Test(priority=3)
  public void SettingAdministrator() throws Exception{//設定個人資訊
	  Thread.sleep(3000);
	  ChooseMenu("GetProfileMenu");
	  ChooseModel("SetPersonalInfo");
		/*
		
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnChangePassword")).click();
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); //換成新的頁面
		}
		
		driver.findElement(By.id("txtOldPassword")).sendKeys("1234");//舊密碼
		driver.findElement(By.id("txtNewPassword")).sendKeys("1");//新密碼
		driver.findElement(By.id("txtRepeatNewPassword")).sendKeys("1");//確認新密碼
		driver.findElement(By.id("btnConfirm")).click();
		Alert Confirmalert = driver.switchTo().alert();
		Confirmalert.accept();
		Alert Cookiealert = driver.switchTo().alert();
		Cookiealert.accept();
		Alert Alarmalert = driver.switchTo().alert();
		Alarmalert.accept();
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); //轉換成OpenDialog
		}
		driver.findElement(By.xpath("//a[contains(@href,'javaScript:logout()')]")).click();
		Alert Logoutalert = driver.switchTo().alert();
		Logoutalert.accept();
		//修改回原密碼
		Select select = new Select(driver.findElement(By.id("ddlLanguage")));
		select.selectByVisibleText("繁體中文");
		driver.findElement(By.id("txtUserId")).sendKeys("administrator"); //帳號
		driver.findElement(By.id("txtPassword")).sendKeys("1");//密碼
		WebElement webElement = driver.findElement(By.id("txtPassword"));//密碼打完執行Enter
		webElement.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//a[contains(@href,'javascript:getProfileMenu()')]")).click();
		driver.findElement(By.partialLinkText("設定個人資訊")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnChangePassword")).click();
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); //轉換成OpenDialog
		}
		driver.findElement(By.id("txtOldPassword")).sendKeys("1");
		driver.findElement(By.id("txtNewPassword")).sendKeys("1234");
		driver.findElement(By.id("txtRepeatNewPassword")).sendKeys("1234");
		driver.findElement(By.id("btnConfirm")).click();
		Alert Confirmalert1 = driver.switchTo().alert();
		Confirmalert1.accept();
		Alert Cookiealert1 = driver.switchTo().alert();
		Cookiealert1.accept();
		Alert Alarmalert1 = driver.switchTo().alert();
		Alarmalert1.accept();
		*/
		Thread.sleep(1000);
  }
  @Test(priority=5)
  public void ManageSchedule() throws Exception{ //管理流程
	  Thread.sleep(5000);
	  	ChooseMenu("Program");
	  	Thread.sleep(3000);
		ChooseModel("ManageSchedule");	
		driver.switchTo().frame("ifmFucntionLocation");
		Thread.sleep(3000);
		driver.findElement(By.id("CreatedTime")).click();
		driver.findElement(By.id("CreatedTime")).click();	
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("一個月內")).click();
		Thread.sleep(2000);
		transferNewWindow();
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("InstanceCompleteType")).click();
		driver.findElement(By.id("InstanceCompleteType")).click();
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("所有可追蹤的流程")).click();
		Thread.sleep(2000);
		transferNewWindow();
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("ProcessCategory")).click();
		driver.findElement(By.id("ProcessCategory")).click();
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("未分類")).click();
		Thread.sleep(2000);
		transferNewWindow();
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("ProcessName")).click();
		driver.findElement(By.id("ProcessName")).click();
		Thread.sleep(2000);
//		driver.findElement(By.partialLinkText("不限流程名稱")).click(); //這個需要自己insert流程指定
//		Thread.sleep(2000);
//		Select select = new Select(driver.findElement(By.id("selRecoredSizePerPage")));
//		select.selectByVisibleText("20");
		//driver.findElement(By.partialLinkText("下一頁")).click();
		//driver.findElement(By.id("btnGenerateExcel")).click(); //轉存Excel表單資料
		/*進階查詢
//		driver.findElement(By.id("btnOpenProcessQueryTask")).click();
//		driver.findElement(By.id("btnChooseProcessRequester")).click();
//		for (String winHandle : driver.getWindowHandles()) {
//		    driver.switchTo().window(winHandle); //換成新的頁面
//		}
//		driver.findElement(By.id("txtConditionValue")).sendKeys("組長");
//		driver.findElement(By.id("btnStartQuerying")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.id("Data0")).click();
//		for (String winHandle : driver.getWindowHandles()) {
//		    driver.switchTo().window(winHandle); //返回BPM畫面
//		}
//		driver.switchTo().frame("ifmFucntionLocation");
//		driver.findElement(By.id("btnExecuteQuery")).click();
//		Thread.sleep(1000);*/
  }
  @Test(priority=6)
  public void SearchFormData() throws Exception{
	  Thread.sleep(5000);
	  ChooseMenu("Program");
	  ChooseModel("SearchFormData");
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnChooseProcessPackages")).click();
		transferNewWindow();
		Thread.sleep(1000);
		List<WebElement> rad = driver.findElements(By.name("chkChosenOptions"));
		rad.get(0).click();
		driver.findElement(By.id("btnReturnValues")).click();
		transferNewWindow();
		Thread.sleep(3000);
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnCreatedTimeBegin")).click();
		List<WebElement> allDates2=driver.findElements(By.xpath("//div[@class='calendar']//tr//td"));
		for(WebElement ele:allDates2)
		{			
			String date=ele.getText();
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
		transferNewWindow();
		Thread.sleep(1000);
		List<WebElement> rad1 = driver.findElements(By.name("chkChosenOptions"));
		rad1.get(0).click();
		driver.findElement(By.id("btnReturnValues")).click();
		transferNewWindow();
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnSetProcessConditions")).click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
		driver.findElement(By.id("btnChooseFormDefinition")).click();
		transferNewWindow();
		Thread.sleep(2000);
		List<WebElement> rad2 = driver.findElements(By.className("ListBodyClass_odd"));
		rad2.get(1).click();
		transferNewWindow();
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnSearchFormData")).click();
		}
  @Test(priority=7)
  public void StaticProcessInfo() throws Exception{ //統計流程資料
	  Thread.sleep(5000);
	  	ChooseMenu("Program");
	  	ChooseModel("StaticProcessInfo");
		driver.switchTo().frame("ifmFucntionLocation");
		driver.switchTo().frame("ifmStatisticsLocation");		
		Thread.sleep(3000);
		driver.findElement(By.id("btnChooseProcessPackages")).click(); //查詢流程
		transferNewWindow();
		transferNewWindow();
		Thread.sleep(3000);
		List<WebElement> rad = driver.findElements(By.name("chkChosenOptions"));
		rad.get(0).click();
		driver.findElement(By.id("btnReturnValues")).click();
		transferNewWindow();
		driver.switchTo().frame("ifmFucntionLocation");
		driver.switchTo().frame("ifmStatisticsLocation");
		driver.findElement(By.id("btnChooseProcessRequesters")).click();//查詢發起人
		transferNewWindow();
		Thread.sleep(1000);
		List<WebElement> rad1 = driver.findElements(By.name("chkChosenOptions"));
		rad1.get(0).click();
		driver.findElement(By.id("btnReturnValues")).click();
		transferNewWindow();
		driver.switchTo().frame("ifmFucntionLocation");
		driver.switchTo().frame("ifmStatisticsLocation");
		Thread.sleep(2000);
		driver.findElement(By.id("btnChooseStartDate")).click();
		List<WebElement> allDates2=driver.findElements(By.xpath("//div[@class='calendar']//tr//td"));
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
		driver.findElement(By.id("btnChooseEndDate")).click();		
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
		Select select = new Select(driver.findElement(By.id("ddlOrgMemberDimension")));
		select.selectByVisibleText("人員");
		driver.findElement(By.id("btnCalculateProcessInstAmount")).click();		
		}
  @Test(priority=8)
  public void TransforEmployerJob() throws Exception{ //轉派員工的工作
	  Thread.sleep(5000);
		String winHandleBefore = driver.getWindowHandle();
		ChooseMenu("Program");
	  	ChooseModel("TransferforEmployerJob");
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnChooseUser")).click();
		transferNewWindow();
		List<WebElement> rad3 = driver.findElements(By.className("ListBodyClass_even"));
		rad3.get(0).click();			
		transferNewWindow();
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("chkLeftEmployeeWorkOID_0")).click();
		List<WebElement> rad = driver.findElements(By.className("cnnNavButton"));
		rad.get(0).click();
		transferNewWindow();
		Thread.sleep(1000);
		driver.findElement(By.id("btnChooseAcceptor")).click();//
		transferNewWindow();
		Thread.sleep(1000);
		List<WebElement> rad1 = driver.findElements(By.className("ListBodyClass_odd"));
		rad1.get(1).click();		
		transferNewWindow();
		driver.findElement(By.id("btnConfirm")).click();
		driver.switchTo().window(winHandleBefore);
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnReassign")).click();
		Thread.sleep(1000);
		transferNewWindow();
		driver.findElement(By.id("txtPassword")).sendKeys("1234");
		driver.findElement(By.id("btnConfirm")).click();
		Alert Alert = driver.switchTo().alert();
		Alert.accept();
		Alert Alert1 = driver.switchTo().alert();
		Alert1.accept();
		driver.switchTo().window(winHandleBefore);
		Alert Alert2 = driver.switchTo().alert();
		Alert2.accept();		
		}
  @Test(priority=9)
  public void RestartInvokeSystem() throws Exception{ //重啟Invoke關卡
	  Thread.sleep(5000);
	  ChooseMenu("Program");
		ChooseModel("RestartInvokeSystem");
		driver.switchTo().frame("ifmFucntionLocation");
		List<WebElement> rad1 = driver.findElements(By.name("chkActivityInstanceOID"));
		rad1.get(0).click();		
		driver.findElement(By.className("buttonFilter")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();		
		}
  @Test(priority =10)
  public void ManageItemHidden() throws Exception{ //管理欄位遮罩
	  Thread.sleep(5000);
	  ChooseMenu("Program");
		ChooseModel("ManageItemHidden");
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnCreate")).click();
		driver.findElement(By.id("txtPerDataProId")).sendKeys("123");
		driver.findElement(By.id("txtPerDataProName_DEF")).sendKeys("456");
		driver.findElement(By.id("txtMaskStartingPos")).sendKeys("2");
		driver.findElement(By.id("txtMaskSymbol")).sendKeys("*");
		driver.findElement(By.id("btnSave")).click();
		Alert Alert1 = driver.switchTo().alert();
		Alert1.accept();
		driver.findElement(By.id("TD_1_1")).click();
		driver.findElement(By.id("btnEdit")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btnSave")).click();
		Alert Alert2 = driver.switchTo().alert();
		Alert2.accept();
		driver.findElement(By.id("TD_1_1")).click();
		driver.findElement(By.id("btnDelete")).click();
		Alert Alert = driver.switchTo().alert();
		Alert.accept();
		Alert Alert3 = driver.switchTo().alert();
		Alert3.accept();
		}
  @Test(priority =11)
  public void InstallPasswordSignup() throws Exception{ //安裝密碼註冊
	  Thread.sleep(5000);
	  ChooseMenu("Program");
		ChooseModel("InstallPasswordSignup");
		Thread.sleep(1000);
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("txtSerNo")).sendKeys("35d3-13oi-1101-0020");//自行調整
		driver.findElement(By.id("txtPassword")).sendKeys("bc37-329a-3c52-49c8-a2b9-99ff");//自行調整
		driver.findElement(By.id("btnRegister")).click();
		Alert Alert = driver.switchTo().alert();
		Alert.accept();
		driver.findElement(By.id("TD_1_2")).click();
		driver.findElement(By.id("btnUnRegister")).click();
		Alert ConfirmAlert = driver.switchTo().alert();
		ConfirmAlert.accept();
		}
  @Test(priority=13)
  public void StartProcessTestMode() throws Exception{ //啟動流程測試程式
	  Thread.sleep(5000);
	  ChooseMenu("Program");
		ChooseModel("StartProcessTestMode");
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("chkFireValidationMode")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("btnChooseUser")).click();
		transferNewWindow();
		List<WebElement> rad1 = driver.findElements(By.className("ListBodyClass_odd"));
		rad1.get(2).click();		
		transferNewWindow();
		Thread.sleep(1000);
		driver.switchTo().frame("ifmFucntionLocation"); //換回系統管理員
		driver.findElement(By.id("chkFireValidationMode")).click();
		}
  @Test(priority =14)
  public void CreateWorkProcessPrint() throws Exception{ //建立作業程序書
	  Thread.sleep(5000);
	  String winHandleBefore = driver.getWindowHandle();
	  ChooseMenu("Program");
		ChooseModel("CreateWorkProcessPrint");
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnSearch")).click(); //查詢流程定義
		transferNewWindow();
		Thread.sleep(1000);
		List<WebElement> rad1 = driver.findElements(By.className("ListBodyClass_odd"));
		rad1.get(2).click();	
		transferNewWindow();
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("txtCompanyName")).sendKeys("BPM");
		driver.findElement(By.id("txtInstituteOrgUnit")).sendKeys("123");
		driver.findElement(By.id("txaDocumentTarget")).sendKeys("456");
		driver.findElement(By.id("txaAppliedScope")).sendKeys("789");
		driver.findElement(By.id("btnCreate")).click();
		Alert Alert = driver.switchTo().alert();
		Alert.accept();
		driver.switchTo().window(winHandleBefore);
		}
  	@Test(priority=12)
  	public void SystemSchedule() throws Exception{ //系統排程
  		Thread.sleep(5000);
  		ChooseMenu("Program");
		ChooseModel("SystemSchedule");
		JavascriptExecutor ScrollUp = (JavascriptExecutor)driver;
		ScrollUp.executeScript("scroll(0,0)");
		driver.switchTo().frame("ifmFucntionLocation");
		Thread.sleep(1000);
		driver.findElement(By.id("addSchedule")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("description")).sendKeys("123");
		driver.findElement(By.id("parameters")).sendKeys("456");
		driver.findElement(By.xpath("//input[@value='下一步']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@onclick='triggerNext()']")).click();
		driver.findElement(By.id("interval")).sendKeys("60000");
		driver.findElement(By.xpath("//*[@id='mainDiv']/div[3]/fieldset/table[2]/tbody/tr/td[2]/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='DealOvertimeActivityHandler']")).click();
		driver.findElement(By.id("btnEditSchedule")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("description")).sendKeys("1");
		driver.findElement(By.id("parameters")).sendKeys("4");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='下一步']")).click();		
		driver.findElement(By.xpath("//input[@onclick='triggerNext()']")).click();
		driver.findElement(By.id("interval")).sendKeys("70");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='mainDiv']/div[4]/fieldset/table[2]/tbody/tr/td[2]/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='DealOvertimeActivityHandler']")).click();
		driver.findElement(By.xpath("//input[@value='刪除']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		}
  @BeforeClass
  public void Explorer() {
      driver.get("http://10.20.9.26:8106/NaNaWeb");
  }
  @AfterClass
  public void logout() throws Exception {
//	  Thread.sleep(5000);
//	 driver.findElement(By.xpath("//a[contains(@href,'javaScript:logout()')]")).click();
//		Alert Logoutalert = driver.switchTo().alert();
//		Logoutalert.accept();
  }
  public void transferNewWindow(){
	  for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); //返回BPM畫面
		}
  }
  public void ChooseMenu(String Function) throws Exception{
		 Thread.sleep(5000);
		 for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
		 if(Function=="GetProfileMenu"){
			 driver.findElement(By.xpath("//a[contains(@href,'javascript:getProfileMenu()')]")).click();
		}else if(Function=="Bigger"){
			driver.findElement(By.xpath("//a[contains(@href,'javaScript:toggleNavigatorMenu()')]")).click(); //V6
			 //driver.findElement(By.xpath("//a[contains(@href,'javaScript:displayNavigatorMenu()')]")).click(); //V5
			driver.findElement(By.id("sideBarImage")).click();
		}else{
			System.out.println("SystemManage");
		}
		 for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
		driver.switchTo().frame("ifmNavigator");		 
		if(Function =="Program"){
			driver.findElement(By.xpath("//p[contains(@onclick,'gotoSystemManage()')]")).click();//系統管理工具
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
		case "SearchFormData":
			funcName = "查詢表單資料";
			break;
		case "StaticProcessInfo":
			funcName = "統計流程資訊";
			break;
		case "TransferforEmployerJob":
			funcName = "轉派員工的工作";
			break;
		case "RestartInvokeSystem":
			funcName = "批次重新啟動已暫停Invoke活動";
			break;
		case "ManageItemHidden":
			funcName = "管理欄位遮罩";
			break;
		case "InstallPasswordSignup":
			funcName = "安裝密碼註冊";
			break;
		case "SystemSchedule":
			funcName = "系統排程";
			break;
		case "StartProcessTestMode":
			funcName = "啟動流程測試模式";
			break;
		case "CreateWorkProcessPrint":
			funcName = "建立作業程序書";
			break;
		default:
			funcName = "";
		}
		driver.findElement(By.partialLinkText(funcName)).click();
		Thread.sleep(3000);
	 }

}
