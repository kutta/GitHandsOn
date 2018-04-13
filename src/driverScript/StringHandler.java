package driverScript;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StringHandler {
	
	public static void main(String[] args) throws IOException{
		
		List<String> al = new ArrayList<String>();
		BufferedReader bufferReader = null ;
		StringBuffer stringBuff = null ;
		
		String readValue ;
		
		try {
			bufferReader = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\testdata\\Sample.txt"));
			
			while((readValue = bufferReader.readLine()) != null) {
				
				readValue.length();
				
				System.out.println(readValue);
				
			}
			
			bufferReader.close();
			
			/*stringBuff = new StringBuffer("KoushicKannan");
			stringBuff.replace(4, 6, "hi");
			
			System.out.println(stringBuff);*/
			
			String str = "5000";
			int iTest = Integer.parseInt(str);
			System.out.println("Arithmetic Operation on Int: " + (iTest/4));
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
	}

}
