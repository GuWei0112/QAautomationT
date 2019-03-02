package Administrator;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class SystemManagementTool {
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
	  public void URL() {
		  driver.get("http://127.0.0.1:8086/NaNaWeb"); //URL BPM		  
	  }
  @Test(priority = 1)  
  public void login() {
	  driver.manage().window().maximize();
		transferNewWindow();
		Select select = new Select(driver.findElement(By.id("ddlLanguage")));
		select.selectByVisibleText("繁體中文");
		driver.findElement(By.id("txtUserId")).sendKeys("administrator"); //帳號
		driver.findElement(By.id("txtPassword")).sendKeys("1234");//密碼
		WebElement webElement = driver.findElement(By.id("txtPassword"));//密碼打完執行Enter
		webElement.sendKeys(Keys.ENTER);
  }
  @Test(priority=2)
  public void SaveProcessMonitor() throws Exception{  //封存流程監控資訊
	  Thread.sleep(5000);
	  ChooseMenu("Program");
		ChooseModel("SaveProcessMonitor");
		 Thread.sleep(1000);
		 JavascriptExecutor ScrollUp = (JavascriptExecutor)driver;
			ScrollUp.executeScript("scroll(0,0)");
		driver.switchTo().frame("ifmFucntionLocation");		
		driver.findElement(By.id("btnAddMultiProcessPackages")).click();
		transferNewWindow();
		transferNewWindow();
		Thread.sleep(1000);
		List<WebElement> rad = driver.findElements(By.id("chkChosenOptions"));
		rad.get(0).click();
		driver.findElement(By.id("btnReturnValues")).click();
		transferNewWindow();
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnStartWrap")).click();
		Alert alert  = driver.switchTo().alert();
		alert.accept();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
  }
  @Test(priority=3)
  public void Language() throws Exception{  //版本更新
	  Thread.sleep(5000);
	  ChooseMenu("Program");
	  ChooseModel("Language");
		 Thread.sleep(1000);
		driver.switchTo().frame("ifmFucntionLocation");		
		WebElement element = driver.findElement(By.id("fileDocument"));
		element.sendKeys("D:\\Gu\\修改文件\\ResourceBundle\\BPMRsrcBundle.xls");//檔案位址自行修改
		driver.findElement(By.id("btnUpload")).click();
  }
  @Test(priority = 4)
  public void iReport()throws Exception{  //報表自定義上傳及關聯設定
	  Thread.sleep(5000);
	  transferNewWindow();
	  driver.switchTo().frame("ifmNavigator");
		driver.findElement(By.xpath("//p[contains(@onclick,'gotoSystemManage()')]")).click();//系統管理工具
		transferNewWindow();
		driver.findElement(By.partialLinkText("報表自定義上傳及關聯設定")).click();
	  ChooseMenu("Program");
	  ChooseModel("iReport");
		driver.switchTo().frame("ifmFucntionLocation");	
		driver.findElement(By.id("btnUpload")).click();
		transferNewWindow();	
		driver.findElement(By.id("txtReportConfigId")).sendKeys("iReport1");
		driver.findElement(By.id("txaReportConfigDesc")).sendKeys("Test123");
		WebElement element = driver.findElement(By.name("fileDocument"));
		element.sendKeys("D:\\Gu\\Ireport\\report1.jasper");
		driver.findElement(By.id("btnUploadDocument")).click();
		Alert alert  = driver.switchTo().alert();
		alert.accept();
		driver.findElement(By.id("btnCancel")).click();
		Thread.sleep(3000);
		transferNewWindow();
		driver.switchTo().frame("ifmFucntionLocation");
		Select select = new Select(driver.findElement(By.name("ddlReportConfig")));
		select.selectByVisibleText("iReport1");
		Select select1 = new Select(driver.findElement(By.name("ddlProcess")));
		select1.selectByVisibleText("簽呈");
		driver.findElement(By.id("btnAddReportDefinition")).click();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		Thread.sleep(1000);
		transferNewWindow();
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.name("chkReportDefinitionOID")).click();
		driver.findElement(By.id("btnDeleteReportDefinition")).click();		 
		Alert alert2 = driver.switchTo().alert();
		alert2.accept();
		Thread.sleep(1000);
		transferNewWindow();
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnChangePassword")).click();
		transferNewWindow();
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("TD_1_1")).click();
		driver.findElement(By.id("btnDelete")).click();
		Alert alert3 = driver.switchTo().alert();
		alert3.accept();
		transferNewWindow();
		JavascriptExecutor ScrollUp = (JavascriptExecutor)driver;
		ScrollUp.executeScript("scroll(0,1000)");
  }
  @Test(priority=5)
  public void ProcessModule() throws Exception{ //流程模組維護
	  JavascriptExecutor ScrollUp = (JavascriptExecutor)driver;
		ScrollUp.executeScript("scroll(0,0)");
	  Thread.sleep(5000);
	  ChooseMenu("Program");
	  ChooseModel("ProcessModule");
		driver.switchTo().frame("ifmFucntionLocation");	
		driver.findElement(By.id("btnCreateDocType")).click();
		transferNewWindow();
		driver.switchTo().frame("ifmFucntionLocation");
		Thread.sleep(1000);
		driver.findElement(By.id("txtId")).sendKeys("Test");
		driver.findElement(By.id("txtName")).sendKeys("測試1");
		Select select = new Select(driver.findElement(By.id("ddlProcessPkgName")));
		select.selectByVisibleText("未分類");
		driver.findElement(By.id("btnToRight")).click();
		driver.findElement(By.id("btnCreateDocType")).click();
		Thread.sleep(1000);
		transferNewWindow();
		driver.switchTo().frame("ifmFucntionLocation");
		Thread.sleep(2000);
		List<WebElement> rad1 = driver.findElements(By.name("rdoProgramOID"));
		rad1.get(0).click();				
		driver.findElement(By.id("btnAccessRigyt")).click();
		Thread.sleep(1000);
		Select select1 = new Select(driver.findElement(By.id("selType")));
		select1.selectByVisibleText("部門");
		driver.findElement(By.id("btnChooseTypes")).click();
		transferNewWindow();
		Thread.sleep(3000);
		List<WebElement> rad = driver.findElements(By.className("ListBodyClass_odd"));
		rad.get(0).click();	
		transferNewWindow();
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnSaveProgramAccessRight")).click();
		driver.findElement(By.id("btnModifyDocType")).click();
		transferNewWindow();
		driver.switchTo().frame("ifmFucntionLocation");
		Thread.sleep(2000);
		List<WebElement> rad2 = driver.findElements(By.name("rdoProgramOID"));
		rad2.get(0).click();	
		driver.findElement(By.id("btnModifyDocType")).click();
		Thread.sleep(1000);
		transferNewWindow();
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("txtName")).sendKeys("測試2");
		driver.findElement(By.id("btnCreateDocType")).click();
		transferNewWindow();
		driver.switchTo().frame("ifmFucntionLocation");
		List<WebElement> rad3 = driver.findElements(By.name("rdoProgramOID"));
		rad3.get(0).click();	
		driver.findElement(By.id("btnDeleteDocType")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
  	}
	 @Test(priority=6)
  public void CompanyProcessMonitor() throws Exception{ //企業流程監控
		  Thread.sleep(5000);
		  ChooseMenu("Program");
		  ChooseModel("CompanyProcessMonitor");
		  JavascriptExecutor ScrollUp = (JavascriptExecutor)driver;
			ScrollUp.executeScript("scroll(0,0)");
	driver.switchTo().frame("ifmFucntionLocation");
	driver.findElement(By.xpath("//*[@id='mainDiv']/div/ul/li[1]/div/div")).click();
	Thread.sleep(5000);
	driver.findElement(By.id("Btntime_1")).click(); //流程平均處理時間
	driver.findElement(By.id("mainDiv")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("btnAddMultiProcessPackages")).click();
	transferNewWindow();
	transferNewWindow();
	Thread.sleep(2000);
	List<WebElement> rad = driver.findElements(By.id("chkChosenOptions"));
	rad.get(0).click();
	driver.findElement(By.id("btnReturnValues")).click();
	transferNewWindow();
	driver.switchTo().frame("ifmFucntionLocation");
	driver.findElement(By.id("generateStatistic")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='mainDiv']/div/ul/li[1]/div/div")).click();		
	driver.findElement(By.id("Btntime_3")).click(); // 活動平均處理時間 
	driver.findElement(By.id("mainDiv")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("btnAddSingleProcessPackage")).click();
	transferNewWindow();
	transferNewWindow();
	Thread.sleep(2000);
	List<WebElement> rad1 = driver.findElements(By.className("ListBodyClass_odd"));
	rad1.get(0).click();
	transferNewWindow();
	driver.switchTo().frame("ifmFucntionLocation");
	driver.findElement(By.id("generateStatistic")).click();
	driver.findElement(By.xpath("//*[@id='mainDiv']/div/ul/li[1]/div/div")).click();
	driver.findElement(By.id("Btntime_4")).click(); //   活動平均實際處理時間 
	driver.findElement(By.id("mainDiv")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("btnAddSingleProcessPackage")).click();
	transferNewWindow();
	transferNewWindow();
	Thread.sleep(1000);
	List<WebElement> rad2 = driver.findElements(By.className("ListBodyClass_odd"));
	rad2.get(0).click();
	transferNewWindow();
	driver.switchTo().frame("ifmFucntionLocation");
	driver.findElement(By.id("generateStatistic")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='mainDiv']/div/ul/li[2]/div/div")).click();
	driver.findElement(By.id("Btncount_1")).click(); //  流程發起量
	driver.findElement(By.id("mainDiv")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("btnAddMultiProcessPackages")).click();
	transferNewWindow();
	transferNewWindow();
	Thread.sleep(1000);	
	List<WebElement> rad4 = driver.findElements(By.id("chkChosenOptions"));
	rad4.get(0).click();
	driver.findElement(By.id("btnReturnValues")).click();
	transferNewWindow();
	driver.switchTo().frame("ifmFucntionLocation");
	driver.findElement(By.id("generateStatistic")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='mainDiv']/div/ul/li[2]/div/div")).click();
	driver.findElement(By.id("Btncount_2")).click(); //  流程發起量
	driver.findElement(By.id("mainDiv")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("btnAddMultiProcessPackages")).click();
	transferNewWindow();
	transferNewWindow();
	Thread.sleep(1000);
	List<WebElement> rad5 = driver.findElements(By.id("chkChosenOptions"));
	rad5.get(0).click();
	driver.findElement(By.id("btnReturnValues")).click();
	transferNewWindow();
	driver.switchTo().frame("ifmFucntionLocation");
	driver.findElement(By.id("generateStatistic")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='mainDiv']/div/ul/li[2]/div/div")).click();
	driver.findElement(By.id("Btncount_3")).click(); //  流程發起量
	driver.findElement(By.id("mainDiv")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("btnAddMultiProcessPackages")).click();
	transferNewWindow();
	transferNewWindow();
	Thread.sleep(1000);
	List<WebElement> rad6 = driver.findElements(By.id("chkChosenOptions"));
	rad6.get(0).click();
	driver.findElement(By.id("btnReturnValues")).click();
	transferNewWindow();
	driver.switchTo().frame("ifmFucntionLocation");
	driver.findElement(By.id("generateStatistic")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='mainDiv']/div/ul/li[2]/div/div")).click();
	driver.findElement(By.id("Btncount_4")).click(); //  流程發起量
	driver.findElement(By.id("mainDiv")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("btnAddMultiProcessPackages")).click();
	transferNewWindow();
	transferNewWindow();
	Thread.sleep(1000);	
	List<WebElement> rad7 = driver.findElements(By.id("chkChosenOptions"));
	rad7.get(0).click();
	driver.findElement(By.id("btnReturnValues")).click();
	transferNewWindow();
	driver.switchTo().frame("ifmFucntionLocation");
	driver.findElement(By.id("generateStatistic")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='mainDiv']/div/ul/li[2]/div/div")).click();
	driver.findElement(By.id("Btncount_5")).click(); //  流程發起量
	driver.findElement(By.id("mainDiv")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("btnAddMultiProcessPackages")).click();
	transferNewWindow();
	transferNewWindow();
	Thread.sleep(1000);	
	List<WebElement> rad8 = driver.findElements(By.id("chkChosenOptions"));
	rad8.get(0).click();
	driver.findElement(By.id("btnReturnValues")).click();
	transferNewWindow();
	driver.switchTo().frame("ifmFucntionLocation");
	driver.findElement(By.id("generateStatistic")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='mainDiv']/div/ul/li[2]/div/div")).click();
	driver.findElement(By.id("Btncount_6")).click(); //  流程發起量
	driver.findElement(By.id("mainDiv")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("btnAddMultiProcessPackages")).click();
	transferNewWindow();
	transferNewWindow();
	Thread.sleep(1000);	
	List<WebElement> rad9 = driver.findElements(By.id("chkChosenOptions"));
	rad9.get(0).click();
	driver.findElement(By.id("btnReturnValues")).click();
	transferNewWindow();
	driver.switchTo().frame("ifmFucntionLocation");
	driver.findElement(By.id("generateStatistic")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='mainDiv']/div/ul/li[2]/div/div")).click();
	driver.findElement(By.id("Btncount_7")).click(); //  流程發起量
	driver.findElement(By.id("mainDiv")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("btnAddSingleProcessPackage")).click();
	transferNewWindow();
	transferNewWindow();
	Thread.sleep(2000);	
	List<WebElement> rad10 = driver.findElements(By.className("ListBodyClass_odd"));
	rad10.get(0).click();
	transferNewWindow();
	driver.switchTo().frame("ifmFucntionLocation");
	driver.findElement(By.id("generateStatistic")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='mainDiv']/div/ul/li[2]/div/div")).click();
	driver.findElement(By.id("Btncount_8")).click(); //  流程發起量
	driver.findElement(By.id("mainDiv")).click();
	Thread.sleep(1000);	
	driver.findElement(By.id("btnAddMultiProcessPackages")).click();
	transferNewWindow();
	transferNewWindow();
	Thread.sleep(1000);		
	List<WebElement> rad11 = driver.findElements(By.id("chkChosenOptions"));
	rad11.get(0).click();
	driver.findElement(By.id("btnReturnValues")).click();
	transferNewWindow();
	driver.switchTo().frame("ifmFucntionLocation");
	driver.findElement(By.id("generateStatistic")).click();
	driver.findElement(By.xpath("//*[@id='mainDiv']/div/ul/li[2]/div/div")).click();
	driver.findElement(By.id("Btncount_9")).click(); //  流程發起量
	driver.findElement(By.id("mainDiv")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("btnAddSingleProcessPackage")).click();
	transferNewWindow();
	transferNewWindow();
	Thread.sleep(1000);		
	List<WebElement> rad12 = driver.findElements(By.className("ListBodyClass_odd"));
	rad12.get(0).click();
	transferNewWindow();
	driver.switchTo().frame("ifmFucntionLocation");
	driver.findElement(By.id("generateStatistic")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='mainDiv']/div/ul/li[3]/div/div")).click();
	driver.findElement(By.id("Btnpath_1")).click();
	driver.findElement(By.id("mainDiv")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("btnAddSingleProcessPackage")).click();
	transferNewWindow();
	transferNewWindow();
	Thread.sleep(1000);	
	List<WebElement> rad13 = driver.findElements(By.className("ListBodyClass_odd"));
	rad13.get(0).click();
	transferNewWindow();
	driver.switchTo().frame("ifmFucntionLocation");
	driver.findElement(By.id("generateStatistic")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='mainDiv']/div/ul/li[4]/div/div")).click();
	driver.findElement(By.id("Btnmonitor_1")).click();	
	driver.findElement(By.id("mainDiv")).click();
	Thread.sleep(1000);	
	driver.findElement(By.id("btnAddMultiProcessPackages")).click();
	transferNewWindow();
	transferNewWindow();
	Thread.sleep(1000);		
	List<WebElement> rad14 = driver.findElements(By.id("chkChosenOptions"));
	rad14.get(0).click();
	driver.findElement(By.id("btnReturnValues")).click();
	transferNewWindow();
	JavascriptExecutor ScrollUp1 = (JavascriptExecutor)driver;
	driver.switchTo().frame("ifmFucntionLocation");
	driver.findElement(By.id("startMonitor")).click();
	transferNewWindow();
	Thread.sleep(1000);
	driver.switchTo().frame("ifmFucntionLocation");
	driver.findElement(By.xpath("//*[@id='mainDiv']/div/ul/li[4]/div/div")).click();
	driver.findElement(By.id("Btnmonitor_2")).click();
	driver.findElement(By.id("mainDiv")).click();
	Thread.sleep(1000);		
	driver.findElement(By.id("btnAddSingleProcessPackage")).click();
	transferNewWindow();
	transferNewWindow();
	Thread.sleep(1000);
	List<WebElement> rad15 = driver.findElements(By.className("ListBodyClass_odd"));
	rad15.get(0).click();
	transferNewWindow();
	ScrollUp1.executeScript("scroll(0,-10)");
	driver.switchTo().frame("ifmFucntionLocation");
	driver.findElement(By.id("startMonitor")).click();
	Thread.sleep(1000);
	  }
  @Test(priority=7)
  public void CreateLanguage() throws Exception{ //新增多語系
	  Thread.sleep(5000);
	  ChooseMenu("Program");
	  ChooseModel("CreateLanguage");
		JavascriptExecutor ScrollUp = (JavascriptExecutor)driver;
		ScrollUp.executeScript("scroll(0,0)");
		driver.switchTo().frame("ifmFucntionLocation");	
  Select select1 = new Select(driver.findElement(By.id("selAvailableLocale")));
	select1.selectByVisibleText("[zh_HK] 香港");
		driver.findElement(By.id("txtDisplayName")).sendKeys("香港文");
		driver.findElement(By.id("txtDesc")).sendKeys("吼嗨壓");
		driver.findElement(By.xpath("//input[@onclick='create()']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();		
  }
  @Test(priority=8)
  public void FormLanguage() throws Exception{ //表單多語系維護作業
	  Thread.sleep(5000);
	  ChooseMenu("Program");
	  ChooseModel("FormLanguage");
		JavascriptExecutor ScrollUp = (JavascriptExecutor)driver;
		ScrollUp.executeScript("scroll(0,0)");
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("formDefsTree_3_check")).click();
		driver.findElement(By.id("btnSubmit")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("btnEdit___MobileDemoForm123___Attachment")).click();//選擇表單
		driver.findElement(By.id("btnSubmit___MobileDemoForm123___Attachment")).click();//選擇表單
		driver.findElement(By.id("btnSave")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.findElement(By.id("btnBack")).click();
  }
  @Test(priority=9)
  public void SystemLanguage() throws Exception{ //系統多語系維護作業
	  Thread.sleep(5000);
	  ChooseMenu("Program");
	  ChooseModel("SystemLanguage");
		JavascriptExecutor ScrollUp = (JavascriptExecutor)driver;
		ScrollUp.executeScript("scroll(0,0)");
		driver.switchTo().frame("ifmFucntionLocation");	
		Select select = new Select(driver.findElement(By.id("selSysLanguage")));
		select.selectByVisibleText("[zh_TW] 繁體中文");
		driver.findElement(By.id("txtCondition")).sendKeys("登入");
		driver.findElement(By.id("btnQuery")).click();
		driver.findElement(By.id("btnEdit_clientside.warning.script.alert.duplicateusererror")).click();
		driver.findElement(By.id("btnSubmit_clientside.warning.script.alert.duplicateusererror")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
  }
  @Test(priority=10)
  public void ImportExportSystemLanguage() throws Exception{ //匯入匯出系統多語系
	  Thread.sleep(5000);
	  ChooseMenu("Program");
	  ChooseModel("ImportExportSystemLanguage");
		JavascriptExecutor ScrollUp = (JavascriptExecutor)driver;
		ScrollUp.executeScript("scroll(0,0)");
		driver.switchTo().frame("ifmFucntionLocation");
		Select select = new Select(driver.findElement(By.id("selTargetLang")));
		select.selectByVisibleText("[zh_TW]繁體中文");
//		driver.findElement(By.xpath("//input[@onclick='exportRsrcBundle()']")).click(); //匯出
		driver.findElement(By.id("divImportTab")).click();
		Select select1 = new Select(driver.findElement(By.id("selNewLang")));
		select1.selectByVisibleText("[zh_TW]繁體中文");
		WebElement element = driver.findElement(By.name("fileDocument"));
		element.sendKeys("D:\\Gu\\修改文件\\ResourceBundle\\BPMRsrcBundle.xls");
		driver.findElement(By.xpath("//input[@onclick='importRsrcBundle()']")).click(); //匯入		
  }
  @AfterClass
  public void afterClass() {
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
		case "SaveProcessMonitor":
			funcName = "封存流程監控資訊";
			break;
		case "Language":
			funcName = "版本更新";
			break;
		case "iReport":
			funcName = "報表自定義上傳及關聯設定";
			break;
		case "ProcessModule":
			funcName = "流程模組維護";
			break;
		case "CompanyProcessMonitor":
			funcName = "企業流程監控";
			break;
		case "CreateLanguage":
			funcName = "新增多語系";
			break;
		case "FormLanguage":
			funcName = "表單多語系維護作業";
			break;
		case "SystemLanguage":
			funcName = "系統多語系維護作業";
			break;
		case "ImportExportSystemLanguage":
			funcName = "匯入匯出系統多語系";
			break;
		default:
			funcName = "";
		}
		driver.findElement(By.partialLinkText(funcName)).click();
		Thread.sleep(3000);
	 }

}
