package dp_basic;

import java.util.Scanner;

// http://mygumi.tistory.com/260

public class Num10844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[][] dp = new long[101][11]; // N인 계단수의 최대 길이 100, 자리에 올 수 있는 숫자 수 0~9

        // dp[N][L] = dp[N - 1][L - 1] + dp[N - 1][L + 1]
        // 길이 N, 마지막 숫자가 L일 경우

        // 1의 자리 숫자는 모두 01, 02, 03 등 1개씩
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][1];
            for (int j = 1; j <= 9; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[n][i];
        }
        System.out.println(sum % 1000000000);
    }
}
