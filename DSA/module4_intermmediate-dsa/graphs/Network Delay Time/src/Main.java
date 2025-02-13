import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int v,e;
        v = sc.nextInt();
        e = sc.nextInt();
        //Create adjacency list of edges
        LinkedList<List<Integer>> adj[] = new LinkedList[v+1];
        for(int i=0;i<=v;i++)
            adj[i] = new LinkedList<>();

        for(int i=0;i<e;i++){
            int u,v1,w;
            u = sc.nextInt();
            v1 = sc.nextInt();
            w = sc.nextInt();
            adj[u].add(Arrays.asList(v1,w));
        }
        Solution obj = new Solution();
        System.out.println(obj.delayTime(v, adj));

    }
}

class Solution{

    static class Pair {
        int node;
        int cost;

        Pair(int node, int cost) {
            this.cost = cost;
            this.node = node;
        }
    }
    static int delayTime(int V, LinkedList<List<Integer>>[] graph){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            return a.cost - b.cost;
        });
        pq.add(new Pair(1, 0));

        boolean [] visited = new boolean[V + 1];
        int count = 0;

        while (pq.size() > 0) {
            Pair top = pq.remove();
            int node = top.node;
            int cost = top.cost;

            if(visited[node]) continue;

            visited[node] = true;
            count = cost;

            for (List<Integer> edge: graph[node]) {
                int nbr = edge.get(0);
                int weight = edge.get(1);

                if(!visited[nbr]) pq.add(new Pair(nbr, cost + weight));
            }
        }

        for (int i = 1; i <= V; i++) {
            if(!visited[i]) return -1;
        }

        return count;
    }
}