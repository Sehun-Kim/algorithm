package main.other.programmers.bruteforce;

import java.util.ArrayList;
import java.util.List;

public class DecimalNumber {
    public static void main(String[] args) {
        String numbers = "011";
        int result = solution(numbers);
        System.out.println(result);
    }

    public static int solution(String numbers) {
        List<String> numberList = new ArrayList<>();
        for (String s : numbers.split("")) {
            numberList.add(s);
        }

        for (int i = 0; i < numberList.size(); i++) {

        }


        return 0;
    }
}
