package sorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Num10989 {

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
	
	public static int maxNumSize(int[] arr){
		int maxNum = 0;
		for(int i=0; i<arr.length; i++){
			if(arr[i] > maxNum){
				maxNum = arr[i];
			}
		}
		return (int)(Math.log10(maxNum)+1);
	}
	
	public static ArrayList<Queue<Integer>> makeBucket(){
		ArrayList<Queue<Integer>> bucket = new ArrayList<Queue<Integer>>();
		for(int i=0; i<10; i++){
			bucket.add(new LinkedList<Integer>());
		}
		return bucket;
	}


	public static int[] radixSort(int[] arr){
		int maxNumSize = maxNumSize(arr);
		ArrayList<Queue<Integer>> bucket = makeBucket();
		
		// arr복사
		int[] result = arr;
		
		for(int i=0; i<maxNumSize; i++){
			
			// 자릿수 넣기
			for(int j=0; j<arr.length; j++){
				bucket.get((result[j]/(int)Math.pow(10, i))%10).offer(result[j]);
			}
			
			// 데이터 뽑기
			int idx = 0;
			for(int k=0; k<10; k++){
				while(bucket.get(k).peek() != null){
					result[idx] = bucket.get(k).remove();
					idx++;
				}
			}
		}
		
		return result;
	}	

	
	public static void main(String[] args) {
		int[] arr = input();
		printResult(radixSort(arr));
	}

}
