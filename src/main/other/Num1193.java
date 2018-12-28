package other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Num1193 {
    public static void main(String[] args) {
        /*
         * 1/1
         * 1/2, 2/1
         * 3/1, 2/2, 1/3
         * 1/4, 2/3, 3/2, 4/1
         */

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<String> result = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            if (i % 2 == 0) { // i가 짝수일때 분모가 i부터 줄어듦
                // 분모
                for (int j = i; j >= 1; j--) {
                    StringBuilder sb = new StringBuilder();
                    sb.append((i - j + 1)); // 분자
                    sb.append("/"); // 등호
                    sb.append(j); // 분모

                    result.add(sb.toString());
                }
            } else { // i가 홀수 일 때 분자가 i부터 줄어듦

                for (int j = i; j >= 1; j--) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(j); // 분자
                    sb.append("/"); // 등호
                    sb.append((i - j + 1)); // 분모

                    result.add(sb.toString());
                }
            }

        }

        System.out.println(result.get(n - 1));
    }
}
