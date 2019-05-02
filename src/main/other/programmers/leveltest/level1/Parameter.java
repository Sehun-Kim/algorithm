package main.other.programmers.leveltest.level1;

public class Parameter {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int result = solution(a, b);
        System.out.println(result);
    }

    private static int solution(int a, int b) {
        return a + b;
    }
}
