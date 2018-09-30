package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;


//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Scanner;
//import java.util.Stack;
//
//public class Num1874 {
//	
//	public static List<Integer> input(){
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		
//		List<Integer> list = new ArrayList<Integer>();
//		for(int i=0; i<n; i++){
//			list.add(sc.nextInt());
//		}
//		
//		sc.close();
//		return list;
//	}
//	
//
//	
//	public static void run(List<Integer> list){
//		List<Integer> sortedList = list;
//		Collections.sort(sortedList); // stack에 넣을 리스트
//		
//		List<Integer> result = new ArrayList<Integer>();
//		Stack<Integer> stack = new Stack<Integer>();
//		List<String> stackResult = new ArrayList<String>();
//		
//		while(list.size() != 0){
//			if(stack.peek() == list.get(0)){ // 스택의 top에 지정한 값이 있을 경우 해당 숫자를 pop한다. 
//				result.add(stack.pop());
//				list.remove(0);
//				stackResult.add("-");
//			}else{
//				int idx = 0;
//				while(sortedList.get(idx) != list.get(0)){ // 스택의 top에 지정한 값이 없을 경우 해당 숫자까지 stack에 값을 push.
//					stack.push(sortedList.remove(idx));
//					idx++;
//				}
//				stack.push(sortedList.remove(++idx));
//				stackResult.add("+");
//			}
//			
//		}
//		
//		// 결과출력
//		if(checkResult(list, result)){
//			for(int i=0; i<stackResult.size(); i++){
//				System.out.println(stackResult.get(i));
//			}
//		}else{
//			System.out.println("NO");
//		}
//	}
//	
//	public static boolean checkResult(List<Integer> list, List<Integer> result) {
//		for(int i=0; i<result.size(); i++){
//			if(result.get(i) != list.get(i)){
//				return false;
//			}
//		}
//		return true;
//	}
//
//	public static void main(String[] args) {
////		List<Integer> list = input();
////		run(list);
//		
//		Stack<Integer> stack = new Stack<Integer>();
//		System.out.println(stack.peek());
//	}
//
//}


// 블로그 참고 http://blog.naver.com/PostView.nhn?blogId=occidere&logNo=220812563361, https://hongku.tistory.com/248

// tip 정직하게 값을 정렬해서 하나하나 비교할 필요가 없다.
/*
 * 스택에 값을 넣을 때는 정렬(오름차순)값을 순서대로 넣을 수 있다.
 * 값을 모두 입력받고 정렬할 필요없 값을 사용자가 입력할 때 해당 값이 스택에 없을경우 스택에 해당값까지 push해주고 pop을 한다. 
 * 값이 있을 경우 pop을 해준다.
 * 해당 값이 stack에 있든 없든 무조건 1번 pop을 해주어야 
 * 
 */
public class Num1874{
	public static void main(String[] args) throws Exception {
		// Scanner 객체보다 빠르게 하기 위해 사용. 한 줄을 통째로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder(); // String 연산 시간을 줄이기 위해 사용
		
		int n = Integer.parseInt(br.readLine()); // 입력할 숫자 갯수
		
		int temp; // 입력한 값
		int max = 0; // stack안에서 제일 큰 값
		int top = 0; // stack에서 최상단에 있는 값
		int[] stack = new int[n];
		
		while(n-- > 0){ // 입력받은 값의 수가 0보다 클 때 까지
			temp = Integer.parseInt(br.readLine());
			if(temp > max){ 
				// 스택에 값이 없을 경우
				for(int i=max+1; i<=temp; i++){
					stack[top++] = i;
					sb.append("+\n"); // push
				}
				max = temp;
			}else if(stack[top-1] != temp) { // 종료조건을 확인하기 위해
				System.out.println("NO");
				return; // 아예 메소드를 종료시켜야 하기때문에 break을 쓰지 않는다.
			}
			// 무조건 한번은 pop을 하기 때문에
			top--;
			sb.append("-\n"); // pop
		}
		System.out.println(sb);
	}
}
