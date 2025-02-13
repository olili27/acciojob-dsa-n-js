import java.io.*;
import java.util.*;

class Stack {

    Queue<Integer> q1 = new LinkedList<>(); // for pushing integers to the stack
    Queue<Integer> q2 = new LinkedList<>(); // for popping integers from the stack in O(1)

    void push(int a) {
        // your code here
        q1.add(a);

        while(!q2.isEmpty()) {
            q1.add(q2.peek());
            q2.remove();
        }

        Queue<Integer> temp = q2;
        q2 = q1;
        q1 = temp;
    }

    int pop() {
        // your code here
        if(!q2.isEmpty()) return q2.remove();

        return -1;
    }
}

public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        Stack g = new Stack();
        int q = sc.nextInt();
        while (q > 0) {
            int QueryType = sc.nextInt();
            if (QueryType == 1) {
                int a = sc.nextInt();
                // call push function here
            } else if (QueryType == 2) {
                // call pop function here
            }
            q--;
        }
    }
}