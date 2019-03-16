package main.other.programmers.highlevelkit.heap;

import java.util.*;

public class DoublePriorityQueue {
    public static void main(String[] args) {
//        String[] operations = {"I 16", "D 1"};
        String[] operations = {"I 7", "I 5", "I -5", "D -1"};
        int[] result = solution(operations);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(String[] operations) {
        List<Integer> list = new ArrayList<>();

        for (String operation : operations) {
            String[] split = operation.split(" ");

            if (split[0].equals("I")) {
                list.add(Integer.parseInt(split[1]));
                Collections.sort(list, Collections.reverseOrder());
            } else if (split[0].equals("D")) {
                if (split[1].equals("1") && list.size() != 0) {
                    list.remove(0);
                } else if (split[1].equals("-1") && list.size() != 0) {
                    list.remove(list.size() - 1);
                }
            }
        }

        int[] result = new int[2];
        if (list.size() == 0) {
            result[0] = 0;
            result[1] = 0;
            return result;
        }

        result[0] = list.get(0);
        result[1] = list.get(list.size()-1);

        return result;
    }
}
