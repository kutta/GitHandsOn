package com.qa.javaHandsOn;

import com.opencsv.CSVReader;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Logger;

public class Files {
	
	final static Logger Log = Logger.getLogger(Files.class.getName());
	
	public static ArrayList<String> arrayList = new ArrayList<String>();
	
	public static CSVReader csvReader = null ;
	public static String csvFile = null;
	
	public static BufferedReader breader = null;
	public static BufferedWriter bwriter = null;
	
	public static void main(String[] args) throws Exception{
		
		openCsvTest();
		/* sortTextFile(); */
	}
	
	public static void openCsvTest() throws Exception {
		
		try {
			
			String value = null;
			String[] csvCell;
			
			csvFile = System.getProperty("user.dir") + "\\testdata\\file.csv";
			
			csvReader = new CSVReader(new FileReader(csvFile));
			
			arrayList.clear();
			
			while((csvCell = csvReader.readNext()) != null) {
				
				value = csvCell[1];
				
				arrayList.add(value);
				System.out.println("Value :: "+value);
				
			}
			
			String name = arrayList.get(2);
			System.out.println("Name : "+name);
			
		}catch(Exception e) {
			
			throw (e);
			
		}
		
		
		
		
	}

	public static void sortTextFile() throws IOException{
		
		try {
			
			breader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\testdata\\Sample.txt"));
			
			String currentLine = breader.readLine();
			
			arrayList.clear();
			
			while(currentLine != null) {
				
				arrayList.add(currentLine);
				
				currentLine = breader.readLine();
			}
			
			Collections.sort(arrayList);
			
			bwriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\testdata\\Sample.txt"));
			
			for (String line : arrayList) {

				bwriter.write(line);
				bwriter.newLine();

			}
			System.out.println("Sorting Done");
		}catch(Exception e) {
			
			e.printStackTrace();
		}finally {
			try {
				if(breader != null) {
					breader.close();
				}
				if(bwriter != null) {
					bwriter.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
