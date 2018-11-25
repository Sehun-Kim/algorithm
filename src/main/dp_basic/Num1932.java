package dp_basic;

import java.util.Scanner;

public class Num1932 {

    static int[][] list; // 모든 값 0으로 초기화

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int sum = 0;
        list = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            int j = 1;
            for (String s : sc.nextLine().split(" ")) {
                list[i][j] = Integer.parseInt(s);
                j++;
            }
        }

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                if (col == 1) // 왼쪽 끝
                    list[row][col] = list[row - 1][col] + list[row][col];
                else if (row == col) // 오른쪽 끝
                    list[row][col] = list[row - 1][col - 1] + list[row][col];
                else // 가운데
                    list[row][col] = Math.max(list[row - 1][col - 1], list[row - 1][col]) + list[row][col];

                if (sum < list[row][col])
                    sum = list[row][col];
            }
        }
        System.out.println(sum);

    }

}
