import java.io.*;
import java.util.*;

class Stack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    void push(int a) {
        // your code here
        q1.add(a);
    }

    int pop() {
        // your code here
        if (q1.isEmpty())
            return -1;

        while (q1.size() > 1) {
            int top = q1.peek();
            q2.add(top);
            q1.remove();
        }

        int peek = q1.remove();

        while (!q2.isEmpty()) {
            int top = q2.remove();
            q1.add(top);
        }

        return peek;
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
                g.push(a);
            } else if (QueryType == 2) {
                // call pop function here
                System.out.print(g.pop() + " ");
            }
            q--;
        }
    }
}