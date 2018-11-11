package binomical_coefficient;

import java.math.BigInteger;
import java.util.Scanner;

public class Num2407 {
    static BigInteger[][] combi = new BigInteger[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] values = sc.nextLine().split(" ");

        int n = Integer.parseInt(values[0]);
        int r = Integer.parseInt(values[1]);

        System.out.println(combination(n, r).toString());

    }

    public static BigInteger combination(int n, int r) {
        if (n == r || r == 0) return BigInteger.ONE;
        if (!(combi[n][r] == null)) return combi[n][r];
        return combi[n][r] = combination(n - 1, r - 1).add(combination(n - 1, r));
    }
}
