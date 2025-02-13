import java.util.*;

class Solution {
    boolean dfs(int node, int color, int [] visited, ArrayList<ArrayList<Integer>> graph) {
        visited[node] = color;
        int nbrColor = color == 1 ? 2 : 1;

        for (int nbr : graph.get(node)) {
            if(visited[nbr] == color) return false;

            if(visited[nbr] == 0) {
                boolean check = dfs(nbr, nbrColor, visited, graph);
                if(!check) return false;
            }
        }

        return true;
    }
    public int possibleBipartition(int n, int[][] dislikes) {
        // create a graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int [] edges : dislikes) {
            graph.get(edges[0]).add(edges[1]);
            graph.get(edges[1]).add(edges[0]);
        }
        int [] visited = new int [n + 1];
        for (int i = 1; i <= n; i++) {
            if(visited[i] != 0) continue;;

            boolean check = dfs(i, 1, visited, graph);
            if(!check) return 0;
        }

        return 1;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int dislike[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                dislike[i][j]= sc.nextInt();
        }

        Solution Obj = new Solution();
        System.out.println(Obj.possibleBipartition(N,dislike));

    }
}