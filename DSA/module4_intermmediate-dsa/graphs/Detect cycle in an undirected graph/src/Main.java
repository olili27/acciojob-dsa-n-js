import java.io.*;
import java.util.*;

class Solution {
    public static boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        boolean [] visited = new boolean[v];

        for (int i = 0; i < v; i++) {

            if(visited[i]) continue;

            Queue<Integer> q= new LinkedList<>();
            q.add(i);

            while(q.size() > 0) {
                int currNode = q.remove();

                if(visited[currNode]) return true;

                visited[currNode] = true;

                for (int nextNode: adj.get(currNode)) {
                    if(!visited[nextNode]) q.add(nextNode);
                }
            }
        }

        return false;
    }
}

public class Main{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N, E;
        N = sc.nextInt();
        E = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i<N; i++) adj.add(i, new ArrayList<Integer>());
        for(int i =0; i<E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean ans = Solution.isCycle(N,adj);
        if(ans)
            System.out.println("1");
        else
            System.out.println("0");
    }
}