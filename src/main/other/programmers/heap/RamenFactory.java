package main.other.programmers.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RamenFactory {
    static int reachable;

    public static void main(String[] args) {
        int stock = 4;
        int[] dates = {3, 7, 20, 24};
        int[] supplies = {3, 20, 4, 8};
        int k = 30;
        int result = solution(stock, dates, supplies, k);
        System.out.println(result);
    }

    static class Supply implements Comparable<Supply> {
        int date;
        int supply;

        public Supply(int date, int supply) {
            this.date = date;
            this.supply = supply;
        }

        @Override
        public int compareTo(Supply o) {
            if (this.date <= reachable && o.date <= reachable) {
                if (this.supply > o.supply)
                    return -1;
                if (this.supply < o.supply)
                    return 1;
                return 0;
            }
            if (this.date <= reachable)
                return -1;
            if (o.date <= reachable)
                return 1;
            return 0;
        }
    }

    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        reachable = stock;
        int result = 0;
        List<Supply> supplyList = new ArrayList<>();

        for (int i = 0; i < dates.length; i++) {
            supplyList.add(new Supply(dates[i], supplies[i]));
        }

        Collections.sort(supplyList);

        while (true) {
            if (reachable >= k) {
                break;
            } else {
                Supply s = supplyList.remove(0);
                reachable += s.supply;
                result += 1;

                Collections.sort(supplyList);
            }
        }

        return result;
    }
}
