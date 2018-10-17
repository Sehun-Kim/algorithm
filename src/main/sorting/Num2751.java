package sorting;

import java.util.Scanner;

public class Num2751 {

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

//	public static void quickSorting(int[] arr, int left, int right){
//		int pivot = left;
//		int j = pivot;
//		int i = left+1;
//		
//		if (left < right) {
//			for (; i <= right; i++) {
//				if (arr[i] < arr[pivot]) {
//					j++;
//					swap(arr, j, i);
//				}
//			}
//			swap(arr, left, j);
//			pivot = j;
//
//			quickSorting(arr, left, pivot-1);
//			quickSorting(arr, pivot+1, right);
//		}
//
//	}
//
//	public static void swap(int[] arr, int left, int right){
//		int temp = arr[left];
//		arr[left] = arr[right];
//		arr[right] = temp;
//	}
	
	public static void mergeSort(int arr[], int l, int r) {
		if(l<r) {
			int mid = (l+r)/2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid+1, r);
			merge(arr, l, mid, r);
		}
	}
	public static void merge(int arr[], int l, int mid, int r) {
		int i = l;
		int j = mid+1;
		int k = l;
		int temp[] = new int[arr.length];
		while(i<=mid && j<=r) {
			if(arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			}else {
				temp[k++] = arr[j++];
			}
		}
		while(i<=mid)
			temp[k++] = arr[i++];
		while(j<=r)
			temp[k++] = arr[j++];
		for(int index=l; index<k; index++)
			arr[index] = temp[index];
	}



	public static void main(String[] args) {
		int[] arr = input();
		int left = 0;
		int right = arr.length-1;
//		quickSorting(arr, left,right);
		mergeSort(arr, left, right);
		printResult(arr);
	}

}