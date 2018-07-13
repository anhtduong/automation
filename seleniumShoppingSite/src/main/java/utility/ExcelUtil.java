package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
    private static XSSFWorkbook eWorkbook;
    private static XSSFSheet eSheet;

    private static XSSFRow eRow;
    private static XSSFCell eCell;
    private static FileInputStream fileIn;
    private static FileOutputStream fileOut;

    public static void getExcelFile(String sheetName) {
        eWorkbook = null;
        fileIn = null;

        try {
            fileIn = new FileInputStream(Constant.dataFilePath.trim() + Constant.dataFileName.trim());

            eWorkbook = new XSSFWorkbook(fileIn);
            eSheet = eWorkbook.getSheet(sheetName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getCell(int rowNum, int cellNum) {
        try {
            return eSheet.getRow(rowNum).getCell(cellNum).getStringCellValue().trim();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void setCell(int rowNum, int colNum, String testResult) {
        try {
            eRow = eSheet.getRow(rowNum);
            eCell = eRow.getCell(colNum);


            if (eCell == null) {
                eCell=eRow.createCell(colNum);
                eCell.setCellValue(testResult.trim());
            }
            else {

                eCell.setCellValue(testResult.trim());

            }
            fileOut = new FileOutputStream(Constant.dataFilePath.trim() + Constant.dataFileName.trim());

            eWorkbook.write(fileOut);
            fileOut.flush();
            fileOut.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * //Iterating all rows Iterator<Row> rows = eSheet.rowIterator(); while
     * (rows.hasNext()){ eRow = (XSSFRow) rows.next(); Iterator<Cell> cells =
     * eRow.cellIterator(); while (cells.hasNext()) { eCell = (XSSFCell)
     * cells.next(); switch (eCell.getCellType()) { case XSSFCell.CELL_TYPE_STRING:
     * System.out.println(eCell.getStringCellValue()); break; case
     * Cell.CELL_TYPE_NUMERIC : System.out.println(eCell.getNumericCellValue());
     * break; }
     *
     * }
     */

}
