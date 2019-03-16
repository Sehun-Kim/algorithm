package main.other.programmers;

import java.util.ArrayList;
import java.util.List;

public class WoowaCourse2 {
    public static void main(String[] args) {
        int[] pobi = {131, 132};
        int[] crong = {211, 212};

        int result = solution(pobi, crong);
        System.out.println(result);
    }

    static class Page implements Comparable<Page> {
        int point;
        int[] pages;

        public Page(int[] pages) {
            this.pages = pages;
            this.point = calcPoint();
        }

        private int calcPoint() {
            int left = makeBestNum(this.pages[0]);
            int right = makeBestNum(this.pages[1]);

            return left > right ? left : right;
        }

        private int makeBestNum(int page) {
            List<Integer> nums = generateNums(page);
            int sum = generateSum(nums);
            int multiply = generateMultiply(nums);

            return sum > multiply ? sum : multiply;
        }

        private List<Integer> generateNums(int page) {
            List<Integer> nums = new ArrayList<>();
            while (page != 0) {
                nums.add(page % 10);
                page /= 10;
            }

            return nums;
        }

        private int generateMultiply(List<Integer> nums) {
            return nums.stream().mapToInt(Integer::intValue).reduce((x, y) -> x * y).getAsInt();
        }

        private int generateSum(List<Integer> nums) {
            return nums.stream().mapToInt(Integer::intValue).sum();
        }

        @Override
        public int compareTo(Page o) {
            if (this.point > o.point)
                return 1;
            if (this.point < o.point)
                return -1;
            return 0;
        }
    }

    private static int solution(int[] pobi, int[] crong) {
        Page pobiPage = new Page(pobi);
        Page crongPage = new Page(crong);

        return pobiPage.compareTo(crongPage);
    }
}
