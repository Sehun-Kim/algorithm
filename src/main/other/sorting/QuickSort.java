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
        int pValue = arr[start];
        int left = start +1;
        int right = end;

        System.out.println("pivot : " + start + ", left : " + left + ", right : " + right);
        boolean done = false;

        while (!done) {
            while (left <= right && arr[left] <= pValue) {
                left++;
                System.out.println("left : " + left);
            }
            while (arr[right] >= pValue && right >= left) {
                right--;
                System.out.println("right : " + right);
            }

            if (right < left) {
                done = true;
            } else {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
        // pivot change
        int tmp = arr[start];
        arr[start] = arr[right];
        arr[right] = tmp;

        return right;
    }

}

