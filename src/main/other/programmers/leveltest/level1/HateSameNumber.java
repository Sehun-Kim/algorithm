package main.other.programmers.leveltest.level1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HateSameNumber {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        int[] result = solution(arr);
        for (int i : result) {
            System.out.println(i);
        }
    }

    private static int[] solution(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i : arr) queue.offer(i);

        List<Integer> distinctNums = new ArrayList<>();

        int num = queue.peek();
        distinctNums.add(queue.poll());

        while (!queue.isEmpty()) {
            if (queue.peek() == num) {
                queue.poll();
                continue;
            } else {
                num = queue.poll();
                distinctNums.add(num);
            }
        }

        int[] answer = new int[distinctNums.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = distinctNums.get(i);
        }

        return answer;
    }
}
