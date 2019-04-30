package main.other.programmers.leveltest.level1;

public class Palindrome {
    public static void main(String[] args) {
        int n = 100;
        int m = 300;
        int result = solution(n, m);
        System.out.println(result);
    }

    private static int solution(int n, int m) {
        int total = 0;
        for (int i = n; i <= m; i++) {
            if (isPalindrome(i))
                total++;
        }

        return total;
    }

    private static boolean isPalindrome(int num) {
        String strNum = String.valueOf(num);
        int size = strNum.length() - 1;

        if (size == 0) return true;

        int len = strNum.length() / 2;
        for (int i = 0; i < len; i++) {
            if (strNum.charAt(i) != strNum.charAt(size - i)) return false;
        }
        return true;
    }
}
