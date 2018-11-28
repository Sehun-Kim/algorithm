package dp_basic;

/*
 * 표를 만든다고 생각하고 접근할 것
 * 예제 : n개의 수들로, k라는 값을 만드는 경우의 수
 * 중요! 경우의 수는 누적된다.
 *
 * memo[n][k] n개의 동전 수로 k라는 수를 만드는 경우의 수를 누적시킨다.
 *
 * 자기보다 작은수 일 때 까지는 경우의 수는 누적됨
 * 자기랑 같거나 커질 때부터 경우의 수는 (구하고자하는 수 / 본인)만큼 늘어남
 */

import java.util.Scanner;

public class Num2293 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] NK = sc.nextLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        int[][] dp = new int[N + 1][K + 1];

        int[] coins = new int[N + 1];
        coins[0] = 0;
        for (int n = 1; n <= N; n++) {
            coins[n] = Integer.parseInt(sc.nextLine());
        }

        for (int n = 0; n <= N; n++) { // 모든 수가 0을 만드는 방법은 하나다. (아무것도 선택안하는 방법)
            dp[n][0] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (j < coins[i]) { // 자기(동전)보다 작은 수일 때는 경우의 수는 누적됨
                    dp[i][j] = dp[i - 1][j];
                } else { // 자기(동전)보다 크거나 같은경우
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                }
            }
        }

        System.out.println(dp[N][K]);
    }

}
