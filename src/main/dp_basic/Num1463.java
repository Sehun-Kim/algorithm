package dp_basic;

import java.util.Scanner;

public class Num1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0; // 0,1은 무조건 연산 횟수없음

        // 비교할 때 -1을 해서 1로 만드는 dp[i]와 2나 3으로 나눠 1로 만드는(이 때는 횟수 1 추가) dp[i-2] + 1 두 개중 작은 값을 구한다.
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1; // -1
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1); // /2
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1); // /3
        }

        System.out.println(dp[n]);
    }
}
