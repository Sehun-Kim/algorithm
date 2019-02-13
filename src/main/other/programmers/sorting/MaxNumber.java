package main.other.programmers.sorting;

import java.util.*;

public class MaxNumber {
    public static void main(String[] args) {
        int[] numbers = {3, 340, 34, 5, 9};
        String answer = solution(numbers);
        System.out.println(answer);
    }


    public static String solution(int[] numbers) {
        List<String> nums = new ArrayList<>();
        for (int num : numbers) {
            nums.add(String.valueOf(num));
        }

        Collections.sort(nums, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (nums.get(0).equals("0")) {
            return "0";
        }

        StringBuffer sb = new StringBuffer();
        nums.stream().forEach(num -> sb.append(num));

        return sb.toString();
    }


    static class Number implements Comparable<Number> {
        private List<Integer> nums;
        private String strNum;

        Number(int num) {
            this.strNum = String.valueOf(num);
            this.nums = new ArrayList<>();

            for (String s : strNum.split("")) {
                nums.add(Integer.parseInt(s));
            }
        }

        public String getStrNum() {
            return strNum;
        }

        private int size() {
            return this.nums.size();
        }

        private int compare(Number otherNum, int idx) {
            if (isBigger(otherNum, idx))
                return 1;
            if (isSame(otherNum, idx))
                return sameCompare(otherNum, idx);
            return -1;
        }

        private int sameCompare(Number o, int idx) {
            if (this.size() > idx + 1 && o.size() > idx + 1) {
                return compare(o, ++idx);
            }

            if (this.size() > idx + 1) {
                for (int i = idx + 1; i < this.size(); i++) {
                    if (this.nums.get(i) < o.nums.get(idx))
                        return 1;
                    if (this.nums.get(i) > o.nums.get(idx))
                        return -1;
                }
            }

            if (o.size() > idx + 1) {
                for (int i = idx + 1; i < o.size(); i++) {
                    if (this.nums.get(idx) > o.nums.get(i))
                        return 1;
                    if (this.nums.get(idx) < o.nums.get(i))
                        return -1;
                }
            }

            return 0;
        }

        private boolean isSame(Number o, int idx) {
            return this.nums.get(idx) == o.nums.get(idx);
        }

        private boolean isBigger(Number o, int idx) {
            return this.nums.get(idx) < o.nums.get(idx);
        }

        @Override
        public int compareTo(Number o) {
            return compare(o, 0);
        }
    }

    // 오답..
    public static String solutionWrong(int[] numbers) {
        List<Number> numberList = new ArrayList<>();

        for (int number : numbers) {
            numberList.add(new Number(number));
        }

        Collections.sort(numberList);

        StringBuffer sb = new StringBuffer();
        for (Number number : numberList) {
            sb.append(number.getStrNum());
        }
        return sb.toString();
    }
}
