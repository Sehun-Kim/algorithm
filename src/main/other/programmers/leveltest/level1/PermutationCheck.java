package main.other.programmers.leveltest.level1;

import java.util.HashSet;
import java.util.Set;

public class PermutationCheck {
    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 2};
        String result = solution(arr);
        System.out.println(result);
    }

    private static String solution(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int i : arr) {
            if (max < i)
                max = i;
            set.add(i);
        }

        return set.size() == max ? "true" : "false";
    }
}
