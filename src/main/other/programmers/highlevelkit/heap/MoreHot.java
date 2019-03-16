package main.other.programmers.highlevelkit.heap;

import java.util.PriorityQueue;

public class MoreHot {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;
        int result = solution(scoville, k);
        System.out.println(result);
    }

    static class Food implements Comparable<Food> {
        int scovil;

        public Food(int scovil) {
            this.scovil = scovil;
        }

        @Override
        public int compareTo(Food o) {
            if (this.scovil > o.scovil)
                return 1;
            if (this.scovil < o.scovil)
                return -1;
            return 0;
        }

        public boolean isHot(int k) {
            return this.scovil >= k;
        }

        public Food mix(Food s2) {
            return new Food(this.scovil + (s2.scovil * 2));
        }
    }

    public static int solution(int[] scoville, int k) {

        PriorityQueue<Food> pQ = new PriorityQueue<>();
        for (int i : scoville) {
            pQ.offer(new Food(i));
        }

        int result = 0;

        while (true) {
            if (pQ.peek().isHot(k)) {
                break;
            } else {
                if (pQ.size() < 2) return -1;
                pQ.offer(pQ.poll().mix(pQ.poll()));
                result++;
            }
        }

        return result;
    }

}
