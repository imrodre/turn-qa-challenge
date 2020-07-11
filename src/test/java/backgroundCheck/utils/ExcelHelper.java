package backgroundCheck.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Excel file helper to perform any operation over an excel file.
 * 
 * @author Rodrigo Moran
 */
public class ExcelHelper {

	/**
	 * 
	 * @param filePath, file name to read from under datafiles directory
	 * @return Multidimentional Object, e.g row1{cell1, cell2, cell3....}
	 * @throws IOException
	 */
	public static Object[][] getDataFromXls(String filePath) throws IOException {

		FileInputStream fs = new FileInputStream("src/test/resources/dataFiles/" + filePath);
		Logger.logStep("Reading file: " + filePath);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fs); // get my workbook
		XSSFSheet worksheet = workbook.getSheetAt(0);// get my sheet from workbook
		XSSFRow headers = worksheet.getRow(0); // get headers Row which start from 0

		int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
		int ColNum = headers.getLastCellNum(); // get last ColNum

		Object Data[][] = new Object[RowNum - 1][ColNum]; // pass my count data in array

		for (int i = 0; i < RowNum - 1; i++) // Loop work for Rows
		{
			XSSFRow row = worksheet.getRow(i + 1);

			for (int j = 0; j < ColNum; j++) // Loop work for colNum
			{
				if (row == null)
					continue;
				else {
					XSSFCell cell = row.getCell(j);
					if (cell == null)
						Data[i][j] = ""; // if it get Null value it pass no data
					else {
						String value = getCellData(cell);
						Data[i][j] = value; // This formatter get my all values as string i.e integer, float all type
											// data value
					}
				}
			}
		}

		workbook.close();
		
		return Data;
	}

	private static String getCellData(Cell cell) {

		String cellVal = "";

		if (cell.getCellType().equals(org.apache.poi.ss.usermodel.CellType.STRING)) {
			cellVal = cell.getStringCellValue();
		} else if (cell.getCellType().equals(org.apache.poi.ss.usermodel.CellType.NUMERIC)) {
			cellVal = String.valueOf(cell.getNumericCellValue());
		}else if (cell.getCellType().equals(org.apache.poi.ss.usermodel.CellType.BOOLEAN)) {
			cellVal = String.valueOf(cell.getBooleanCellValue());
		} else if (cell.getCellType().equals(org.apache.poi.ss.usermodel.CellType.BLANK)) {
			cellVal = "";
		}
		return cellVal;

	}
}