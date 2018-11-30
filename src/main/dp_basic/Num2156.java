package dp_basic;

import java.util.Scanner;

import static java.lang.Math.max;

/*
 * 동적계획법을 만들 때
 * 먼저 점화식을 만들어 보자
 * 이 때는 다음 값을 고를 때 무엇이 기준이 되어야 되는지를 생각해보면 좋다
 * 순서대로 손으로 해보는 것도 좋다.
 *
 *
 * 와인이 1잔일 때 최대값은 dp[1] = wine[1];
 * 와인이 2잔일 때 최대값은 dp[2] = max(wine[1], wine[2]);
 * 와인이 3잔일 때 최대값은 dp[3] = max(wine[1] + wine[3], wine[2] + wine[3], wine[1] + wine[2]);
 * 와인이 4잔일 때 최대값은 dp[4] = max(dp[2] + wine[4], dp[1] + wine[3] + wine[4])
 *
 * 여기서 점화식은 (내 앞 것을 빼고 먹은 최대값 + 나), (내 앞 것을 먹고 그 전을 안먹은 것중 최대값 + 나), (나를 안 골랐을 때 뺀 최대값) 중에서 최대값을 구하는 것이다.
 * 추가적으로 나를 안먹을 경우도 존재한다.
 */

public class Num2156 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] wine = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            wine[i] = sc.nextInt();
        }
        wine[0] = 0;

        // n이 1일 때
        if (n >= 1) dp[1] = wine[1];

        // n이 2일 때
        if (n >= 2) dp[2] = wine[1] + wine[2];

        // n이 3일때
        if (n >= 3) dp[3] = max(dp[2], max(dp[1] + wine[3], wine[2] + wine[3]));

        for (int i = 4; i <= n; i++) {
            dp[i] = max(dp[i - 1], max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
        }

        System.out.println(dp[n]);
    }
}
