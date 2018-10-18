package deque;

public class Num10866 {

    public static void main(String[] args) {
        MyDeque deque = new MyDeque();
        System.out.println(deque.empty());
        for (int i = 0; i < 10; i++) {
            deque.push_front(i);
        }

        System.out.println(deque.front());
        System.out.println(deque.size());
        System.out.println(deque.pop_back());
        System.out.println(deque.back());
        System.out.println(deque.size());
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

        if (empty() == 1) {
            this.front = node;
            this.back = node;
        } else {
            node.llink = this.back;
            this.back.rlink = node;
            this.back = node;
        }
    }

    void push_front(int n) {
        Node node = new Node(n);
        this.size++;

        if (empty() == 1) {
            this.front = node;
            this.back = node;
        } else {
            node.rlink = this.front;
            this.front.llink = node;
            this.front = node;
        }
    }

    int pop_front() {
        if (empty() == 1) {
            return -1;
        } else {
            this.size--;
            int n = this.front.data;

            if (this.front.rlink == null) {
                this.front = null;
                this.back = null;
            } else {
                this.front = this.front.rlink;
                this.front.llink = null;
            }

            return n;
        }
    }

    int pop_back() {
        if (empty() == 1) {
            return -1;
        } else {
            this.size--;
            int n = this.back.data;

            if (this.back.llink == null) {
                this.back = null;
                this.front = null;
            } else {
                this.back = this.back.llink;
                this.back.rlink = null;
            }
            return n;
        }
    }

    int size() {
        return this.size;
    }

    int empty() {
        if (this.front == null && this.back == null)
            return 1;
        return 0;
    }

    int front() {
        if (empty() == 1) {
            return -1;
        } else {
            return this.front.data;
        }
    }

    int back() {
        if (empty() == 1) {
            return -1;
        } else {
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
