package main.other.programmers.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DiskControllerTwo {
    public static void main(String[] args) {
        int[][] jobs = {{0, 9}, {0, 4}, {0, 5}, {0, 7}, {0, 3}};
        int result = solution(jobs);
        System.out.println(result);
    }

    static class Job implements Comparable<Job> {
        int start;
        int workTime;

        public Job(int start, int time) {
            this.start = start;
            this.workTime = time;
        }

        @Override
        public int compareTo(Job o) {
            if (this.workTime < o.workTime) return -1;
            else if (this.workTime == o.workTime) {
                if (this.start < o.start) return -1;
                else return 1;
            } else return 1;
        }
    }

    public static int solution(int[][] jobs) {
        PriorityQueue<Job> pq = new PriorityQueue<>();
        List<Job> list = new ArrayList<>();

        //PriorityQueue를 활용한 Job 정렬
        for (int i = 0; i < jobs.length; i++) {
            pq.add(new Job(jobs[i][0], jobs[i][1]));
        }

        //list에 우선순위 순으로 정렬된 Job 순차적으로 삽입
        for (int i = 0; i < jobs.length; i++) {
            list.add(pq.poll());
        }

        int time = 0;
        int sum = 0;
        while (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                //시작시간이 현재 시간보다 이전이라면 시작 가능
                if (time >= list.get(i).start) {
                    time += list.get(i).workTime;
                    sum += time - list.get(i).start;
                    list.remove(i);
                    break;
                }
                //시작시간이 현재 시간보다 이전인 것이 없다면 시간 1초 증가
                if (i == list.size() - 1) time++;
            }
        }

        int answer = (sum / jobs.length);
        return answer;
    }
}
