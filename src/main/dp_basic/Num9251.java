package dp_basic;

import java.util.Scanner;

public class Num9251 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr1 = sc.nextLine().split("");
        String[] arr2 = sc.nextLine().split("");

        int[][] dp = new int[arr1.length + 1][arr2.length + 1];

        for (int i = 1; i <= arr1.length; i++) {
            for (int j = 1; j <= arr2.length; j++) {
                if (arr1[i - 1].equals(arr2[j - 1])) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[arr1.length][arr2.length]);
    }
}
