package dp_basic;
/*
 * A ~ B 까지 가는 방법의 수를 계속 더하면 됨
 * http://mygumi.tistory.com/231
 *
 * dfsbfs + dp 문제
 */

import java.util.Scanner;

public class Num1520 {
    static int M; // 행
    static int N; // 열
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] MN = sc.nextLine().split(" ");
        M = Integer.parseInt(MN[0]);
        N = Integer.parseInt(MN[1]);

        map = new int[M][N];
        dp = new int[M][N];

        for (int m = 0; m < M; m++) {
            String[] values = sc.nextLine().split(" ");
            for (int n = 0; n < N; n++) {
                map[m][n] = Integer.parseInt(values[n]);
                dp[m][n] = -1;  // 방문하지 않은 경로 -1로 초기화
            }
        }

        System.out.println(findWay(0, 0));


    }

    private static int findWay(int x, int y) {
        if (x == M - 1 && y == N - 1) { // 도착지점에 도달하면 경로의 수 1을 리턴한다
            return 1;
        }

        // x 행, y 열
        if (dp[x][y] == -1) { // 경로의 수가 계산된 적 없고, 방문한 적 없는 경우만 계산
            dp[x][y] = 0; // 방문 체크

            // 위로 이동
            if (x > 0 && map[x][y] > map[x - 1][y]) {
                dp[x][y] += findWay(x - 1, y);
            }
            // 아래로 이동
            if (x < M - 1 && map[x][y] > map[x + 1][y]) {
                dp[x][y] += findWay(x + 1, y);
            }
            // 왼쪽으로 이동
            if (y > 0 && map[x][y] > map[x][y - 1]) {
                dp[x][y] += findWay(x, y - 1);
            }
            // 오른쪽으로 이동
            if (y < N - 1 && map[x][y] > map[x][y + 1]) {
                dp[x][y] += findWay(x, y + 1);
            }
        }
        return dp[x][y]; // 이미 와봤던 경로라면 계산된 경로의 수를 return

    }

    // 깊이 우선 탐색을 위한 초기화 메소드
//    public void depthFirstSearchStart(int v){
//        visited = new boolean[this.n]; //정점 탐색여부를 확인하는 배열의 길이 초기화
//
//        // 모든 정점의 탐색여부를 false로 초기화
//        for(int i=0; i<this.n; i++){
//            visited[i] = false;
//        }
//
//        // 정점 탐색이 안되어 있을 경우 탐색을 수행하는 private 메소드 호출, 연결되지 않은 정점까지 탐색하기 위함
//        for(int i=0; i<this.n; i++){ // 0번 정점부터 탐색
//            int idx = visitIdxChecker(this.visited, v);
//            if(idx != -1){
//                this.depthFirstSearch(idx);
//            }
//        }
//    }

    // 깊이 우선 탐색을 직접 수행하는 메소드
//    private void depthFirstSearch(int v){
//        visited[v] = true; // 인자로 받은 정점의 탐색여부를 true로 덮어씀
//        System.out.print((v + 1) +" "); // 탐색한 정점을 출력
//
//        // 탐색한 정점과 연결되어 있는 정점을 우선으로 탐색
//        for(int i=0; i<this.n; i++){
//            // 간선이 연결된 정점을 탐색하지 않은 경우 private 메소드 재호출
//            if(this.matrix[v][i] == 1){
//                if(visited[i]==false) this.depthFirstSearch(i);
//            }else{
//                continue;
//            }
//        }
//    }
}
