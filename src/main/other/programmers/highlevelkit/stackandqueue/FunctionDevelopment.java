package main.other.programmers.highlevelkit.stackandqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FunctionDevelopment {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] result = solution(progresses, speeds);
        for (int i : result) {
            System.out.println(i);
        }
    }

    static class Function {
        private int progress;
        private int speed;

        public Function(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }

        public void progress() {
            this.progress += this.speed;
        }

        public boolean isOver() {
            return this.progress >= 100;
        }
    }

    static class FunctionChecker {
        private Queue<Function> functions;

        FunctionChecker() {
            this.functions = new LinkedList<>();
        }

        void addFunction(Function function) {
            this.functions.offer(function);
        }

        boolean isDone() {
            return this.functions.isEmpty();
        }

        void progress() {
            functions.stream().forEach(function -> function.progress());
        }

        public void deploy(List<Integer> result) {
            int count = checkOver();
            if (count != 0)
                result.add(count);
        }

        private int checkOver() {
            int num = 0;
            while (!functions.isEmpty() && functions.peek().isOver()) {
                num++;
                functions.poll();
            }
            return num;
        }
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        FunctionChecker functionChecker = new FunctionChecker();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            functionChecker.addFunction(new Function(progresses[i], speeds[i]));
        }

        while (!functionChecker.isDone()) {
            functionChecker.progress();
            functionChecker.deploy(result);
        }

        int[] solution = new int[result.size()];
        for (int i=0; i<solution.length; i++) {
            solution[i] = result.get(i);
        }

        return solution;
    }
}