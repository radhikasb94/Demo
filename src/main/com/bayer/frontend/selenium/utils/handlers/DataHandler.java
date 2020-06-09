package main.com.bayer.frontend.selenium.utils.handlers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import main.com.bayer.frontend.selenium.utils.config.PropertiesRepository;

import main.com.bayer.frontend.selenium.utils.config.GlobalProperties;
import org.apache.poi.ss.usermodel.CellBase;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import jxl.Sheet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


public class DataHandler {

	static XSSFSheet ExcelWSheet;
	static XSSFWorkbook ExcelWBook;
	static XSSFCell Cell;
	static XSSFRow Row;
	
	 static String FilePath = PropertiesRepository.getString("global.excelpath");
	static String SheetName1 = "Sheet1";
	static String SheetName2 = "Sheet2";
	static int row = 0;
	static int col = 0;
	
@DataProvider(name = "Cleartrip")
public static Object[][] getTableArray() throws Exception {   

   Object[][] tab = null;

   try {

	   FileInputStream ExcelFile = new FileInputStream(FilePath);

	   // Access the required test data sheet
	   ExcelWBook = new XSSFWorkbook(ExcelFile);
	   ExcelWSheet = ExcelWBook.getSheet(SheetName1);
	 
	   int startRow = 1;
	   int startCol = 0;
	   int ci,cj;
	   int totalRows = ExcelWSheet.getLastRowNum();
	   

	   // you can write a function as well to get Column count
	   int totalCols = ExcelWSheet.getRow(0).getLastCellNum();
	   tab = new String[totalRows][totalCols];
	   ci=0;

	   for (int i=startRow;i<=totalRows;i++, ci++) {           	   

		  cj=0;

		   for (int j=startCol;j<=1;j++, cj++){

			  tab[ci][cj]=getCellData(i,j);
              System.out.println(tab[ci][cj]);  
             
				}

			}

		}

	catch (FileNotFoundException e){

		System.out.println("Could not read the Excel sheet");
		e.printStackTrace();

		}

	catch (IOException e){

		System.out.println("Could not read the Excel sheet");
		e.printStackTrace();

		}

	return(tab);

	}

public static String getCellData(int RowNum, int ColNum) throws Exception {

	try{

		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
                String CellData = Cell.getStringCellValue();
                return CellData;
		
	}catch (Exception e){

	        System.out.println(e.getMessage());
		throw (e);
	}

		}

//Based on particular TestCase	


@DataProvider(name = "CleartripSignup")
public static String[][] singleInput() throws Exception{
		String [][] tab = null;
    
	   try {

		   FileInputStream ExcelFile = new FileInputStream(FilePath);

		   // Access the required test data sheet
		   ExcelWBook = new XSSFWorkbook(ExcelFile);
		   ExcelWSheet = ExcelWBook.getSheet(SheetName2);
		   int LastRowNo = ExcelWSheet.getLastRowNum();
		   int LastColNo = ExcelWSheet.getRow(0).getLastCellNum();
		   tab = new String[LastColNo-1][1];
		   int rowno = 0;
		  int colno = 0;
		   for(int i = 0;i < 2;i++){
			   Cell = ExcelWSheet.getRow(i).getCell(0);
			   String Data=getCellData(i,0).toString();
			   if (Data.equalsIgnoreCase("Invalid")){
				   for(int j = 1;j<LastColNo;j++,rowno++){
				   tab[rowno][colno]=getCellData(i,j).toString();
				   System.out.println(tab[rowno][colno]);
				   }
			   }
			   
		   }
			   
			  
	   }   
	    catch (FileNotFoundException e){

			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();

			}

		catch (IOException e){

			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();

			}

	   return (tab);	

		
}

}

