package javaHandsOn;

import java.io.IOException;
import java.util.HashMap;

public class HashMapTut {

	public static void main(String[] args) throws IOException {
		
		HashMap<String, String> hashMap = new HashMap<String, String>();
		
		hashMap.put("Name", "Koushic Kannan");
		hashMap.put("Age", "28");
		hashMap.put("Gender", "Male");
		hashMap.put("City", "Bangalore");
		hashMap.put("City", "Salem");
		hashMap.put("Place", "Konena Agrahara");
		
		if(hashMap.containsKey("City")) {
			
			String city = hashMap.get("City");
			
			System.out.println("City - "+ city);
		}
		
		
		
		System.out.println(hashMap);
		
		if(hashMap.isEmpty()) {
			System.out.println("Hash Map is empty");
		}
		else {
			System.out.println("Hash Map is not empty");
		}
		

	}
	
	
}
