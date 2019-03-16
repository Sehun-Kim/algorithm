package main.other.programmers.highlevelkit.stackandqueue;

import java.util.Stack;

public class Top {
    public static void main(String[] args) {
        int[] heights = {3,9,9,3,5,7,2};
        int[] result = solution(heights);
        for (int i : result) {
            System.out.println(i);
        }
    }

    static class Tower {
        private int index;
        private int height;

        public Tower(int index, int height) {
            this.index = index;
            this.height = height;
        }

        public boolean isBig(Tower tower) {
            return this.height > tower.height;
        }

        public int getIndex() {
            return this.index;
        }
    }

    public static int[] solution(int[] heights) {
        int[] result = new int[heights.length];
        Stack<Tower> towers = new Stack<>();
        for (int i = 0; i < result.length; i++) {
            towers.push(new Tower(i + 1, heights[i]));
        }

        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = receptionSignal(towers);
        }

        return result;
    }

    private static int receptionSignal(Stack<Tower> towers) {
        Tower tower = towers.pop();
        if (towers.isEmpty())
            return 0;

        for (int i = towers.size() - 1; i >= 0; i--) {
            if (towers.get(i).isBig(tower))
                return towers.get(i).getIndex();
        }
        return 0;
    }
}
