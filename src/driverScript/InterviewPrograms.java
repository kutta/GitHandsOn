package driverScript;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class InterviewPrograms {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		/*removeDupStr();
		
		stringManipulation("Hello welcome to India");*/
		
		/*arrayToLinkedList();*/
		
		/*reverseString("kannan");*/
		
		reverseNumber(12345);

	}

	/*
	 * Method to remove duplicates from array in Java, without using Collection
	 * classes e.g. Set or ArrayList. Algorithm for this method is simple, it first
	 * sort the array and then compare adjacent objects, leaving out duplicates,
	 * which is already in the result.
	 */
	
	public static void removeDupStr() throws IOException{
		
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
	
	public static void stringManipulation(String str) throws IOException{
		
		String[] str1 = str.split(" ");
		
		for(int i =0; i <= str1.length; i++) {
			
			char[] ch = str1[i].toCharArray();
			
			System.out.println(ch[0]);
		}
	}
	
	/*To convert an array into a java.util.LinkedList we can use the java.util.Arrays class’s asList() method. 
	 * The Arrays class in the java.util package provides a utility method to convert an array to a List. 
	 * The Arrays.asList() method will convert an array to a fixed size List. 
	 * To create a LinkedList, we just need to pass the List to the constructor of the java.util.LinkedList class. 
	 * A java.util.ArrayList could be created in this way too.*/
	public static void arrayToLinkedList() throws IOException{
		
		String[] str = new String[] {"Koushic","Priya","Kannan"};
		
		LinkedList<String> ll = new LinkedList<>(Arrays.asList(str));
		
		Iterator iterator = ll.iterator();
		
		while(iterator.hasNext()) {
			
			System.out.println((String)iterator.next());
		}
	}
	
	public static void reverseString(String str) throws IOException{
		
		int len = str.length();
		
		String revWord = "";
		
		for(int i=len - 1; i >= 0;i--) {
			
			
			revWord = revWord+str.charAt(i);
			System.out.println(revWord);
		}
		
		
	}
	public static void reverseNumber(int num) throws IOException{
		
		System.out.println("Before Reversing :: "+num);
		
		int r, re=0;
		
		while(num != 0) {
			
			r = num % 10;
			re = re * 10 + r;
			num = num/10;
		}
		
		System.out.println("After reversing :: "+re);
	}
}
