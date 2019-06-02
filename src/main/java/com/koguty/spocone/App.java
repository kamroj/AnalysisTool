package com.koguty.spocone;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.itextpdf.text.DocumentException;
import com.koguty.spocone.datamanagement.PdfCreator;

public class App {
	public static void main(String[] args) throws IOException, DocumentException {
		PdfCreator pdfCreator = new PdfCreator();

		FileInputStream input_document = new FileInputStream(
				new File("C:\\Users\\student6\\KJ\\advanced_project_raport.xls"));
		HSSFWorkbook wb = new HSSFWorkbook(input_document);
		pdfCreator.createPDF(wb);

	}

}
