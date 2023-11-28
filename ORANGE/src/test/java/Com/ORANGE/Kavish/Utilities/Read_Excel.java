package Com.ORANGE.Kavish.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Excel {

	XSSFWorkbook WB;
	XSSFSheet WS;

	public Read_Excel() {

		try {
			String excelpath = "E:\\ORANGE\\Data.xlsx";

			File src = new File(excelpath);

			FileInputStream fs = new FileInputStream(src);

			WB = new XSSFWorkbook(fs);
			WS = WB.getSheet("Sheet1");
		} catch (IOException e) {

			System.out.println(e.getMessage());
		}
	}

	public String getData(String sheetname, int row, int column) {
		String UN = WS.getRow(row).getCell(column).getStringCellValue();
		return UN;
	}

//	public String getvalue(String sheetname, int row, int column) {
//		String UP = WS.getRow(row).getCell(column).getStringCellValue();
//		return UP;
//	}
}
