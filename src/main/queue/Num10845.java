package queue;

import java.util.Scanner;

public class Num10845 {
	
	public Num10845() {}
	
	class MyQueue{
		private int[] queue;
		private int size;
		private int front;
		private int back;
		
		public MyQueue() {
			this.queue = new int[10000];
			this.size = 0;
			this.front = 0;
			this.back = 0;
		}
		
		
		public void push(int i) {
			this.size++;
			this.queue[this.back++] = i;
		}
		
		public int pop() {
			this.size--;
			return this.queue[this.front++];
		}
		
		public int size() {
			return this.size;
		}
		
		public int isEmpty() {
			if(this.front == this.back){
				return 1;
			}
			return 0;
		}
		
		public int front() {
			if(isEmpty() == 1){
				return -1;
			}
			return this.queue[this.front];
		}
		
		public int back() {
			if(isEmpty() == 1){
				return -1;
			}
			return this.queue[this.back];
		}
		
	}
		
	public static String[] input(){
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());
		String[] operations = new String[n];

		for (int i=0; i<n; i++) {
			operations[i] = sc.nextLine();
		}

		sc.close();
		return operations;
	}

	public static void run(String[] operations) {
		Num10845 out = new Num10845();
		Num10845.MyQueue queue = out.new MyQueue();

		for(String operation : operations){
			checkCase(operation, queue);
		}
	}

	public static void checkCase(String operation, MyQueue queue){
		String[] op = operation.split(" ");
		switch(op[0]){
		case "push" :
			queue.push(Integer.parseInt(op[1]));
			break;
		case "pop" :
			System.out.println(queue.pop());
			break;
		case "size" :
			System.out.println(queue.size());
			break;
		case "empty" :
			System.out.println(queue.isEmpty());
			break;
		case "front" :
			System.out.println(queue.front());
			break;
		case "back" :
			System.out.println(queue.back());
			break;
		default: break;	
		}
	}

	public static void main(String[] args) {
		String[] operations = input();
		run(operations);
	}

}
