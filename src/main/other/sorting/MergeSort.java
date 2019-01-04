package other.sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {2, 7, 5, 3, 1, 6, 4};

        for (int i : solution(arr)) {
            System.out.println(i);
        }
    }

    private static int[] solution(int[] arr) {
        return mergeSort(arr, arr.length);
    }

    private static int[] mergeSort(int[] arr, int length) {
        int mid = length / 2;
        int[] pre = new int[length - mid];
        int[] back = new int[mid];

        for (int i = 0; i < length - mid; i++) {
            pre[i] = arr[i];
        }

        for (int i = 0; i < mid; i++) {
            back[i] = arr[pre.length + i];
        }

        if (pre.length > 1) { // 길이가 1과 같거나 작을 경우(0) 정렬 필요 x
            pre = mergeSort(pre, pre.length);
        }
        if (back.length > 1) {
            back = mergeSort(back, back.length);
        }

        return merge(pre, back);
    }

    private static int[] merge(int[] pre, int[] back) {
        int[] result = new int[pre.length + back.length];
        int n = 0; // 전체 idx
        int p_idx = 0; // pre idx
        int b_idx = 0; // back idx

        // 오른쪽 array에 값이 없을 경우 합친 결과는 왼쪽 array의 값 하나.
        if (back.length == b_idx) {
            result[n] = pre[p_idx];
            return result;
        }

        while (p_idx <= pre.length - 1 && b_idx <= back.length - 1) {
            if (pre[p_idx] <= back[b_idx]) {
                result[n] = pre[p_idx++];
            } else {
                result[n] = back[b_idx++];
            }
            n++;
        }

        if (p_idx == pre.length) {
            result[n] = back[b_idx];
        } else if (b_idx == back.length) {
            result[n] = pre[p_idx];
        }

        return result;
    }
}

// merge idea 바보 버전... 실패..
//        while (n != result.length) {
//            // 지그 재그로 증가시키면서 제일 작은 값을 찾는다.
//            if (pre[p_idx] <= back[b_idx]) {
//                result[n++] = pre[p_idx];
//                p_idx = (p_idx == (pre.length - 1)) ? p_idx : p_idx + 1;
//            } else if (pre[p_idx] > back[b_idx]) {
//                result[n++] = back[b_idx++];
//                b_idx = (b_idx == (back.length - 1)) ? b_idx : b_idx + 1;
//            } else {
//                if (pre[p_idx] < back[b_idx])
//                    result[n] = back[b_idx];
//                else
//                    result[n] = pre[p_idx];
//            }
//        }