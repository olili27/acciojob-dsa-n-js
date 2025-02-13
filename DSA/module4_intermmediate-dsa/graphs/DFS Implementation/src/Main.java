import java.util.*;

class Solution {

    static void dfs(int currNode, List<List<Integer>> graph, boolean [] visited) {
        visited[currNode] = true;

        System.out.print(currNode + " ");

        Collections.sort(graph.get(currNode), (a, b) -> {
            return a - b;
        });

        for(int nextNode: graph.get(currNode)) {
            if(!visited[nextNode]) dfs(nextNode, graph, visited);
        }
    }
    public static void DFSTraversal(List<List<Integer>> edges, int n) {
        //Write your code here
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(List<Integer> edge: edges){
            int node1 = edge.get(0);
            int node2 = edge.get(1);

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        boolean [] visited = new boolean[n];

        dfs(0, graph, visited);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        List<List<Integer>> ed = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            List<Integer> l = new ArrayList<>();
            l.add(sc.nextInt());
            l.add(sc.nextInt());
            ed.add(l);
        }

        Solution ob = new Solution();
        ob.DFSTraversal(ed, n);
    }
}