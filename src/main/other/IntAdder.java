package other;

import java.util.Scanner;

public class IntAdder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int length = (int)(Math.log10(num)+1);

        int result = 0;
        for(int i=0; i<length; i++) {
            result += num % 10;
            num = num/10;
        }

        System.out.println(result);
    }

}
