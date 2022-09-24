package Base;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//import Utility.ScreenShot;
import Utility.ScreenShot;

public class MainBaseFeature {
	
	public  static WebDriver driver;
    Properties prop = new Properties();
	
	
	//SoftAssert soft = new SoftAssert();
    
	
    public String readPropertyFile(String value) throws IOException
    {
        //Properties prop = new Properties();
        FileInputStream file = new FileInputStream("C:\\\\Users\\\\USER\\\\eclipse-workspace\\\\ABDM_Automation_Script.v.32"
        		+ "\\\\src\\\\main\\\\java\\\\Configuration\\\\configDetails.properties");
        prop.load(file);
        return prop.getProperty(value);
        
    }
    
   
    public void initialization() throws IOException
    {
        String browserName = readPropertyFile("browserType");
        if(browserName.equalsIgnoreCase("chrome"))
        {
        System.setProperty("webdriver.chrome.driver", readPropertyFile("sysFileLocation")+readPropertyFile("packageName")+
        		"\\\\Drivers\\\\chromedriver2.exe");
        ChromeOptions opt1 = new ChromeOptions(); 
        //opt1.addArguments("--disable-notifications"); // to disable browser exception
        //opt1.addArguments("--headless");
        opt1.addArguments("--incognito");             // to run the test in Incognito mode 
        opt1.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        opt1.addArguments("--no-sandbox"); // Bypass OS security model
        opt1.addArguments("disable-infobars"); // disabling infobars
        opt1.addArguments("--disable-extensions"); // disabling extensions
        opt1.addArguments("--disable-gpu"); // applicable to windows os only
        opt1.addArguments("--ignore-certificate-errors");
        opt1.addArguments("--disable-popup-blocking");
        opt1.addArguments("--disable-default-apps");
        opt1.addArguments("--disable-extensions-file-access-check");
        driver = new ChromeDriver(opt1);
        
        //soft.assertAll();
        }
        
        else if(browserName.equalsIgnoreCase("gecko"))
        {
        	System.out.print("gecko");
        }
        
        else
        {
        	System.out.print("invalid browser");
        }
        
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();    //To delete all browser cookies
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.get(readPropertyFile("url"));
        
    }
    
    
    //EXTENT
    public static ExtentSparkReporter spark;
    public static ExtentReports extent;
    public static ExtentTest test;
	
    @BeforeSuite
    public void beforeSuit() throws IOException
    {
    	Date currentDate = new Date();
    	String date = currentDate.toString().replace(" ", "-").replace(":", "-");
        //spark = new ExtentSparkReporter("C:\\\\Users\\\\USER\\\\eclipse-workspace\\\\ABDM_Automation_Script.v.24\\\\EXTENT_REPORT"+"\\\\ExtentReport.html");
        spark = new ExtentSparkReporter(readPropertyFile("sysFileLocation")
        		+ readPropertyFile("packageName")+"\\\\EXTENT_REPORT"+"\\\\"+date+"--"+"ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
         
        extent.setSystemInfo("OS", "Windows 11");
        extent.setSystemInfo("Host Name", "HP");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Sourav Padhi");
    }
     
    @AfterMethod
    public void getResult(ITestResult result) throws IOException
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
         
            test.fail(result.getThrowable());
            
            
            String screeshotPath = ScreenShot.failedTCSS(result.getName(),readPropertyFile("sysFileLocation")+readPropertyFile("packageName")+"\\\\ScreenShots\\\\");
            
            test.fail("FAILED TEST CASE SCREENSHOT", MediaEntityBuilder.createScreenCaptureFromPath(screeshotPath).build());
            
            
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
        	System.out.println("enter success listener");
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
            System.out.println("exit success listener");
        }
        else if(result.getStatus() == ITestResult.SKIP)
        {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
        //driver.close();
        //extent.flush();
        
    }
     
    @AfterSuite
    public void tearDown()
    
    {
    	//System.out.println("flush enter listener");
        extent.flush();
        //System.out.println("flush exit listener");
        //driver.close();
    }
	

}
