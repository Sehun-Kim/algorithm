package other;

import java.util.Scanner;

public class Num1914 {
	/*
	 * 마지막을 제외한 부분을 중간으로
	 * 마지막을 목적위치로 옮기고
	 * 다시 마지막을 제외한 부분을 목적위치로 옮김을 반복
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		// 하노이탑 옮긴 횟수 : 2^n -1
		System.out.println((int) Math.pow(2, n)-1);
		
		hanoi(n, 1, 2, 3);
	}
	
	public static void hanoi(int n, int from, int aux, int to) {
		if(n == 1) {
			System.out.println(from + " " + to);
		}else{
			hanoi(n-1, from, to, aux); // 첫번째 묶음을 목적 위치가 아닌 곳으로 옮김
			System.out.println(from + " " + to); // 맨마지막 녀석을 끝으로 옮김
			hanoi(n-1, aux, from, to); // 목적위치가 아닌 곳에 있는 녀석들을 다시 목적위치로 옮김
		}	
	}

}
