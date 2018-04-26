package driverScript;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class StringSampler {

	public static void main(String[] args) throws IOException {

		/*String mainArray = "My name is koushic Kannnan ";
		String sumArray = "Passed=40 Failed=20 Skipped=15";
		String s = "Koushic kannan";*/

		/*longestString(mainArray);*/
		/*repeatingString(mainArray);*/
		/*sumString(sumArray);*/
		/*isPalindrome("koushic");*/
		
		/*smallestElement();
		largestElement();
		swapNumbers(4,5);
		*/
		/*reverseNumbers(1560);*/
		
		/*int arr[] ={11,22,3,34,9,19,234}; 
		bubbleSortAlgo(arr);*/
		
		/*stringTest(mainArray);*/
		
		/*reverseString(s);*/
		
		/*CountCharacterOccurence("Koushick Kannan");*/
		
		/*repeatedWordsinTextFile();*/
		/*wordCountInFile();*/
		
		/*fileWriterEx();*/
		
		/*firstRepeatedNonRepeatedChar("Koushicannan");*/
		
		/*swapTwoStrings("Koushic", "Priya");*/
		
		/*characterPercentage("Tiger Runs @ The Speed Of 100 km/hour.");
		characterPercentage("My e-mail : eMail_Address321@anymail.com");*/
		
		replaceSpecificStr("75", "105");

	}

	public static void longestString(String stringKey) throws IOException {

		String[] str = stringKey.split(" ");
		String rt = " ";

		for (int i = 0; i < str.length; i++) {

			if (str[i].length() >= rt.length()) {

				rt = str[i];

			}
		}

		System.out.println("Longest word - " + rt);
		System.out.println("Longest word length - " + rt.length());

	}

	public static void repeatingString(String repeatStr) throws IOException {

		int len = repeatStr.length();

		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
		
		char[] ch = repeatStr.toCharArray();
		
		for(char c : ch) {
			
			if(hashMap.containsKey(c)) {
				
				hashMap.put(c, hashMap.get(c)+1);
			}
			
			else {
				
				hashMap.put(c, 1);
			}
		}

		

		/*System.out.println(hashMap);*/
		
		Set<Character> charInString = hashMap.keySet();
		
		for(char cha : charInString) {
			
			if(hashMap.get(cha) > 1) {
				
				System.out.println(cha+" : "+hashMap.get(cha));
			}
		}

	}

	public static void sumString(String sumStr) throws IOException {

		String[] space = sumStr.split(" ");

		String[] pass = space[0].split("=");
		String[] fail = space[1].split("=");
		String[] skip = space[2].split("=");

		int passvalue = Integer.valueOf(pass[1]);
		int failvalue = Integer.valueOf(fail[1]);
		int skipvalue = Integer.valueOf(skip[1]);

		System.out.println("Total Sum :: " + (passvalue + failvalue + skipvalue));

	}
	
	public static void isPalindrome(String str) throws IOException{
		
		int len = str.length();
		String rev = "";
		
		for(int i= len - 1;i>=0;i--) {
			
			rev = rev + str.charAt(i);
			
		}
			
			if(str.equals(rev)){
				
				System.out.println(str + " is a Palindrome");
				
			}else {
				System.out.println(str + " is not Palindrome");
			}
		}
	
	public static void smallestElement() throws IOException{
		
		int small;
		int a[] = {12,45,9,34,112,22,5};
		
		
		int size = a.length;
		
		/*System.out.println(size);*/
		
		small = a[0];
		
		for(int i=0;i<size;i++) {
			
			if(small > a[i]) {
				
				small = a[i];
			}
		}
		
		System.out.println("Smallest element :: "+ small);
	}
	
	public static void largestElement() throws IOException{
		
		int small;
		int a[] = {12,45,9,34,112,22,5};
		
		
		int size = a.length;
		
		/*System.out.println(size);*/
		
		small = a[0];
		
		for(int i=0;i<size;i++) {
			
			if(small < a[i]) {
				
				small = a[i];
			}
		}
		
		System.out.println("Largest element :: "+ small);
	}

	public static void swapNumbers(int num1, int num2) throws IOException{
		
		int swap;
		
		System.out.println("Before swapping :: num1 ::"+num1 +" num2:: "+ num2);
		
		swap = num1;
		num1 = num2;
		num2 = swap;
		
		System.out.println("After swapping :: num1 ::"+num1 +" num2:: "+ num2);
		
		
	}
	
	public static void reverseNumbers(int num) throws IOException{
		
		int r, re =0;
		
		while(num !=0) {
			
			r = num%10;
			re = re*10 +r ;
			num = num/10;
		}
		
		System.out.println("Reverse :: "+re);
	}

	
	public static void bubbleSortAlgo(int arr[]) throws IOException{
		
		int n = arr.length;
		
		int temp =0;
		
		for(int i=0; i<n -1; i++) {
			
			for(int j=0; j<(n-i-1);j++) {
				
				if(arr[j] > arr[j+1]) {
					
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;					
					
				}				
				
			}
					
			
		}
		
		for(int m=0;m<n;m++) {
			
			System.out.print(arr[m]+" ");
			System.out.println();
		}
		
		
	}

	
	public static void stringTest(String str) throws IOException{
		
		String[] s = str.split(" ");
		
				
		int len = s.length;
		
		for(int i=0;i<len;i++) {
			
			char first = s[i].charAt(0);
			
			System.out.println(first);
		}
		
	}
	
	public static void reverseString(String s) throws IOException{
		
		
		
		String revStr = "";
		
		String[] words = s.split(" ");
		
		for(int i = 0;i<words.length;i++) {
			
			String word = words[i];
			
			String revWord = "";
			
			for(int j=word.length()-1;j>=0;j--) {
				
				revWord = revWord + word.charAt(j);
				
			}
			
			revStr = revStr + revWord + " ";
		}
		
		System.out.println(revStr);
	}
	
	public static void CountCharacterOccurence(String str) throws IOException{
		
		/*char ch = 'k';*/
		
		int count = str.length() - str.replaceAll("k", "").length();
		
		System.out.println(count);
	}
	
	public static void repeatedWordsinTextFile() throws IOException{
		
		HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
		
		BufferedReader buffer = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\testdata\\Sample.txt"));
		
		String curLine = buffer.readLine();
		
		while(curLine != null) {
			
			String[] words = curLine.toLowerCase().split(" ");
			
			for(String word : words) {
				
				if(wordCount.containsKey(word)) {
					
					wordCount.put(word, wordCount.get(word)+1);
				}
				else {
					wordCount.put(word, 1);
				}
				
				
			}
			curLine =buffer.readLine();
			
		}
		
		
		
		String repeatedWord = null;
		int count = 0;
		
		Set<Entry<String, Integer>> entrySet = wordCount.entrySet();
		
		for(Entry<String, Integer> entry : entrySet) {
			
			if(entry.getValue() > count) {
				
				repeatedWord = entry.getKey();
				count = entry.getValue();
			}
		}
		
		System.out.println("The most repeated word in input file is : "+repeatedWord);
        
        System.out.println("Number Of Occurrences : "+count);
        
        buffer.close();
		
	}
	
	public static void wordCountInFile() throws IOException{
		
		try {
			
			BufferedReader buffer = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\testdata\\Sample.txt"));
			
			int charCount = 0;
			int wordCount = 0;
			int lineCount = 0;
			
			String currentLine = buffer.readLine();
			
			System.out.println("current line :: "+currentLine);
			
			while(currentLine != null) {
				
				lineCount++;
				
				String[] words = currentLine.split(" ");
				
				wordCount = wordCount + words.length;
				
				for(String word : words) {
					
					charCount = charCount + word.length();
				}
				currentLine = buffer.readLine();
			}
			
			System.out.println("Number Of Chars In A File : "+charCount);
            
            System.out.println("Number Of Words In A File : "+wordCount);
             
            System.out.println("Number Of Lines In A File : "+lineCount);
            
            buffer.close();
            
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public static void fileWriterEx() throws IOException{
		
		try {
			
			/*Open an existing text file in an append mode by passing ‘true’ while constructing the FileWriter object.*/
			FileWriter fileWriter = new FileWriter(System.getProperty("user.dir") + "\\testdata\\Sample.txt", true);
			
			/*Bundle FileWriter object in BufferedWriter if you are writing lots of text.*/
			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
			
			/*Use PrintWriter object if you are writing the text in multiple lines by wrapping BufferedWriter object in PrintWriter.*/
			PrintWriter printWriter = new PrintWriter(bufferWriter);
			
			/*Use printWriter.println() method to write each line into a file.*/
			printWriter.println();
			
			printWriter.println("Hewlett Packard");
			printWriter.println("Aricent");
			printWriter.println("Object Technologies");
			printWriter.println("Amdocs");
			
			
			System.out.println("Writing Done");
			
			printWriter.close();
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void firstRepeatedNonRepeatedChar(String str) throws IOException{
		
		try {
			
			HashMap<Character, Integer> charCountmap = new HashMap<Character, Integer>();
			
			char[] chars = str.toCharArray();
			
			for(char c : chars) {
				
				if(charCountmap.containsKey(c)) {
					
					charCountmap.put(c, charCountmap.get(c)+1);
				}
				else {
					charCountmap.put(c, 1);
				}
				
			}
			
			for(char c : chars) {
				
				if(charCountmap.get(c) == 1) {
					
					System.out.println("First Non-Repeated Character In '"+str+"' is '"+c+"'");
	                 
	                break;
				}
			}
			
			for(char c : chars) {
				
				if(charCountmap.get(c) > 1) {
					
					System.out.println("First Repeated Character In '"+str+"' is '"+c+"'");
	                 
	                break;
				}
			}
			
			
		}catch (Exception e) {
			
			
		}
	}
	
	public static void swapTwoStrings(String str1, String str2) throws IOException{
		
		try {
			
			/*Before Swappin*/
			
			System.out.println("String 1 :: "+str1);
			System.out.println("String 2 :: "+str2);
			
			str1 = str1 + str2;
			str2 = str1.substring(0, str1.length()-str2.length());
			str1 = str1.substring(str2.length());
			
			/*After Swappin*/
			
			System.out.println("String 1 :: "+str1);
			System.out.println("String 2 :: "+str2);
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public static void characterPercentage(String inputString) throws IOException{
		
		try {
			
			int totalChars = inputString.length();
			
			int upperChars = 0;
			int lowerChars = 0;
			int digitCount = 0;
			
			int others = 0;
			
			
			
			for(int i=0; i<inputString.length();i++) {
				
				char ch = inputString.charAt(i);
				
				if(Character.isUpperCase(ch)) {
					
					upperChars++;
				}
				
				else if(Character.isLowerCase(ch)) {
					
					lowerChars++;
				}
				
				else if(Character.isDigit(ch)) {
					
					digitCount++;
				
				}
				else {
					others++;
				}
			}
				
				//Calculating percentage of uppercase letters, lowercase letters, digits and other characters
				System.out.println("In '"+inputString+"' : ");
				
				double upperPercentage = (upperChars * 100.0) / totalChars;
				double lowerPercentage = (lowerChars * 100.0) / totalChars;
				double digitPercentage = (digitCount * 100.0) / totalChars;
				double othersPercentage = (others * 100.0) / totalChars;
				
				DecimalFormat formatter = new DecimalFormat("##.##");
				
				System.out.println("UpperChar Percentage :: "+formatter.format(upperPercentage)+"%");
				System.out.println("LowerChar Percentage :: "+formatter.format(lowerPercentage)+"%");
				System.out.println("Digit Percentage :: "+formatter.format(digitPercentage)+"%");
				System.out.println("Special character Percentage :: "+formatter.format(othersPercentage)+"%");
				
				System.out.println("-----------------------------");
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	public static void replaceSpecificStr(String oldStr, String newStr) throws IOException{
		
		File file = new File(System.getProperty("user.dir") + "\\testdata\\StudentFile.txt");
		
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		
		String oldContent = "";
		
		String line = buffer.readLine();
		
		while(line != null) {
			
			oldContent = oldContent+line+System.lineSeparator();
			
			line = buffer.readLine();
		}
		
		String newContent = oldContent.replaceAll(oldStr, newStr);
		
		FileWriter writer = new FileWriter(file);
		
		writer.write(newContent);
		
		writer.close();
		
		System.out.println("Done");
	}
}
