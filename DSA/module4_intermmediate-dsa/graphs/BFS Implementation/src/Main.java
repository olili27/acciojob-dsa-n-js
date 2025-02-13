import java.util.*;
import java.io.*;

class Graph {
    public int vertices;
    public ArrayList<Integer>[] adjList;

    Graph(int v) {
        this.vertices = v+1;
        adjList = new ArrayList[v+1];

        for (int i = 0; i <= v; i++) adjList[i] = new ArrayList<Integer>();
    }

    void addEdge(int v, int w) {
        adjList[v].add(w);

    }

    void BFS(int x) {
        // your code here
    }
}

public class Main {

    static void bfs(int node,  List<List<Integer>> graph, boolean [] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while(q.size() > 0) {
            int currNode = q.remove();

            if(visited[currNode]) continue;

            visited[currNode] = true;

            System.out.print(currNode + " ");

            for(int nextNode: graph.get(currNode)) {
                if(!visited[nextNode]) q.add(nextNode);
            }
        }
    }
    public static void main(String args[]) {

        List<List<Integer>> graph = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i =0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.get(u).add(v);
        }

        boolean [] visited = new boolean[n + 1];

        bfs(0, graph, visited);
    }
}
