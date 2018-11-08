package binomical_coefficient;

import java.math.BigInteger;
import java.util.Scanner;

// 기본 팩토리얼 0 <= n <= 12
public class Num10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(factorial(n));
    }

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for(int i=1; i<=n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }
}
