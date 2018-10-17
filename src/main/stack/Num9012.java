package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Num9012 {
	/*
	 * 실패 조건
	 * 1. 맨 첫 괄호가 ")" 닫히는 괄호일 때
	 * 2. 모든 괄호를 검사한 후 스택에 값이 남아 있을 때
	 */

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder();
		
		
		int n = Integer.parseInt(br.readLine());
		List<String> brackets = new ArrayList<String>();
		
		while(n-- > 0){
			Stack<String> stack = new Stack<String>();
			brackets = Arrays.asList(br.readLine().split(""));
			boolean isVPS = true;
			
			for(String bracket : brackets){
				if(bracket.equals(")")){
					if(stack.size() == 0){
						isVPS = false;
						break;
					}
					stack.pop();
				}else{
					stack.push(bracket);
				}
			}
			if(!(stack.size() == 0)){
				isVPS = false;
			}
			if(isVPS){
				sb.append("YES\n");
			}else{
				sb.append("NO\n");
			}
		}
		System.out.println(sb.toString());

	}

}
