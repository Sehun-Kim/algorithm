package main.other.programmers.leveltest.level1;

import java.util.*;

public class FindAlphabet {
    public static void main(String[] args) {
        String s = "BA";
        String result = solution(s);
        System.out.println(result);
    }

    private static String solution(String s) {
        Map<String, Integer> alphabets = new HashMap<>();
        for (String s1 : s.toLowerCase().split("")) {
            if (alphabets.containsKey(s1)) {
                alphabets.put(s1, alphabets.get(s1) + 1);
            } else {
                alphabets.put(s1, 1);
            }
        }

        int maxCnt = 0;
        for (String s1 : alphabets.keySet()) {
            if (maxCnt < alphabets.get(s1))
                maxCnt = alphabets.get(s1);
        }

        List<String> result = new ArrayList<>();
        for (String s1 : alphabets.keySet()) {
            if(alphabets.get(s1).intValue() == maxCnt) {
                result.add(s1);
            }
        }

        Collections.sort(result);

        StringBuffer sb = new StringBuffer();
        for (String s1 : result) {
            sb.append(s1);
        }

        return sb.toString();
    }
}