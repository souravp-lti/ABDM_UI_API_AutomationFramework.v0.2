package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import Base.MainBaseFeature;

public class ReadExcel extends MainBaseFeature{
	
	public  String readExcelFile(String sheetName, int rowNum, int CellNum) throws EncryptedDocumentException, IOException
    {
        //FileInputStream file = new FileInputStream("C:\\Users\\USER\\eclipse-workspace\\ABDM_DDD_v.8\\src\\main\\java\\Configuration\\XPath&TestData.xlsx");
		FileInputStream file = new FileInputStream(readPropertyFile("sysFileLocation")+readPropertyFile("packageName")+"\\\\src\\\\main\\\\java\\\\Configuration\\\\XPath&TestData.xlsx");
        Sheet excelSheet = WorkbookFactory.create(file).getSheet(sheetName);
        String value = excelSheet.getRow(rowNum).getCell(CellNum).getStringCellValue();
        return value;
    }

}
