package binomical_coefficient;

// http://oper6210.tistory.com/133

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Num9375 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 같은 종류의 의상 수(의상들 중에서 하나를 고를 경우의 수 nC1) + 1 (안 고를 경우) * .. -1(모두 안 입었을 경우의 수)
        // a = 3
        // b = 2
        // c = 4
        // a * b * c - 1
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            int N = sc.nextInt();
            Map<String, Integer> hm = new HashMap<>();

            for (int j = 0; j < N; j++) {
                String s1 = sc.next();
                String s2 = sc.next();
                if (hm.containsKey(s2)) {
                    int idx = hm.get(s2);
                    hm.put(s2, idx + 1);
                } else {
                    hm.put(s2, 1);
                }
            }

            int result = 1;
            for (int val : hm.values()) {
                result *= val+1;
            }
            System.out.println(result - 1);
        }

    }
}
