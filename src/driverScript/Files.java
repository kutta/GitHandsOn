package driverScript;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.opencsv.CSVReader;

public class Files {
	
	final static Logger Log = Logger.getLogger(Files.class.getName());
	
	public static ArrayList<String> arrayList = new ArrayList<String>();
	
	public static CSVReader csvReader = null ;
	public static String csvFile = null;
	
	public static void main(String[] args) throws IOException {
		
		try {
			
			String value = null;
			String[] csvCell;
			
			csvFile = System.getProperty("user.dir") + "\\testdata\\file.csv";
			
			csvReader = new CSVReader(new FileReader(csvFile));
			
			arrayList.clear();
			
			while((csvCell = csvReader.readNext()) != null) {
				
				value = csvCell[1];
				
				arrayList.add(value);
				
			}
			
			String name = arrayList.get(0);
			System.out.println("Name :"+name);
			
		}catch(Exception e) {
			
			throw (e);
			
		}
		
		
		
		
	}

}
