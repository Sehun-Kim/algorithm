package dp_basic;

import java.util.Scanner;

// https://m.blog.naver.com/PostView.nhn?blogId=tjdwns0920&logNo=221135677693&proxyReferer=https%3A%2F%2Fwww.google.com%2F

public class Num11066 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int caseCNT = s.nextInt();

        for (int i = 0; i < caseCNT; i++) {
            int numCNT = s.nextInt();
            int testCase[] = new int[numCNT];

            for (int j = 0; j < numCNT; j++) testCase[j] = s.nextInt();

            System.out.println(solution(testCase));
        }
    }

    public static int MIN(int a, int b) {
        return a <= b ? a : b;
    }

    public static int sum(int[] a, int s, int e) {
        if (s == 0) return a[e];
        else return a[e] - a[s - 1];
    }

    private static int solution(int[] a) {
        int size = a.length;
        int DP[][] = new int[size][size];    //i~j까지 최소합 DP
        int s[] = new int[size];    //SUM 저장

        //i요소까지 총합
        s[0] = a[0];
        for (int i = 1; i < size; i++) s[i] += s[i - 1] + a[i];

        //초기값 저장
        for (int i = 0; i < size - 1; i++) DP[i][i + 1] = a[i] + a[i + 1];

        for (int gap = 2; gap < size; gap++) {    //i와 j간 gap 3칸부터
            for (int i = 0; i + gap < size; i++) {    //i인덱스
                int j = i + gap;    //j인덱스
                DP[i][j] = Integer.MAX_VALUE;    // MIN을 구하기 위해 원래 dp에 들어있어야 하는 값은 엄청 큰 값이 들어있어야 함

                // k 값(사이의 텀)을 바꾸어가 면서 작은 값을 변경 시킴
                for (int k = i; k < j; k++)    //i~j 사이의 k값
                    DP[i][j] = MIN(DP[i][k] + DP[k + 1][j] + sum(s, i, j), DP[i][j]);
            }
        }
        return DP[0][a.length - 1];
    }
}
