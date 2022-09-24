package HBI_OBJ;


import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import Base.MainBaseFeature;
import Utility.ReadExcel;
import io.qameta.allure.Step;

public class Obj_HBI_HomePage_Features_visible extends MainBaseFeature {
	
	//protected WebDriver driver;	 
	SoftAssert softAssert = new SoftAssert();
	ReadExcel takeData = new ReadExcel();
		
	@Step("OBJect-1")
    public boolean homeButtonDisplayed() throws InterruptedException, IOException {
    	System.out.println(takeData.readExcelFile("Obj_HBI_HomePage_Features",1, 1));
    	//return driver.findElement(By.xpath(readHomePageData("homeButton"))).isDisplayed();
    	return driver.findElement(By.xpath(takeData.readExcelFile("Obj_HBI_HomePage_Features",1, 1))).isDisplayed();    	
    }
    
	@Step("OBJect-2")
    public boolean RecruitersDirectoryDisplayed() throws InterruptedException, IOException {
    	//return driver.findElement(By.xpath(readHomePageData("recruitersDirectoryButton"))).isDisplayed();
    	return driver.findElement(By.xpath(takeData.readExcelFile("Obj_HBI_HomePage_Features",2, 1))).isDisplayed(); 
    }
    
	@Step("OBJect-3")
    public boolean empDirectoryDisplayed() throws InterruptedException, IOException {
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	//return driver.findElement(By.xpath(readHomePageData("employersDirectoryButton"))).isDisplayed();
    	return driver.findElement(By.xpath(takeData.readExcelFile("Obj_HBI_HomePage_Features",3, 1))).isDisplayed(); 
    }
    
	@Step("OBJect-4")
    public boolean aboutUsDisplayed() throws InterruptedException, IOException{
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	//return driver.findElement(By.xpath(readHomePageData("aboutUsButton"))).isDisplayed();
    	return driver.findElement(By.xpath(takeData.readExcelFile("Obj_HBI_HomePage_Features",4, 1))).isDisplayed(); 
    }
    
	@Step("OBJect-4")
    public boolean faqDisplayed() throws InterruptedException, IOException{
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	//return driver.findElement(By.xpath(readHomePageData("fAQdropdown"))).isDisplayed();
    	return driver.findElement(By.xpath(takeData.readExcelFile("Obj_HBI_HomePage_Features",5, 1))).isDisplayed(); 
    }
    
	@Step("OBJect-5")
    public boolean contactUsDisplayed() throws InterruptedException, IOException{
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	//return driver.findElement(By.xpath(readHomePageData("contactUsButton"))).isDisplayed();
    	return driver.findElement(By.xpath(takeData.readExcelFile("Obj_HBI_HomePage_Features",6, 1))).isDisplayed(); 
    }
    
	@Step("OBJect-6")
    public boolean dashboardButtonDisplayed() throws InterruptedException, IOException{
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	//return driver.findElement(By.xpath(readHomePageData("dashboardButton"))).isDisplayed();
    	return driver.findElement(By.xpath(takeData.readExcelFile("Obj_HBI_HomePage_Features",7, 1))).isDisplayed(); 
    }
    
	@Step("OBJect-7")
    public boolean GrievanceDisplayed() throws InterruptedException, IOException{
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	//return driver.findElement(By.xpath(readHomePageData("grievanceButton"))).isDisplayed();
    	return driver.findElement(By.xpath(takeData.readExcelFile("Obj_HBI_HomePage_Features",8, 1))).isDisplayed(); 
    }
    
	@Step("OBJect-8")
    public boolean searchHeakthcareDisplayed() throws InterruptedException, IOException{
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	//return driver.findElement(By.xpath(readHomePageData("searchHealthcareTextbox"))).isDisplayed(); 
    	return driver.findElement(By.xpath(takeData.readExcelFile("Obj_HBI_HomePage_Features",9, 1))).isDisplayed(); 
    }
    
	@Step("OBJect-9")
    public boolean searchButtonDisplayed() throws InterruptedException, IOException{
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	//return driver.findElement(By.xpath(readHomePageData("searchButton"))).isDisplayed();
    	return driver.findElement(By.xpath(takeData.readExcelFile("Obj_HBI_HomePage_Features",10, 1))).isDisplayed(); 
    }
	
	@Step("OBJect-10")
    public boolean regdProfNumDisplayed() throws InterruptedException, IOException{
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	//return driver.findElement(By.xpath(readHomePageData("registeredProfessionalsNumber"))).isDisplayed();
    	return driver.findElement(By.xpath(takeData.readExcelFile("Obj_HBI_HomePage_Features",11, 1))).isDisplayed(); 
    }
    
	@Step("OBJect-11")
    public boolean docNumDisplayed() throws InterruptedException, IOException{
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	//return driver.findElement(By.xpath(readHomePageData("doctorsNumber"))).isDisplayed();
    	return driver.findElement(By.xpath(takeData.readExcelFile("Obj_HBI_HomePage_Features",12, 1))).isDisplayed(); 
    }
    
	@Step("OBJect-12")
    public boolean nursesNumberDisplayed() throws InterruptedException, IOException{
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	//return driver.findElement(By.xpath(readHomePageData("nursesNumber"))).isDisplayed();
    	return driver.findElement(By.xpath(takeData.readExcelFile("Obj_HBI_HomePage_Features",13, 1))).isDisplayed(); 
    }
    
	@Step("OBJect-13")
    public boolean otherRegdNumDsiplayed() throws InterruptedException, IOException{
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	//return driver.findElement(By.xpath(readHomePageData("otherRegistrationNumber"))).isDisplayed();
    	return driver.findElement(By.xpath(takeData.readExcelFile("Obj_HBI_HomePage_Features",14, 1))).isDisplayed(); 
    }



}



