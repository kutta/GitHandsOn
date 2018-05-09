package johnsonControls;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class driverClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		/*ArrayList<JohnsonControls> arr = new ArrayList<JohnsonControls>();
        arr.add(new JohnsonControls(111, "bbbb", "londonn","a@gmail.com"));
        arr.add(new JohnsonControls(131, "aaaa", "nyc","ba@gmail.com"));
        arr.add(new JohnsonControls(121, "cccc", "jaipur","c@gmail.com"));*/
		
		JohnsonControls[] arr = {new JohnsonControls(11, "Koushic", "Avanthu", "ka@gmail.com"),
				new JohnsonControls(31, "Priya", "Koushic", "pk@gmail.com"),
				new JohnsonControls(5, "Priya", "Siva Sankar", "ps@gmail.com"),
				new JohnsonControls(9, "Raju", "Gomathi", "rg@gmail.com")};
		
		System.out.println("Before sorting ::");
		for(int i=0; i<arr.length; i++) {
			
			System.out.println(arr[i]);
		}
		
		Arrays.sort(arr, new arraySort());
		/*Collections.sort(arr, new arraySort());*/

		System.out.println("After sorting ::");
		for(int i=0; i<arr.length; i++) {
			
			System.out.println(arr[i]);
		}

	}

}
