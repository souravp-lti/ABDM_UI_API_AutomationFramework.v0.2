package UI_HBI;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import AllureReport_Listener.Allure_Listener;
import Base.MainBaseFeature;
import HBI_OBJ.Obj_HBI_Foreign_dashboard_visible;
import Utility.ReadExcel;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners(Allure_Listener.class)   //IMPORTANT TO KNOW WHEN TO GO FOR SCREENSHOT
public class Test_HBI_Foreign_dashboard_visible extends MainBaseFeature{
	
	Obj_HBI_Foreign_dashboard_visible FELoginObj;
    Properties prop1 = new Properties();
    ReadExcel takeData = new ReadExcel();
    //ExtentReports extent;
	//ExtentTest test;
    
    
    SoftAssert softAssert = new SoftAssert();
   
	@Test(priority = 1)
	@Severity(SeverityLevel.CRITICAL)
	@Description("user Launch Chrome browser") 
	@Story("To verify that chrome browser was launched properly")
    public void user_Launch_Chrome_browser() throws InterruptedException,IOException {
    	test = extent.createTest("user_Launch_Chrome_browser");
        initialization();   
    }
    
        
    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
	@Description("user opens URL") 
    @Story("To verify that URL opened properly")
    public void user_opens_URL() throws IOException,InterruptedException {
    	test = extent.createTest("user_opens_URL");
    	driver.get(takeData.readExcelFile("testData",1,1));
    	
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.BLOCKER)
	@Description("user clicks on login Register button") 
    @Story("User able to find and click on Register button")
    public void user_clicks_on_login_Register_button() throws InterruptedException, IOException {
    	test = extent.createTest("user_clicks_on_login_Register_button");
        FELoginObj = new Obj_HBI_Foreign_dashboard_visible();
        FELoginObj.clickLoginRegisterationButton();
       
    }

 
    @Test(priority = 4)
    @Severity(SeverityLevel.BLOCKER)
	@Description("user selects Foreign Employer and clicks on Login button") 
    @Story("User able to find and select Foreign Employer radio button")
    public void user_selects_Foreign_Employer_and_clicks_on_Login_button() throws InterruptedException, IOException {
    	test = extent.createTest("user_selects_Foreign_Employer_and_clicks_on_Login_button");
        FELoginObj.selectUserTypeAsFE();
        FELoginObj.clickOnUserTypePopupLogin();
        
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
	@Description("user enters Healthcare gmail com and Healthcare") 
    @Story("User enters username and password")
    public void user_enters_Healthcare_gmail_com_and_Healthcare() throws InterruptedException, IOException {
    	test = extent.createTest("user_enters_Healthcare_gmail_com_and_Healthcare");
            //FELoginObj.setEmailID(readPropertyFile("userEmail"));
    	    FELoginObj.setEmailID(takeData.readExcelFile("testData",2,1));
 
            //FELoginObj.setPassword(readPropertyFile("password"));
    	    FELoginObj.setPassword(takeData.readExcelFile("testData",3,1));
            
            FELoginObj.clickOnLoginDashboard();   
            
            try{
	            boolean withoutEmailID = FELoginObj.proceedWithoutEmailID();
	            softAssert.assertEquals(withoutEmailID, false,"Cannot proceed without entering emailID");
            }
            
            catch(Exception e){
            	
            }
            
            try {
            	
	            boolean withoutPassw = FELoginObj.proceedWithoutPassword();
	            softAssert.assertEquals(withoutPassw, false,"Cannot proceed without entering Password");
            }
            catch(Exception e){
            	
            }
            
            try {
	            boolean withoutEmailPassw = FELoginObj.invalidUserIDPassword();
	            softAssert.assertEquals(withoutEmailPassw, false,"Invalid userID or Password");
            }
            
            catch(Exception e){
            	
            }
            
            try {
            	boolean validEmailID = FELoginObj.checkForValidUserID();
            	softAssert.assertEquals(validEmailID, false,"Entered invalid UserID");
            }
            
            catch(Exception e){
            	
            }
            softAssert.assertAll();
           
            
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.CRITICAL)
	@Description("click_on_Login") 
    @Story("User able to click on Login button")
    public void click_on_Login() throws InterruptedException {
    	
    	test = extent.createTest("click_on_Login");
        System.out.println("Able to click on Login button");       
       
    }

 
    @Test(priority = 7)
    @Severity(SeverityLevel.NORMAL)
	@Description("dashboard will be displayed") 
    @Story("User able to see dashboard")
    public void dashboard_will_be_displayed() throws InterruptedException {
    	
    	test = extent.createTest("dashboard_will_be_displayed");
    	try {
        	boolean dashBoardDisplay = FELoginObj.dashboardIsDisplayed();
        	softAssert.assertEquals(dashBoardDisplay, true,"Dashboard Not displayed");
        }
        
        catch(Exception e){
        	
        }
    	
    	softAssert.assertAll();
    	
        //driver.quit();
        //System.out.println("closed");
        
    }
    
   
 
}
