package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Num2504 {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        List<String> brackets = Arrays.asList(br.readLine().split(""));
        Stack<String> stack = new Stack<>();
        int roundBracket = 0; // ()
        int squareBracket = 0; // []
        
        for(String bracket : brackets) {
            
            switch (bracket) {
            
            case "(":
                roundBracket++;
                stack.push("(");
                break;    
            case ")":
                roundBracket--;
                // 닫힘 bracket이 올때
                if(roundBracket > -1) {
                    
                    if(stack.peek().equals("(")) {
                        stack.pop();
                        stack.push("2");
                    }else {
                        int roundResult = 0;
                        
                        while(!stack.isEmpty()) {
                            
                            if(stack.peek().equals("[")) { // 사각 닫힘이 오면 무조건 잘못된 괄호
                            	sb.append("0");
                            	System.out.println(sb);
                                return;
                            }else if(stack.peek().equals("(")) { // 여는게 오면 곱해준다.
                                stack.pop();
                                roundResult *=2;
                                stack.push(String.valueOf(roundResult));
                                break;
                            }else {
                                roundResult += Integer.parseInt(stack.pop());
                            }
                            
                        }
                    }
                }
                break; // 0보다 작다는 건 하나도 없었다는 뜻
            case "[":
                squareBracket++;
                stack.push("[");
                break;
            case "]":
                squareBracket--;
                
                if(squareBracket > -1) {
                    if(stack.peek().equals("[")) {
                        stack.pop();
                        stack.push("3");
                    }else {
                        int squareResult = 0;
                        
                        while(!stack.isEmpty()) {
                            
                            if(stack.peek().equals("(")) {
                            	sb.append("0");
                            	System.out.println(sb);
                                return;
                            }else if(stack.peek().equals("[")) {
                                stack.pop();
                                squareResult *=3;
                                stack.push(String.valueOf(squareResult));
                                break;
                            }else {
                                squareResult += Integer.parseInt(stack.pop());
                            }
                        }
                    }
                }
                break;
            }
            
            if(squareBracket < 0 || roundBracket < 0) { // 만약 둘 중 0보다 작은 값이 있으면 오류
            	sb.append("0");
            	System.out.println(sb);
                return;
            }
        }
        
        if(squareBracket != 0 || roundBracket != 0) { // stack 남은 괄호가 있어도 오류
        	sb.append("0");
        	System.out.println(sb);
            return;
        }
        
        int output = 0;
        
        // stack에 남은 숫자를 모두 더 해줌
        while(!stack.isEmpty()) {
            output += Integer.parseInt(stack.pop());
        }
        
        sb.append(String.valueOf(output));
        System.out.println(sb);
    }
 
}