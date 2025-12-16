package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static String[][] readData() {
		
		String fileName = "src\\test\\resources\\testData\\Books.xlsx";
		FileInputStream fis;
		XSSFWorkbook workBook = null;
		XSSFCell cell;
		
		try {
			fis = new FileInputStream(fileName);
			workBook = new XSSFWorkbook(fis);
			}catch (FileNotFoundException e) {
				System.out.println("File path or File name is not correct");;
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

		XSSFSheet sheet = workBook.getSheet("ProductDetails");
		
		// get count of rows
		int rowCount = sheet.getLastRowNum();
		System.out.println("No of Rows: " + rowCount);
		
		DataFormatter df = new DataFormatter();
		
		String[][] data = new String[2][2];
		
		for(int rowNo = 1; rowNo<=rowCount; rowNo++) {
			int cellCount = sheet.getRow(rowNo).getLastCellNum();
			
			for(int cellNo=0; cellNo<cellCount; cellNo++) {
				cell = sheet.getRow(rowNo).getCell(cellNo);
				data[rowNo-1][cellNo] = df.formatCellValue(cell);
				System.out.print(data[rowNo-1][cellNo] + "\t");
			}			
			System.out.println();
		}
	
	return data;
	}
	
}
