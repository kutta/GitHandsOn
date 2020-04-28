package com.qa.javaHandsOn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TestJava {

	public static void main(String[] args) throws IOException {

		/* largestElement(); */

		/* isPalindrome("MoM"); */
		/* wordCountInFile(); */

		/* swapNumbers(); */

		/* countWords("Ariella Ferrera"); */
		/* countCharacters("Syren De Merr"); */

		/*
		 * int arr[] = {6,1290,289,800,49,776,766,10}; largestNumber(arr);
		 */

		/* sortArrayNum(arr); */

		/* duplicateCharacters("volvo grup"); */

		/* fibonacciSeries(15); */

		/* isPrime(8); */

		/* pattern01(1); */

		/* stringRotation("koushickannan", "kannankoushic"); */
		/* revStringPreservingSpace("my favourite is ariella ferrara"); */

		/*
		 * arraylistToArray();
		 * 
		 * arrayToArraylist();
		 */

		/* patternMatching(4); */
		 
		/* subStringProgram("koushic"); */
		 
		/*
		 * int[] arrayA = new int[] {7, -5, 3, 8, -4, 11, -19, -21};
		 * 
		 * int[] arrayB = new int[] {6, 13, -7, 0, 11, -4, 3, -5};
		 * 
		 * int[] mergerArr = mergeArray(arrayA, arrayB);
		 * System.out.println(Arrays.toString(mergerArr));
		 */
	        
	        reverseString("Brandi Love");

	}

	public static void largestElement() throws IOException {

		int large;
		int a[] = { 12, 150, 9, 34, 112, 22, 5 };

		int size = a.length;

		large = a[0];

		for (int i = 0; i < size; i++) {

			if (large < a[i]) {

				large = a[i];
			}
		}

		System.out.println("largest number : " + large);

	}

	public static void isPalindrome(String str) throws IOException {

		/*
		 * String str1 = str.toLowerCase(); int len = str1.length();
		 * 
		 * String rev = "";
		 * 
		 * for (int i = len - 1; i >= 0; i--) {
		 * 
		 * rev = rev + str1.charAt(i); } System.out.println(rev);
		 * 
		 * if (str1.equals(rev)) {
		 * 
		 * System.out.println("Palindrome"); } else {
		 * System.out.println("Not Palindrome"); }
		 */
		String rev = "";
		String str1 = str.toLowerCase();
		int len = str1.length();
		char chars[] = str1.toCharArray();

		for (int i = len - 1; i >= 0; i--) {
			System.out.print(chars[i]);
			rev = rev + chars[i];
		}

		if (str1.equals(rev)) {
			System.out.println("Palindrome");
		} else {
			System.out.println("Not a Palindrome");
		}
	}

	public static void wordCountInFile() throws IOException {

		try {

			BufferedReader buffer = new BufferedReader(
					new FileReader(System.getProperty("user.dir") + "\\testdata\\Sample.txt"));

			int charCount = 0;
			int wordCount = 0;
			int lineCount = 0;

			String currentline = buffer.readLine();

			while (currentline != null) {

				lineCount++;

				String[] words = currentline.split(" ");
				wordCount = wordCount + words.length;

				for (String word : words) {
					charCount = charCount + word.length();
				}
				currentline = buffer.readLine();
			}

			System.out.println("Number Of Chars In A File : " + charCount);

			System.out.println("Number Of Words In A File : " + wordCount);

			System.out.println("Number Of Lines In A File : " + lineCount);

			buffer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void swapNumbers() throws IOException {
		try {

			int x = 8, y = 6;

			System.out.println("Before Swapping\nx :" + x + "\ny :" + y);

			x = x + y;
			y = x - y;
			x = x - y;

			System.out.println("After Swapping\nx :" + x + "\ny :" + y);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void countWords(String str) throws IOException {

		try {

			String[] a = str.split(" ");

			HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

			for (int i = 0; i <= a.length - 1; i++) {

				if (hashMap.containsKey(a[i])) {

					hashMap.put(a[i], hashMap.get(a[i]) + 1);
				} else {
					hashMap.put(a[i], 1);
				}
			}

			System.out.println(hashMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void countCharacters(String str) throws IOException {

		try {

			HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();

			char[] ch = str.toLowerCase().toCharArray();

			for (char c : ch) {

				if (hashMap.containsKey(c)) {
					hashMap.put(c, hashMap.get(c) + 1);
				} else {
					hashMap.put(c, 1);
				}

				Set<Character> charInString = hashMap.keySet();

				for (char cha : charInString) {
					if (hashMap.get(cha) > 1) {

						System.out.println(cha + " : " + hashMap.get(cha));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void largestNumber(int arr[]) throws IOException {

		try {
			int largest = 0;
			int secondlargest = 0;
			int thirdlargest = 0;
			int fourthlargest = 0;
			System.out.println("Given Array : ");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + "\t");
			}

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > largest) {
					fourthlargest = thirdlargest;
					thirdlargest = secondlargest;
					secondlargest = largest;
					largest = arr[i];
				} else {
					if (arr[i] > secondlargest) {
						fourthlargest = thirdlargest;
						thirdlargest = secondlargest;
						secondlargest = arr[i];
					} else {
						if (arr[i] > thirdlargest) {
							fourthlargest = thirdlargest;
							thirdlargest = arr[i];
						} else {
							if (arr[i] > fourthlargest) {
								fourthlargest = arr[i];
							}
						}
					}
				}

			}
			System.out.println("First Largest number : " + largest);
			System.out.println("Second Largest number : " + secondlargest);
			System.out.println("Thrid Largest number : " + thirdlargest);
			System.out.println("Fourth Largest number : " + fourthlargest);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void duplicateCharacters(String str) throws IOException {

		try {

			String as = str.replaceAll(" ", "");
			int count = 0;

			char[] s = as.toCharArray();

			System.out.println("Duplicate characters are : ");

			for (int i = 0; i < as.length(); i++) {
				for (int j = i + 1; j < as.length(); j++) {

					if (s[i] == s[j]) {

						System.out.print(s[j]);
						count++;
						break;
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void fibonacciSeries(int num) throws IOException {
		try {

			int a = 0, b = 0, c = 1;

			for (int i = 0; i <= num; i++) {

				a = b;
				b = c;
				c = a + b;

				System.out.print(a + " ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void isPrime(int num) throws IOException {

		try {
			int temp;
			boolean isPrime = false;
			System.out.println("Entered number : " + num);

			for (int i = 2; i <= num / 2; i++) {

				temp = num % i;

				if (temp == 0) {

					isPrime = true;
					break;
				}
			}

			if (isPrime) {
				System.out.println(num + " is prime");

			} else {
				System.out.println(num + " is not prime");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void pattern01(int num) throws IOException {
		try {

			for (int i = 5; i >= num; i--) {
				for (int j = 5; j >= i; j--) {
					System.out.print(j + " ");
				}
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sortArrayNum(int arr[]) throws IOException {
		try {

			System.out.print("Array before sorting: ");
			System.out.println();
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}

			int temp;

			for (int i = 0; i < arr.length; i++) {
				for (int j = i; j > 0; j--) {

					if (arr[j] > arr[j - 1]) {
						temp = arr[j];
						arr[j] = arr[j - 1];
						arr[j - 1] = temp;
					}

				}

			}

			System.out.print("Array after sorting: ");
			System.out.println();
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void stringRotation(String str1, String str2) throws IOException {
		try {

			System.out.println("String 1 : " + str1);
			System.out.println("String 2 : " + str2);

			if (str1.length() != str2.length()) {
				System.out.println("String 2 is not rotated version of String 1");
			} else {

				String str3 = str1 + str1;

				if (str3.contains(str2)) {
					System.out.println("String 2 is rotated version of String 1");
				} else {
					System.out.println("String 2 is not rotated version of String 1");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void revStringPreservingSpace(String str) throws IOException {
		try {

			// Converting inputString to char array 'inputStringArray'

			char[] inputStringArray = str.toCharArray();

			// Defining a new char array 'resultArray' with same size as inputStringArray

			char[] resultArray = new char[inputStringArray.length];

			// First for loop :
			// For every space in the 'inputStringArray',
			// we insert spaces in the 'resultArray' at the corresponding positions

			for(int i = 0; i < inputStringArray.length; i++) {
				
				if(inputStringArray[i] == ' ') {
					
					resultArray[i] = ' ';
					
				}
			}

			// Initializing 'j' with length of resultArray

			int j = resultArray.length - 1;

			// Second for loop :
			// we copy every non-space character of inputStringArray
			// from first to last at 'j' position of resultArray

			for(int i = 0; i < inputStringArray.length; i++) {
				
				if(inputStringArray[i] != ' ') {
					
					if(resultArray[j] == ' ') {
						j-- ;
					}
					
					resultArray[j] = inputStringArray[i];
					j-- ;
				}
			}
			
			System.out.println(String.valueOf(resultArray));

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void arrayToArraylist() throws IOException {

		String arr[] = { "Koushic", "Kannan" };

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		ArrayList<String> al = new ArrayList<String>(Arrays.asList(arr));
		al.add("Priya");
		System.out.println(al);
	}

	public static void arraylistToArray() throws IOException {

		List<Integer> al = new ArrayList<Integer>();
		al.add(10);
		al.add(50);
		al.add(89);

		Integer[] arr = new Integer[al.size()];
		arr = al.toArray(arr);

		for (Integer x : arr) {
			System.out.println(x);
		}

	}

	public static void patternMatching(int num) throws IOException {

		try {

			/*
			 * for (int i = 1; i <= num; ++i) { for (int j = 1; j <= i; ++j) {
			 * System.out.print(j + " "); } System.out.println();
			 * 
			 * }
			 */

			

			for (int i = num; i >= 1; i--) {
				for (int j = num; j >= i; j--) {

					System.out.print(j);

				}
				 System.out.println(); 
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void subStringProgram(String str) throws IOException{
		try {
			
			int len = str.length();
			
			for(int i = 0; i < len ; i ++) {
				for(int j = i+1; j<=len; j++) {
					System.out.println(str.substring(i,j));
				}
			}
			
			StringBuilder sb = null;
			
			for(int i = 0 ; i < len ; i++) {
				
				sb = new StringBuilder().append(str.charAt(i));
				for(int j = i+1 ; j < len ; j++) {
					sb.append(str.charAt(j));
					System.out.println(sb);
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int[] mergeArray(int[] arr1, int[] arr2) throws IOException{
		
			
			//Step 1 : Merging of two arrays
	         
	        //Defining mergedArray with combined size of arrayA and arrayB
			int[] mergeArrays = new int[arr1.length + arr2.length];
			
			//Initializing pointers of arrayA, arrayB and mergedArray with 0
			int i = 0, j = 0 , k = 0;
			
			//Inserting all elements of arrayA into mergedArray
			while(i < arr1.length) {
				mergeArrays[k] = arr1[i];
				k++;
				i++;
			}
			
			//Inserting all elements of arrayB into mergedArray
			while(j < arr2.length) {
				mergeArrays[k] = arr2[j];
				k++;
				j++;
							}
			
			 //Step 2 : Removing duplicates from merged array
	         
	        //Defining one HashSet object called setWithNoDuplicates
	        //Remember, HashSet allows only unique elements
			Set<Integer> noDuplicates = new HashSet<Integer>();
			
			//Adding all elements of mergedArray into setWithNoDuplicates
			for(int m = 0 ; m < mergeArrays.length ; m ++) {
				
				noDuplicates.add(mergeArrays[m]);
			}
			
			//Now, setWithNoDuplicates will have only unique elements of mergedArray
	         
	        //So, now iterate setWithNoDuplicates and 
	        //add its elements into new array called mergedArrayWithNoDuplicates
			Iterator<Integer> ite = noDuplicates.iterator();
			
			int[] setWithNoDupl = new int[noDuplicates.size()];
			
			int n = 0;
			
			//Adding all elements of setWithNoDuplicates into mergedArrayWithNoDuplicates
			
			while(ite.hasNext()) {
				setWithNoDupl[n] = ite.next();
				n++;
			}
			
			//Step 3 : Sorting merged array after removing duplicates
			Arrays.sort(setWithNoDupl);
			
			return setWithNoDupl;
			
		
		
	}
	
	//Reverse each word in a string, for example, if input Str = "I Am Ironman",
	//then the output should be "I mA namnorI"..

	public static void reverseString(String str) throws IOException{
		
		String revWord = "";
		
		String[] s = str.split(" ");
		
		for(int i = 0; i<s.length; i++) {
			
			String word = s[i];
			
			String revStr = "";
			
			for(int j=word.length() - 1; j >=0; j--) {
				
				revStr = revStr + word.charAt(j);
			}
			
			revWord = revWord + revStr + " ";
		}
		
		System.out.print(revWord);
		
	}
}
