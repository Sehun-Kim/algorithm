package deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] op1 = br.readLine().split(" ");

        int N = Integer.parseInt(op1[0]);
        int M = Integer.parseInt(op1[1]);

        String[] op2 = br.readLine().split(" ");
        List<Integer> nums = new ArrayList<>();

        for (String s : op2) {
            nums.add(Integer.parseInt(s));
        }

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        int result = 0;

        for (int num : nums) {
            while (true) {
                int idx = 0; // 찾을 숫자의 인덱스
                Iterator<Integer> it = deque.iterator(); // 실제로 큐에서 값을 삭제하지 않고 반복하기 위해 iterator사용
                // 찾을 번호의 위치를 찾음
                while (it.hasNext()) {
                    if (it.next() == num) break;
                    idx++;
                }
                if (idx == 0) { // 인덱스가 0일 때
                    deque.pollFirst();
                    break;
                } else if (deque.size() / 2 >= idx) { // 큐 절반보다 인덱스가 작거나 같을 때 반대로 돌려준다.
                    deque.addLast(deque.pollFirst());
                    result++;
                } else { // 큐 절반보다 인덱스가 클 때 시계방향으로 돌려준다.
                    deque.addFirst(deque.pollLast());
                    result++;
                }
            }
        }

        System.out.println(result);

    }
}


// 직접 구현한 것
class MyCircularQueue {

    private int[] array; // 큐 값이 들어갈 array
    private int capacity; // array 크기
    private int front = 0; // front
    private int rear = 0; // rear

    // 크기를 입력받아 원형큐를 생성하는 생성자
    public MyCircularQueue(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
    }

    // rear와 front가 가리키는 값이 같으면 빈 큐
    public boolean isEmpty() {
        return rear == front;
    }

    // 하나 빈 공간을 제외하고 모든 값이 다 있으면 가득찬 큐
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    // Queue에 삽입하는 메소드
    public void enQueue(int item) {
        if (this.isFull()) { // 가득차 있으면 에러메세지 반환
            System.out.println("Queue가 가득 찼습니다.");
        } else {
            rear = (rear + 1) % capacity; // 큐(array)의 크기를 벗어 나지 않게 rear의 위치는 커지면서 반복됨
            array[rear] = item;
        }
    }

    // Queue에서 값을 삭제하는 메소드, 값이 없을 경우 Exception 발생
    public int deQueue() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Queue is Empty");
        } else {
            front = (front + 1) % capacity;
            int value = array[front];
            return value;
        }
    }


}
