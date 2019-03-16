package main.other.programmers.highlevelkit.dfsbfs;

import java.util.ArrayList;
import java.util.List;

public class Network {
    public static void main(String[] args) {
        int[][] computers = {{1, 0, 1}, {0, 1, 1}, {1, 1, 1}};
        int n = computers.length;
        int result = solution(n, computers);
        System.out.println(result);
    }

    static class Computer {
        boolean visit;
        int ip;
        List<Integer> linkedIp;

        public Computer(int ip) {
            this.ip = ip;
            this.visit = false;
            this.linkedIp = new ArrayList<>();
        }

        void settingLink(int[] ips) {
            for (int i = 0; i < ips.length; i++) {
                if (ips[i] == 1 && i != ip) {
                    this.linkedIp.add(i);
                }
            }
        }

        public boolean isVisit() {
            return this.visit;
        }

        public void visitNetwork(List<Computer> computerList) {
            for (Integer integer : linkedIp) {
                Computer com = computerList.get(integer);
                if (!com.isVisit()) {
                    com.visiting().visitNetwork(computerList);
                }
            }
        }

        private Computer visiting() {
            this.visit = true;
            return this;
        }

        @Override
        public String toString() {
            return "Computer{" +
                    "visit=" + visit +
                    ", ip=" + ip +
                    ", linkedIp=" + linkedIp +
                    '}';
        }
    }

    public static int solution(int n, int[][] computers) {
        List<Computer> computerList = new ArrayList<>();

        int answer = 0;

        for (int i = 0; i < n; i++) {
            Computer com = new Computer(i);
            com.settingLink(computers[i]);
            computerList.add(com);
            System.out.println(com);
        }

        for (Computer computer : computerList) {
            if (!computer.isVisit()) {
                computer.visitNetwork(computerList);
                computer.visiting();
                answer += 1;
            }
        }

        return answer;
    }

}
