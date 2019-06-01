package main.other.programmers.leveltest.level1;

import java.util.*;

public class RedundantNumberRemovalWith {
    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 2, 5, 2, 5, 5};
        int[] result = soultion(arr);
        for (int i : result) {
            System.out.println(i);
        }
    }

    private static int[] soultion(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i : arr) {
            if (cnt.containsKey(i)) {
                cnt.put(i, cnt.get(i) + 1);
            } else {
                cnt.put(i, 1);
            }
        }

        for (Integer integer : cnt.keySet()) {
            int tmp = cnt.get(integer);
            if (tmp == 1) {
                result.add(integer);
            }
        }

        if(result.size()==0)
            return new int[] {-1};

        Collections.sort(result);
        return result.stream().mapToInt(x -> x).toArray();
    }
}
