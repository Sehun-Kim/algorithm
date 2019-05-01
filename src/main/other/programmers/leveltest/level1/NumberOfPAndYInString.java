package main.other.programmers.leveltest.level1;

import java.util.HashMap;
import java.util.Map;

public class NumberOfPAndYInString {
    public static void main(String[] args) {
        String s = "Pyy";
        boolean answer = solution(s);
        System.out.println(answer);
    }

    private static boolean solution(String s) {
        String[] strs = s.toLowerCase().split("");
        Map<String, Integer> map = new HashMap<>();
        map.put("p", 0);
        map.put("y", 0);

        for (String str : strs) {
            if(map.containsKey(str)) {
                int tmp = map.get(str);
                map.put(str, ++tmp);
            }
        }

        if (map.get("p").equals(map.get("y")))
            return true;
        
        return false;
    }
}
