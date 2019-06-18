package edu.handong.csee.java.javaFinalProject.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import edu.handong.csee.java.javaFinalProject.datamodel.GraphT;
import edu.handong.csee.java.javaFinalProject.datamodel.SummaryT;

public class Utils {

	public static ArrayList<SummaryT<String>> ZipReaderSummary(String path, String id) {
		ZipFile zipFile;
		ArrayList<SummaryT<String>> list = new ArrayList<SummaryT<String>>();

		try {
			zipFile = new ZipFile(path, "EUC-KR");

			Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries();

			while (entries.hasMoreElements()) {
				ZipArchiveEntry entry = entries.nextElement();
				InputStream stream1 = zipFile.getInputStream(entry);

				System.out.println(">>>> ZipReaderSummary summarys : " + entry.getName());
				if (entry.getName().indexOf("(요약문)") < 1)
					continue;

				ExcelReader myReader1 = new ExcelReader();

				list = myReader1.getSummaryData(stream1, id);

				if (list == null || list.size() < 1) {
					throw new MyException(path);
				}
				System.out.println("==== ZipReaderSummary summarys :: " + list.size());

			}
			
		} catch (Exception e) {
			System.out.println("==== ZipReaderSummary Exception : " + e.toString());
		}
		return list;
	}

	public static ArrayList<GraphT<String>> ZipReaderGraph(String path, String id) throws Exception{
		ZipFile zipFile;
		ArrayList<GraphT<String>> list = new ArrayList<GraphT<String>>();

		try {
			zipFile = new ZipFile(path, "EUC-KR");

			Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries();

			while (entries.hasMoreElements()) {
				ZipArchiveEntry entry = entries.nextElement();
				InputStream stream1 = zipFile.getInputStream(entry);

				System.out.println(">>>> ZipReaderGraph graphs : " + entry.getName());
				if (entry.getName().indexOf("(표.그림)") < 1)
					continue;

				ExcelReader myReader1 = new ExcelReader();

				list = myReader1.getGraphData(stream1, id);
				
				if (list == null || list.size() < 1) {
					throw new MyException(path);
				}
				System.out.println("==== ZipReaderGraph summarys :: " + list.size());

			}
			
		} catch (Exception e) {
			System.out.println("==== ZipReaderGraph Exception : " + e.toString());
		}
		return list;
	}

	public static void writeexcelSummary(ArrayList<SummaryT<String>> list, String resultPath) {
		String path = "";

		path = resultPath.replace(".xlsx", "1.xlsx");
		// String path = "./result1.xlsx"; // 저장할 파일 경로
		try {
			File file = new File(path);
			FileOutputStream fileout = new FileOutputStream(file);

			XSSFWorkbook hworkbook = new XSSFWorkbook();
			XSSFSheet sheet = hworkbook.createSheet("theaterList"); // sheet 생성

			XSSFRow curRow;

			int row = list.size(); // list 크기

			curRow = sheet.createRow(0); // row 생성
			curRow.createCell(0).setCellValue("학생"); // row에 각 cell에 저장
			curRow.createCell(1).setCellValue("제목");
			curRow.createCell(2).setCellValue("요약문 (300자 내외)");
			curRow.createCell(3).setCellValue("핵심어 (keyword,쉽표로 구분)");
			curRow.createCell(4).setCellValue("조회날짜");
			curRow.createCell(5).setCellValue("실제자료조회 출처 (웹자료링크)");
			curRow.createCell(6).setCellValue("원출처 (기관명 등)");
			curRow.createCell(7).setCellValue("제작자 (Copyright 소유처)");

			for (int i = 0; i < row; i++) {
				curRow = sheet.createRow(i + 1); // row 생성
				curRow.createCell(0).setCellValue(list.get(i).getStudentId()); // row에 각 cell에 저장
				curRow.createCell(1).setCellValue(list.get(i).getTitle());
				curRow.createCell(2).setCellValue(list.get(i).getSummarys());
				curRow.createCell(3).setCellValue(list.get(i).getKeyword());
				curRow.createCell(4).setCellValue(list.get(i).getDate());
				curRow.createCell(5).setCellValue(list.get(i).getLink());
				curRow.createCell(6).setCellValue(list.get(i).getSourse());
				curRow.createCell(7).setCellValue(list.get(i).getCopyRight());
			}
			hworkbook.write(fileout); // 파일 쓰기
			hworkbook.close();
			fileout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static void writeexcelGraph(ArrayList<GraphT<String>> list, String resultPath) {

		String path = "";

		path = resultPath.replace(".xlsx", "2.xlsx");

		System.out.println("path : " + path);
		// String path = "./result.xlsx"; // 저장할 파일 경로
		try {
			File file = new File(path);
			FileOutputStream fileout = new FileOutputStream(file);

			XSSFWorkbook hworkbook = new XSSFWorkbook();
			XSSFSheet sheet = hworkbook.createSheet("theaterList"); // sheet 생성

			XSSFRow curRow;

			int row = list.size(); // list 크기

			curRow = sheet.createRow(0); // row 생성
			curRow.createCell(0).setCellValue("학생"); // row에 각 cell에 저장
			curRow.createCell(1).setCellValue("제목(반드시 요약문 양식에 입력한 제목과 같아야 함.)");
			curRow.createCell(2).setCellValue("표/그림 일련번호");
			curRow.createCell(3).setCellValue("자료유형(표,그림,…)");
			curRow.createCell(4).setCellValue("자료에 나온 표나 그림 설명(캡션)");
			curRow.createCell(5).setCellValue("자료가 나온 쪽번호");

			for (int i = 0; i < row; i++) {
				curRow = sheet.createRow(i + 1); // row 생성
				curRow.createCell(0).setCellValue(list.get(i).getStudentId()); // row에 각 cell에 저장
				curRow.createCell(1).setCellValue(list.get(i).getTitle());
				curRow.createCell(2).setCellValue(list.get(i).getNumber());
				curRow.createCell(3).setCellValue(list.get(i).getType());
				curRow.createCell(4).setCellValue(list.get(i).getComment());
				curRow.createCell(5).setCellValue(list.get(i).getPage());
			}
			hworkbook.write(fileout); // 파일 쓰기
			hworkbook.close();
			fileout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeError(ArrayList<String> list, String path) {

		try {
			File file = new File(path);
			FileOutputStream fileout = new FileOutputStream(file);

			XSSFWorkbook hworkbook = new XSSFWorkbook();
			XSSFSheet sheet = hworkbook.createSheet("theaterList"); // sheet 생성

			XSSFRow curRow;

			curRow = sheet.createRow(0); // row 생성
			curRow.createCell(0).setCellValue("Error 파일"); // row에 각 cell에 저장
			//curRow.createCell(1).setCellValue("Error 파일");
			
			System.out.println("errors : " + list);
			int i=1;
			for (String num : list) {
				curRow = sheet.createRow(i + 1); // row 생성
				curRow.createCell(0).setCellValue(num); // row에 각 cell에 저장
				//curRow.createCell(1).setCellValue(num);
				i++;
			}
			hworkbook.write(fileout); // 파일 쓰기
			hworkbook.close();
			fileout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
