package queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Num11866 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<Integer>();
		
		List<Integer> result = new ArrayList<Integer>();
		
		String[] ops = br.readLine().split(" ");
		
		int size = Integer.parseInt(ops[0]);
		int term = Integer.parseInt(ops[1]);
		
		// queue에 값 넣기
		for(int i=1; i<=size; i++){
			q.offer(i);
		}
		
		// pop and push는 term-1번
		// term 번째는 pop만
	
		int cnt = 0;
		while(!q.isEmpty()) {
			++cnt;
			if(cnt % term == 0) {
				result.add(q.poll());
			}else{
				int num = q.poll();
				q.offer(num);
			}
		}
		
		sb.append("<");
		for (int i=0; i<size; i++) {
			sb.append(result.get(i));
			if(i<size-1) {
				sb.append(",");
			}
		}
		sb.append(">");
		
		System.out.println(sb.toString());
	}

}
