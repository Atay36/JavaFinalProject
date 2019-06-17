package edu.handong.csee.java.javaFinalProject.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;

import edu.handong.csee.java.javaFinalProject.datamodel.graphT;
import edu.handong.csee.java.javaFinalProject.datamodel.summaryT;

public class Utils {

	public static ArrayList<summaryT<String>> ZipReaderSummary(String path) {
		ZipFile zipFile;
		ArrayList<summaryT<String>> summarys = new ArrayList<summaryT<String>>();

		try {
			zipFile = new ZipFile(path, "euc-kr");

			Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries();

			while (entries.hasMoreElements()) {
				ZipArchiveEntry entry = entries.nextElement();
				InputStream stream1 = zipFile.getInputStream(entry);

				System.out.println(">>>> ZipReaderSummary summarys : " + entry.getName());
				if (entry.getName().indexOf("(요약문)") < 1)
					continue;

				ExcelReader myReader1 = new ExcelReader();

				summarys = myReader1.getSummaryData(stream1);

				if (summarys == null) {
					System.out.println(">>>> ZipReaderSummary summarys null~~~ ");
					// 여기에서 예외처리 (User Exception)

				} else {
					System.out.println(">>>> ZipReaderSummary summarys :: " + summarys.size());

					for (int i = 0; i < summarys.size(); i++) {
						System.out.println(">>>> ZipReaderSummary [" + i + "]" + summarys.get(i).toString());

					}
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("==== ZipReaderSummary summarys :: " + summarys.size());
		return summarys;
	}

	public static ArrayList<graphT<String>> ZipReaderGraph(String path) {
		ZipFile zipFile;
		ArrayList<graphT<String>> graphs = new ArrayList<graphT<String>>();

		try {
			zipFile = new ZipFile(path, "euc-kr");

			Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries();

			while (entries.hasMoreElements()) {
				ZipArchiveEntry entry = entries.nextElement();
				InputStream stream1 = zipFile.getInputStream(entry);

				System.out.println(">>>> ZipReaderGraph graphs : " + entry.getName());
				if (entry.getName().indexOf("(표.그림)") < 1)
					continue;

				ExcelReader myReader1 = new ExcelReader();

				graphs = myReader1.getGraphData(stream1);

				if (graphs == null) {
					System.out.println(">>>> ZipReaderGraph graphs null~~~ ");
					// 여기에서 예외처리 (User Exception)

				} else {
					System.out.println(">>>> ZipReaderGraph graphs :: " + graphs.size());

					for (int i = 0; i < graphs.size(); i++) {
						System.out.println(">>>> ZipReaderGraph [" + i + "]" + graphs.get(i).toString());

					}
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("==== ZipReaderGraph graphs :: " + graphs.size());
		return graphs;
	}
}
