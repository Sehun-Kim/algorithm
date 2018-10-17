package fibonacci;

import java.util.Scanner;

public class Num2748 {

    public static void main(String[] ar){
        Num2748 ex = new Num2748();
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        long result = 0;
        if (n>0) {
        	result = ex.calcFibo(n);
        }
        System.out.println(result);
        
        sc.close();
    }

    public long calcFibo(int n){
        long[] fibo = new long[n+1];
        fibo[0] = 0;
        fibo[1] = 1;

        int index = 2;
        while(index <= n){
            fibo[index] = fibo[index-1] + fibo[index-2];
            index++;
        }

        return fibo[n];
    }
}