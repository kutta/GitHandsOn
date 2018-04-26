package driverScript;

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
		
		iteratorTest();
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
}
