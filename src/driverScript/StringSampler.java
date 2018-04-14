package driverScript;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class StringSampler {

	public static void main(String[] args) throws IOException {

		String mainArray = "My name is koushic Kannnan ";
		String sumArray = "Passed=40 Failed=20 Skipped=15";
		
		/*longestString(mainArray);
		repeatingString(mainArray);*/
		sumString(sumArray);

	}

	public static void longestString(String stringKey) throws IOException {

		String[] str = stringKey.split(" ");
		String rt = " ";

		for (int i = 0; i < str.length; i++) {

			if (str[i].length() >= rt.length()) {

				rt = str[i];

			}
		}
		
		System.out.println("Longest word - "+rt);
		System.out.println("Longest word length - "+rt.length());

	}
	
	public static void repeatingString(String repeatStr) throws IOException{
		
		int len = repeatStr.length();
		
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
		
		for(int i=0;i<len;i++) {
			
			char charAt = repeatStr.charAt(i);
			
			if(!hashMap.containsKey(charAt)) {
				
				hashMap.put(charAt, 1);
			}else {
				
				hashMap.put(charAt, hashMap.get(charAt) +1);
			}
		}
		
		System.out.println(hashMap);
		
	}
	
	
	public static void sumString(String sumStr) throws IOException {
		
		ArrayList<String> al = new ArrayList<String>();
		String[] space = sumStr.split(" ");
		
		
		String[] pass = space[0].split("=");
		String[] fail = space[1].split("=");
		String[] skip = space[2].split("=");
		
		int passvalue = Integer.valueOf(pass[1]);
		int failvalue = Integer.valueOf(fail[1]);
		int skipvalue = Integer.valueOf(skip[1]);
		
		System.out.println("Total Sum :: "+( passvalue+failvalue+skipvalue));
		
		
	    
	    
	   
	}

}
