package other.sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2, 7, 5, 3, 1, 6, 4};

        for (int i : solution(arr)) {
            System.out.println(i);
        }
    }

    private static int[] solution(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        return quickSort(arr, l, r);
    }

    public static int[] quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int p = partition(arr, start, end);
            quickSort(arr, start, p - 1);// pivot의 왼쪽 부분집합에 대해 퀵 정렬 재귀호출
            quickSort(arr, p + 1, end);//pivot의 오른쪽 부분집합에 대해 퀵 정렬 재귀호출
        }
        return arr;
    }

    public static int partition(int[] arr, int start, int end) {
        int pValue = arr[end];
        int left = start;
        int right = end - 1;

        System.out.println("==== pivot idx:" + end + ", 값:" + pValue + " ====");
        boolean done = false;

        while (!done) {
            while (left < end && arr[left] <= pValue) {
                left++;
            }
            System.out.println("left idx: " + left + ", 값:" + arr[left]);
            while (arr[right] >= pValue && right > left) {
                right--;
            }
            System.out.println("right idx: " + right + ", 값:" + arr[right]);
            if (right <= left) { // right와 left가 같을 경우 pivot change
                done = true;
            } else {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
        // left와 pivot이 만날 경우 그냥 종료
        if (end == left) {
            return left;
        }
        // pivot change
        int tmp = arr[end];
        arr[end] = arr[right];
        arr[right] = tmp;

        return right;
    }

}

