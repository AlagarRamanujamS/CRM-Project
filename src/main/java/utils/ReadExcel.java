package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import freemarker.core.ReturnInstruction.Return;
//import org.testng.annotations.Test;


public class ReadExcel {
	
	public static Object[][] readexcel(String dataSheetName) throws IOException {
		 
		//Open Excel
		XSSFWorkbook wb = new XSSFWorkbook("./data/"+dataSheetName+".xlsx");
		//Go to Sheet
		XSSFSheet sheet = wb.getSheetAt(0);
		//Row Count
		int rowcount = sheet.getLastRowNum();
		
		System.out.println(rowcount);
		//Column count
		int cellcount = sheet.getRow(0).getLastCellNum();
		
		System.out.println(cellcount);
		
		Object[][] data = new Object[rowcount][cellcount];
		
		for (int i = 1; i <= rowcount ; i++) {
			//Go to Specific row
			XSSFRow row = sheet.getRow(i);
			
			for (int j = 0; j < cellcount; j++) {
				
				XSSFCell cell = row.getCell(j);
				
				try {
					//Read the column value
					String stringval = cell.getStringCellValue();
					
					System.out.println(stringval);
					
					data[i-1][j] = stringval;
				} catch (NullPointerException e) {

					System.out.println("");
				}
			
			}
			
		}
		//close the Excel
		wb.close();
		
		return data;

	}

}
