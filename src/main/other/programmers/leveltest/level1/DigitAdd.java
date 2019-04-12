package main.other.programmers.leveltest.level1;

public class DigitAdd {
    public static void main(String[] args) {
//        int N = 123;
        int N = 987;
        int result = solution(N);
        System.out.println(result);
    }

    private static int solution(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10);
            n = n / 10;
        }

        return sum;
    }
}
