package main.other.programmers.stackandqueue;

public class StockPrice {
    public static void main(String[] args) {
        int[] prices = {498, 501, 470, 489};
        int[] result = solution(prices);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] prices) {
        int[] result = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            if (i < prices.length - 1) {
                result[i] = check(i, prices);
            } else {
                result[i] = 0;
            }
        }
        return result;
    }

    private static int check(int i, int[] prices) {
        for (int j = i + 1; j < prices.length; j++) {
            if (prices[i] > prices[j])
                return j - i;
            if (j == prices.length - 1)
                return j - i;
        }
        return 0;
    }
}
