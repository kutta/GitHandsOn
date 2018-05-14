package sortingAlgorithm;

import java.io.IOException;
import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		int[] arr = {12, 13, 24, 10, 3, 6, 90, 70};
		quickSort(arr, 0, arr.length - 1);
		
		// Verify sorted array
        System.out.println(Arrays.toString(arr));

	}
	
	/*Quicksort or partition-exchange sort, is a fast sorting algorithm, which is using divide and conquer algorithm. 
	 * Quicksort first divides a large list into two smaller sub-lists: the low elements and the high elements. 
	 * Quicksort can then recursively sort the sub-lists.

	Steps to implement Quick sort:

	1) Choose an element, called pivot, from the list. Generally pivot can be the middle index element.
	2) Reorder the list so that all elements with values less than the pivot come before the pivot, 
	while all elements with values greater than the pivot come after it (equal values can go either way). 
	After this partitioning, the pivot is in its final position. This is called the partition operation.
	3) Recursively apply the above steps to the sub-list of elements with smaller values and separately the sub-list of elements with greater values.*/
	
	public static void quickSort(int[] arr, int low, int high) throws IOException{
		
		if(arr == null || arr.length == 0) {
			return;
		}
		
		if(low >= high) {
			return;
		}
		 
		//Get the pivot element from the middle of the list
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
		
		// make left < pivot and right > pivot
		int i =low, j = high;
		
		while(i <= j) {
			
			//Check until all values on left side array are lower than pivot
			
			while(arr[i] < pivot) {
				i++;
			}
			
			//Check until all values on left side array are greater than pivot
			
			while(arr[j] > pivot) {
				j--;
			}
			
			//Now compare values from both side of lists to see if they need swapping
            //After swapping move the iterator on both lists
			
			if(i <= j) {
				
				swap(arr,i,j);
				i++;
				j--;
			}
		}
		
		//Do same operation as above recursively to sort two sub arrays
        if (low < j){
            quickSort(arr, low, j);
        }
        if (high > i){
            quickSort(arr, i, high);
        }
		
	}
	
	public static void swap (int[] arr, int x, int y)
    {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}
