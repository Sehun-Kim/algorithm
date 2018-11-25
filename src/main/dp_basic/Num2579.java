package dp_basic;

import java.util.Scanner;

public class Num2579 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] stair = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            stair[i] = sc.nextInt();
        }

        dp[1] = stair[1]; // 첫번째 계단을 밟을 때 최대값
        dp[2] = max(stair[1] + stair[2], stair[2]); // 두번째 계단을 밟을 때 최대값
        dp[3] = max(stair[1] + stair[3], stair[2] + stair[3]); // 세번째 계단을 밟을 때 최대값

        // 4번째부터 조건 충족
        for(int h=4; h<=n; h++) {
            dp[h] = max(dp[h-2] + stair[h], dp[h-3] + dp[h-1] + stair[h]);
        }

        System.out.println(dp[n]);
    }


    public static int max(int a, int b) {
        return a > b ? a : b;
    }
}
