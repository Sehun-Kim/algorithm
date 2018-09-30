package sorting;

import java.util.Scanner;

public class Num2750 {
   
   public static int[] input(){
      Scanner sc = new Scanner(System.in);
      
      int n = sc.nextInt();
      int[] arr = new int[n];
      for(int i=0; i<n; i++){
         arr[i] = sc.nextInt();
      }
      
      sc.close();
      return arr;
   }
   
   public static void printResult(int[] arr){
	   for(int i=0; i<arr.length; i++){
		   System.out.println(arr[i]);
	   }
   }
   
   public static void bubbleSorting(){
      int[] arr = input();
      int n = arr.length;
      for(int i=0; i<n-1; i++){
         for(int j=i+1; j<n; j++){
        	 if(arr[i]>arr[j]){
        		 int temp = arr[j];
        		 arr[j] = arr[i];
        		 arr[i] = temp;
        	 }
         }
      }
      printResult(arr);
   }

   public static void main(String[] args) {
	   bubbleSorting();
   }

}