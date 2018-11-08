package binomical_coefficient;

import java.math.BigInteger;
import java.util.Scanner;

/*
 * 방식은 두 개.
 * 0의 갯수는 10의 갯수를 구하면 알 수 있다.
 *
 */

public class Num1676 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//
//        int zeroCnt = 0;
//        String[] result = factorial(n).toString().split("");
//        for (int i = result.length - 1; i >= 0; i--) {
//            if (result[i].equals("0")) {
//                zeroCnt++;
//            } else {
//                break;
//            }
//        }
//        System.out.println(zeroCnt);
//    }
//
//    public static BigInteger factorial(int n) {
//        BigInteger result = BigInteger.ONE;
//        for (int i = 1; i <= n; i++) {
//            result = result.multiply(BigInteger.valueOf(i));
//        }
//
//        return result;
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int tmp = 0;
        int result = 0;

        for (int i = 1; i <= n; i++) {

            tmp = i;

            while ((tmp % 2) == 0 || (tmp % 5) == 0) {
                if ((i % 2) == 0) {
                    tmp /= 2;
                }
                if ((i % 5) == 0) {
                    tmp /= 5;
                    result++;
                }

            }

        }
        System.out.println(result);
    }
}
