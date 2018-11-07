package binomical_coefficient;

import java.util.Scanner;

public class Num11051 {

    static int[][] combi = new int[1001][1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] values = sc.nextLine().split(" ");

        int n = Integer.parseInt(values[0]);
        int r = Integer.parseInt(values[1]);

        System.out.println(combination(n, r));

    }

    public static int combination(int n, int r) {
        if (n == r || r == 0) return 1;
        if (combi[n][r] != 0) return combi[n][r];
        return combi[n][r] = (combination(n - 1, r - 1) + combination(n - 1, r)) % 10007;
    }
}
