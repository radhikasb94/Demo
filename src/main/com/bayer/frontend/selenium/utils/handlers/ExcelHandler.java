package main.com.bayer.frontend.selenium.utils.handlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.util.HashMap;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import main.com.bayer.frontend.selenium.utils.config.PropertiesRepository;


public class ExcelHandler {

	private HashMap<String, Sheet> importedSheets = new HashMap<String, Sheet>();
	private static Sheet selectedSheet = null;
	
	

	public ExcelHandler(File excel) throws Exception, IOException {
		
		Workbook workbook = Workbook.getWorkbook(excel);
		String[] sheetNames = workbook.getSheetNames();
		Sheet[] sheetData = workbook.getSheets();
		if (sheetData.length != sheetNames.length) {
			throw new Exception("Cannot map sheets to sheet names");
		}
		for (int sheetNumber = 0; sheetNumber < sheetData.length; sheetNumber++) {
			this.importedSheets.put(sheetNames[sheetNumber], sheetData[sheetNumber]);

			// added by radhika
			System.out.println(sheetNames[sheetNumber]);
		}
	}

	public void selectSheet(String sheetName) throws Exception {
		if (this.importedSheets.containsKey(sheetName)) {
			ExcelHandler.selectedSheet = importedSheets.get(sheetName);
			// added by radhika 
			System.out.println("Selected given Sheet");
		} else {
			throw new Exception("Sheet with name '" + sheetName + "' doesn't exist!");
		}
	}

	public String selectedSheetName() throws Exception {
		return ExcelHandler.selectedSheet.getName();
	}

	/**
	 * Get a specific column from the Excel Worksheet (The first column is
	 * column 1)
	 *
	 * @param columnNumber
	 * @return
	 * @throws Exception
	 */
	public HashMap<Integer, Cell> getColumn(int columnNumber) throws Exception {
		return getColumn(columnNumber, false);
	}

	/**
	 * Get a specific column from the Excel Worksheet You can optionally skip
	 * the top row of the column to ensure column titles are not pulled into the
	 * data set (The first column is column 1)
	 *
	 * @param columnNumber
	 * @param skipFirstRow
	 * @return
	 * @throws Exception
	 */
	public HashMap<Integer, Cell> getColumn(int columnNumber, boolean skipFirstRow) throws Exception {
		if (ExcelHandler.selectedSheet.equals(null)) {
			throw new Exception("No sheet selected.  You must select a sheet before trying to get data!");
		} else if (columnNumber > ExcelHandler.selectedSheet.getColumns()) {
			throw new Exception("There are only " + ExcelHandler.selectedSheet.getColumns()
					+ " columns in this sheet.  Unable to select column " + columnNumber + "!");
		}
		HashMap<Integer, Cell> selectedColumn = new HashMap<Integer, Cell>();
		for (Cell currentCell : ExcelHandler.selectedSheet.getColumn(columnNumber - 1)) {
			selectedColumn.put(selectedColumn.size() + 1, currentCell);
		}
		if (skipFirstRow) {
			selectedColumn.remove(1);
		}
		return selectedColumn;
	}

	/**
	 * Get a specific row from the Excel Worksheet (The first row is row 1)
	 *
	 * @param rowNumber
	 * @return
	 * @throws Exception
	 */
	public HashMap<Integer, Cell> getRow(int rowNumber) throws Exception {
		return getRow(rowNumber, false);
	}

	/**
	 * Get a specific row from the Excel Worksheet You can optionally skip the
	 * first column of the row to ensure row titles are not pulled into the data
	 * set (The first row is row 1)
	 *
	 * @param rowNumber
	 * @param skipFirstColumn
	 * @return
	 * @throws Exception
	 */
	public HashMap<Integer, Cell> getRow(int rowNumber, boolean skipFirstColumn) throws Exception {
		if (ExcelHandler.selectedSheet.equals(null)) {
			throw new Exception("No sheet selected.  You must select a sheet before trying to get data!");
		} else if (rowNumber > ExcelHandler.selectedSheet.getRows()) {
			throw new Exception("There are only " + ExcelHandler.selectedSheet.getRows()
					+ " rows in this sheet.  Unable to select row " + rowNumber + "!");
		}
		HashMap<Integer, Cell> selectedRow = new HashMap<Integer, Cell>();
		for (Cell currentCell : ExcelHandler.selectedSheet.getRow(rowNumber - 1)) {
			selectedRow.put(selectedRow.size() + 1, currentCell);
		}
		if (skipFirstColumn) {
			selectedRow.remove(1);
		}
		return selectedRow;
	}

	/**
	 * This will map two rows into a HashMap. The key row will be converted into
	 * a string that can be used to reference the matching data in he value row.
	 * You can optionally skip the first column of the row to ensure row titles
	 * are not pulled into the data set (The first row is row 1)
	 */
	public HashMap<String, Cell> mapTwoRows(int keyRow, int valueRow) throws Exception {
		return mapTwoRows(keyRow, valueRow, false);
	}

