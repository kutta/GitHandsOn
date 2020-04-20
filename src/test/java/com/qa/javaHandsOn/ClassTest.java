package com.qa.javaHandsOn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class ClassTest {
	
	public static void main(String[] args) throws IOException {
		
		/*iteratorTest();*/
		
		/*fiboSeries(2);*/
		
		/* fibonacci(8); */
		
		classTest("Koushic");
	}

	public static void classTest(String str) throws IOException {

		char[] ch = str.toCharArray();

		for (int i = 0; i < ch.length; i++) {

			for (int j = 0; j <= i; j++) {

				System.out.print(ch[j] + " ");
			}
			System.out.println();
		}

	}

	public static void iteratorTest() throws IOException {

		List<String> list = new ArrayList<String>();

		list.add("ONE");

		list.add("TWO");

		list.add("THREE");

		// Traversing list elements using Iterator
		Iterator iterator = list.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		ListIterator listIt = list.listIterator();
		
		while(listIt.hasNext()) {
			
			System.out.println(listIt.next());
			
		}
		
		while(listIt.hasPrevious()) {
			
			
			
			System.out.println(listIt.previous());
		}
	}
	
	public static void fiboSeries(int num) throws IOException{
		
		for(int i=1;i<=num;i++) {
			
			System.out.println("Fibonacci Series :: "+getFiboSeries(i));
		}
		
	}
	
	public static int getFiboSeries(int num) throws IOException{
		
		
			
			if(num == 1) {
				return 1;
			}
			
			if(num == 2) {
				
				return 1;
			}
			
			return getFiboSeries(num -1) + getFiboSeries(num -2);
		
		
		
	}
	
	public static void fibonacci(int num) throws IOException{
		
		int fi1 = 0;
		int fi2 = 1;
		
		for(int i = 2; i<=num;i++) {
			
			int fi3 = fi1 + fi2;
			
			System.out.println("Fibo Series :: "+fi3);
			fi2 = fi1;
			fi1 = fi3;
			
			
		}
	}
}
