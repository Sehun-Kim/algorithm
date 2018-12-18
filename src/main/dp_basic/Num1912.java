package dp_basic;

import java.util.Arrays;
import java.util.Scanner;

public class Num1912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dp = new int[N];

        int max = nums[0];
        // 숫자가 하나만 있을 때 자기 자리의 값이 최대값
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }
}
