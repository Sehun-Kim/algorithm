package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Num2108 {

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

	public static void average(int[] arr){
		int sum = 0;
		for(int i : arr){
			sum += i;
		}
		System.out.println(sum/arr.length);
	}

	public static void middleNum(int[] arr){
		int[] sortedArr = bubbleSorting(arr);
		int middleNum = sortedArr[(int)arr.length/2];
		System.out.println(middleNum);
	}

	public static int[] bubbleSorting(int[] arr){
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
		return arr;
	}

	public static void modeNum(int[] arr){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		// 값 별 갯수 추가
		for(int i : arr){
			map.put(i, map.containsKey(i)? map.remove(i) + 1 : 1);
		}
		// 최빈값 얻기
		int mode = sortByValue(map).get(0);
		// 최빈값이 여러개일 경우 찾기
		List<Integer> modeList = equalMode(map, mode);
		if(modeList.size() >= 2){
			System.out.println(modeList.get(1));
		}else{
			System.out.println(mode);
		}
	}

	public static List<Integer> equalMode(final Map<Integer, Integer> map, int mode){
		List<Integer> list = new ArrayList<Integer>();
		for(Object o : map.keySet()){
			if(map.get(o).equals(mode)){
				list.add(map.get(o));
			}
		}
		Collections.sort(list);
		return list;
	}
	
	public static List<Integer> sortByValue(final Map<Integer, Integer> map) {
		List<Integer> list = new ArrayList<Integer>();
		list.addAll(map.keySet());

		Collections.sort(list,new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				int v1 = map.get((int)o1);
				int v2 = map.get((int)o2);

				return ((Comparable) v2).compareTo(v1);
			}
		});

		return list;
	}
	
	public static void range(int[] arr){
		int[] sortedArr = bubbleSorting(arr);
		System.out.println(sortedArr[arr.length - 1] - sortedArr[0]);
	}

	public static void main(String[] args) {
		int[] inputArr = input();
		average(inputArr);
		middleNum(inputArr);
		modeNum(inputArr);
		range(inputArr);
	}

}
