package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	private static XSSFSheet ExcelSheet;
	private static XSSFWorkbook ExcelWbook;
	private static XSSFRow Row;
	private static XSSFCell Cell;

	public static void setExcelFile(String sPath, String sSheetName) {
		try {
			FileInputStream ExcelFile = new FileInputStream(sPath);
			ExcelWbook = new XSSFWorkbook(ExcelFile);
			ExcelSheet = ExcelWbook.getSheet(sSheetName);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getCellData(int iRowNum, int iColNum) throws Exception {
		try {

			Cell = ExcelSheet.getRow(iRowNum).getCell(iColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			throw (e);
		}
	}
	//This method is to write in the Excel cell, Row num and Col num are the parameters

	public static void setCellData(String sResult, int iRowNum, int iColNum) throws Exception
	{
		try {
			Row = ExcelSheet.getRow(iRowNum);
			Cell = Row.getCell(iColNum);
			if (Cell == null)
			{
				Cell = Row.createCell(iColNum);
				Cell.setCellValue(sResult);
			}else {
				Cell.setCellValue(sResult);
			}
			FileOutputStream fileOut = new FileOutputStream(Constant.sDataFilePath+Constant.sDataFileName);
			ExcelWbook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		}catch (Exception e) {
			throw (e);
		}
		
	}
}
