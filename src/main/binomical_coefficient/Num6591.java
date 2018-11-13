package binomical_coefficient;

// http://ksh-code.tistory.com/187
// http://mygumi.tistory.com/225


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Num6591 {
    public static void main(String[] args) {
        List<List<Long>> inputs = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        String input;

        while (!(input = sc.nextLine()).equals("0 0")) {
            inputs.add(Arrays
                    .stream(input.split(" "))
                    .map(Long::parseLong)
                    .collect(Collectors.toList()));
        }

        for (List<Long> nums : inputs) {
            long n = nums.get(0);
            long k = nums.get(1);

            long result = 1;

            // nCr == nCn-r (0 <= r <= n)
            if (k > n - k){
                k = n - k;
            }

            // n! / (k! * (n - k)!)
            // ex) 5 C 2
            // 5 * 4 * 3 * 2 * 1
            // 2 * 1 * 3 * 2 * 1

            for (long i = 1; i <= k; i++) {
                result *= n--;
                result /= i;
            }
            System.out.println(result);

        }
    }
}
