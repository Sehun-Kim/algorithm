package main.other.programmers.heap;

import java.util.*;

public class DiskController {
    static int time = 0;

    public static void main(String[] args) {
        int[][] jobs = {{0, 9}, {0, 4}, {0, 5}, {0, 7}, {0, 3}};
        int result = solution(jobs);
        System.out.println(result);
    }

    static class Job implements Comparable<Job> {
        int requestTime;
        int workingTime;
        int totalTime;

        public Job(int[] job) {
            this.requestTime = job[0];
            this.workingTime = job[1];
            this.totalTime = 0;
        }

        @Override
        public int compareTo(Job o) {
            int j1 = time - this.requestTime + this.workingTime;
            int j2 = time - o.requestTime + o.workingTime;

            if (j1 < j2)
                return -1;
            if (j1 > j2)
                return 1;

            if (this.requestTime < o.requestTime)
                return -1;
            if (this.requestTime > o.requestTime)
                return 1;
            return 0;
        }

        public void process() {
            int startWaitTime = time - this.requestTime;
            this.totalTime = startWaitTime + this.workingTime;
            time += this.workingTime;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "requestTime=" + requestTime +
                    ", workingTime=" + workingTime +
                    ", totalTime=" + totalTime +
                    '}';
        }
    }

    static class Disk {
        PriorityQueue<Job> waitingJobs;
        List<Job> doneJobs;

        public Disk() {
            this.waitingJobs = new PriorityQueue<>();
            this.doneJobs = new ArrayList<>();
        }

        public boolean isDone(int size) {
            return this.doneJobs.size() == size;
        }

        public void insertJob(Job job) {
            this.waitingJobs.offer(job);
        }

        public void checkProcessing() {
            if (this.waitingJobs.isEmpty()) {
                time += 1;
            } else {
                Job job = this.waitingJobs.poll();
                job.process();
                this.doneJobs.add(job);
            }
        }

        public int avgTime() {
            int sum = 0;
            for (Job doneJob : doneJobs) {
                sum += doneJob.totalTime;
            }
            return sum / doneJobs.size();
        }
    }

    public static int solution(int[][] jobs) {
        List<Job> jobList = new ArrayList<>();

        for (int[] job : jobs)
            jobList.add(new Job(job));

        Collections.sort(jobList, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                if (o1.requestTime < o2.requestTime)
                    return -1;
                if (o1.requestTime > o2.requestTime)
                    return 1;
                return 0;
            }
        });

        int size = jobList.size();
        Disk disk = new Disk();

        while (true) {
            if (disk.isDone(size)) break;

            insertJob(disk, jobList);
            disk.checkProcessing();
        }

        return disk.avgTime();
    }

    private static void insertJob(Disk disk, List<Job> jobList) {
        int size = jobList.size();

        for (int i = 0; i < size; i++) {
            if (time >= jobList.get(0).requestTime)
                disk.insertJob(jobList.remove(0));
        }
    }

}
