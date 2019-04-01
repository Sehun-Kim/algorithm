package main.other.sixshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pangrams {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("we promptly judged antique ivory buckles for the next prize");
        strings.add("we promptly judged antique ivory buckles for the prizes");
        String result = isPangram(strings);
        System.out.println(result);
    }

    public static String isPangram(List<String> strings) {
        StringBuffer sb = new StringBuffer();

        for (String string : strings) {
            Map<String, Integer> alpabet = gerateAlphabet();
            String[] values = string.split("");
            for (String value : values) {
                if (alpabet.containsKey(value)){
                    alpabet.put(value, 1);
                }
                if (checkOver(alpabet)) {
                    sb.append("1");
                    break;
                }
            }
            if(!checkOver(alpabet)) {
                sb.append("0");
            }
        }

        return sb.toString();
    }

    private static boolean checkOver(Map<String, Integer> alpabet) {
        for (Integer value : alpabet.values()) {
            if (value.equals(0))
                return false;
        }
        return true;
    }

    private static Map<String, Integer> gerateAlphabet() {
        Map<String, Integer> alphabet = new HashMap<>();
        for (char a = 97; a < 123; a++) {
            alphabet.put(String.valueOf(a), 0);
        }
        return alphabet;
    }

}
