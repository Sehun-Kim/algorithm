package queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


// http://blog.eairship.kr/268?category=431859
public class Num1260 {

	public static String[] inputValues() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");

		return inputs;
	}


	public static void runGame() throws Exception {
		String[] operations = inputValues();
		
		int n = Integer.parseInt(operations[0]); // 정점 갯수 n
		int m = Integer.parseInt(operations[1]); // 간선 갯수 m
		int v = Integer.parseInt(operations[2]); // 탐색을 시작할 정점 v
		
		MatrixGraph graph = new MatrixGraph(n); // 양방향 그래프
		
		for(int i=0; i<m; i++) {
			String[] values = inputValues();
			graph.addEdge(Integer.parseInt(values[0]) - 1, Integer.parseInt(values[1]) - 1);
		}
		
		graph.depthFirstSearchStart(v - 1);
		System.out.println();
		graph.breadthFirstSearchStart(v - 1);

	}
	


	public static void main(String[] args) throws Exception {
		runGame();
	}

}

class MatrixGraph{
	private int[][] matrix;
	private boolean[] visited; // 정점에 방문했는지 확인할 boolean 배열 
	private int n; // 정점 갯수

	public MatrixGraph(int n){
		this.matrix = new int[n][n];
		this.n = n;
	}

	// 간선추가 메소드 
	public void addEdge(int v1, int v2){
		if(v1 >= this.n || v2 >= this.n || v1 < 0 || v2 < 0){
			System.out.println("간선 삽입 오류 - 잘못된 정점 번호입니다.");
		}else{
			if(this.matrix[v1][v2] == 1){
				System.out.println("간선 삽입 오류 - 이미 존재하는 간선입니다. ");
			}else{
				this.matrix[v1][v2] = 1;
				this.matrix[v2][v1] = 1;
			}
		}
	}
	
	public int visitIdxChecker(boolean[] visited, int idx){
		if(!visited[idx]){
			return idx;
		}else{
			for(int i=0; i<visited.length; i++){
				if(!visited[i]){
					return i;
				}
			}
		}
		return -1;
	}

	// 깊이 우선 탐색을 위한 초기화 메소드 
	public void depthFirstSearchStart(int v){
		visited = new boolean[this.n]; //정점 탐색여부를 확인하는 배열의 길이 초기화 
		
		// 모든 정점의 탐색여부를 false로 초기화 
		for(int i=0; i<this.n; i++){
			visited[i] = false;
		}

		// 정점 탐색이 안되어 있을 경우 탐색을 수행하는 private 메소드 호출, 연결되지 않은 정점까지 탐색하기 위함 
		for(int i=0; i<this.n; i++){ // 0번 정점부터 탐색 
			int idx = visitIdxChecker(this.visited, v);
			if(idx != -1){
				this.depthFirstSearch(idx);
			}
		}
	}

	// 깊이 우선 탐색을 직접 수행하는 메소드 
	private void depthFirstSearch(int v){
		visited[v] = true; // 인자로 받은 정점의 탐색여부를 true로 덮어씀 
		System.out.print((v + 1) +" "); // 탐색한 정점을 출력 
		
		// 탐색한 정점과 연결되어 있는 정점을 우선으로 탐색 
		for(int i=0; i<this.n; i++){
			// 간선이 연결된 정점을 탐색하지 않은 경우 private 메소드 재호출 
			if(this.matrix[v][i] == 1){
				if(visited[i]==false) this.depthFirstSearch(i);
			}else{
				continue;
			}
		}
	}

	// 너비 우선 탐색을 위한 초기화 메소드 
	public void breadthFirstSearchStart(int v){
		visited = new boolean[this.n];
		for(int i=0; i<this.n; i++){
			visited[i] = false;
		}

		// 정점 탐색이 안되어 있을 경우 탐색을 수행하는 private 메소드 호출, 연결되지 않은 정점까지 탐색하기 위함 
		for(int i=0; i<this.n; i++){ // 0번 정점부터 탐색
			int idx = visitIdxChecker(this.visited, v);
			if(idx != -1){
				this.breadthFirstSearch(idx);
			}
		}
	}

	// 너비 우선 탐색을 직접 수행하는 메소드 
	private void breadthFirstSearch(int v){
		visited[v] = true; // 인자로 받은 정점의 탐색여부를 true로 덮어씀 
		System.out.print((v + 1) + " "); // 탐색한 정점을 출력 
		
		Queue<Integer> queue = new LinkedList<Integer>(); // 인자로 받은 정점을 넣어줄 큐 생성 
		queue.offer(v); // 큐에 탐색할 정점을 넣어줌 

		// 큐안에 값이 없을때 까지 반복 
		while(queue.peek() != null){
			int w = queue.poll(); // 큐에서 정점을 추출한 값을 w에 초기화 
			// 큐에 들어있는 정점과 간선이 연결된 정점부터 출력하는 메소드 
			for(int i=0; i<this.n; i++){
				if(this.matrix[w][i] == 1){
					if(visited[i]==false){
						visited[i]=true;
						System.out.print((i + 1) + " ");
						queue.offer(i);
					}
				}
			}
		}
	}
}
