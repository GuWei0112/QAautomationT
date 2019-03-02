package Administrator;

import java.io.File;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ProSystemTest {
	WebDriver driver ;
	@BeforeSuite
	  public void beforeSuite() {
		  driver = new FirefoxDriver();
//			 System.setProperty("webdriver.chrome.driver", "D://eclipse_BPM_develop/WorkSpace/TEST/chromedriver.exe");
//		        driver = new ChromeDriver();
//				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
//		       capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//		        System.setProperty("webdriver.ie.driver", "D://Gu/自動測試工具/selenium/Eclipse/workspace/Selenium/IEDriverServer.exe");
//		        capabilities.setCapability("ignoreZoomSetting", true);
//		        driver = new InternetExplorerDriver(capabilities);
	  }
	@BeforeClass
	  public void beforeClass() {
		  driver.get("http://127.0.0.1:8086/NaNaWeb"); //URL BPM
	  }
  @Test(priority=1)
  public void login() { //登入
	  driver.manage().window().maximize();
	  	transferNewWindow();
		Select select = new Select(driver.findElement(By.id("ddlLanguage"))); //切換語系
		select.selectByVisibleText("繁體中文");
		driver.findElement(By.id("txtUserId")).sendKeys("administrator"); //帳號
		driver.findElement(By.id("txtPassword")).sendKeys("1234");//密碼
		WebElement webElement = driver.findElement(By.id("txtPassword"));//密碼打完執行Enter
		webElement.sendKeys(Keys.ENTER);		
  }
  @Test(priority=2)
  public void Process () throws Exception{ //啟動流程測試模式
	  Thread.sleep(5000);
	  ChooseMenu("Program");
	  ChooseModel("StartProcessTestMode");
		Thread.sleep(3000);
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("chkFireValidationMode")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("btnChooseUser")).click();
		transferNewWindow();
		Thread.sleep(2000);
		List<WebElement> rad1 = driver.findElements(By.className("ListBodyClass_odd"));
		rad1.get(2).click();		
  }
  @Test(priority=3)
  public void SingleSetting() throws Exception{ //單一操作
	  InvokeProcess(); //發起流程
	  GetBackEndProcess(); //派至下一關
//	  CancelDirect(); 	 //直接退回
	  TakeProcessRestart(); //取回重辦
	  SingleChooseTheFunctionProcessDirect(); //流程結案	  
  }
