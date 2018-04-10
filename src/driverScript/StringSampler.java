package driverScript;

import java.io.IOException;

public class StringSampler {
	
	public static void main(String[] args) throws IOException {
		
		String mainArray = "koushic,kannan,priya,avantika,Doctor";
		
		String[] array = mainArray.split(",");
		
		for(int i =0; i < array.length; i++) {
			
			System.out.println(array[i]);
			
			
		}
	
	}

}
