package Administrator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

class basicsetting {
	/*總關卡*/
	int allprocess = 4;
	/*發起人*/
	String starter = "0001";
	/*最後一關的人*/
	String person0 = "0005";
	/*退給誰1*/
	String person1 = "0003";
	/*退給誰2*/
	String person2 = "0001";
	String[] person = {"0001","0002","0003","0004","0005"};
}

public class advance extends basicsetting{
	WebDriver driver;
	
	
	@BeforeClass
	public void first() throws Exception {
		driver.get("http://10.20.9.26:8106/NaNaWeb");
//		driver.get("http://127.0.0.1:8086/NaNaWeb");

		driver.manage().window().maximize();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		
		login("administrator");
	}
	
	public void login(String LoginUser) throws Exception {
		/*administrator vs 一般使用者 ex:0001*/
//		String LoginUser = "administrator";
		
		/* 登入 */
		Select select = new Select(driver.findElement(By.id("ddlLanguage")));
		select.selectByVisibleText("繁體中文");
		
		/*輸入帳密*/
		if(LoginUser == "administrator"){
			driver.findElement(By.id("txtUserId")).sendKeys("administrator"); // 帳號
			driver.findElement(By.id("txtPassword")).sendKeys("1234");// 密碼
		}else{
			driver.findElement(By.id("txtUserId")).sendKeys(LoginUser); // 帳號
			driver.findElement(By.id("txtPassword")).sendKeys(LoginUser);// 密碼
		}

		WebElement webElement = driver.findElement(By.id("txtPassword"));// 密碼打完執行Enter
		webElement.sendKeys(Keys.ENTER);
	}

	@BeforeSuite
	public void initDriver() throws Exception {
		/* IE 1 */
//		System.setProperty("webdriver.ie.driver", "c:\\IEDriverServer.exe");
//		driver = new InternetExplorerDriver();
    	
		/* IE 2 */
//    	DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
//        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//        System.setProperty("webdriver.ie.driver", "c:\\IEDriverServer.exe");
//        driver = new InternetExplorerDriver(capabilities);
		
//        /*Chrome*/
//		System.setProperty("webdriver.chrome.driver", "D://eclipse_BPM_develop/WorkSpace/TEST/chromedriver.exe");
//		driver = new ChromeDriver();
		driver = new FirefoxDriver();
	}
	
	public void Nav2Fun(String function) throws InterruptedException{
		String funcName = null;
		int choice = 0;
		switch (function) {
		case "ValidateProcess":
			choice = 1;
			funcName = "啟動流程測試模式";
			break;
		case "AbortProcess":
			choice = 2;
			funcName = "撤銷流程";
			break;
		case "DealDoneWorkItem":
			choice = 2;
			funcName = "取回工作重辦";
			break;
		default:
			funcName = "";
		}
		
		Thread.sleep(1000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().frame("ifmNavigator");
		
		if(choice == 1){
			driver.findElement(By.xpath("//p[@onclick='gotoSystemManage()']")).click();
		}else if(choice == 2){
			driver.findElement(By.xpath("//p[@onclick='gotoProcessingRecords()']")).click();
		}
		
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		
		driver.findElement(By.partialLinkText(funcName)).click();
	}
	
	/*終止流程*/
	public void terminateProcess(String UserId) throws Exception{
		ValidateProcess(UserId);
		
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.findElement(By.xpath("//a[contains(@href,'javascript:getToDoList(2)')]")).click();
		
		/*第二關_選擇關卡*/
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.xpath("//td[contains(text(),'1')]")).click();
		
		Thread.sleep(2000);
		
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.close();
		
		/*終止動作_選擇片語_預設要寫入片語*/
		/*Thread.sleep(1000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnPhrase")).click();
		
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.findElement(By.xpath("//td[@class='text11']")).click();*/
		
		/*終止動作_填入簽核意見*/
		Thread.sleep(1000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().frame("ifmFucntionLocation");
		
		driver.findElement(By.id("txaExecutiveComment")).click();
		driver.findElement(By.id("txaNewExecutiveComment")).sendKeys("終止");
		
		/*終止動作*/
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnTerminateProcess")).click();
		
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.close();
	}
	
	/*繼續派送*/
	public boolean methodsuccess() throws Exception {
		/*第二關_選擇關卡*/
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.xpath("//td[contains(text(),'1')]")).click();
		
		Thread.sleep(2000);
		
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.close();
		
		/*第二關_繼續派送*/
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnDispatchWorkItem")).click();
		
		/*啟動測試模式須點選的按鈕
		 * 這會遇到派送到最後一關會有問題
		 * 解決方法如果找不到switchWorkAssignee就不要選這動作*/
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		
		boolean str = false;
		List<WebElement> element = driver.findElements(By.xpath("//input[contains(@onclick,'switchWorkAssignee')]"));
		if(element != null && element.size() > 0){
			element.get(0).click();
			Thread.sleep(2000);
			driver.close();
			return str = true;
		}else{
			driver.close();
		}
		return str;
	}
	
