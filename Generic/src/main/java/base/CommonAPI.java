package base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import reporting.ExtentManager;
import reporting.ExtentTestManager;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonAPI {
    //ExtentReport
    public static ExtentReports extent;
    @BeforeSuite
    public void extentSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }
    @BeforeMethod
    public void startExtent(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName().toLowerCase();
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().assignCategory(className);
    }
    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }
    @AfterMethod
    public void afterEachTestMethod(ITestResult result) {
        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));

        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }

        if (result.getStatus() == 1) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
        } else if (result.getStatus() == 2) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, getStackTrace(result.getThrowable()));
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
        }
        ExtentTestManager.endTest();
        extent.flush();
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(driver, result.getName());
        }
        driver.quit();
    }
    @AfterSuite
    public void generateReport() {
        extent.close();
    }
    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    public static WebDriver driver = null;
    // update your saucelabs/browserstack credentials
    private String saucelabs_username = "username";
    private String browserstack_username = "username";
    private String saucelabs_accesskey = "ssh_key";
    private String browserstack_accesskey = "ssh_key";

    @Parameters({"useCloudEnv","cloudEnvName","os","os_version","browserName","browserVersion","url"})
    @BeforeMethod
    public void setUp(@Optional("false") boolean useCloudEnv, @Optional("false")String cloudEnvName,
                      @Optional("OS X") String os, @Optional("10") String os_version, @Optional("chrome") String browserName, @Optional("34")
                              String browserVersion, @Optional("http://www.amazon.com") String url)throws IOException {
        if(useCloudEnv==true){
            if(cloudEnvName.equalsIgnoreCase("browserstack")) {
                getCloudDriver(cloudEnvName,browserstack_username,browserstack_accesskey,os,os_version, browserName, browserVersion);
            }else if (cloudEnvName.equalsIgnoreCase("saucelabs")){
                getCloudDriver(cloudEnvName,saucelabs_username, saucelabs_accesskey,os,os_version, browserName, browserVersion);
            }
        }else{
            getLocalDriver(os, browserName);
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
    }
    public WebDriver getLocalDriver(@Optional("mac") String OS, String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            if(OS.equalsIgnoreCase("OS X")){
                System.setProperty("webdriver.chrome.driver", "../Generic/driver/chromedriver");
            }else if(OS.equalsIgnoreCase("Windows")){
                System.setProperty("webdriver.chrome.driver", "../Generic/driver/chromedriver.exe");
            }
            driver = new ChromeDriver();
        }else if(browserName.equalsIgnoreCase("firefox")){
            if(OS.equalsIgnoreCase("OS X")){
                System.setProperty("webdriver.gecko.driver", "../Generic/driver/geckodriver");
            }else if(OS.equalsIgnoreCase("Windows")) {
                System.setProperty("webdriver.gecko.driver", "../Generic/driver/geckodriver.exe");
            }
            driver = new FirefoxDriver();
        } else if(browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "../Generic/driver/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        return driver;
    }
    public WebDriver getCloudDriver(String envName,String envUsername, String envAccessKey,String os, String os_version,String browserName,
                                    String browserVersion)throws IOException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("browser",browserName);
        cap.setCapability("browser_version",browserVersion);
        cap.setCapability("os", os);
        cap.setCapability("os_version", os_version);
        if(envName.equalsIgnoreCase("Saucelabs")){
            driver = new RemoteWebDriver(new URL("http://"+envUsername+":"+envAccessKey+
                    "@ondemand.saucelabs.com:80/wd/hub"), cap);
        }else if(envName.equalsIgnoreCase("Browserstack")) {
            cap.setCapability("resolution", "1024x768");
            driver = new RemoteWebDriver(new URL("http://" + envUsername + ":" + envAccessKey +
                    "@hub-cloud.browserstack.com/wd/hub"), cap);
        }
        return driver;
    }
    @AfterMethod
    public static void cleanUp(){
        driver.quit();
    }
    // handling click by locators
    public void clickById(String locator) { driver.findElement(By.id(locator)).click(); }
    public void clickByName(String locator) { driver.findElement(By.name(locator)).click(); }
    public void clickByClassName(String locator) { driver.findElement(By.className(locator)).click(); }
    public void clickByTagName(String locator) { driver.findElement(By.tagName(locator)).click(); }
    public void clickByLinkText(String locator) { driver.findElement(By.linkText(locator)).click(); }
    public void clickByPartialLinkText(String locator) { driver.findElement(By.partialLinkText(locator)).click(); }
    public void clickByCss(String locator) { driver.findElement(By.cssSelector(locator)).click(); }
    public void clickByXpath(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }
    // handling sendKeys by locators
    public void typeById(String locator, String value) {
        driver.findElement(By.id(locator)).sendKeys(value);
    }
    public void typeByName(String locator, String value) { driver.findElement(By.name(locator)).sendKeys(value); }
    public void typeByClassName(String locator, String value) { driver.findElement(By.className(locator)).sendKeys(value); }
    public void typeByTagName(String locator, String value) { driver.findElement(By.tagName(locator)).sendKeys(value); }
    public void typeByLinkText(String locator, String value) { driver.findElement(By.linkText(locator)).sendKeys(value); }
    public void typeByPartialLinkText(String locator, String value) { driver.findElement(By.partialLinkText(locator)).sendKeys(value); }
    public void typeByCss(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }
    public void typeByXpath(String locator, String value) {
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }
    // handling sendKeys by locators with enter
    public void typeByIdNEnter(String locator, String value) { driver.findElement(By.id(locator)).sendKeys(value, Keys.ENTER); }
    public void typeByNameNEnter(String locator, String value) { driver.findElement(By.name(locator)).sendKeys(value, Keys.ENTER); }
    public void typeByClassNameNEnter(String locator, String value) { driver.findElement(By.className(locator)).sendKeys(value, Keys.ENTER); }
    public void typeByTagNameNEnter(String locator, String value) { driver.findElement(By.tagName(locator)).sendKeys(value, Keys.ENTER); }
    public void typeByLinkTextNEnter(String locator, String value) { driver.findElement(By.linkText(locator)).sendKeys(value, Keys.ENTER); }
    public void typeByPartialLinkTextNEnter(String locator, String value) { driver.findElement(By.partialLinkText(locator)).sendKeys(value, Keys.ENTER); }
    public void typeByCssNEnter(String locator, String value) { driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER); }
    public void typeByXpathNEnter(String locator, String value) { driver.findElement(By.xpath(locator)).sendKeys(value, Keys.ENTER); }
    // handling enter keys by locators
    public void takeEnterKeysById(String locator) {
        driver.findElement(By.id(locator)).sendKeys(Keys.ENTER);
    }
    public void takeEnterKeysByName(String locator) { driver.findElement(By.name(locator)).sendKeys(Keys.ENTER); }
    public void takeEnterKeysByClassName(String locator) { driver.findElement(By.className(locator)).sendKeys(Keys.ENTER); }
    public void takeEnterKeysByTagName(String locator) { driver.findElement(By.tagName(locator)).sendKeys(Keys.ENTER); }
    public void takeEnterKeysByLinkText(String locator) { driver.findElement(By.linkText(locator)).sendKeys(Keys.ENTER); }
    public void takeEnterKeysByPartialLinkText(String locator) { driver.findElement(By.partialLinkText(locator)).sendKeys(Keys.ENTER); }
    public void takeEnterKeysByCss(String locator) {
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }
    public void takeEnterKeysByXpath(String locator) { driver.findElement(By.xpath(locator)).sendKeys(Keys.ENTER); }
    // handing clear input by locators
    public void clearInputFieldById(String locator){
        driver.findElement(By.id(locator)).clear();
    }
    public void clearInputFieldByName(String locator){
        driver.findElement(By.name(locator)).clear();
    }
    public void clearInputFieldByClassName(String locator){
        driver.findElement(By.className(locator)).clear();
    }
    public void clearInputFieldByTagName(String locator){
        driver.findElement(By.tagName(locator)).clear();
    }
    public void clearInputFieldByLinkText(String locator){
        driver.findElement(By.linkText(locator)).clear();
    }
    public void clearInputFieldByPartialLinkText(String locator){ driver.findElement(By.partialLinkText(locator)).clear(); }
    public void clearInputFieldByCss(String locator){
        driver.findElement(By.cssSelector(locator)).clear();
    }
    public void clearInputFieldByXpath(String locator){
        driver.findElement(By.xpath(locator)).clear();
    }

    // getting text from web elements by locators
    public List<String> getTextFromWebElementsById(String locator){
        List<WebElement> element = new ArrayList<WebElement>();
        List<String> text = new ArrayList<String>();
        element = driver.findElements(By.id(locator));
        for(WebElement web:element){
            text.add(web.getText());
        }
        return text;
    }
    public List<String> getTextFromWebElementsByName(String locator){
        List<WebElement> element = new ArrayList<WebElement>();
        List<String> text = new ArrayList<String>();
        element = driver.findElements(By.name(locator));
        for(WebElement web:element){
            text.add(web.getText());
        }
        return text;
    }
    public List<String> getTextFromWebElementsByClassName(String locator){
        List<WebElement> element = new ArrayList<WebElement>();
        List<String> text = new ArrayList<String>();
        element = driver.findElements(By.className(locator));
        for(WebElement web:element){
            text.add(web.getText());
        }
        return text;
    }
    public List<String> getTextFromWebElementsByTagName(String locator){
        List<WebElement> element = new ArrayList<WebElement>();
        List<String> text = new ArrayList<String>();
        element = driver.findElements(By.tagName(locator));
        for(WebElement web:element){
            text.add(web.getText());
        }
        return text;
    }
    public List<String> getTextFromWebElementsByLinkText(String locator){
        List<WebElement> element = new ArrayList<WebElement>();
        List<String> text = new ArrayList<String>();
        element = driver.findElements(By.linkText(locator));
        for(WebElement web:element){
            text.add(web.getText());
        }
        return text;
    }
    public List<String> getTextFromWebElementsByPartialLinkText(String locator){
        List<WebElement> element = new ArrayList<WebElement>();
        List<String> text = new ArrayList<String>();
        element = driver.findElements(By.partialLinkText(locator));
        for(WebElement web:element){
            text.add(web.getText());
        }
        return text;
    }
    public List<String> getTextFromWebElementsByCss(String locator){
        List<WebElement> element = new ArrayList<WebElement>();
        List<String> text = new ArrayList<String>();
        element = driver.findElements(By.cssSelector(locator));
        for(WebElement web:element){
            text.add(web.getText());
        }
        return text;
    }
    public List<String> getTextFromWebElementsByXpath(String locator){
        List<WebElement> element = new ArrayList<WebElement>();
        List<String> text = new ArrayList<String>();
        element = driver.findElements(By.xpath(locator));
        for(WebElement web:element){
            text.add(web.getText());
        }
        return text;
    }
    // getting list of web elements by locators
    public List<WebElement> getListOfWebElementsById(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.id(locator));
        return list;
    }
    public List<WebElement> getListOfWebElementsByName(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.name(locator));
        return list;
    }
    public List<WebElement> getListOfWebElementsByClassName(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.className(locator));
        return list;
    }
    public List<WebElement> getListOfWebElementsByTagName(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.tagName(locator));
        return list;
    }
    public List<WebElement> getListOfWebElementsByLinkText(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.linkText(locator));
        return list;
    }
    public List<WebElement> getListOfWebElementsByPartialLinkText(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.partialLinkText(locator));
        return list;
    }
    public List<WebElement> getListOfWebElementsByCss(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.cssSelector(locator));
        return list;
    }
    public List<WebElement> getListOfWebElementsByXpath(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.xpath(locator));
        return list;
    }
    public String  getCurrentPageUrl(){
        String url = driver.getCurrentUrl();
        return url;
    }
    public String getCurrentPageTitle(){
        String title = driver.getTitle();
        return title;
    }
    public void navigateBack(){
        driver.navigate().back();
    }
    public void navigateForward(){
        driver.navigate().forward();
    }
    // getting text by locators
    public String getTextById(String locator){
        String st = driver.findElement(By.id(locator)).getText();
        return st;
    }
    public String getTextByName(String locator){
        String st = driver.findElement(By.name(locator)).getText();
        return st;
    }
    public String getTextByClassName(String locator){
        String st = driver.findElement(By.className(locator)).getText();
        return st;
    }
    public String getTextByTagName(String locator){
        String st = driver.findElement(By.tagName(locator)).getText();
        return st;
    }
    public String getTextByLinkText(String locator){
        String st = driver.findElement(By.linkText(locator)).getText();
        return st;
    }
    public String getTextByPartialLinkText(String locator){
        String st = driver.findElement(By.partialLinkText(locator)).getText();
        return st;
    }
    public String getTextByCss(String locator){
        String st = driver.findElement(By.cssSelector(locator)).getText();
        return st;
    }
    public String getTextByXpath(String locator){
        String st = driver.findElement(By.xpath(locator)).getText();
        return st;
    }
    public List<String> getListOfString(List<WebElement> list) {
        List<String> items = new ArrayList<String>();
        for (WebElement element : list) {
            items.add(element.getText());
        }
        return items;
    }
    public void selectOptionByVisibleText(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }
    public void sleepFor(int sec)throws InterruptedException{
        Thread.sleep(sec * 1000);
    }
    // handling mouse hover
    public void mouseHoverById(String locator){
        try {
            WebElement element = driver.findElement(By.id(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        }catch(Exception ex){
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.id(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        }
    }
    public void mouseHoverByName(String locator){
        try {
            WebElement element = driver.findElement(By.name(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        }catch(Exception ex){
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.name(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        }
    }
    public void mouseHoverByClassName(String locator){
        try {
            WebElement element = driver.findElement(By.className(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        }catch(Exception ex){
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.className(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        }
    }
    public void mouseHoverByTagName(String locator){
        try {
            WebElement element = driver.findElement(By.tagName(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        }catch(Exception ex){
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.tagName(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        }
    }
    public void mouseHoverByLinkText(String locator){
        try {
            WebElement element = driver.findElement(By.linkText(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        }catch(Exception ex){
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.linkText(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        }
    }
    public void mouseHoverByPartialLinkText(String locator){
        try {
            WebElement element = driver.findElement(By.partialLinkText(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        }catch(Exception ex){
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.partialLinkText(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        }
    }
    public void mouseHoverByCss(String locator){
        try {
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        }catch(Exception ex){
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        }
    }
    public void mouseHoverByXpath(String locator){
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        }catch(Exception ex){
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.xpath(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        }
    }
    // handling alert
    public void okAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void cancelAlert(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    public void iframeHandle(WebElement element){
        driver.switchTo().frame(element);
    }
    public void goBackToHomeWindow(){
        driver.switchTo().defaultContent();
    }
    public void getLinks(String locator){
        driver.findElement(By.linkText(locator)).findElement(By.tagName("a")).getText();
    }
    // handling screenshot
    public static void captureScreenshot(WebDriver driver, String screenshotName){
        DateFormat df = new SimpleDateFormat("(MM.dd.yyyy-HH:mma)");
        Date date = new Date();
        df.format(date);
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(System.getProperty("user.dir")+ "/screenshots/"+screenshotName+" "+df.format(date)+".png"));
            System.out.println("Screenshot captured");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot "+e.getMessage());;
        }
    }
    public void takeScreenShot()throws IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("screenShots.png"));
    }
    // Synchronization
    public void waitUntilClickAble(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void waitUntilVisible(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitUntilSelectable(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean element = wait.until(ExpectedConditions.elementToBeSelected(locator));
    }
    public void upLoadFileByCss(String locator,String path){
        driver.findElement(By.cssSelector(locator)).sendKeys(path);
    }
    public String convertToString(String st){
        String splitString ;
        splitString = StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(st), ' ');
        return splitString;
    }
}
