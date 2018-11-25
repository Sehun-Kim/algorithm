package dp_basic;

import java.util.Scanner;

public class Num1149 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());

        int[][] values = new int[N + 1][3];
        int[][] results = new int[N + 1][3];

        results[0][0] = results[0][1] = results[0][2] = 0;
        for (int i = 1; i < N + 1; i++) {
            int j = 0;
            for (String s : scanner.nextLine().split(" ")) {
                values[i][j] = Integer.parseInt(s);
                j++;
            }
        }

        // results[n][0] = min(results[n - 1][1], results[n - 1][2]) + values[n][0];
        // n번째 집을 i색으로 색칠하는 최소비용 = min(앞 집을 i색을 제외한 다른색을 색칠하는 경우) + n번째 집을 i색으로 색칠하는 비용
        for (int n = 1; n < N + 1; n++) {
            results[n][0] = min(results[n - 1][1], results[n - 1][2]) + values[n][0]; // 0 : R 색으로 시작한 경우
            results[n][1] = min(results[n - 1][0], results[n - 1][2]) + values[n][1]; // 1 : G 색으로 시작한 경우
            results[n][2] = min(results[n - 1][1], results[n - 1][0]) + values[n][2]; // 2 : B 색으로 시작한 경우
        }

        System.out.println(min(min(results[N][0], results[N][1]), results[N][2]));
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }

}
