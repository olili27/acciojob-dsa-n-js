import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    
    boolean dfs(int currNode, ArrayList<Integer>[] graph, boolean [] visited, boolean [] path) {
        visited[currNode] = true;
        path[currNode] = true;
        
        for (int nextNode: graph[currNode]) {
            if(visited[nextNode] && path[nextNode]) return true;

            else if(!visited[nextNode]) {
                boolean isCycle = dfs(nextNode, graph, visited, path);
                if(isCycle) return true;
            }
        }

        path[currNode] = false;

        return false;
    }
    public boolean isCyclic(int V, ArrayList<Integer>[] adj) {
        // Your code here
        boolean [] visited = new boolean[V];
        boolean [] path = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (visited[i]) continue;;

            boolean isCycle = dfs(i, adj, visited, path);

            if(isCycle) return true;
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V, E;
        V = sc.nextInt();
        E = sc.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < E; i++) {
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();
            adj[u].add(v);
        }
        Solution obj = new Solution();
        boolean ans = obj.isCyclic(V, adj);
        if (ans == true) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}