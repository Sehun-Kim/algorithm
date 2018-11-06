package binomical_coefficient;

/*
 * 이항계수란 n개의 원소에서 r개의 원소를 뽑아내는 방법의 수를 나타낸다.
 * 즉, nCr과 같이 수학에서 조합을 뜻한다.
 *
 * n-1개의 원소 중 r-1개를 뽑아내는 경우의 수 + n-1개의 원소 중 r개를 뽑아내는 경우의 수
 *
 * N 개의 원소 중에서 K 개의 원소를 뽑아내는 경우의 수란
 * N 개의 원소 중 N번째 원소를 선택하고 나머지를 뽑는 경우와 N번째 원소를 선택하지 않고 나머지를 뽑는 경우의 합이다.
 */

import java.util.Scanner;

public class Num11050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] values = sc.nextLine().split(" ");

        int n = Integer.parseInt(values[0]);
        int r = Integer.parseInt(values[1]);

        System.out.println(combination(n, r));

    }

    public static int combination(int n, int r) {
        if (r == n || r == 0) { // n개에서 n개를 선택하는 방법은 하나, 0개 고르는 방법도 하나
            return 1;
        }
        return combination(n - 1, r - 1) + combination(n - 1, r);
    }
}
