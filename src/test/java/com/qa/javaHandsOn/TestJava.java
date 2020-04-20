package com.qa.javaHandsOn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class TestJava {

	public static void main(String[] args) throws IOException {

		/* largestElement(); */

		/* isPalindrome("MoM"); */
		/* wordCountInFile(); */

		/* swapNumbers(); */

		/* countWords("Ariella Ferrera"); */
		/* countCharacters("Syren De Merr"); */

		 int arr[] = {6,1290,289,800,49,776,766,10}; 
		 largestNumber(arr); 

		 sortArrayNum(arr); 

		/* duplicateCharacters("volvo grup"); */

		/* fibonacciSeries(15); */

		/* isPrime(8); */

		/* pattern01(1); */

		/* stringRotation("koushickannan", "kannankoushic"); */
		/* revStringPreservingSpace("I am koushic"); */
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
						}else {
							if(arr[i] > fourthlargest) {
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

			for (int i = 0; i < inputStringArray.length; i++) {
				if (inputStringArray[i] == ' ') {
					resultArray[i] = ' ';
				}
			}

			// Initializing 'j' with length of resultArray

			int j = resultArray.length - 1;

			// Second for loop :
			// we copy every non-space character of inputStringArray
			// from first to last at 'j' position of resultArray

			for (int i = 0; i < inputStringArray.length; i++) {
				if (inputStringArray[i] != ' ') {
					// If resultArray already has space at index j then decrementing 'j'

					if (resultArray[j] == ' ') {
						j--;
					}

					resultArray[j] = inputStringArray[i];

					j--;
				}
			}

			System.out.println(str + " ---> " + String.valueOf(resultArray));
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
