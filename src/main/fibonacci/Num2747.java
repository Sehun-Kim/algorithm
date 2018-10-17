package fibonacci;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 메모이제이션 활용
public class Num2747 {

	static long[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		arr = new long[n+1];
		for(int i = 0; i < n + 1; i++) {
			arr[i] = -1;
		}
		
		System.out.println(fibonacchi(n));
	}
	
	public static long fibonacchi(int n) {
		if(n < 2) {
			return n;
		}
		if(arr[n] != -1) {
			return arr[n];
		}else{
			return arr[n] = fibonacchi(n-1) + fibonacchi(n-2);
		}
	}

}


