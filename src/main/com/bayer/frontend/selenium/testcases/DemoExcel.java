package main.com.bayer.frontend.selenium.testcases;


import main.com.bayer.frontend.selenium.utils.config.PropertiesRepository;

import main.com.bayer.frontend.selenium.utils.handlers.ExcelHandler;


import java.io.File;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.testng.annotations.Test;

import jxl.Cell;



public class DemoExcel{

 //@Test(description="Single Data")
 public void singleData() throws IOException, Exception{
	 ExcelHandler excel = new ExcelHandler(new File("C:\\Users\\acer\\Desktop\\book1.xls"));
	 excel.selectSheet("Sheet1");
	 System.out.println(excel.getCellData(1, 1).getContents());
 }
 
 //@Test(description = "Mapped Rows")
 public void rowMap() throws Exception{
	 ExcelHandler excel = new ExcelHandler(new File(PropertiesRepository.getString("global.jexcelpath")));
	 excel.selectSheet("Sheet1");
	 HashMap<String, Cell> map = excel.mapTwoRows(1, 2);
	System.out.println(map);
	Iterator<String> it = map.keySet().iterator();       
    //String key=it.next();
    System.out.println(map.get("TestCase").getContents());
    System.out.println(map.get("Data 1").getContents());
    System.out.println(map.get("Data 2").getContents());
    System.out.println(map.get("Data 3").getContents());
    System.out.println(map.get("Data 4").getContents());
    System.out.println(map.get("Data 5").getContents());
    System.out.println(map.get("Data 6").getContents());
	
 }
 
 //@Test(description = "One Row")
 public void oneRow() throws Exception{
	 ExcelHandler excel = new ExcelHandler(new File("C:\\Users\\acer\\Desktop\\book1.xls"));
	 excel.selectSheet("Sheet1");
	 HashMap<Integer, Cell> r = excel.getRow(2);
	System.out.println(r.get(2).getContents());
	System.out.println(r.get(3).getContents());
	System.out.println(r.get(4).getContents());
	System.out.println(r.get(5).getContents());
	System.out.println(r.get(6).getContents());
 }
 

 //@Test(description = "One Column")
 public void oneCol() throws Exception{
	 ExcelHandler excel = new ExcelHandler(new File("C:\\Users\\acer\\Desktop\\book1.xls"));
	 excel.selectSheet("Sheet1");
	 HashMap<Integer, Cell> c = excel.getColumn(2);
	System.out.println(c.get(2).getContents());
	System.out.println(c.get(3).getContents());
	
 }
 
@Test(description = "Mapped Cols")
public void colMap() throws Exception{
	 ExcelHandler excel = new ExcelHandler(new File("C:\\Users\\acer\\Desktop\\book1.xls"));
	 excel.selectSheet("Sheet1");
	 HashMap<String, Cell> map = excel.mapTwoColumns(1, 2);
	System.out.println(map);
	//Iterator<String> it = map.keySet().iterator();       
   //String key=it.next();
   System.out.println(map.get("TestCase").getContents());
   System.out.println(map.get("Invalid").getContents());
   System.out.println(map.get("Valid").getContents());
   
	
}

	
}


