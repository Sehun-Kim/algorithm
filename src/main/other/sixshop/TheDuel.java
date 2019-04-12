package main.other.sixshop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;

public class TheDuel {
    public static void main(String[] args) {

        Integer[] s = {-5,
                4,
                -2,
                3,
                1,
                -1,
                -6,
                -1,
                0,
                -5};

        List<Integer> p = Arrays.asList(s);

        int result = minPower(p);
        System.out.println(result);

    }

    public static int minPower(List<Integer> p) {
        int sum = 0;
        for (Integer integer : p) {
            sum += integer;
        }

        int v = 0;
        if (sum < 0) {
            v = Math.abs(sum) + 1;
        } else {
            v = 0;
        }

        if (p.get(0) < 0) {
            int first = Math.abs(p.get(0));
            if (first > v) {
                v += first;
            }
        }

        return v;
    }
}
