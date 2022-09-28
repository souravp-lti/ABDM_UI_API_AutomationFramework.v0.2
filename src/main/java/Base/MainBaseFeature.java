package Base;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

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
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


//import Utility.ScreenShot;
import Utility.ScreenShot;



public class MainBaseFeature{
	
	public  static WebDriver driver;
    Properties prop = new Properties();
    
    //-----------------------TAKING VALUE FROM CONFIG FILE-----------------------------------//
    public String readPropertyFile(String value) throws IOException
    {
    	prop.load(new FileInputStream("config.properties"));
        return prop.getProperty(value);
    }
   //-----------------------TAKING VALUE FROM CONFIG FILE/-----------------------------------//
    
   //-----------------------CREATING DATE FOR EXTENT REPORT-----------------------------------//
   Date currentDate = new Date();
   final String date = currentDate.toString().replace(" ", "-").replace(":", "-");
 	
   public String extentFilePathCreate() throws IOException {
    	System.out.println("enter extentFilePathCreate()");
    	
        String extentFile = readPropertyFile("sysFileLocation")
         		+ readPropertyFile("packageName")+"\\\\EXTENT_REPORT"+"\\\\"+date+"--"+"ExtentReport.html";
        System.out.println("exit extentFilePathCreate()");
    	return extentFile;
    	
    }
  //-----------------------CREATING DATE FOR EXTENT REPORT/-----------------------------------//
    
    
  //-----------------------INITIALIZATION-----------------------------------------------------//
    public void initialization() throws IOException
    {
    	System.out.println("enter initialization()");
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
        
        System.out.println("exit initialization()");
        
    }
  //-----------------------INITIALIZATION/-----------------------------------//
    
  //-------------------------EMAIL-------------------------------------------//
    public void sendMailAttach(String toEmail, String fromEmail, String appPass) throws IOException {
    	//beforeSuit();
    	
    	System.out.println("enter sendMailAttach()");
       
    	Properties properties = System.getProperties();
    	System.out.println("PROPERTIES"+properties);
    	
    	properties.put("mail.smtp.host", readPropertyFile("hostName"));
    	properties.put("mail.smtp.port", readPropertyFile("portName"));
    	properties.put("mail.smtp.ssl.enable", readPropertyFile("sslBoolean"));
    	properties.put("mail.smtp.auth", readPropertyFile("authBoolean"));	
    	
    	Session session = Session.getInstance(properties, new Authenticator() {
    		
    		@Override
    	
    		protected PasswordAuthentication getPasswordAuthentication() {
    			
    			return new PasswordAuthentication(fromEmail, appPass);
    			
    		}
		});
    	
    
    	
    	session.setDebug(true);
    	
    	MimeMessage m =new MimeMessage(session);
    	
    	try {
    		
			m.setFrom(fromEmail);
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			m.setSubject("newTestSubject");
			
			//String path = "C:\\Users\\USER\\eclipse-workspace\\ABDM_Automation_Script.v.45\\EXTENT_REPORT\\Mon-Sep-26-12-37-54-IST-2022--ExtentReport.html";
			
			MimeMultipart mimeMultipart = new MimeMultipart();
			
			MimeBodyPart textMime = new MimeBodyPart();

			MimeBodyPart fileMime = new MimeBodyPart();
			
			try {
				textMime.setText("newTestMessage");
				
				//File file = new File("C:\\\\Users\\\\USER\\\\eclipse-workspace\\\\ABDM_Automation_Script.v.45\\\\EXTENT_REPORT\\\\Mon-Sep-26-12-37-54-IST-2022--ExtentReport.html");
				
				
				File file = new File(extentFilePathCreate());//--------------------1-//
				fileMime.attachFile(file);
				
				mimeMultipart.addBodyPart(textMime);
				mimeMultipart.addBodyPart(fileMime);
			}
			catch (Exception e){
				e.printStackTrace();
			}
			m.setContent(mimeMultipart);
			
			Transport.send(m);
			
			System.out.println("Email sent successfully");
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
    	System.out.println("exit sendMailAttach()");
    }
    
    
    //-----------------------------------EMAIL/--------------------------------------------------//
    
      
    //-------------------------------EXTENT REPORT------------------------------------------------------//
    public static ExtentSparkReporter spark;
    public static ExtentReports extent;
    public static ExtentTest test;
	
    @BeforeSuite
    public void beforeSuit() throws IOException
    {
    	System.out.println("enter beforesuite()");
        spark = new ExtentSparkReporter(extentFilePathCreate());//--------------------2-----------//
        //System.out.println(extentFile);
        extent = new ExtentReports();
        extent.attachReporter(spark);
         
        extent.setSystemInfo("OS", "Windows 11");
        extent.setSystemInfo("Host Name", "HP");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Sourav Padhi");
        System.out.println("exit beforesuite()");
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
    public void tearDown() throws  IOException
    
    {
    	System.out.println("enter aftersuite()");
    	//JavaEmailSender();
        extent.flush();
        
        //sendMailAttach("sourav.padhi94@gmail.com","sourav94padhi@gmail.com","hixqppatinhzmyrh");
        sendMailAttach(readPropertyFile("toEmailAddress"),readPropertyFile("fromEmailAddress"),readPropertyFile("appPasswordGmail"));
        
        System.out.println("exit aftersuite()");
    }
    
  //-------------------------------EXTENT REPORT/------------------------------------------------------//

}
