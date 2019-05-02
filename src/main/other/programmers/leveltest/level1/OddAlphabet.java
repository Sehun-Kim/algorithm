package main.other.programmers.leveltest.level1;

import java.util.HashMap;
import java.util.Map;

public class OddAlphabet {
    public static void main(String[] args) {
        String s = "aabbbccd";
        int result = solution(s);
        System.out.println(result);
    }

    public static int solution(String s) {
        String[] strs = s.split("");
        Map<String, Integer> alphabets = new HashMap<>();

        for (String str : strs) {
            if (alphabets.containsKey(str)) {
                alphabets.put(str, alphabets.get(str) + 1);
            } else {
                alphabets.put(str, 1);
            }
        }

        int result = 0;
        for (String s1 : alphabets.keySet()) {
            if ((alphabets.get(s1) % 2) != 0)
                result++;
        }

        return result;
    }
}
