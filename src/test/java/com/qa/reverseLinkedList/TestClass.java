package com.qa.reverseLinkedList;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] list = { 4, 3, 2, 1 };

		LinkedListSample<Integer> linkedList = new LinkedListSample<Integer>(list);

        linkedList.printList();
        linkedList.reverseList();
        linkedList.printList();
        

	}

}
