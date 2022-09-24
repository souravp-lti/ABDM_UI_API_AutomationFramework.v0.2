package Utility;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Base.MainBaseFeature;

public class ScreenShot extends MainBaseFeature{
	
	//CLASS TO TAKE SCREENSHOT
	static ReadExcel takeData = new ReadExcel();
  	//public static String failedTCSS(String testMethodName) throws IOException {  
  	public static String failedTCSS(String testMethodName, String screenSPath) throws IOException {  	
  		
  		Date currentdate = new Date();
  		String screenShotName = currentdate.toString().replace(" ", "-").replace(":", "-");	
  		File scrShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  		//File dest = new File(takeData.readExcelFile("testData", 4, 1)+testMethodName+"-"+screenShotName+"_FAILED.png");
  		File dest = new File(screenSPath+testMethodName+"-"+screenShotName+"_FAILED.png");
  		FileUtils.copyFile(scrShot, dest);
  		return dest.getAbsolutePath();
  	
  	}

}
