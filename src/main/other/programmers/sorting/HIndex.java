package main.other.programmers.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HIndex {
    public static void main(String[] args) {
        int[] citations = {10, 0, 6, 1, 5, 5, 7};
        int answer = solution(citations);
        System.out.println(answer);
    }

    public static int solution(int[] citations) {
        List<Integer> citationList = new ArrayList<>();
        for (int num : citations) {
            citationList.add(num);
        }

        Collections.sort(citationList);

        int result = 0;
        int size = citationList.size();

        for (int i = 0; i < size; i++) {
            int v = Math.min(size - i, citationList.get(i));
            result = Math.max(v, result);
        }

        return result;
    }
}
