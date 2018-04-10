package driverScript;

public class ArrayTest {
	
	public static void main(String args[])
    {
       int arr1[] = {11, 21, 31, 41, 51};
       int arr2[] = {10, 20, 30, 40, 50};
       arr2 = arr1;
       System.out.println("arr2 : "+arr2.length);
       arr1 = arr2;  
       System.out.println("arr1 : "+arr1.length);
       
       System.out.println();
       for (int i = 0; i < arr2.length; i++)
          System.out.println(arr2[i]);          
    }  

}
