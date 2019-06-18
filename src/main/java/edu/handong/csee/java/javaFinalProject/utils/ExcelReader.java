package edu.handong.csee.java.javaFinalProject.utils;

import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import edu.handong.csee.java.javaFinalProject.datamodel.GraphT;
import edu.handong.csee.java.javaFinalProject.datamodel.SummaryT;

public class ExcelReader {

	public ArrayList<SummaryT<String>> getSummaryData(InputStream is,String name) throws Exception{

		ArrayList<SummaryT<String>> list = new ArrayList<SummaryT<String>>();

		try (InputStream inp = is) {
			XSSFWorkbook wb = new XSSFWorkbook(is);
			XSSFSheet sheet = wb.getSheetAt(0);

			int rows = sheet.getPhysicalNumberOfRows();

			String id = name;

			for (int a = 1; a < rows; a++) {
				SummaryT<String> data = new SummaryT<String>(id);
				XSSFRow row = sheet.getRow(a);

				data.setTitle((String.valueOf(row.getCell(0))));
				data.setSummarys((String.valueOf(row.getCell(1))));
				data.setKeyword((String.valueOf(row.getCell(2))));
				data.setDate((String.valueOf(row.getCell(3))));
				data.setLink((String.valueOf(row.getCell(4))));
				data.setSourse((String.valueOf(row.getCell(5))));
				data.setCopyRight((String.valueOf(row.getCell(6))));

				System.out.println("==== getSummaryData data [" + a + "] " + data.toString());

				if (row.getCell(0) == null 
						|| row.getCell(1) == null 
						|| row.getCell(2) == null 
						|| row.getCell(3) == null
						|| row.getCell(4) == null
						|| row.getCell(5) == null
						|| row.getCell(6) == null) {
					break;
				}
				
				if (row.getCell(0).toString().isEmpty() 
						|| row.getCell(1).toString().isEmpty()
						|| row.getCell(2).toString().isEmpty() 
						|| row.getCell(3).toString().isEmpty()
						|| row.getCell(4).toString().isEmpty()
						|| row.getCell(5).toString().isEmpty()
						|| row.getCell(6).toString().isEmpty()) {
					break;
				}

				list.add(data);
			} // for rows
			
			wb.close();

			if (list.size() != (rows-1)) {
				list.clear();
			}
		} catch (Exception e) {
			System.out.println("==== getSummaryData MyException : " + e.toString());
		}

		System.out.println("==== getSummaryData list :: " + list.size());

		return list;
	}

	public ArrayList<GraphT<String>> getGraphData(InputStream is,String name) {
		
		ArrayList<GraphT<String>> list = new ArrayList<GraphT<String>>();

		try (InputStream inp = is) {
			XSSFWorkbook wb = new XSSFWorkbook(inp);
			XSSFSheet sheet = wb.getSheetAt(0);

			int rows = sheet.getPhysicalNumberOfRows();

			String id = name;

			for (int a = 2; a < rows; a++) {

				GraphT<String> data = new GraphT<String>(id);
				XSSFRow row = sheet.getRow(a);

				data.setTitle((String.valueOf(row.getCell(0))));
				data.setNumber((String.valueOf(row.getCell(1))));
				data.setType((String.valueOf(row.getCell(2))));
				data.setComment((String.valueOf(row.getCell(3))));
				data.setPage((String.valueOf(row.getCell(4))));

				System.out.println("==== getGraphData data [" + a + "] " + data.toString());

				if (row.getCell(0) == null 
						|| row.getCell(1) == null 
						|| row.getCell(2) == null 
						|| row.getCell(3) == null
						|| row.getCell(4) == null) {
					break;
				}
				
				if (row.getCell(0).toString().isEmpty() 
						|| row.getCell(1).toString().isEmpty()
						|| row.getCell(2).toString().isEmpty() 
						|| row.getCell(3).toString().isEmpty()
						|| row.getCell(4).toString().isEmpty()) {
					break;
				}

				list.add(data);
			} // for rows

			wb.close();

			if (list.size() != (rows-2)) {
				list.clear();
			}


		} catch (Exception e) {
			System.out.println("==== getGraphData MyException : " + e.toString());
		}

		System.out.println("==== getGraphData list :: " + list.size());

		return list;
	}
}
