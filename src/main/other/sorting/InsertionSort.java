package other.sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {2, 7, 5, 3, 1, 6, 4};

        for (int i : solution(arr)) {
            System.out.println(i);
        }
    }

    private static int[] solution(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int v = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > v) {
                    arr[j + 1] = arr[j];
                    arr[j] = v;
                }
            }
        }
        return arr;
    }
}
