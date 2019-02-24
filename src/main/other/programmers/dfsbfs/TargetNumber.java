package main.other.programmers.dfsbfs;

// 다른 사람의 풀이를 참고하여 풀었음
public class TargetNumber {
    static int result = 0;

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        int result = solution(numbers, target);
        System.out.println(result);
    }

    public static int solution(int[] numbers, int target) {
        boolean[] addOrSub = new boolean[numbers.length];
        dfs(numbers, target, addOrSub, 0);
        return result;
    }

    private static void dfs(int[] numbers, int target, boolean[] addOrSub, int length) {
        if (length == numbers.length) {
            int sum = 0;
            for (int i = 0; i < addOrSub.length; i++) {
                if (addOrSub[i])
                    sum += numbers[i];
                else
                    sum -= numbers[i];
            }
            if (sum == target)
                result++;

            return;
        }

        addOrSub[length] = true;
        dfs(numbers, target, addOrSub, length + 1);

        addOrSub[length] = false;
        dfs(numbers, target, addOrSub, length + 1);
    }
}
