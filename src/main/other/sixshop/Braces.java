package main.other.sixshop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Braces {
    private static String YES = "YES";
    private static String NO = "NO";

    public static void main(String[] args) {
        String[] values = {"{}[]()", "{[}]}" };
        String[] result = braces(values);
        for (String s : result) {
            System.out.println(s);
        }

    }

    public static String[] braces(String[] values) {
        List<String> brackets = new ArrayList<>();
        Stack<String> stack;
        String[] result = new String[values.length];

        for (int i = 0; i < values.length; i++) {
            stack = new Stack<>();
            brackets = Arrays.asList(values[i].split(""));
            boolean isVPS = true;

            for (String bracket : brackets) {
                if (bracket.equals(")") || bracket.equals("}") || bracket.equals("]")) {
                    if (stack.isEmpty()) {
                        isVPS = false;
                        break;
                    }

                    String pop = stack.pop();
                    if (bracket.equals(")")) {
                        if (!pop.equals("(")) {
                            isVPS = false;
                            break;
                        }
                    }else if(bracket.equals("}")) {
                        if (!pop.equals("{")) {
                            isVPS = false;
                            break;
                        }
                    } else if(bracket.equals("]")) {
                        if (!pop.equals("[")) {
                            isVPS = false;
                            break;
                        }
                    }
                } else {
                    stack.push(bracket);
                }
            }
            if (!(stack.isEmpty())) {
                isVPS = false;
            }
            if (isVPS) {
                result[i] = YES;
            } else {
                result[i] = NO;
            }
        }

        return result;
    }
}
