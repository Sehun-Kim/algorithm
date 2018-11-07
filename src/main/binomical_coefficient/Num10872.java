package binomical_coefficient;

import java.util.Scanner;

// 기본 팩토리얼 0 <= n <= 12
public class Num10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(factorial(n));
    }

    public static int factorial(int n) {
        int result = 1;
        for(int i=1; i<=n; i++) {
            result *= i;
        }

        return result;
    }
}
