package other.sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {2, 7, 5, 3, 1, 6, 4};

        for (int i : solution(arr)) {
            System.out.println(i);
        }
    }

    private static int[] solution(int[] arr) {
        for (int i = arr.length; i > 0; i--) {
            int min_idx = arr.length - i;
            for (int j = arr.length - i; j < arr.length; j++) {
                if (arr[min_idx] > arr[j]) {
                    min_idx = j;
                }
            }

            if (min_idx != arr.length - i) {
                int tmp = arr[arr.length - i];
                arr[arr.length - i] = arr[min_idx];
                arr[min_idx] = tmp;
            }
        }

        return arr;
    }
}
