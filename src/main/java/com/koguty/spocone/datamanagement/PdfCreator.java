package com.koguty.spocone.datamanagement;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfCreator {

	public void createPDF(HSSFWorkbook raportWorkbook) {
		HSSFSheet raportWorksheet = raportWorkbook.getSheetAt(0);
		Iterator<Row> rowIterator = raportWorksheet.iterator();
		Document raportPDF = new Document();
		String raportName = raportWorkbook.getSheetName(0);
		
		int countOfColumns = 0;
		Row rowZero = raportWorksheet.getRow(0);
		if(rowZero == null){
			countOfColumns = rowZero.getPhysicalNumberOfCells();
		}
		
		try {
			PdfWriter.getInstance(raportPDF, new FileOutputStream(raportName));

		} catch (FileNotFoundException e) {
			System.out.println("Nie znaleziono pliku");
			e.printStackTrace();
		} catch (DocumentException e) {
			System.out.println("Nie znaleziono pliku");
			e.printStackTrace();
		}
		raportPDF.open();
		PdfPTable raportTable = new PdfPTable(countOfColumns);
		PdfPCell table_cell;
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (cell.getCellType()) {

				case Cell.CELL_TYPE_STRING:
					// Push the data from Excel to PDF Cell
					table_cell = new PdfPCell(new Phrase(cell.getStringCellValue()));
					// feel free to move the code below to suit to your needs
					raportTable.addCell(table_cell);
					break;
				case Cell.CELL_TYPE_NUMERIC:
					// Push the data from Excel to PDF Cell
					table_cell = new PdfPCell(new Phrase(String.valueOf(cell.getNumericCellValue())));
					// feel free to move the code below to suit to your needs
					raportTable.addCell(table_cell);
					break;
//				case Cell.:
//					// Push the data from Excel to PDF Cell
//					table_cell = new PdfPCell(new Phrase(String.valueOf(cell.getNumericCellValue())));
//					// feel free to move the code below to suit to your needs
//					raportTable.addCell(table_cell);
//					break;
				case Cell.CELL_TYPE_BLANK:
					break;
				}
			}
			try {
				raportPDF.add(raportTable);
			} catch (DocumentException e) {
				System.out.println("Nie znaleziono danych do zapisania");
				e.printStackTrace();
			}
			raportPDF.close();
		}
	}
}
