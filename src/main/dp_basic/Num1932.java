package dp_basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Num1932 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = Integer.parseInt(sc.nextLine());
//
//        List<List<Integer>> values = new ArrayList<>();
//        List<List<Integer>> results = new ArrayList<>();
//
//        for(int i=0; i<N; i++) {
//            List<Integer> list = new ArrayList<>();
//            for(String value : sc.nextLine().split(" ")) {
//                list.add(Integer.parseInt(value));
//            }
//            values.add(list);
//        }
//
//
//        for(int i=1; i<N+1; i++) {
//            for(int j=0; j<i; )
//        }
//
//    }


    static int[][] list;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0, tmp = 0;
        list = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                list[i][j] = sc.nextInt();

                if (j == 1)
                    list[i][j] = list[i - 1][j] + list[i][j];
                else if (j == i)
                    list[i][j] = list[i - 1][j - 1] + list[i][j];
                else
                    list[i][j] = Math.max(list[i - 1][j - 1], list[i - 1][j]) + list[i][j];

                if (sum < list[i][j])
                    sum = list[i][j];
            }
        }
        System.out.println(sum);

    }

}
