package implementation;
import java.util.*;

class Main {
    
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(2);
        q.add(3);
        q.add(4);

        System.out.println(q);
        
        q.remove();
        
        System.out.println(q);

        // implement pop in O(1)
        // -
    }
}