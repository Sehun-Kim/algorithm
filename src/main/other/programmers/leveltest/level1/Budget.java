package main.other.programmers.leveltest.level1;

import java.util.Arrays;

public class Budget {
    public static void main(String[] args) {
//        int[] d = {1, 3, 2, 5, 4};
//        int budget = 9;
        int[] d = {2, 2, 3, 3};
        int budget = 10;

        int result = solution(d, budget);
        System.out.println(result);
    }

    private static int solution(int[] d, int budget) {
        int sum = 0;
        int cnt = 0;
        Arrays.sort(d);
        for (int i : d) {
            sum += i;
            if (budget < sum)
                return cnt;
            cnt++;
        }

        return cnt;
    }
}
