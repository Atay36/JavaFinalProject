package edu.handong.csee.java.javaFinalProject.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;

import edu.handong.csee.java.javaFinalProject.datamodel.graphT;
import edu.handong.csee.java.javaFinalProject.datamodel.summaryT;

public class ZipReader {

	
	public static void main(String[] dataPath) {
		ZipReader zipReader = new ZipReader();
		zipReader.run(dataPath);
	}
	

	private void run(String[] dataPath) {
		//String path = dataPath[0];
		
		readFileInZip("/Users/yeeunlee/git/JavaFinalProject/0001.zip","");
		
	}

	public void readFileInZip(String path,String name) {
		ZipFile zipFile;
		ArrayList<summaryT<String>> summarys = new ArrayList<summaryT<String>>();
		ArrayList<graphT<String>> graphs = new ArrayList<graphT<String>>();

		
		try {
			zipFile = new ZipFile(path);
			Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries();

		    while(entries.hasMoreElements()){
		    	ZipArchiveEntry entry = entries.nextElement();
		        InputStream stream1 = zipFile.getInputStream(entry);
		        InputStream stream2 = zipFile.getInputStream(entry);

		    
		        ExcelReader myReader1 = new ExcelReader();
		        ExcelReader myReader2 = new ExcelReader();

		        
		        summarys = myReader1.getSummaryData(stream1,name);
		        //System.out.println(">>"+summarys.);
		        
		        //for(summary value : summarys) {
		        	System.out.println(">>"+summarys.toString());
		        	//System.out.println(">>"+value.getTitle());
		        	//System.out.println(">>"+value.getSummarys());

		        //}
		        
		        graphs = myReader2.getGraphData(stream2,name);
		        //System.out.println(">>"+summarys.);
		        
		        for(graphT<String> value : graphs) {
		        	System.out.println(">>"+value.getStudentId());
		        	System.out.println(">>"+value.getTitle());
		        	System.out.println(">>"+value.getNumber());

		        }
		        
		        
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
