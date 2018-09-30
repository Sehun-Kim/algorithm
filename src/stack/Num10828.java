package stack;

import java.util.Scanner;

public class Num10828 {
	public Num10828() {}

	class MyStack {
		private int top;
		private int size;
		private int[] stack;

		public MyStack() {
			this.size = 0;
			this.top = -1;
			this.stack = new int[10000];
		}

		public void push(int i){
			this.size++;
			this.stack[++this.top] = i;
		}

		public int pop(){
			if(empty()==1)
				return -1;
			this.size--;
			return this.stack[this.top--];
		}

		public int size(){
			return this.size;
		}

		public int empty(){
			return this.size == 0 ? 1 : 0;
		}

		public int top(){
			if(empty()==1)
				return -1;
			return this.stack[this.top];
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
		Num10828 out = new Num10828();
		Num10828.MyStack stack = out.new MyStack();

		for(String operation : operations){
			checkCase(operation, stack);
		}
	}

	public static void checkCase(String operation, MyStack stack){
		String[] op = operation.split(" ");
		switch(op[0]){
		case "push" :
			stack.push(Integer.parseInt(op[1]));
			break;
		case "pop" :
			System.out.println(stack.pop());
			break;
		case "size" :
			System.out.println(stack.size());
			break;
		case "empty" :
			System.out.println(stack.empty());
			break;
		case "top" :
			System.out.println(stack.top());
			break;
		default: break;	
		}
	}

	public static void main(String[] args) {
		String[] operations = input();
		run(operations);
	}
	
}