//  @Test(priority=3)
//  public void MultipleSetting1() throws Exception{ //複合操作 退回 -> 取回
//	  InvokeProcess(); //發起流程
//	  GetBackEndProcess(); //派至下一關
//	  CancelDirect(); 	 //直接退回	  
//	  TakeProcessRestart(); //取回重辦
//	  ChooseTheFunctionProcessDirect(); //流程結案
//  }
//  @Test(priority=3)
  public void MultipleSetting2() throws Exception{ //複合操作 退回 -> 退回
	  InvokeProcess();
	  String BPM = driver.getWindowHandle();
	  GetBackEndProcess();
	  CancelEach();
	  driver.switchTo().window(BPM);
	  CancelEach();
	  //ChooseTheFunctionProcessDirect();
	  //ChooseTheFunctionCancel();
	  ChooseTheFunctionStop();
  }
  public void InvokeProcess() throws Exception{ //發起流程
	  Thread.sleep(3000);
	  ChooseMenu("InvokeProcess");
		transferNewWindow();		
		driver.switchTo().frame("ifmFucntionLocation");
		String Before  =  driver.getWindowHandle();
		Thread.sleep(1000);
		Select select1 = new Select(driver.findElement(By.id("ddlProcessCategory")));
		select1.selectByVisibleText("未分類");
		Thread.sleep(2000);
		List<WebElement> rad2 = driver.findElements(By.className("a7"));
		rad2.get(10).click();
		Thread.sleep(2000);
		driver.findElement(By.id("txtSubject")).sendKeys("test");
		driver.switchTo().frame("ifmAppLocation");
		driver.findElement(By.id("Textbox3")).sendKeys("123");
		driver.findElement(By.id("Textbox4")).sendKeys("456");
		driver.findElement(By.id("Button12")).click();
		driver.findElement(By.id("RadioButton27_1")).click();
		Thread.sleep(2000);
		transferNewWindow();
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnInvokeProcess")).click();		
		  driver.switchTo().window(Before);
  }
  public void GetBackEndProcess() throws Exception{ //派至下一關
	  Thread.sleep(5000);
	  String before  =  driver.getWindowHandle();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//a[contains(@href,'javascript:getToDoList(2)')]")).click();
	  Thread.sleep(2000);
	  List<WebElement> rad = driver.findElements(By.xpath("//td/a[contains(text(),'無核決權限')]"));
		rad.get(0).click();
		driver.findElement(By.id("Topwhite")).click();
		driver.switchTo().frame("ifmFucntionLocation");
		Thread.sleep(3000);
		transferNewWindow();
		driver.findElement(By.name("rdoWorkAssigneeOID")).click();
		driver.switchTo().window(before);
		Thread.sleep(1000);
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.xpath("//*[@id='Detail']/tbody/tr[2]/td[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("btnDispatchWorkItem")).click();
		Thread.sleep(2000);
		driver.switchTo().window(before);
  }  
  public void CancelDirect() throws Exception{//退回重辦(直接)
	  Thread.sleep(5000);
	  String before  =  driver.getWindowHandle();
	  Thread.sleep(3000);
	 driver.findElement(By.xpath("//a[contains(@href,'javascript:getToDoList(2)')]")).click();
	  driver.switchTo().window(before);	  
	  Thread.sleep(2000);
	  List<WebElement> rad = driver.findElements(By.xpath("//td/a[contains(text(),'無核決權限')]"));
		rad.get(0).click();
		driver.findElement(By.id("Topwhite")).click();
		Thread.sleep(2000);
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnReexecuteActivity")).click();		
		transferNewWindow();
		List<WebElement> rad1 = driver.findElements(By.name("rdoActivityInstOID"));
		rad1.get(0).click();
		driver.findElement(By.id("btnRexecute")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	  Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		driver.switchTo().window(before);
		driver.findElement(By.xpath("//a[contains(@href,'javascript:getToDoList(2)')]")).click();
		Thread.sleep(2000);
		  List<WebElement> rad2 = driver.findElements(By.xpath("//td/a[contains(text(),'無核決權限')]"));
			rad2.get(0).click();
			driver.findElement(By.id("Topwhite")).click();
			driver.switchTo().frame("ifmFucntionLocation");
  }  
  public void CancelEach() throws Exception{//退回重辦(逐關)
	  Thread.sleep(5000);
	  String before  =  driver.getWindowHandle();
	  driver.switchTo().window(before);
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//a[contains(@href,'javascript:getToDoList(2)')]")).click();
	  Thread.sleep(2000);
	  List<WebElement> rad = driver.findElements(By.xpath("//td/a[contains(text(),'無核決權限')]"));
		rad.get(0).click();
		driver.findElement(By.id("Topwhite")).click();
		Thread.sleep(2000);
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnReexecuteActivity")).click();
		transferNewWindow();
		List<WebElement> rad1 = driver.findElements(By.name("rdoActivityInstOID"));
		rad1.get(0).click();
		driver.findElement(By.id("rdoReexecuteType0")).click();
		driver.findElement(By.id("btnRexecute")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		driver.switchTo().window(before);
		  driver.findElement(By.xpath("//a[contains(@href,'javascript:getToDoList(2)')]")).click();
		  Thread.sleep(3000);
		  List<WebElement> rad2 = driver.findElements(By.xpath("//td/a[contains(text(),'無核決權限')]"));
			rad2.get(0).click();
			driver.findElement(By.id("Topwhite")).click();
			driver.switchTo().frame("ifmFucntionLocation");
			Thread.sleep(3000);
			}
  public void transferNewWindow(){
	  for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); //返回BPM畫面
		}
  }
  public void  ChooseTheFunctionProcessEach() throws Exception{ //流程結案	  
	  	String test  = driver.getWindowHandle();
	  	transferNewWindow();
		String Job = driver.getWindowHandle();
		Thread.sleep(1000);
		driver.findElement(By.name("rdoWorkAssigneeOID")).click();
		driver.switchTo().window(test);
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.xpath("//*[@id='Detail']/tbody/tr[2]/td[2]")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("btnDispatchWorkItem")).click();
		Thread.sleep(2000);
		driver.switchTo().window(Job);
		driver.findElement(By.name("rdoWorkAssigneeOID")).click();
		driver.switchTo().window(test);
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.xpath("//*[@id='Detail']/tbody/tr[2]/td[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btnDispatchWorkItem")).click();
		Thread.sleep(2000);
		driver.switchTo().window(Job);
		Thread.sleep(2000);
		driver.findElement(By.name("rdoWorkAssigneeOID")).click();
		driver.switchTo().window(test);
		driver.switchTo().frame("ifmFucntionLocation");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='Detail']/tbody/tr[2]/td[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btnDispatchWorkItem")).click();
		Thread.sleep(5000);
}
  public void  ChooseTheFunctionProcessDirect() throws Exception{ //流程結案	  
	  	String before  = driver.getWindowHandle();
	  	transferNewWindow();
		String Job = driver.getWindowHandle();
		Thread.sleep(1000);
		driver.findElement(By.name("rdoWorkAssigneeOID")).click();
		driver.switchTo().window(before);
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.xpath("//*[@id='Detail']/tbody/tr[2]/td[2]")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("btnDispatchWorkItem")).click();
		Thread.sleep(2000);
		driver.switchTo().window(Job);
		driver.findElement(By.name("rdoWorkAssigneeOID")).click();
		driver.switchTo().window(before);
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.xpath("//*[@id='Detail']/tbody/tr[2]/td[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btnDispatchWorkItem")).click();
		Thread.sleep(2000);
		driver.switchTo().window(Job);
		Thread.sleep(2000);
		driver.findElement(By.name("rdoWorkAssigneeOID")).click();
		driver.switchTo().window(before);
		driver.switchTo().frame("ifmFucntionLocation");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='Detail']/tbody/tr[2]/td[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btnDispatchWorkItem")).click();
		Thread.sleep(5000);
}
  public void  SingleChooseTheFunctionProcessDirect() throws Exception{ //流程結案	  
	  	String before  = driver.getWindowHandle();
	  	transferNewWindow();
		String Job = driver.getWindowHandle();
		Thread.sleep(1000);
		driver.findElement(By.name("rdoWorkAssigneeOID")).click();
		driver.switchTo().window(before);
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.xpath("//*[@id='Detail']/tbody/tr[2]/td[2]")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("btnDispatchWorkItem")).click();
		Thread.sleep(2000);
		driver.switchTo().window(Job);
		driver.findElement(By.name("rdoWorkAssigneeOID")).click();
		driver.switchTo().window(before);
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.xpath("//*[@id='Detail']/tbody/tr[2]/td[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btnDispatchWorkItem")).click();
		Thread.sleep(2000);
}
public void  ChooseTheFunctionCancel() throws Exception{
	  String before = driver.getWindowHandle();
	  driver.switchTo().window(before); //撤銷流程
		driver.switchTo().frame("ifmNavigator");
		 driver.findElement(By.xpath("//p[contains(@onclick,'gotoProcessingRecords()')]")).click();
		  driver.switchTo().window(before);
		  driver.findElement(By.partialLinkText("撤銷流程")).click();
		  driver.switchTo().frame("ifmFucntionLocation");
		  Thread.sleep(3000);
		  driver.findElement(By.id("btnExecuteQuery")).click();
		  Thread.sleep(2000);
		  List<WebElement> rad1 = driver.findElements(By.name("chkProcessInstOID"));
			rad1.get(0).click();
			driver.findElement(By.id("txaAbortComment")).click();
			driver.findElement(By.id("txaNewExecutiveComment")).sendKeys("close");
			driver.findElement(By.className("topButtonBgImg")).click();
			driver.findElement(By.id("btnAbort")).click();
			Alert alert = driver.switchTo().alert();
			alert.accept();
			driver.switchTo().window(before);
}
public void  ChooseTheFunctionStop() throws Exception{
		String before  = driver.getWindowHandle();
		transferNewWindow();
		Thread.sleep(1000);
		driver.findElement(By.name("rdoWorkAssigneeOID")).click();
		driver.switchTo().window(before);
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.xpath("//*[@id='Detail']/tbody/tr[2]/td[2]")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("txaExecutiveComment")).click();//終止流程
		Thread.sleep(1000);
		driver.findElement(By.id("txaNewExecutiveComment")).sendKeys("fail");
		driver.findElement(By.className("text11")).click();
		driver.findElement(By.id("btnTerminateProcess")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();		
}
  public void ChooseMenu(String Function) throws Exception{
		 Thread.sleep(5000);
		 transferNewWindow();
		 if(Function=="GetProfileMenu"){
			 driver.findElement(By.xpath("//a[contains(@href,'javascript:getProfileMenu()')]")).click();
		}else if(Function=="Bigger"){
			driver.findElement(By.xpath("//a[contains(@href,'javaScript:toggleNavigatorMenu()')]")).click(); //V6
			 //driver.findElement(By.xpath("//a[contains(@href,'javaScript:displayNavigatorMenu()')]")).click(); //V5
			driver.findElement(By.id("sideBarImage")).click();
		}else if(Function =="ProcessList"){
			driver.findElement(By.xpath("//a[contains(@href,'javascript:getToDoList(2)')]")).click();
		}
		  transferNewWindow();
		driver.switchTo().frame("ifmNavigator");		 
		if(Function =="Program"){
			driver.findElement(By.xpath("//p[contains(@onclick,'gotoSystemManage()')]")).click();//系統管理工具
		}else if(Function =="UserRecord"){
			driver.findElement(By.xpath("//p[contains(@onclick,'gotoProcessingRecords()')]")).click();
		}else if(Function =="InvokeProcess"){
			driver.findElement(By.xpath("//*[@id='CenterleftOuter']/div[1]/p")).click();
		}
	 }
	 public  void ChooseModel(String Function) throws Exception{
		 Thread.sleep(1000);		
		String funcName = null;
		transferNewWindow();
		switch (Function) {		
		case "StartProcessTestMode":
			funcName = "啟動流程測試模式";
			break;
		case "GetJobRestart":
			funcName = "取回工作重辦";
			break;
		default:
			funcName = "";
		}
		driver.findElement(By.partialLinkText(funcName)).click();
		Thread.sleep(3000);
	 }
	 public void TakeProcessRestart() throws Exception{ //取回工作重辦
		  Thread.sleep(5000);
		  String Before  =  driver.getWindowHandle();
		  driver.switchTo().window(Before);
		  driver.switchTo().frame("ifmNavigator");
		  driver.findElement(By.xpath("//p[contains(@onclick,'gotoProcessingRecords()')]")).click();
		  String New = driver.getWindowHandle();
		  driver.switchTo().window(New);
		  System.out.println("456");
		  Thread.sleep(3000);	    
		  driver.findElement(By.partialLinkText("取回工作重辦")).click();
		  driver.switchTo().window(Before);
		  driver.switchTo().frame("ifmFucntionLocation");
		  Thread.sleep(3000);
		  driver.findElement(By.id("btnExecuteQuery")).click();
		  Thread.sleep(3000);
		  List<WebElement> rad = driver.findElements(By.name("rdoDoneWorkItemOID"));
			rad.get(0).click();
			driver.findElement(By.id("btnRollback")).click();
			Alert alert = driver.switchTo().alert();
			alert.accept();	
	  }
}