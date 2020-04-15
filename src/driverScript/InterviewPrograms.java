package driverScript;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class InterviewPrograms {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		/* removeDupStr(); */
		/* stringManipulation("Hello welcome to India"); */

		/* arrayToLinkedList(); */

		/* reverseString("kannan"); */
		/* reverseNumber(986); */

		/* System.out.println(reverseNumber(121)); */

		/* findMaxChar("Hello World"); */

		/* System.out.println(isPrime(13)); */
		/* findMaxChar("Koushic Kannan"); */

		/* removeDuplicateValue(new int[] { 0, 1, 2, 2, 2, 2, 5 }); */
		/* removeDuplicateValuewithoutSet(new int[] { 0, 1, 2, 2, 2, 2, 5 }); */

		/* printPatternNumber(); */
		/* printPatternNumberReverse(); */
		/* printPatternTriangle1(); */
		printPatternTriangle2();
		printPatternTriangle3();

	}

	/*
	 * Method to remove duplicates from array in Java, without using Collection
	 * classes e.g. Set or ArrayList. Algorithm for this method is simple, it first
	 * sort the array and then compare adjacent objects, leaving out duplicates,
	 * which is already in the result.
	 */

	public static void removeDupStr() throws IOException {

		int[][] test = new int[][] { { 1, 1, 2, 2, 3, 4, 5 }, { 1, 1, 1, 1, 1, 1, 1 }, { 1, 2, 3, 4, 5, 6, 7 },
				{ 1, 2, 1, 1, 1, 1, 1 }, };

		for (int[] input : test) {
			System.out.println("Array with Duplicates       : " + Arrays.toString(input));
			System.out.println("After removing duplicates   : " + Arrays.toString(removeDuplicates(input)));
		}

	}

	public static int[] removeDuplicates(int[] numbersWithDuplicates) throws IOException {

		Arrays.sort(numbersWithDuplicates);

		int[] result = new int[numbersWithDuplicates.length];

		int previous = numbersWithDuplicates[0];

		result[0] = previous;

		for (int i = 1; i < numbersWithDuplicates.length; i++) {

			int ch = numbersWithDuplicates[i];

			if (previous != ch) {

				result[i] = ch;
			}

			previous = ch;
		}

		return result;

	}

	public static void stringManipulation(String str) throws IOException {

		String[] str1 = str.split(" ");

		for (int i = 0; i <= str1.length; i++) {

			char[] ch = str1[i].toCharArray();

			System.out.println(ch[0]);
		}
	}

	/*
	 * To convert an array into a java.util.LinkedList we can use the
	 * java.util.Arrays class’s asList() method. The Arrays class in the java.util
	 * package provides a utility method to convert an array to a List. The
	 * Arrays.asList() method will convert an array to a fixed size List. To create
	 * a LinkedList, we just need to pass the List to the constructor of the
	 * java.util.LinkedList class. A java.util.ArrayList could be created in this
	 * way too.
	 */
	public static void arrayToLinkedList() throws IOException {

		String[] str = new String[] { "Koushic", "Priya", "Kannan" };

		LinkedList<String> ll = new LinkedList<>(Arrays.asList(str));

		Iterator iterator = ll.iterator();

		while (iterator.hasNext()) {

			System.out.println((String) iterator.next());
		}

	}

	public static void reverseString(String str) throws IOException {

		int len = str.length();

		String revWord = "";

		for (int i = len - 1; i >= 0; i--) {

			revWord = revWord + str.charAt(i);
			System.out.println(revWord);
		}

	}

	public static boolean reverseNumber(int num) throws IOException {

		System.out.println("Before Reversing :: " + num);

		int r, re = 0, originalNum;
		originalNum = num;
		boolean res = false;

		while (num != 0) {

			r = num % 10;
			re = re * 10 + r;
			num = num / 10;
		}

		System.out.println("After reversing :: " + re);

		if (originalNum == re) {

			return res = true;
		}
		return res;

	}

	public static boolean isPrime(int n) throws IOException {

		for (int i = 2; i <= n / 2; i++) {

			if (n % i == 0) {
				return false;
			}
		}

		return true;

	}

	public static void findMaxChar(String str) throws IOException {

		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();

		char[] charArray = str.toLowerCase().toCharArray();

		for (char c : charArray) {

			if (hashMap.containsKey(c)) {

				hashMap.put(c, hashMap.get(c) + 1);
			} else {

				hashMap.put(c, 1);
			}
		}

		Character repeatedWord = null;
		int count = 0;

		Set<Entry<Character, Integer>> entrySet = hashMap.entrySet();

		for (Entry<Character, Integer> entry : entrySet) {

			if (entry.getValue() > count) {

				repeatedWord = entry.getKey();
				count = entry.getValue();
			}
		}

		System.out.println("The most repeated word in input file is : " + repeatedWord);

		System.out.println("Number Of Occurrences : " + count);

	}

	public static void removeDuplicateValue(int[] arr) throws IOException {

		Set<Integer> setMap = new HashSet<Integer>();

		int len = arr.length;

		for (int i = 0; i < len; i++) {

			setMap.add(arr[i]);
		}

		Iterator<Integer> it = setMap.iterator();

		while (it.hasNext()) {

			System.out.println(it.next());
		}

	}

	public static void removeDuplicateValuewithoutSet(int[] arr) throws IOException {

		System.out.println("Array with duplicates :: ");

		for (int i = 0; i < arr.length; i++) {

			System.out.println(arr[i] + "\t");
		}

		int noOfUniqueElements = arr.length;

		for (int i = 0; i < noOfUniqueElements; i++) {

			for (int j = i + 1; j < noOfUniqueElements; j++) {

				if (arr[i] == arr[j]) {

					arr[j] = arr[noOfUniqueElements - 1];

					noOfUniqueElements--;

					j--;
				}
			}
		}

		int[] arrayWithoutDuplicates = Arrays.copyOf(arr, noOfUniqueElements);

		System.out.println("Array without duplicates :: ");

		for (int m = 0; m < arrayWithoutDuplicates.length; m++) {

			System.out.println(arrayWithoutDuplicates[m] + "\t");
		}
	}

	public static void printPatternNumber() throws IOException {

		int rows = 5;
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {

				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	public static void printPatternNumberReverse() throws IOException {

		int rows = 6;

		for (int i = 1; i <= rows; i++) {
			for (int j = rows; j >= i; j--) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	public static void printPatternTriangle1() throws IOException {

		int n = 5;

		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i);
			}

			System.out.println("");
		}
	}
	
	public static void printPatternTriangle2() throws IOException {

		int n = 5;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i);
			}

			System.out.println("");
		}
	}
	
	public static void printPatternTriangle3() throws IOException {

		int n = 5, num = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(num + " ");
				num++;
			}

			System.out.println("");
		}
	}

}
