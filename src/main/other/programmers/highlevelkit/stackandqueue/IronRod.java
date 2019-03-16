package other.programmers.stackandqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class IronRod {
    public static void main(String[] args) {
        String arrangement = "()(((()())(())()))(())";
        int result = solution(arrangement);
        System.out.println(result);
    }

    private static int solution(String arrangement) {
        List<String> brackets = new ArrayList<>(Arrays.asList(arrangement.split("")));
        int result = 0;

        Stack<String> stack = new Stack<>();

        String before = "";
        for (String bracket : brackets) {
            if (bracket.equals("(")) {
                stack.push(bracket);
            } else if (bracket.equals(")")) {
                stack.pop();
                if (before.equals("(")) {
                    result += stack.size();
                } else {
                    result += 1;
                }
            }
            before = bracket;
        }

        return result;
    }
}