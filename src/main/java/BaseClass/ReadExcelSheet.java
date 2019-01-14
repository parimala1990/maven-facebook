package BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;

public class ReadExcelSheet {
	
	
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public   ReadExcelSheet(String path)
	{
		try {
			File scrFile = new File(path);
			
			FileInputStream fis = new FileInputStream(scrFile);
			wb = new XSSFWorkbook(fis);
						
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		public String ReadData(int sheetIndex ,int row,int col)
		{
			sheet=wb.getSheetAt(sheetIndex);
			String data=sheet.getRow(row).getCell(col).getStringCellValue();
			return data;
			
		}
		
		public int rowCount(int sheetIndex)
		{
		
			int row=wb.getSheetAt(sheetIndex).getLastRowNum();
			row=row+1;
			return row;
		}
	}


