package driverScript;

import java.io.IOException;

import java.util.HashMap;

public class StringSampler {

	public static void main(String[] args) throws IOException {

		String mainArray = "My name is koushic Kannnan ";
		String sumArray = "Passed=40 Failed=20 Skipped=15";

		/*longestString(mainArray);
		repeatingString(mainArray);
		sumString(sumArray);
		isPalindrome("koushic");*/
		
		/*smallestElement();
		largestElement();
		swapNumbers(4,5);
		*/
		/*reverseNumbers(1560);*/
		
		int arr[] ={11,22,3,34,9,19,234}; 
		bubbleSortAlgo(arr);

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

		for (int i = 0; i < len; i++) {

			char charAt = repeatStr.charAt(i);

			if (!hashMap.containsKey(charAt)) {

				hashMap.put(charAt, 1);
			} else {

				hashMap.put(charAt, hashMap.get(charAt) + 1);
			}
		}

		System.out.println(hashMap);

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
}
