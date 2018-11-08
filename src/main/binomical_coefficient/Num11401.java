package binomical_coefficient;

import java.util.Scanner;

/*
 * https://onsil-thegreenhouse.github.io/programming/problem/2018/04/02/problem_combination/
 * http://jason9319.tistory.com/169
 *
 * https://www.acmicpc.net/blog/view/29
 * 서로소 : 두 수 사이에 1이외에는 공약수가 없는 수
 *
 * 곱셈의 역원 : http://zetacode.com/math/2016/04/22/modular-multiplicative-inverse.html
 */

public class Num11401 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] values = sc.nextLine().split(" ");

        long mod = 1000000007;

        int n = Integer.parseInt(values[0]);
        int r = Integer.parseInt(values[1]);

        long a = factorial(n);
        long b = (factorial(r) * factorial(n - r));

        System.out.println(a + " " + b);

        long result = ((a % mod) * (powMod(b, mod - 2) % mod)) % mod;
        System.out.println(result);
    }

    public static long powMod(long b, long n) {
        if (n == 0) {
            return 1;
        } else {
            long temp = powMod(b, n / 2);
            if (n % 2 == 0) return temp * temp;
            else return temp * temp * b;
        }
    }

    public static long factorial(int num) {
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }

        return result;
    }
}
