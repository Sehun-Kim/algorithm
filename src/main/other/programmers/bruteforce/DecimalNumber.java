package main.other.programmers.bruteforce;

import java.util.HashSet;
import java.util.Set;

// 순열 : n개의 수에서 r개의 숫자를 뽑아 정렬 nPr
// 조합 : n개의 수에서 r개의 숫자를 뽑음 (순서 x) nCr

// 이 문제에서는 순열이 필요함
public class DecimalNumber {
    public static void main(String[] args) {
        String numbers = "011";
        int result = solution(numbers);
        System.out.println(result);
    }

    public static int solution(String numbers) {
        String[] nums = numbers.split("");
        Set<Integer> p = new HashSet<>();

        doPermutation(nums, 0, p);
        int answer = 0;

        for (Integer integer : p) {
            System.out.println(integer);
            if(primeCheck(integer))
                answer++;
        }

        return answer;
    }

    private static boolean primeCheck(int num) {
        for (int i=2; i<num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void doPermutation(String[] arr, int startIdx, Set<Integer> p) {
        int length = arr.length;
        if (startIdx == length - 1) {
            addNum(arr, startIdx, p);
            return;
        }

        for (int i = startIdx; i < length; i++) {
            swap(arr, startIdx, i);
            addNum(arr, startIdx, p);
            doPermutation(arr, startIdx + 1, p);
            swap(arr, startIdx, i);
        }
    }

    private static void swap(String[] arr, int n1, int n2) {
        String temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }

    private static void addNum(String[] nums, int len, Set<Integer> p) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <= len; i++) {
            sb.append(nums[i]);
        }

        int num = Integer.parseInt(sb.toString());
        if (num > 1)
            p.add(num);
    }
}
