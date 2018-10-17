package queue;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class Num1966 {
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int testCaseNum = Integer.parseInt(br.readLine());
		
		List<Integer> results = new ArrayList<>();
		
		for(int s=0; s<testCaseNum; s++){
			List<Integer> numsQ = new ArrayList<>();
			List<Integer> result = new ArrayList<>();
			
			// 큐 크기, 순서 찾을 중요도
			String[] ops = br.readLine().split(" ");
			
			int length = Integer.parseInt(ops[0]);
			int searchIdx = Integer.parseInt(ops[1]);
			
			// 실제로 갯수를 카운트할 리스트
			for (int i=0; i<length; i++) {
				if(i == searchIdx) {
					result.add(1);
				}else{
					result.add(0);
				}
			}
			
			// Q에 있는 값중에 제일 큰 값
			int max = 0;
			String[] slist = br.readLine().split(" ");
			
			// 우선순위가 저장될 list
			for(String value : slist){
				int num = Integer.parseInt(value);
				if(num > max){ // Q에 있는 값중에 제일 큰 값
					max = num;
				}
				numsQ.add(num);
			}
			
			int cnt=0;
			
			while(true) {
				if(numsQ.get(0) < max){ // max값보다 우선순위가 낮을 경우
					int numsI = numsQ.remove(0);
					numsQ.add(numsI);
					int resI = result.remove(0);
					result.add(resI);
				}else{ // max값과 우선순위가 같을경우
					++cnt; // pop
	
					if(result.get(0) == 1){
						break;
					}else{
						numsQ.remove(0);
						result.remove(0);
						max = Collections.max(numsQ);
					}
				}
			}
			
			results.add(cnt);
		}
		
		for(int num : results) {
			System.out.println(num);
		}

	}

}