	/*取回重辦*/
	public void DealDoneWorkItem(String UserId) throws Exception{
		/*取回重辦_要做誰取回重辦*/
		ValidateProcess(UserId);//誰取回，要做變數
		Nav2Fun("DealDoneWorkItem");
		
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnExecuteQuery")).click();
		
		Thread.sleep(2000);
		
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElements(By.name("rdoDoneWorkItemOID")).get(0).click();
		driver.findElement(By.id("btnRollback")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		List<WebElement> element = driver.findElements(By.xpath("//input[contains(@onclick,'switchWorkAssignee')]"));
		if(element != null && element.size() > 0){
			driver.close();
		}
	}
	
	/*啟動流程測試模式*/
	public void ValidateProcess(String UserId) throws Exception{
		Nav2Fun("ValidateProcess");
		
		Thread.sleep(1000);
		driver.switchTo().frame("ifmFucntionLocation");
		
		WebElement element = driver.findElement(By.id("chkFireValidationMode"));
		if(!element.isSelected()){
			element.click();
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[contains(@onclick,'chooseUser')]")).click();
		
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		
		Select select1 = new Select(driver.findElement(By.id("ddlConditionName")));
		select1.selectByValue("userId");
		
		Select select2 = new Select(driver.findElement(By.id("ddlOperators")));
		select2.selectByValue("=");
		
		/*做成變數*/
		driver.findElement(By.id("txtConditionValue")).sendKeys(UserId);
		driver.findElement(By.id("btnStartQuerying")).click();
		driver.findElement(By.xpath("//td[contains(text(),'1')]")).click();
	}
	
	/*發起流程_發起哪張流程*/
	public void StartProcess(String ProcessName,String UserId) throws Exception{
		ValidateProcess(UserId);//誰發起流程
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().frame("ifmNavigator");
		driver.findElement(By.xpath("//p[contains(@onclick,'InvokeProcess')]")).click();
		
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().frame("ifmFucntionLocation");
		Thread.sleep(3000);
		/*可做成變數*/
//		driver.findElement(By.xpath("//td/a[contains(text(),'無核決權限')]")).click();
//		driver.findElement(By.xpath("//td/a[contains(text(),'有核決權限')]")).click();
		driver.findElement(By.xpath("//td/a[contains(text(),'"+ProcessName+"')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btnInvokeProcess")).click();
		
		/*啟動測試模式須點選的按鈕*/
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.findElement(By.xpath("//input[contains(@onclick,'switchWorkAssignee')]")).click();
		driver.close();
	}
	
	/*退回重辦_ReexecuteActivity*/
	public void ReexecuteActivity(String UserId, int choice) throws Exception{
		ValidateProcess(UserId);
		
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.findElement(By.xpath("//a[contains(@href,'javascript:getToDoList(2)')]")).click();
		
		/*第二關_選擇關卡*/
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.xpath("//td[contains(text(),'1')]")).click();
		
		Thread.sleep(2000);
		
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.close();
		
		/*簽核意見_選擇片語*/
		/*for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnPhrase")).click();
		
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.findElement(By.xpath("//td[@class='text11']")).click();*/
		
		/*簽核意見_填選方式*/
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().frame("ifmFucntionLocation");
		
		driver.findElement(By.id("txaExecutiveComment")).click();
		driver.findElement(By.id("txaNewExecutiveComment")).sendKeys("退回");
		
		/*退回動作*/
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnReexecuteActivity")).click();
		
		/*退回動作_選擇關卡*/
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		/*尚未設計num=0時，要怎麼做*/
		int num = driver.findElements(By.name("rdoActivityInstOID")).size();
		if(allprocess <= 3 || num == 1){
			driver.findElements(By.name("rdoActivityInstOID")).get(0).click();
		}else if(num > 1){
			driver.findElements(By.name("rdoActivityInstOID")).get(1).click();
		}
		
		/*退回動作_逐關(1)或直接(2)*/
		if(choice == 1){
			driver.findElement(By.id("rdoReexecuteType0")).click();
		}else if(choice == 2 ){
			driver.findElement(By.id("rdoReexecuteType1")).click();
		}
		
		/*確認*/
		Thread.sleep(1000);
		driver.findElement(By.id("btnRexecute")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		alert.accept();
		
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.close();
	}
	
	/*撤銷流程_發起人*/
	public void AbortProcess(String UserId) throws Exception{
		ValidateProcess(UserId);//發起人
		Nav2Fun("AbortProcess");
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnExecuteQuery")).click();
		
		Thread.sleep(2000);
		
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElements(By.name("chkProcessInstOID")).get(0).click();
		
		/*選擇理由_片語*/
		/*driver.findElement(By.id("btnPhrase")).click();
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.findElement(By.xpath("//td[@class='text11']")).click();*/
		
		
		/*填寫撤銷理由*/
		driver.findElement(By.id("txaAbortComment")).click();
		driver.findElement(By.id("txaNewExecutiveComment")).sendKeys("撤銷");
		
		/*撤銷*/
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().frame("ifmFucntionLocation");
		driver.findElement(By.id("btnAbort")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		List<WebElement> element = driver.findElements(By.xpath("//input[contains(@onclick,'switchWorkAssignee')]"));
		if(element != null && element.size() > 0){
			driver.close();
		}
	}
	
	/*派送至流程完成*/
	public void processcontinue(String UserId) throws Exception{
		ValidateProcess(UserId);
		
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.findElement(By.xpath("//a[contains(@href,'javascript:getToDoList(2)')]")).click();
		
		boolean str;
		do{
			str = methodsuccess();
		}while(str == true);
	}
	
	/*OnlyEnterIntoBPMIndex*/
//	@Test(priority=0)
	public void test() throws Exception{}
	
//	public void test123() throws Exception{
//		//發起流程
//		startprocess();
//		
//		/*第二,三,四關*/
//		int a=1;
//		while(a<=3){
//			//繼續派送
//			methodsuccess();
//			a++;
//		}
//		
//		//取回重辦
//		DealDoneWorkItem();
//		//退回重辦_直接(2)或逐關(1)
//		ReexecuteActivity(1);
//		//終止流程
//		terminateProcess();
//		/*撤銷流程*/
//		AbortProcess();
//		/*派送至流程完成*/
//		processcontinue();
//	}
	
	@Test(priority=1)
	public void test1() throws Exception{
		Thread.sleep(2000);
		StartProcess("無核決權限",starter);
		int a=2;
		while(a<allprocess){
			//繼續派送
			methodsuccess();
			a++;
		}
		ReexecuteActivity(person0,1);
		check();
		ReexecuteActivity(person1,1);
		processcontinue(person2);
		
		
		
//		terminateProcess("0001");
//		AbortProcess("0001");
		
	}
	public void check(){
		for(int i=0 ; i<person.length ; i++){
			if((person0 == person[i]||person1==person[i])&&i>1){
			System.out.println(person[i+1]);
			System.out.println(person0);
			System.out.println(person1);
			}
			else if((person0 == person[i]||person1==person[i])&&i>2){
				System.out.println(person[i+2]);
				System.out.println(person0);
				System.out.println(person1);
			}
			else if((person0 == person[i]||person1==person[i])&&i>3){
				System.out.println(person[i+3]);
				System.out.println(person0);
				System.out.println(person1);
			}
		}
	}
}

