package other.sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2, 7, 5, 3, 1, 6, 4};

        for (int i : solution(arr)) {
            System.out.println(i);
        }
    }

    private static int[] solution(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
