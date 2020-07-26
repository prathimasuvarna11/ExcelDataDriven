package DataDriven.ExcelDataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.stream.FileImageInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataDrivenTest {
	
	public ArrayList getData(String testcasename) throws IOException
	{
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("C:\\Users\\NI7587\\Documents\\DataDrivenExcel.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		int sheets=workBook.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
			if(workBook.getSheetName(i).equalsIgnoreCase("test"))
			{
				XSSFSheet sheet=workBook.getSheetAt(i);
				Iterator<Row> rows=sheet.iterator();
				
				/*
				 * Row firstRow=rows.next(); Iterator<Cell> cells=firstRow.cellIterator();
				 */
				 
					
					int k=0;
					int column=0;
					/*
					 * while(cells.hasNext()) { Cell value=cells.next();
					 * System.out.println("cell value " + value);
					 * if(value.getStringCellValue().equalsIgnoreCase("nbb")) { column=k; } k++; }
					 * System.out.println(column);
					 */
					
					
					 while(rows.hasNext())
					 {
						 Row r=rows.next();
						 System.out.println("cell value " + r.getCell(column).getStringCellValue());
					  if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename))
					  {
					  Iterator<Cell> v=r.iterator();
					  while(v.hasNext()) 
					  {
						  Cell c=v.next();
					  if(c.getCellTypeEnum()==CellType.STRING) 
					  {
						  a.add(c.getStringCellValue()); 
					  }
					  else {
						  a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
					  }
					  } 
					  }
					  }
					 
					
				}
				
				
		
			
		}
		return a;
	}

	public static void main(String[] args) throws IOException {
	
	}

}
