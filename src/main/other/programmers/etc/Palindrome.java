package main.other.programmers.etc;

import java.util.Scanner;

public class Palindrome {

    /*
    팰린드롬
    앞에서부터 읽을 때와 뒤에서부터 읽을 때 똑같은 단어를 팰린드롬이라고 합니다.
    두 자연수 n, m이 주어질 때 n 이상 m 이하의 자연수 중 팰린드롬인 숫자의 개수를 반환하는 알고리즘을 짜세요.
    ex) n = 1, m = 100일 때 18개 (1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 22, 33, 44, 55, 66, 77, 88, 99)
    ex) n = 100, m = 300 일 때 20개 (101, 111, 121, ... 292)
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int sum = 0;

        for (int i = n; i <= m; i++) {
            sum += checkPalindrome(String.valueOf(i));
        }

        System.out.println(sum);

    }

    private static int checkPalindrome(String num) {
        String[] nums = num.split("");
        for (int i = 0; i < nums.length/2; i++) {
            if (!(nums[i].equals(nums[(nums.length - 1) - i])))
                return 0;
        }
        return 1;

    }
}
