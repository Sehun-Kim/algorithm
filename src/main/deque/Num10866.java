package deque;

import java.util.Scanner;

public class Num10866 {

    public static void main(String[] args) {
        MyDeque deque = new MyDeque();
        System.out.println(deque.empty());


    }

    public static void operation() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
    }

}


class MyDeque {
    private int size;
    private Node front;
    private Node back;

    MyDeque() {
        this.size = 0;
        this.front = null;
        this.back = null;
    }

    void push_back(int n) {
        Node node = new Node(n);
        this.size++;

        if(empty() == 1) {
            this.front = node;
            this.back = node;
        }else{
            this.back.rlink = node;
            node.llink = this.back;
            this.back = node;
        }
    }

    void push_front(int n) {
        Node node = new Node(n);
        this.size++;

        if(empty() == 1) {
            this.front = node;
            this.front = node;
        }else{
            this.front.llink = node;
            node.rlink = node;
            this.front = node;
        }
    }

    int pop_front() {
        if(empty() == 1) {
            return -1;
        }else{
            int n = this.front.data;

            this.front.rlink.llink = null;
            this.front = this.front.rlink;

            return n;
        }
    }

    int pop_back() {
        if(empty() == 1) {
            return -1;
        }else{
            int n = this.back.data;

            this.back.llink.rlink = null;
            this.back = this.back.llink;
            return n;
        }
    }

    int size() {
        return this.size;
    }

    int empty() {
        if(this.front == null)
            return 1;
        return 0;
    }

    int front() {
        if(empty() == 1) {
            return -1;
        }else{
            return this.front.data;
        }
    }

    int back() {
        if(empty() == 1){
            return -1;
        }else {
            return this.back.data;
        }
    }

    class Node {
        int data;
        Node llink;
        Node rlink;

        Node(int data) {
            this.data = data;
            this.llink = null;
            this.rlink = null;
        }

    }

}
