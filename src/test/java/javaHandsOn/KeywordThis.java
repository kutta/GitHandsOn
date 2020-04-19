package javaHandsOn;

import java.io.IOException;

public class KeywordThis {
	
	int a ;
	int b ;
	
	public void setData(int a, int b) throws IOException{
		
		this.a = a;
		this.b = b;
	}
	
	public void showData() throws IOException{
		
		System.out.println("Value of a : "+a);
		System.out.println("Value of b : "+b);
	}
	
	public static void main(String[] args) throws IOException{
		
		KeywordThis key = new KeywordThis();
		key.setData(4, 7);
		key.showData();
	}

}
