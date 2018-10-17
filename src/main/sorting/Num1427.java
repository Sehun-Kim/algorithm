package sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Num1427 {
	
	public static String[] input(){
		Scanner sc = new Scanner(System.in);
		String inputStr = sc.nextLine();
		sc.close();
		return inputStr.split("");
	}
	
	public static void sorting(){
		List<String> list = Arrays.asList(input());
		Collections.sort(list);
		Collections.reverse(list);
		printlist(list);
	}
	
	public static void printlist(List<String> list){
		for(String s : list){
			System.out.print(s);
		}
		System.out.print("\n");
	}

	public static void main(String[] args) {
		sorting();
	}

}