	/**
	 * This will map two rows into a HashMap. The key row will be converted into
	 * a string that can be used to reference the matching data in he value row.
	 * You can optionally skip the first column of the row to ensure row titles
	 * are not pulled into the data set (The first row is row 1)
	 *
	 * @param keyRow
	 *            The row number to be used as the HashMap key.
	 * @param valueRow
	 *            The row number to be used as the HashMap value.
	 * @param skipFirstColumn
	 * @return
	 * @throws Exception
	 */
	public HashMap<String, Cell> mapTwoRows(int keyRow, int valueRow, boolean skipFirstColumn) throws Exception {
		if (ExcelHandler.selectedSheet.equals(null)) {
			throw new Exception("No sheet selected.  You must select a sheet before trying to get data!");
		} else if ((keyRow > ExcelHandler.selectedSheet.getRows()) || (valueRow > ExcelHandler.selectedSheet.getRows())) {
			throw new Exception("There are only " + ExcelHandler.selectedSheet.getRows()
					+ " rows in this sheet.  Unable to select rows " + keyRow + " and " + valueRow + "!");
		}
		Cell[] hashMapKey = ExcelHandler.selectedSheet.getRow(keyRow - 1);
		Cell[] hashMapValue = ExcelHandler.selectedSheet.getRow(valueRow - 1);
		if (hashMapKey.length != hashMapValue.length) {
			throw new Exception("The rows supplied are different lengths, unable to map them!");
		}
		int startPoint = 0;
		if (skipFirstColumn) {
			startPoint = 1;
		}
		HashMap<String, Cell> selectedRows = new HashMap<String, Cell>();
		for (int i = startPoint; i < hashMapKey.length; i++) {
			selectedRows.put(hashMapKey[i].getContents(), hashMapValue[i]);
		}
		return selectedRows;
	}

	/**
	 * This will map two columns into a HashMap. The key column will be
	 * converted into a string that can be used to reference the matching data
	 * in he value column. You can optionally skip the first row of the column
	 * to ensure column titles are not pulled into the data set (The first row
	 * is row 1)
	 */
	public HashMap<String, Cell> mapTwoColumns(int keyColumn, int valueColumn) throws Exception {
		return mapTwoColumns(keyColumn, valueColumn, false);
	}

	/**
	 * This will map two columns into a HashMap. The key column will be
	 * converted into a string that can be used to reference the matching data
	 * in he value column. You can optionally skip the first row of the column
	 * to ensure column titles are not pulled into the data set (The first row
	 * is row 1)
	 *
	 * @param keyColumn
	 *            The row number to be used as the HashMap key.
	 * @param valueColumn
	 *            The row number to be used as the HashMap value.
	 * @param skipFirstColumn
	 * @return
	 * @throws Exception
	 */
	public HashMap<String, Cell> mapTwoColumns(int keyColumn, int valueColumn, boolean skipFirstColumn)
			throws Exception {
		if (ExcelHandler.selectedSheet.equals(null)) {
			throw new Exception("No sheet selected.  You must select a sheet before trying to get data!");
		} else if ((keyColumn > ExcelHandler.selectedSheet.getRows()) || (valueColumn > ExcelHandler.selectedSheet.getRows())) {
			throw new Exception("There are only " + ExcelHandler.selectedSheet.getRows()
					+ " columnss in this sheet.  Unable to select columns " + keyColumn + " and " + valueColumn + "!");
		}
		Cell[] hashMapKey = ExcelHandler.selectedSheet.getColumn(keyColumn - 1);
		Cell[] hashMapValue = ExcelHandler.selectedSheet.getColumn(valueColumn - 1);
		if (hashMapKey.length != hashMapValue.length) {
			throw new Exception("The columns supplied are different lengths, unable to map them!");
		}
		int startPoint = 0;
		if (skipFirstColumn) {
			startPoint = 1;
		}
		HashMap<String, Cell> selectedColumns = new HashMap<String, Cell>();
		for (int i = startPoint; i < hashMapKey.length; i++) {
			selectedColumns.put(hashMapKey[i].getContents(), hashMapValue[i]);
		}
		return selectedColumns;
	}

	/**
	 * Get a specific cell from the Excel Worksheet (The top left cell is
	 * assumed to be in position 1, 1)
	 *
	 * @param column
	 * @param row
	 * @return
	 * @throws Exception
	 */
	public Cell getCellData(int column, int row) throws Exception {
		column--;
		row--;
		if (ExcelHandler.selectedSheet.equals(null)) {
			throw new Exception("No sheet selected.  You must select a sheet before trying to get data!");
		}
		System.out.println("Getting cell data");
		return ExcelHandler.selectedSheet.getCell(column, row);
	}
}
