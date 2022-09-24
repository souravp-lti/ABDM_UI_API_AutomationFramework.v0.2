package UI_HBI;

import java.io.IOException;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import AllureReport_Listener.Allure_Listener;
import Base.MainBaseFeature;
import HBI_OBJ.Obj_HBI_Foreign_dashboard_visible;
import HBI_OBJ.Obj_HBI_HomePage_Features_visible;
import Utility.ReadExcel;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners(Allure_Listener.class)   //IMPORTANT TO KNOW WHEN TO GO FOR SCREENSHOT
public class Test_HBI_HomePage_Features_Visible extends MainBaseFeature {

	Obj_HBI_HomePage_Features_visible homePageObj;
    Properties prop1 = new Properties();
    SoftAssert softAssert = new SoftAssert();
    ReadExcel takeData = new ReadExcel();
    
    @Test(priority = 1)
    @Severity(SeverityLevel.BLOCKER)
	@Description("user Launch Chrome") 
    @Story("To verify that chrome browser was launched properly")
    public void user_Launch_Chrome() throws InterruptedException,IOException {
    	test = extent.createTest("user_Launch_Chrome");
        initialization();    
    }
    
        
    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
	@Description("user opens the URL") 
    @Story("To verify that URL opened properly")
    public void user_opens_the_URL() throws IOException,InterruptedException {
    	test = extent.createTest("user_opens_the_URL");
    	driver.get(takeData.readExcelFile("testData",1,1));
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.TRIVIAL)
	@Description("homeButton will be displayed") 
    @Story("User able to see Home Button in the home page")
    public void homeButton_will_be_displayed() throws InterruptedException {
    	test = extent.createTest("homeButton_will_be_displayed");
    	
    	try {
        	boolean homeButtonDisplay = homePageObj.homeButtonDisplayed();
        	System.out.println();
        	softAssert.assertEquals(homeButtonDisplay, true,"Home Button Not displayed");
        }
        
        catch(Exception e){
        	
        }
    	
    	softAssert.assertAll();
        //driver.quit();
        
    }
    
    @Test(priority = 4)
    @Severity(SeverityLevel.TRIVIAL)
   	@Description("Recruiter's Directory will be displayed") 
    @Story("User able to see Recruiter's Directory in the home page")
    public void recruitersDir_will_be_displayed() throws InterruptedException {
    	test = extent.createTest("recruitersDir_will_be_displayed");
    	
    	try {
        	boolean recDirButtonDisplay = homePageObj.RecruitersDirectoryDisplayed();
        	softAssert.assertEquals(recDirButtonDisplay, true,"Recruiters directory Button Not displayed");
        }
        
        catch(Exception e){
        	
        }
    	
    	softAssert.assertAll();
        //driver.quit();
        
    }
    
    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
   	@Description("Employee Directory will be displayed") 
    @Story("User able to see Employee Directory in the home page") 
    public void empDir_will_be_displayed() throws InterruptedException {
    	test = extent.createTest("empDir_will_be_displayed");
    	
    	try {
        	boolean empDirButtonDisplay = homePageObj.empDirectoryDisplayed();
        	softAssert.assertEquals(empDirButtonDisplay, true,"Emp directory Button Not displayed");
        }
        
        catch(Exception e){
        	
        }
    	
    	softAssert.assertAll();
        driver.quit();
        
    }
    
    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
   	@Description("About Us will be displayed") 
    @Story("User able to see About Us Button in the home page") 
    public void abtUs_will_be_displayed() throws InterruptedException {
    	test = extent.createTest("abtUs_will_be_displayed");
    	
    	try {
        	boolean aboutUsDisplay = homePageObj.aboutUsDisplayed();
        	softAssert.assertEquals(aboutUsDisplay, true,"About Us Button Not displayed");
        }
        
        catch(Exception e){
        	
        }
    	
    	softAssert.assertAll();
        //driver.quit();
        
    }
    
    @Test(priority = 7)
    @Severity(SeverityLevel.NORMAL)
   	@Description("FAQ will be displayed") 
    @Story("User able to see FAQ Button in the home page") 
    public void faq_will_be_displayed() throws InterruptedException {
    	test = extent.createTest("faq_will_be_displayed");
    	
    	try {
        	boolean faqButtonDisplay = homePageObj.faqDisplayed();
        	softAssert.assertEquals(faqButtonDisplay, true,"FAQ Button Not displayed");
        }
        
        catch(Exception e){
        	
        }
    	
    	softAssert.assertAll();
        //driver.quit();
        
    }
    
    @Test(priority = 8)
    @Severity(SeverityLevel.TRIVIAL)
   	@Description("contactUs will be displayed") 
    @Story("User able to see Contac tUs in the home page") 
    public void contactUs_will_be_displayed() throws InterruptedException {
    	test = extent.createTest("contactUs_will_be_displayed");
    	
    	try {
        	boolean contactUsDisplay = homePageObj.contactUsDisplayed();
        	softAssert.assertEquals(contactUsDisplay, true,"Contact Us Button Not displayed");
        }
        
        catch(Exception e){
        	
        }
    	
    	softAssert.assertAll();
        //driver.quit();
        
    }
    
