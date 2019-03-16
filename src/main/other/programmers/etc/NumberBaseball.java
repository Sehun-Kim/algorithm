package main.other.programmers.etc;

import java.util.*;

public class NumberBaseball {

    public static void main(String[] args) {
//        solutionWrong();
    }

    public static void solution(int[][] baseball) {
        int cnt = 0;
        for (int i = 123; i <= 987; i++) {
            if (checkBalls(String.valueOf(i), baseball)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean checkBalls(String value, int[][] baseball) {
        List<String> values = Arrays.asList(value.split(""));

        if (new HashSet<>(values).size() != 3) // 야구 중복검사
            return false;

        if (value.contains("0")) // 0 들어있어도 false
            return false;

        for (int i = 0; i < baseball.length; i++) {
            String[] opValue = String.valueOf(baseball[i][0]).split("");
            int s = baseball[i][1]; // strike
            int b = baseball[i][2]; // ball

            int[] SnB = checkStrikeAndBall(opValue, values);
            if(SnB[0] != s || SnB[1] != b) // strike나 ball 둘 중 하나가 다를 때
                return false;
        }
        return true;
    }

    private static int[] checkStrikeAndBall(String[] opValue, List<String> values) {
        int[] SnB = {0, 0}; // strike / ball 갯수
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (opValue[i].equals(values.get(j))) { // 숫자가 같을 때
                    if (i==j) SnB[0]++;
                    else SnB[1]++;
                }
            }
        }
        return SnB;
    }
}
