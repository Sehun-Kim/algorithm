package main.other.programmers.etc;

import java.util.HashMap;
import java.util.Map;

public class Rectangle {
    public static void main(String[] args) {
        int[][] v = {{1, 4}, {3, 4}, {3, 10}};
        int[] result = solution(v);

        for (int num : result) {
            System.out.println(num);
        }

    }

    private static int[] solution(int[][] v) {
        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();
        for (int[] ints : v) {
            if (xMap.containsKey(ints[0])) {
                xMap.put(ints[0], 2);
            } else {
                xMap.put(ints[0], 1);
            }
            if (yMap.containsKey(ints[1])) {
                yMap.put(ints[1], 2);
            } else {
                yMap.put(ints[1], 1);
            }
        }

        int[] result = new int[2];

        for (Integer integer : xMap.keySet()) {
            if (xMap.get(integer) == 1) {
                result[0] = integer;
                break;
            }
        }

        for (Integer integer : yMap.keySet()) {
            if (yMap.get(integer) == 1) {
                result[1] = integer;
                break;
            }
        }
        return result;
    }
}