    @Test(priority = 9)
    @Severity(SeverityLevel.CRITICAL)
   	@Description("dashboardButton will be displayed") 
    @Story("User able to see Dashboard Button in the home page") 
    public void dashboardButton_will_be_displayed() throws InterruptedException {
    	test = extent.createTest("dashboardButton_will_be_displayed");
    	
    	try {
        	boolean dashboardDisplayed = homePageObj.dashboardButtonDisplayed();
        	softAssert.assertEquals(dashboardDisplayed, true,"Dashboard Button Not displayed");
        }
        
        catch(Exception e){
        	
        }
    	
    	softAssert.assertAll();
        //driver.quit();
        
    }
    
    @Test(priority = 10)
    @Severity(SeverityLevel.TRIVIAL)
   	@Description("grievance Button will be displayed") 
    @Story("User able to see Grievance Button in the home page") 
    public void grievanceButton_will_be_displayed() throws InterruptedException {
    	test = extent.createTest("grievanceButton_will_be_displayed");
    	
    	try {
        	boolean grienavenceButtonDisplay = homePageObj.GrievanceDisplayed();
        	softAssert.assertEquals(grienavenceButtonDisplay, true,"Greivance Button Not displayed");
        }
        
        catch(Exception e){
        	
        }
    	
    	softAssert.assertAll();
        //driver.quit();
        
    }
    
    @Test(priority = 11)
    @Severity(SeverityLevel.TRIVIAL)
   	@Description("health care textbox will be displayed") 
    @Story("User able to see Healthcare Textbox in the home page")
    public void health_care_textbox_will_be_displayed() throws InterruptedException {
    	test = extent.createTest("health_care_textbox_will_be_displayed");
    	
    	try {
        	boolean searchTextbixDisplay = homePageObj.searchHeakthcareDisplayed();
        	softAssert.assertEquals(searchTextbixDisplay, true,"Search textbox Not displayed");
        }
        
        catch(Exception e){
        	
        }
    	
    	softAssert.assertAll();
        //driver.quit();
        
    }
    
    @Test(priority = 12)
    @Severity(SeverityLevel.TRIVIAL)
   	@Description("search button will be displayed") 
    @Story("User able to see Search Button in the home page") 
    public void search_button_will_be_displayed() throws InterruptedException {
    	test = extent.createTest("search_button_will_be_displayed");
    	
    	try {
        	boolean searchbuttonDisplayed = homePageObj.searchButtonDisplayed();
        	softAssert.assertEquals(searchbuttonDisplayed, true,"Search button Not displayed");
        }
        
        catch(Exception e){
        	
        }
    	
    	softAssert.assertAll();
        //driver.quit();
        
    }
    
    @Test(priority = 13)
    @Severity(SeverityLevel.CRITICAL)
   	@Description("regd prof num will be displayed") 
    @Story("User able to see Professional Number in the home page") 
    public void regd_prof_num_will_be_displayed() throws InterruptedException {
    	test = extent.createTest("regd_prof_num_will_be_displayed");
    	
    	try {
        	boolean regdProfNumDisplay = homePageObj.regdProfNumDisplayed();
        	softAssert.assertEquals(regdProfNumDisplay, true,"Registered proffesional number Not displayed");
        }
        
        catch(Exception e){
        	
        }
    	
    	softAssert.assertAll();
       // driver.quit();
        
    }
    
    @Test(priority = 14)
    @Severity(SeverityLevel.MINOR)
   	@Description("doc num will be displayed") 
    @Story("User able to see Doctor Number in the home page") 
    public void doc_num_will_be_displayed() throws InterruptedException {
    	test = extent.createTest("doc_num_will_be_displayed");
    	
    	try {
        	boolean docNoDisplay = homePageObj.docNumDisplayed();
        	softAssert.assertEquals(docNoDisplay, true,"Doctor number Not displayed");
        }
        
        catch(Exception e){
        	
        }
    	
    	softAssert.assertAll();
        //driver.quit();
        
    }
    
    @Test(priority = 15)
    @Severity(SeverityLevel.MINOR)
   	@Description("nurse num will be displayed") 
    @Story("User able to see Nurse Number in the home page")
    public void nurse_num_will_be_displayed() throws InterruptedException {
    	test = extent.createTest("nurse_num_will_be_displayed");
    	
    	try {
        	boolean nurseNumDisplay = homePageObj.nursesNumberDisplayed();
        	softAssert.assertEquals(nurseNumDisplay, true,"Nurses number Not displayed");
        }
        
        catch(Exception e){
        	
        }
    	
    	softAssert.assertAll();
        //driver.quit();
        
    }
    
    @Test(priority = 16)
    @Severity(SeverityLevel.NORMAL)
   	@Description("other regd num will be displayed") 
    @Story("User able to see Registration number in the home page") 
    public void other_regd_num_will_be_displayed() throws InterruptedException {
    	test = extent.createTest("other_regd_num_will_be_displayed");
    	
    	try {
        	boolean otherRegdNumDisplay = homePageObj.otherRegdNumDsiplayed();
        	softAssert.assertEquals(otherRegdNumDisplay, true,"Other Registeration Not displayed");
        }
        
        catch(Exception e){
        	
        }
    	
    	softAssert.assertAll();
    	//driver.quit();
        
    }

 
}
