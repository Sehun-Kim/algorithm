package other.woowa;

import java.util.Scanner;

public class Num1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.nextLine();
        int n = Integer.parseInt(binary, 2);

        // 짝수면 /2
        // 홀수면 -1
        // 0이 되는 횟수
        int result = 0;
        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
                result += 1;
            } else {
                n -= 1;
                result += 1;
            }
        }

        System.out.println(result);
    }
}
