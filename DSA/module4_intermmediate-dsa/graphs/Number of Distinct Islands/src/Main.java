import java.util.*;

class Solution {
    static  void dfs (int[][] graph, boolean [] visited, int node) {
        visited[node] = true;

        for (int nbr = 0; nbr < graph[0].length; nbr++) {
            if (graph[node][nbr] == 0) continue;

            if (!visited[nbr]) dfs(graph, visited, nbr);
        }
    }
    public static int countDistinctIslands(int[][] grid) {
        // write your code here
        int n = grid.length;
        boolean [] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            dfs(grid, visited, i);
            count++;
        }

        return count;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        Solution ob = new Solution();
        int ans = ob.countDistinctIslands(grid);
        System.out.println(ans);
    }
}