package other.woowa;

// 이상해 이거..
// 수정해야할 곳이 세개가 넘는데;
public class Num4 {
    public static void main(String[] args) {
        int[] A = {1, 4, 10, 15};
        for (int i : A) {
            System.out.println(solution(A, i));
        }

    }

    private static int solution(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0; // 탐색할 첫 인덱스
        int r = N - 1; // 탐색할 마지막 인덱스

        while (l < r) {
            int m = (l + r) / 2 + 1; // 중간 인덱스
            if (A[m] > X) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        if (A[l] == X) {
            return l;
        }
        return -1;
    }
}
