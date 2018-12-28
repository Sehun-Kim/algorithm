package dp_basic;

import java.util.Scanner;

// 숫자 dp[i] = dp[i-3] + dp[i-2]
public class Num9461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = Integer.parseInt(sc.nextLine());
        int[] dp;
        int[] result = new int[testCase];
        int t = 0;
        while (testCase-- > 0) {
            dp = new int[100];
            int n = Integer.parseInt(sc.nextLine());

            dp[0] = 1;

            if (n > 0) dp[1] = 1;

            if (n > 1) dp[2] = 1;

            for (int i = 3; i < n; i++) {
                dp[i] = dp[i - 3] + dp[i - 2];
            }

            result[t] = dp[n - 1];
            t++;
        }
        for (int i : result) {
            System.out.println(i);
        }
    }
}
