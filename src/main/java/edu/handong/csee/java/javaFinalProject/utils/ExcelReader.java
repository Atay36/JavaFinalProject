package edu.handong.csee.java.javaFinalProject.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import edu.handong.csee.java.javaFinalProject.datamodel.graphT;
import edu.handong.csee.java.javaFinalProject.datamodel.summaryT;

public class ExcelReader {

	public ArrayList<String> getData(String path) {
		ArrayList<String> values = new ArrayList<String>();

		System.out.println(path);

		try (InputStream inp = new FileInputStream(path)) {
			// InputStream inp = new FileInputStream("workbook.xlsx");

			Workbook wb = WorkbookFactory.create(inp);
			Sheet sheet = wb.getSheetAt(0);
			Row row = sheet.getRow(2);
			Cell cell = row.getCell(1);
			if (cell == null)
				cell = row.createCell(3);

			values.add(cell.getStringCellValue());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return values;
	}

	public ArrayList<summaryT<String>> getSummaryData(InputStream is,String name) {
		ArrayList<summaryT<String>> sum = new ArrayList<summaryT<String>>();

		try (InputStream inp = is) {
			// InputStream inp = new FileInputStream("workbook.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(inp);
			XSSFSheet sheet = wb.getSheetAt(0);

			int rows = sheet.getPhysicalNumberOfRows();
			String id = name;//.split(".")[0];

			for (int a = 1; a < rows; a++) {
				summaryT<String> sm = new summaryT<String>(id);
				// sm.setTitle();
				if (sheet.getRow(a) == null)
					break;

				XSSFRow row = sheet.getRow(a);

				if (row.getCell(0) == null || row.getCell(1) == null || row.getCell(2) == null || row.getCell(3) == null
						|| row.getCell(4) == null || row.getCell(5) == null || row.getCell(6) == null)
					break;

				XSSFCell cell0 = row.getCell(0);
				XSSFCell cell1 = row.getCell(1);
				XSSFCell cell2 = row.getCell(2);
				XSSFCell cell3 = row.getCell(3);
				XSSFCell cell4 = row.getCell(4);
				XSSFCell cell5 = row.getCell(5);
				XSSFCell cell6 = row.getCell(6);

//				if (row.getCell(5) == null)
//					break;

				sm.setTitle((String.valueOf(row.getCell(0))));
				sm.setSummarys((String.valueOf(row.getCell(1))));
				sm.setKeyword((String.valueOf(row.getCell(2))));
				sm.setDate((String.valueOf(row.getCell(3))));
				sm.setLink((String.valueOf(row.getCell(4))));
				sm.setSourse((String.valueOf(row.getCell(5))));
				sm.setCopyRight((String.valueOf(row.getCell(6))));

				// System.out.println(">>> getSummaryData sm [" + a + "] " + sm.toString());

				sum.add(sm);
			}
			wb.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("E>>"+sum.get(0));

		System.out.println("==== getSummaryData sum :: " + sum.size());

		for (int i = 0; i < sum.size(); i++) {
			System.out.println("==== getSummaryData [" + i + "]" + sum.get(i).toString());

		}

		return sum;
	}

	public ArrayList<graphT<String>> getGraphData(InputStream is,String name) {
		ArrayList<graphT<String>> grp = new ArrayList<graphT<String>>();

		try (InputStream inp = is) {
			XSSFWorkbook wb = new XSSFWorkbook(inp);
			XSSFSheet sheet = wb.getSheetAt(0);

			int rows = sheet.getPhysicalNumberOfRows();
			System.out.println("--------------------------rows : "+rows);
			String id = name;//.split(".")[0];
			for (int a = 2; a < rows; a++) {

				graphT<String> gr = new graphT<String>(id);
				

//				if (sheet.getRow(a) == null)
//					break;

				XSSFRow row = sheet.getRow(a);

				if (row.getCell(0) == null || row.getCell(1) == null || row.getCell(2) == null || row.getCell(3) == null
						|| row.getCell(4) == null)	continue;


				XSSFCell cell0 = row.getCell(0);
				XSSFCell cell1 = row.getCell(1);
				XSSFCell cell2 = row.getCell(2);
				XSSFCell cell3 = row.getCell(3);
				XSSFCell cell4 = row.getCell(4);

				gr.setTitle((String.valueOf(row.getCell(0))));
				gr.setNumber((String.valueOf(row.getCell(1))));
				gr.setType((String.valueOf(row.getCell(2))));
				gr.setComment((String.valueOf(row.getCell(3))));
				//gr.setPage(cell4.getStringCellValue());
				gr.setPage((String.valueOf(row.getCell(4))));

				/*
				 * System.out.println("cell0 : "+ gr.getTitle()); System.out.println("cell1 : "+
				 * gr.getNumber()); System.out.println("cell2 : "+ gr.getType());
				 * System.out.println("cell3 : "+ gr.getComment());
				 * System.out.println("cell4 : "+ gr.getPage());
				 */

				grp.add(gr);

			}

			wb.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("==== getGraphData grp :: " + grp.size());

		for (int i = 0; i < grp.size(); i++) {
			System.out.println("==== getGraphData [" + i + "]" + grp.get(i).toString());

		}
		return grp;
	}
}
