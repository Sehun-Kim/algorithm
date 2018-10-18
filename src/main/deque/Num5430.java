package deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Num5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // test case

        int size;
        String[] op;
        List<Integer> deque;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) { // test case 만큼 반복
            op = br.readLine().split("");
            size = Integer.parseInt(br.readLine());
            deque = makeDeque(br.readLine());

            int idx = 0;
            boolean rvs = false;
            boolean error = false;

            // R,D 체크
            for (String s : op) {
                switch (s) {
                    case "R":
                        rvs = changeReverse(rvs);
                        if (rvs) {
                            idx = (deque.size() - 1) - idx;
                        }
                        break;
                    case "D":
                        try {
                            print(deque);
                            deque.remove(idx);
                            print(deque);
                            if (rvs) {
                                idx--;
                            } else {
                                idx++;
                            }

                            break;
                        } catch (Exception e) {
                            error = true;
                            break;
                        }
                    default:
                        break;
                }
            }

            // error check!
            if (error) {
                sb.append("error!\n");
            } else {

                for (Integer integer : deque) {
                    System.out.print( " " + integer + " ");
                }
                System.out.println("덱 사이즈" + deque.size());


                if (rvs) {
                    sb.append("[");
                    size = deque.size();
                    for (int j = 0; j < size; j++) {
                        sb.append(deque.get(idx--));
                        if (j < size - 1)
                            sb.append(",");
                    }
                    sb.append("]\n");
                } else {
                    sb.append("[");
                    for (int j = 0; j < deque.size(); j++) {
                        sb.append(deque.get(idx++));
                        if (j < deque.size() - 1)
                            sb.append(",");
                    }
                    sb.append("]\n");
                }
            }

        }

        System.out.println(sb.toString());
    }

    public static boolean changeReverse(boolean rvs) {
        if (rvs == true)
            return false;
        return true;
    }

    public static void print(List<Integer> list) {
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.print("\n");
    }

    public static List<Integer> makeDeque(String str) {
        List<Integer> deque = new ArrayList<>();
        String[] values = str.substring(1, str.length() - 1).split(",");

        for (String value : values) {
            deque.add(Integer.parseInt(value));
        }

        return deque;
    }

}
