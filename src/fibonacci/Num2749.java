package fibonacci;

import java.util.Scanner;

// 피사노 주기를 활용한 문제 풀이
/*
 * 피보나치 수열을 어떤 자연수 k로 나누었을 때 나머지로 이루어진 수열은 주기를 가진다.
 * https://png93.github.io/baekjoon-2749-fibonacci/
 * 
 * 피보나치 수를 나누는 수 k
 * k = 10^n 일 때 
 * 주기 : 15*10^n-1 
 */
public class Num2749 {
	static int period = 1500000; // 주기 1000000 10^6승 15 * 10^5
	static long[] fi = new long[period + 1];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i=0; i<period; i++) {
			fi[i] = -1;
		}
		
		if(n >= period) {
			n %= period;
		}
		
		System.out.println((int) fibonacci(n));
		
		sc.close();
	}
	
	public static long fibonacci(int n) {
		if(n < 2){
			return n;
		}
		if(fi[n] != -1) {
			return fi[n];
		}else{
			return fi[n] = (fibonacci(n-1) + fibonacci(n-2)) % (long) Math.pow(10, 6);
		}
		
	}

}
