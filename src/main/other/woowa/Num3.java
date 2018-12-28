package other.woowa;

import java.util.*;

public class Num3 {
    public static void main(String[] args) {
        int[] A = {30, 30, 30}; // 승객들 몸무게
        int[] B = {1, 2, 1}; // 승객들이 하차할 층
        int M = 3; // 엘리베이터 최고 높이
        int X = 3; // 엘리베이터 최대 탑승가능 인원 수
        int Y = 100; // 엘리베이터 최대 탑승 가능 무게

        System.out.println(solution(A, B, M, X, Y));

    }

    public static int solution(int[] A, int[] B, int M, int X, int Y) {
        Queue<Person> personQueue = new LinkedList<>();

        for (int i = 0; i < A.length; i++) {
            personQueue.add(new Person(A[i], B[i]));
        }

        System.out.println("총 인원수 :" + personQueue.size());
        Elevator elevator = new Elevator(M, Y, X);

        while (personQueue.size() > 0) {
            // 탑승
            if (elevator.isBoardingPossible(personQueue.peek())) {
                elevator.onBoard(personQueue.poll());
                System.out.println("현재 탑승인원 : " + elevator.getNowPeopleSize());
            } else {
                elevator.service();
                System.out.println("현재 운행횟수 : " + elevator.getServiceCnt());
            }
        }
        elevator.service();
        System.out.println("현재 운행횟수 : " + elevator.getServiceCnt());

        return elevator.getServiceCnt();
    }
}

class Person implements Comparable<Person> {
    private int weight;
    private int floor;

    public Person(int weight, int floor) {
        this.weight = weight;
        this.floor = floor;
    }

    public int getFloor() {
        return floor;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Person o) {
        if (this.floor < o.floor)
            return -1;
        if (this.floor > o.floor)
            return 1;
        return 0;
    }
}

class Elevator {
    private int height; // 높이
    private int maxBoardSize; // 최대 탑승인원
    private int maximumWeight; // 최대 수용무게

    private int serviceCnt; // 운행 횟수
    private PriorityQueue<Person> onBoardPeople; // 탑승자
    private int nowWeight; // 현재무게

    public Elevator(int height, int maximumWeight, int maxBoardSize) {
        this.height = height;
        this.maximumWeight = maximumWeight;
        this.maxBoardSize = maxBoardSize;

        this.onBoardPeople = new PriorityQueue<>();
        this.serviceCnt = 0;
        this.nowWeight = 0;
    }

    public void service() {
        for (int i = 0; i < this.height; i++) {
            // i층에 내릴 사람은 다 내려야함
            int size = onBoardPeople.size();
            for (int j = 0; j < size; j++) {
                if (onBoardPeople.peek().getFloor() == i) {
                    Person person = onBoardPeople.poll();
                    this.nowWeight -= person.getWeight();
                }
            }
            // 서비스 횟수 증가
            if (size != onBoardPeople.size())
                this.serviceCnt += 1;
        }

        // 원래 위치로 돌아왔으니 횟수 증가
        this.serviceCnt += 1;
    }

    public void onBoard(Person person) {
        this.nowWeight += person.getWeight();
        this.onBoardPeople.offer(person);
    }

    public boolean isBoardingPossible(Person person) {
        return (this.nowWeight + person.getWeight() <= this.maximumWeight) &&
                ((onBoardPeople.size() + 1) <= this.maxBoardSize);
    }

    public int getServiceCnt() {
        return serviceCnt;
    }

    // 보기용
    public int getNowPeopleSize() {
        return this.onBoardPeople.size();
    }

}