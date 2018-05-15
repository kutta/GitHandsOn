package sortingAlgorithm;

import java.io.IOException;

public class BinarySearch {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		int[] arr = {2, 4, 6, 8, 10, 12, 14, 16};
		System.out.println("Key 2's position: "+binarySearch(arr, 2));

	}
	
	
	/*A binary search or half-interval search algorithm finds the position of a specified value (the input "key") within a sorted array. 
	 * In each step, the algorithm compares the input key value with the key value of the middle element of the array. 
	 * If the keys match, then a matching element has been found so its index, or position, is returned. 
	 * Otherwise, if the sought key is less than the middle element's key, 
	 * then the algorithm repeats its action on the sub-array to the left of the middle element or, if the input key is greater, 
	 * on the sub-array to the right. If the remaining array to be searched is reduced to zero, 
	 * then the key cannot be found in the array and a special "Not found" indication is returned.

	Every iteration eliminates half of the remaining possibilities. This makes binary searches very efficient - even for large collections.

	Binary search requires a sorted collection. Also, binary searching can only be applied to a collection that allows random access (indexing).

	Worst case performance: O(log n)

	Best case performance: O(1)*/
	
	public static int binarySearch(int[] arr, int key) throws IOException{
		
		int start = 0;
		int end = arr.length - 1;
		
		while(start <= end) {
			
			int middle = (start + end) / 2;
			
			if(key == arr[middle]) {
				
				return middle;
			}
			
			if(key < arr[middle]) {
				
				end = middle - 1;
			}else {
				
				start = middle + 1;
			}
		}
		
		return -1;
	}

}
