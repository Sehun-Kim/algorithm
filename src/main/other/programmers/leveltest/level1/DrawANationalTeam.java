package main.other.programmers.leveltest.level1;

import java.util.HashMap;
import java.util.Map;

public class DrawANationalTeam {
    private static final String A = "A";
    private static final String B = "B";
    private static final String C = "C";

    public static void main(String[] args) {
        String vote = "ABBCCCBBAB";
        String result = solution(vote);
        System.out.println(result);
    }

    private static String solution(String vote) {
        Map<String, Integer> teamCnt = new HashMap<>();

        String[] votes = vote.split("");
        for (String v : votes) {
            if (teamCnt.containsKey(v)) {
                teamCnt.put(v, teamCnt.get(v) + 1);
            } else {
                teamCnt.put(v, 1);
            }
        }

        if (teamCnt.get(A) < teamCnt.get(B)) {
            if (teamCnt.get(B) < teamCnt.get(C))
                return C;
            return B;
        }

        if (teamCnt.get(B) < teamCnt.get(A)) {
            if (teamCnt.get(A) < teamCnt.get(C))
                return C;
            return A;
        }

        if (teamCnt.get(A) < teamCnt.get(C))
            return C;
        return "AB";
    }
}
