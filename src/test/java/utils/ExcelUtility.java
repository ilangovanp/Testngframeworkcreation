package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static String[][] excelfilereading(String fileName) throws IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook workbook = new XSSFWorkbook("./src/test/resources/"+fileName+".xlsx");
		
		XSSFSheet sheet=workbook.getSheetAt(0);
		int rowNumber=sheet.getLastRowNum();
		int colnumber= sheet.getRow(1).getLastCellNum();
		System.out.println(rowNumber);
		System.out.println(colnumber);
		
		 String values[][]= new String[rowNumber][colnumber];
		for (int i = 1; i <=rowNumber; i++) {
			//System.out.println("|");
			for(int j=0;j<colnumber;j++) {
			
			String txt =sheet.getRow(i).getCell(j).getStringCellValue();
			System.out.println(txt);
			values[i-1][j]=txt;
		}
		
}
		workbook.close();
return values;
		
		
		
}

}
