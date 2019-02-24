package main.other.remotejobpair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test1 {
    static int answer = 0;

    public static void main(String[] args) {
        int n = 9;
        int result = solution(n);
        System.out.println(result);
    }

    public static int solution(int n) {
        Set<Integer> primeNums = new HashSet<>();
        for (int i = 2; i < n; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primeNums.add(i);
            }
        }

        List<Integer> primeList = new ArrayList<>(primeNums);

        int[] combArr = new int[primeList.size()];
        doCombination(combArr, primeList.size(), 3, 0, 0, primeList, n);

        return answer;
    }

    public static void doCombination(int[] combArr, int n, int r, int index, int target, List<Integer> primeList, int number) {
        if (r == 0) {
            int sum = 0;
            for (int i = 0; i < index; i++) {
                sum += primeList.get(combArr[i]);
            }
            if (sum == number) {
                answer++;
            }
        } else if (target == n) return;
        else {
            combArr[index] = target;
            doCombination(combArr, n, r - 1, index + 1, target + 1, primeList, number); // (i)
            doCombination(combArr, n, r, index, target + 1, primeList, number); //(ii)
        }
    }


}
