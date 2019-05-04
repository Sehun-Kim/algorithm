package main.other.programmers.leveltest.level1;

import java.util.HashMap;
import java.util.Map;

public class FindMajority {
    public static void main(String[] args) {
//        int[] numbers = {6, 1, 6, 6, 7, 6, 6, 7};
        int[] numbers = {6, 1, 6, 6, 7, 5, 6, 7};
        int result = solution(numbers);
        System.out.println(result);
    }

    private static int solution(int[] numbers) {
        int majority = numbers.length / 2;
        int max = 0;
        int maxNum = 0;
        Map<Integer, Integer> numberCounts = new HashMap<>();

        for (int number : numbers) {
            if (numberCounts.containsKey(number)) {
                numberCounts.put(
                        number,
                        numberCounts.get(number) + 1
                );
            } else {
                numberCounts.put(number, 1);
            }
        }

        for (Integer integer : numberCounts.keySet()) {
            int count = numberCounts.get(integer);
            if (max < count) {
                max = count;
                maxNum = integer;
            }
        }

        if (max > majority) {
            return maxNum;
        }
        return -1;
    }

}
