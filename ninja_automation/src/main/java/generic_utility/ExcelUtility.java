package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String[] getDataFromExcelFile(String sheetname, int rownum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/ninjacrmTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet(sheetname);
		
		Row row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		String []data=new String[cellcount];
				for(int i=0;i<cellcount;i++)
				{
					data[i]=row.getCell(i).toString();
				}
		
	

//		String value = wb.getSheet(sheetname).getRow(rownum).getCell(cell).getStringCellValue();

		wb.close();
		fis.close();
		return data;

	}

}
