package sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Num1181 {
	
	public static String[] input(){
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String[] inputString = new String[n];
		for(int i=0; i<n; i++){
			inputString[i] = sc.nextLine();
		}
		sc.close();
		return inputString;
	}
	
	public static void treeSet(String[] arr){
		TreeSet<String> set = new TreeSet<String>();
		for(String str : arr){
			set.add(str);
		}
		for(String str : set){
			System.out.println(str);
		}
	}
	
	public static void hashSet(String[] arr){
		Set<String> set = new HashSet<String>();
		// 중복제거
		for(int i=0; i<arr.length; i ++){
			set.add(arr[i]);
		}
		// 중복제거한 arr
		String[] removeOverlap = new String[set.size()];
		set.toArray(removeOverlap);
		
		Arrays.sort(removeOverlap);
		
		Arrays.sort(removeOverlap, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2){
				return o1.length() - o2.length();
			}
		});
		
		for(String str : removeOverlap){
			System.out.println(str);
		}
	}

	public static void main(String[] args) {
		hashSet(input());
	}

}
